
package mephi.b22901.ae.lab2;


public class MordorGearFactory implements OrcGearFactory {

    @Override
    public String createWeapon() {
        return "HardSword";
    }

    @Override
    public String createArmor() {
        return "SteelArmor";
    }

    @Override
    public String createBanner() {
        return "RedEyeBanner";
                
    }
    
}
