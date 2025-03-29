
package mephi.b22901.ae.lab2;

import java.util.ArrayList;
import java.util.List;


public class ArmyFactoryManager {
    
    public static String[] getTribes() {
        return new String[]{"Мордор", "Дол Гулдур", "Мглистые Горы"};
    }
    
    public static OrcBuilderFactory[] createFactories() {
        
        OrcBuilderFactory mordorFactory = new MordorOrcBuilderFactory();
        OrcBuilderFactory dolGuldurFactory = new DolGuldurBuilderFactory();
        OrcBuilderFactory mistyMountainsFactory = new MistyMountainsOrcBuilderFactory();

        return new OrcBuilderFactory[]{mordorFactory, dolGuldurFactory, mistyMountainsFactory};
    }
    
     public static List<Orc> createArmy(OrcBuilderFactory[] factories, String[] tribes) {
        List<Orc> army = new ArrayList<>();
        OrcDirector director = new OrcDirector(null);

        for (int i = 0; i < tribes.length; i++) {
            
            // Получаем строителя для текущего племени
            OrcBuilder builder = factories[i].createOrcBuilder();
            director.setBuilder(builder);

            // Создаем базового орка
            Orc basicOrc = director.createBasicOrk();
            army.add(basicOrc);

            // Создаем командира
            Orc leaderOrc = director.createLeaderOrk();
            army.add(leaderOrc);

            // Создаем разведчика
            Orc scoutOrc = director.createScoutOrk();
            army.add(scoutOrc);
        }

        return army;
    }
   
    
}
