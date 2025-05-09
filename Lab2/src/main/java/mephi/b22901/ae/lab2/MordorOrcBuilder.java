
package mephi.b22901.ae.lab2;

import com.github.javafaker.Faker;

public class MordorOrcBuilder extends OrcBuilder {
    private MordorGearFactory mgf;
    
    public MordorOrcBuilder(MordorGearFactory mgf){
        this.mgf = mgf;
    }

    

   

    @Override
    public void buildWeapon() {
       this.orc.setWeapon(mgf.createWeapon());
    }

    @Override
    public void buildArmor() {
        this.orc.setArmor(mgf.createArmor());
    }

    @Override
    public void buildBanner() {
        this.orc.setBanner(mgf.createBanner());
    }

    @Override
    public void buildStrength() {
        this.orc.setStrength(85);
    }

    @Override
    public void buildDexterity() {
       this.orc.setDexterity(50);
    }

    @Override
    public void buildIq() {
      this.orc.setIq(25);
    }

    @Override
    public void buildHealth() {
       this.orc.setHealth(150);
    }

    @Override
    public Orc getOrc() {
        return this.orc;
    }

    @Override
    public void buildScoutWeapon() {
        this.orc.setWeapon(mgf.createScoutWeapon());
    }

    @Override
    public void buildLeaderWeapon() {
        this.orc.setWeapon(mgf.createLeaderWeapon());
    }
    
}
