package mephi.b22901.ae.lab1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class GuiController {
    private MainGui guiView;
    private DataStorage dataStorage;
    private ExcelReader excelReader;
    private ExcelWriter excelWriter;
    private StatisticsController statisticsController;
    private String currentSheetName;

    public GuiController(MainGui mainGui) {
        this.guiView = mainGui;
        this.dataStorage = new DataStorage();
        this.excelReader = new ExcelReader();
        this.excelWriter = new ExcelWriter();
        this.statisticsController = new StatisticsController();

        // Устанавливаем обработчики событий для кнопок
        guiView.setImportButtonListener(new ImportButtonListener());
        guiView.setExportButtonListener(new ExportButtonListener());
        guiView.setExitButtonListener(new ExitButtonListener());
    }

    /**
     * Обработчик события для кнопки "Импортировать данные".
     */
    private class ImportButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                try {
                    // Получаем путь к выбранному файлу
                    String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                    guiView.displayMessage("Выбран файл: " + filePath);
                    
                    List<String> sheetNames = excelReader.getSheetNames(filePath);
                    
                    String selectedSheet = (String) JOptionPane.showInputDialog(
                        null,
                        "Выберите лист для анализа:",
                        "Выбор листа",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        sheetNames.toArray(),
                        sheetNames.get(0)
                    );
                    
                    if (selectedSheet != null){
                        currentSheetName = selectedSheet;
                    }
                    
                    

                    // Читаем данные из файла
                    HashMap<String, List<Double>> data = excelReader.readData(filePath, selectedSheet);
                    dataStorage.setData(data);

                    // Отображаем сообщение об успешном импорте
                    guiView.displayMessage("Данные успешно импортированы.");
                } catch (IOException ex) {
                    guiView.displayErrorMessage("Ошибка при чтении файла: " + ex.getMessage());
                } catch (IllegalArgumentException ex) {
                    guiView.displayErrorMessage("Ошибка в структуре данных: " + ex.getMessage());
                }
            }
        }
    }

    /**
     * Обработчик события для кнопки "Экспортировать данные".
     */
    private class ExportButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (currentSheetName == null){
                guiView.displayErrorMessage("Сначала импортируйте данные");
            }
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showSaveDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                try {
                    // Получаем путь для сохранения файла
                    String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                    guiView.displayMessage("Выбрано место сохранения: " + filePath);

                    // Получаем список столбцов из хранилища данных
                    List<String> columnNames = dataStorage.getAllData().keySet().stream().toList();

                    // Рассчитываем статистические показатели
                    HashMap<String, HashMap<String, Double>> statistics = statisticsController.calculateAllStatistics(dataStorage);

                    // Экспортируем данные в файл
                    excelWriter.writeData(filePath, statistics, columnNames);

                    // Отображаем сообщение об успешном экспорте
                    guiView.displayMessage("Данные успешно экспортированы.");
                } catch (IOException ex) {
                    guiView.displayErrorMessage("Ошибка при записи файла: " + ex.getMessage());
                } catch (Exception ex) {
                    guiView.displayErrorMessage("Ошибка при расчете статистики: " + ex.getMessage());
                }
            }
        }
    }

    /**
     * Обработчик события для кнопки "Выход".
     */
    private class ExitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
