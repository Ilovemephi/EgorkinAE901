package mephi.b22901.ae.lab2;

import javax.swing.SwingUtilities;


public class Lab2 {

    public static void main(String[] args) {
        // Используем SwingUtilities.invokeLater для корректной работы с GUI
        SwingUtilities.invokeLater(() -> {
            new OrcArmyView(); // Создаем экземпляр графического интерфейса
        });
        
    }
}
