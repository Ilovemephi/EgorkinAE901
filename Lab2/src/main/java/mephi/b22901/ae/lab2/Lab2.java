package mephi.b22901.ae.lab2;

import javax.swing.SwingUtilities;


public class Lab2 {

    public static void main(String[] args) {
       SwingUtilities.invokeLater(() -> {
            // Создаем представление
            OrcArmyView view = new OrcArmyView();

            // Создаем контроллер и передаем ему представление
            OrcArmyController controller = new OrcArmyController(view);
        });
    }

}
