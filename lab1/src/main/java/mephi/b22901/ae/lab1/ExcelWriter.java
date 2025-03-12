
package mephi.b22901.ae.lab1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelWriter {
    
    public void writeData(String filePath, HashMap<String, HashMap<String, Double>> statistics, List<String> columnNames) throws IOException {
    Workbook workbook = new XSSFWorkbook();

    // Лист для основных статистических показателей
    Sheet statsSheet = workbook.createSheet("Statistics");
    createStatisticsTable(statsSheet, statistics, columnNames);

    // Лист для ковариационной матрицы
    Sheet covarianceSheet = workbook.createSheet("Covariance Matrix");
    createCovarianceMatrix(covarianceSheet, statistics, columnNames);

    // Сохраняем файл
    try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
        workbook.write(fileOut);
    } finally {
        workbook.close();
    }
}

    private void createStatisticsTable(Sheet sheet, HashMap<String, HashMap<String, Double>> statistics, List<String> columnNames) {
        // Создаем заголовки
        ArrayList<String> headers = new ArrayList<>();
        headers.add("Столбец");
        headers.add("Среднее геометрическое");
        headers.add("Среднее арифметическое");
        headers.add("Стандартное отклонение");
        headers.add("Размах");
        headers.add("Коэффициент вариации");
        headers.add("Дисперсия");
        headers.add("Количество элементов");
        headers.add("Минимум");
        headers.add("Максимум");
        headers.add("Доверительный интервал (нижняя граница)");
        headers.add("Доверительный интервал (верхняя граница)");
                

        // Создаем первую строку с заголовками
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.size(); i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers.get(i));
        }

        // Заполняем таблицу данными
        int rowIndex = 1;
        for (String columnName : columnNames) {
            Row row = sheet.createRow(rowIndex++);
            int cellIndex = 0;

            // Название столбца
            row.createCell(cellIndex++).setCellValue(columnName);

            // Значения показателей
            HashMap<String, Double> columnStats = statistics.get(columnName);
            row.createCell(cellIndex++).setCellValue(columnStats.getOrDefault("Среднее геометрическое", 0.0));
            row.createCell(cellIndex++).setCellValue(columnStats.getOrDefault("Среднее арифметическое", 0.0));
            row.createCell(cellIndex++).setCellValue(columnStats.getOrDefault("Стандартное отклонение", 0.0));
            row.createCell(cellIndex++).setCellValue(columnStats.getOrDefault("Размах", 0.0));
            row.createCell(cellIndex++).setCellValue(columnStats.getOrDefault("Коэффициент вариации", 0.0));
            row.createCell(cellIndex++).setCellValue(columnStats.getOrDefault("Дисперсия", 0.0));
            row.createCell(cellIndex++).setCellValue(columnStats.getOrDefault("Количество элементов", 0.0));
            row.createCell(cellIndex++).setCellValue(columnStats.getOrDefault("Минимум", 0.0));
            row.createCell(cellIndex++).setCellValue(columnStats.getOrDefault("Максимум", 0.0));
            row.createCell(cellIndex++).setCellValue(columnStats.getOrDefault("Доверительный интервал (нижняя граница)", 0.0));
            row.createCell(cellIndex++).setCellValue(columnStats.getOrDefault("Доверительный интервал (верхняя граница)", 0.0));
        }
    }
    
    
    private void createCovarianceMatrix(Sheet sheet, HashMap<String, HashMap<String, Double>> statistics, List<String> columnNames) {
        // Создаем заголовки для ковариационной матрицы
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue(""); // Пустая ячейка в углу
        for (int i = 0; i < columnNames.size(); i++) {
            headerRow.createCell(i + 1).setCellValue(columnNames.get(i));
        }

        // Заполняем матрицу
        for (int i = 0; i < columnNames.size(); i++) {
            Row row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(columnNames.get(i)); // Название строки

            for (int j = 0; j < columnNames.size(); j++) {
                String covKey = "Ковариация " + columnNames.get(i) + "-" + columnNames.get(j);
                double covariance = statistics.get(columnNames.get(i)).getOrDefault(covKey, 0.0);

                // Для симметрии убедитесь, что ключи Cov(X,Y) и Cov(Y,X) дают одинаковые значения
                if (i != j) {
                    String reverseCovKey = "Ковариация " + columnNames.get(j) + "-" + columnNames.get(i);
                    covariance = statistics.get(columnNames.get(j)).getOrDefault(reverseCovKey, covariance);
                }

                row.createCell(j + 1).setCellValue(covariance);
            }
        }
    }
    
    
    


    
    
    
}
