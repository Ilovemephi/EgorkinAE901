
package mephi.b22901.ae.lab1;

import java.util.HashMap;
import java.util.List;


public class DataStorage {
    
    private final HashMap<String, List<Double>> dataMap;
    
    public DataStorage(){
        this.dataMap = new HashMap<>();
    }
    
    public void setData(HashMap<String, List<Double>> dataMap) {
        if (dataMap == null || dataMap.isEmpty()) {
            throw new IllegalArgumentException("Данные не могут быть пустыми.");
        }
        this.dataMap.clear();
        this.dataMap.putAll(dataMap);
    }
    
    public List<Double> getColumnData(String columnName) {
        if (!dataMap.containsKey(columnName)) {
            throw new IllegalArgumentException("Столбец с названием '" + columnName + "' не найден.");
        }
        return dataMap.get(columnName);
    }
    
    public HashMap<String, List<Double>> getAllData() {
        return new HashMap<>(dataMap); // Возвращаем копию, чтобы исходные данные нельзя было изменить
    }

    
    
    
}
