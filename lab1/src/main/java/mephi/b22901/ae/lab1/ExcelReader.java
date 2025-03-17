
package mephi.b22901.ae.lab1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {
    
    public HashMap<String, List<Double>> readData(String filePath, String sheetName) throws FileNotFoundException, IOException{
        HashMap<String, List<Double>> dataMap = new LinkedHashMap<>();
        
        FileInputStream fis = null;
        Workbook workbook = null;
        
        try{
            fis = new FileInputStream(new File(filePath));
            workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null){
                 throw new IllegalArgumentException("Лист с таким именем не найден.");
            }
            
            // Определяем заголовки (названия столбцов)
            Row headerRow = sheet.getRow(0);
            if (headerRow == null) {
                throw new IllegalArgumentException("Файл не содержит заголовков.");
            }
            
            // Создаем списки для каждого столбца
            for (Cell cell : headerRow) {
                String columnName = cell.getStringCellValue().trim();
                dataMap.put(columnName, new ArrayList<>());
            }
            
            // Читаем данные из каждой строки
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) {
                    continue; // Пропускаем пустые строки
                }

                int columnIndex = 0;
                for (String columnName : dataMap.keySet()) {
                    Cell cell = row.getCell(columnIndex++);
                    if (cell != null) {
                        try {
                            double value = cell.getNumericCellValue();
                            dataMap.get(columnName).add(value);
                        } catch (Exception e) {
                            // Если ячейка не содержит числовое значение, пропускаем её
                            System.err.println("Невозможно прочитать значение из ячейки: " + cell.getAddress());
                        }
                    }
                }
            }

        } catch (IOException e) {
            // Обработка ошибок чтения файла
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            // Обработка ошибок, связанных с форматом данных
            System.err.println("Ошибка в структуре файла: " + e.getMessage());
        } finally {
            // Закрываем файл и освобождаем ресурсы
            try {
                if (workbook != null) {
                    workbook.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                System.err.println("Ошибка при закрытии файла: " + e.getMessage());
            }
        }

        return dataMap; 
    }
    
    public List<String> getSheetNames(String filePath) throws IOException{
        List <String> sheetNames = new ArrayList<>();
        FileInputStream fis = null;
        Workbook workbook = null;
        try{
            fis = new FileInputStream(new File(filePath));
            workbook = new XSSFWorkbook(fis);
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++){
            sheetNames.add(workbook.getSheetName(i));
            }  
        } catch(IOException ex){
            System.err.println("Ошибка при чтении списка листов: " + ex.getMessage());
            throw ex;
        } finally {
            try{
                if (workbook != null){
                    workbook.close();
                }
                if (fis != null){
                    fis.close();
                }
                
            } catch(IOException ex){
                System.err.println("Ошибка при закрытии файла: " + ex.getMessage());
            }
        }
        return sheetNames;
        
    }
    
}
