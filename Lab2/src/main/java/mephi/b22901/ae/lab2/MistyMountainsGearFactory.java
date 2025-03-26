
package mephi.b22901.ae.lab2;


public class MistyMountainsGearFactory implements OrcGearFactory {

    @Override
    public String createWeapon() {
       return "Axe";
    }

    @Override
    public String createArmor() {
        return "Leatherarmor";
    }

    @Override
    public String createBanner() {
        return "MoonBanner";
       
    }
    
}
