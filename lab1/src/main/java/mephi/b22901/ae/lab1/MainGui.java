package mephi.b22901.ae.lab1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class MainGui {
    
    private JFrame frame;
    private JButton importButton;
    private JButton exportButton;
    private JButton exitButton;
    private JTextArea outputArea;

    public MainGui() {
        // Создаем главное окно
        frame = new JFrame("Статистический анализ данных");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Создаем панель и добавляем ее на фрейм
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.add(panel);
        
        // Добавляем кнопки
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        importButton = new JButton("Импортировать данные");
        exportButton = new JButton("Экспортировать данные");
        exitButton = new JButton("Выход");

        buttonPanel.add(importButton);
        buttonPanel.add(exportButton);
        buttonPanel.add(exitButton);
        panel.add(buttonPanel, BorderLayout.NORTH);
        
        // Добавляем текстовую область для вывода сообщений
        outputArea = new JTextArea();
        outputArea.setEditable(false); // Запрещаем редактирование текста
        JScrollPane scrollPane = new JScrollPane(outputArea); // Добавляем прокрутку
        panel.add(scrollPane, BorderLayout.CENTER);

        // Делаем окно видимым
        frame.setVisible(true);
        
    }
    
    public void setImportButtonListener(ActionListener listener) {
        importButton.addActionListener(listener);
    }

    
    public void setExportButtonListener(ActionListener listener) {
        exportButton.addActionListener(listener);
    }

    
    public void setExitButtonListener(ActionListener listener) {
        exitButton.addActionListener(listener);
    }

    
    public void displayMessage(String message) {
        outputArea.append(message + "\n"); // Добавляем сообщение в конец текстовой области
    }
    
    public void displayErrorMessage(String message) {
        outputArea.append("[Ошибка] " + message + "\n"); // Добавляем сообщение об ошибке
    }

    
    public void displayStatistics(String statistics) {
        outputArea.append("Рассчитанные показатели:\n" + statistics + "\n"); // Добавляем статистику
    }

    

    
}
