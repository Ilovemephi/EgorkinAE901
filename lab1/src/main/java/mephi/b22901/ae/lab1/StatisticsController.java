package mephi.b22901.ae.lab1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsController {
    private final StatisticsCalculator statisticsCalculator;

    public StatisticsController() {
        this.statisticsCalculator = new StatisticsCalculator();
    }

    
    public HashMap<String, HashMap<String, Double>> calculateAllStatistics(DataStorage dataStorage) {
        HashMap<String, HashMap<String, Double>> allStatistics = new HashMap<>();

        // Получаем список всех столбцов из хранилища данных
        List<String> columnNames = dataStorage.getAllData().keySet().stream().toList();

        // Рассчитываем статистические показатели для каждого столбца
        for (String columnName : columnNames) {
            List<Double> columnData = dataStorage.getColumnData(columnName);
            HashMap<String, Double> columnStatistics = calculateColumnStatistics(columnData);

            // Добавляем ковариации для пар столбцов
            for (int i = 0; i < columnNames.size(); i++) {
                for (int j = i + 1; j < columnNames.size(); j++) {
                    String covKey = "Ковариация " + columnNames.get(i) + "-" + columnNames.get(j);
                    if (columnName.equals(columnNames.get(i))) {
                        double covariance = statisticsCalculator.calculateCovariance(
                                columnData,
                                dataStorage.getColumnData(columnNames.get(j))
                        );
                        columnStatistics.put(covKey, covariance);
                    }
                }
            }

            // Сохраняем рассчитанные показатели для текущего столбца
            allStatistics.put(columnName, columnStatistics);
        }

        return allStatistics;
    }

    
    private HashMap<String, Double> calculateColumnStatistics(List<Double> columnData) {
        HashMap<String, Double> statistics = new HashMap<>();

        // Рассчитываем стандартные показатели
        statistics.put("Среднее геометрическое", statisticsCalculator.calculateGeometricMean(columnData));
        statistics.put("Среднее арифметическое", statisticsCalculator.calculateArithmeticMean(columnData));
        statistics.put("Стандартное отклонение", statisticsCalculator.calculateStandardDeviation(columnData));
        statistics.put("Размах", statisticsCalculator.calculateRange(columnData));
        statistics.put("Количество элементов", (double) statisticsCalculator.calculateSampleSize(columnData));
        statistics.put("Коэффициент вариации", statisticsCalculator.calculateCoefficientOfVariation(columnData));
        statistics.put("Дисперсия", statisticsCalculator.calculateVariance(columnData));

        // Рассчитываем минимум и максимум
        double[] minMax = statisticsCalculator.calculateMinMax(columnData);
        statistics.put("Минимум", minMax[0]);
        statistics.put("Максимум", minMax[1]);

        // Рассчитываем доверительный интервал
        double[] confidenceInterval = statisticsCalculator.calculateConfidenceInterval(columnData, 0.95);
        statistics.put("Доверительный интервал (нижняя граница)", confidenceInterval[0]);
        statistics.put("Доверительный интервал (верхняя граница)", confidenceInterval[1]);

        return statistics;
    }
}
