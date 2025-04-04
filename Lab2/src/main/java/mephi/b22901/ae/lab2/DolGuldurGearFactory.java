
package mephi.b22901.ae.lab2;


public class DolGuldurGearFactory implements OrcGearFactory {

    @Override
    public Weapon createWeapon() {
        return new Spear();
    }

    @Override
    public Armor createArmor() {
        return new Chainmail();
    }

    @Override
    public Banner createBanner() {
        return new SpiderBanner();
    }

    @Override
    public Weapon createScoutWeapon() {
        return new Bow();
    }

    @Override
    public Weapon createLeaderWeapon() {
        return new Ax();
    }
    
}
