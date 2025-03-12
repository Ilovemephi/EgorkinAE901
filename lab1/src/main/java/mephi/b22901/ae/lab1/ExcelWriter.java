
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
        // Создаем новую рабочую книгу и лист
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Statistics");

        // Создаем заголовки для таблицы
        List<String> headers = new ArrayList<>();
        headers.add("Столбец");
        headers.add("Среднее геометрическое");
        headers.add("Среднее арифметическое");
        headers.add("Стандартное отклонение");
        headers.add("Размах");
        headers.add("Коэффициент вариации");
        headers.add("Дисперсия");
        headers.add("Максимум");
        headers.add("Минимум");
        headers.add("Количество элементов");
        headers.add("Доверительный интервал (нижняя граница)");
        headers.add("Доверительный интервал (верхняя граница)");
        
        // Добавляем заголовки для ковариаций
        for (int i = 0; i < columnNames.size(); i++) {
        for (int j = i + 1; j < columnNames.size(); j++) {
            headers.add("Ковариация " + columnNames.get(i) + "-" + columnNames.get(j));
        }
    }

        
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
            row.createCell(cellIndex++).setCellValue(columnStats.getOrDefault("Максимум", 0.0));
            row.createCell(cellIndex++).setCellValue(columnStats.getOrDefault("Минимум", 0.0));
            row.createCell(cellIndex++).setCellValue(columnStats.getOrDefault("Количество элементов", 0.0));
            row.createCell(cellIndex++).setCellValue(columnStats.getOrDefault("Доверительный интервал (нижняя граница)", 0.0));
            row.createCell(cellIndex++).setCellValue(columnStats.getOrDefault("Доверительный интервал (верхняя граница)", 0.0));
            // Значения ковариаций
            for (int i = 0; i < columnNames.size(); i++) {
                for (int j = i + 1; j < columnNames.size(); j++) {
                    String covKey = "Ковариация " + columnNames.get(i) + "-" + columnNames.get(j);
                    double covariance = columnStats.getOrDefault(covKey, 0.0);
                    row.createCell(cellIndex++).setCellValue(covariance);
                }
            }
            
        }
        
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }

        // Закрываем рабочую книгу
        workbook.close();
            
            

    }

    
    
    
}
