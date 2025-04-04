
package mephi.b22901.ae.lab2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;


public class OrcArmyController {
    private OrcArmyView view;
    private Map<String, OrcBuilderFactory> factoryMap;

    public OrcArmyController(OrcArmyView view) {
        this.view = view;

        // Инициализация фабрик
        factoryMap = new HashMap<>();
        factoryMap.put("Мордор", new MordorOrcBuilderFactory());
        factoryMap.put("Дол Гулдур", new DolGuldurBuilderFactory());
        factoryMap.put("Мглистые Горы", new MistyMountainsOrcBuilderFactory());

        // Настройка слушателей событий
        setupEventListeners();
    }

    private void setupEventListeners() {
        // Слушатель для кнопки создания нового орка
        view.addCreateOrcListener(e -> {
            String tribe = view.getSelectedTribe();
            String role = view.getSelectedRole();

            if (tribe != null && role != null) {
                Orc newOrc = createNewOrc(tribe, role);
                if (newOrc != null) {
                    view.addOrcToArmy(newOrc, tribe);
                }
            }
        });

        // Слушатель для выбора орка в дереве
        view.addTreeSelectionListener(e -> {
            Orc selectedOrc = view.getSelectedOrc();
            if (selectedOrc != null) {
                view.displayOrcInfo(selectedOrc);
            }
        });
    }

    public Orc createNewOrc(String tribe, String role) {
        OrcBuilderFactory factory = factoryMap.get(tribe);
        if (factory == null) {
            throw new IllegalArgumentException("Фабрика для племени не найдена: " + tribe);
        }

        OrcBuilder builder = factory.createOrcBuilder();
        OrcDirector director = new OrcDirector(builder);

        Orc newOrc = null;
        if ("Базовый".equals(role)) {
            newOrc = director.createBasicOrk();
        } else if ("Командир".equals(role)) {
            newOrc = director.createLeaderOrk();
        } else if ("Разведчик".equals(role)) {
            newOrc = director.createScoutOrk();
        }

        return newOrc;
    }
}