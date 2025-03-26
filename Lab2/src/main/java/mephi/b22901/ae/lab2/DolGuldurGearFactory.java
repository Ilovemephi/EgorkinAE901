
package mephi.b22901.ae.lab2;


public class DolGuldurGearFactory implements OrcGearFactory {

    @Override
    public String createWeapon() {
        return "Spear";
    }

    @Override
    public String createArmor() {
        return "Chainmail";
    }

    @Override
    public String createBanner() {
        return "SpiderBanner";
    }
    
}
