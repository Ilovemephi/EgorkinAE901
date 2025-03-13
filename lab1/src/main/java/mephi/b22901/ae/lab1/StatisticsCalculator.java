package mephi.b22901.ae.lab1;

import java.util.List;
import org.apache.commons.math3.stat.correlation.Covariance;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;


public class StatisticsCalculator {
   
    
   
    
    public double calculateGeometricMean(List<Double> data) { // среднее геометрическое 
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("Список данных не может быть пустым.");
        }
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for (double value : data) {
            stats.addValue(value);
        }
        return stats.getGeometricMean();
    }
    
    public double calculateArithmeticMean(List<Double> data) { // среднее арифметическое
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("Список данных не может быть пустым.");
        }
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for (double value : data) {
            stats.addValue(value);
        }
        return stats.getMean();
    }
    
    public double calculateStandardDeviation(List<Double> data) { // стандартное отклонение 
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("Список данных не может быть пустым.");
        }
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for (double value : data) {
            stats.addValue(value);
        }
        return stats.getStandardDeviation();
    }
    
    public double calculateRange(List<Double> data) { // размах
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("Список данных не может быть пустым.");
        }
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for (double value : data) {
            stats.addValue(value);
        }
        return stats.getMax() - stats.getMin();
    }
    
    public int calculateSampleSize(List<Double> data) {// количество элементов
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("Список данных не может быть пустым.");
        }
        return data.size();
    }
    
    public double calculateCoefficientOfVariation(List<Double> data) { // коэфф вариации
       if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("Список данных не может быть пустым.");
        }
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for (double value : data) {
            stats.addValue(value);
        }
        double mean = stats.getMean();
        double stdDev = stats.getStandardDeviation();
        return (stdDev / mean) * 100; 
    }
    
    public double calculateVariance(List<Double> data) { // Дисперсия 
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("Список данных не может быть пустым.");
        }
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for (double value : data) {
            stats.addValue(value);
        }
        return stats.getVariance();
    }
    
    public double[] calculateMinMax(List<Double> data) { // минимум и максимум
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("Список данных не может быть пустым.");
        }
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for (double value : data) {
            stats.addValue(value);
        }
        return new double[]{stats.getMin(), stats.getMax()};
    }
    
    public double calculateCovariance(List<Double> data1, List<Double> data2) { // коэфф ковариации
        if (data1 == null || data2 == null || data1.size() != data2.size()) {
            throw new IllegalArgumentException("Размеры выборок должны совпадать для расчета ковариации.");
        }
        Covariance covariance = new Covariance();
        double[] array1 = new double[data1.size()];
        double[] array2 = new double[data2.size()];
        for (int i = 0; i < data1.size(); i++){
            array1[i] = data1.get(i);
        }
        for (int i = 0; i < data2.size(); i++){
            array2[i] = data2.get(i);
        }
        return covariance.covariance(array1, array2);
    }
    
    
    public double[] calculateConfidenceInterval(List<Double> data, double confidenceLevel) { // доверительный интервал 
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("Список данных не может быть пустым.");
        }
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for (double value : data) {
            stats.addValue(value);
        }
        double mean = stats.getMean();
        double stdDev = stats.getStandardDeviation();
        int n = data.size();

        // из таблицы значений Лапласа получаем следующий квантиль
        double quantille = 1.96; // Для 95% уровня доверия
        double marginOfError = quantille * (stdDev / Math.sqrt(n));

        double lowerBound = mean - marginOfError;
        double upperBound = mean + marginOfError;

        return new double[]{lowerBound, upperBound};
}
}
