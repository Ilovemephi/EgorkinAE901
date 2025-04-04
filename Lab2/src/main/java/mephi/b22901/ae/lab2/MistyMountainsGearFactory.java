
package mephi.b22901.ae.lab2;


public class MistyMountainsGearFactory implements OrcGearFactory {

    @Override
    public Weapon createWeapon() {
       return new Axe();
    }

    @Override
    public Armor createArmor() {
        return new LeatherArmor();
    }

    @Override
    public Banner createBanner() {
        return new MoonBanner();
       
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
