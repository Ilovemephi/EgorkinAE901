
package mephi.b22901.ae.lab2;

import com.github.javafaker.Faker;






public class DolGuldurOrcBuilder implements OrcBuilder {
    private Orc orc;
    private DolGuldurGearFactory dggf;
    
    public DolGuldurOrcBuilder (DolGuldurGearFactory dggf){
        this.dggf = dggf;
    }

    @Override
    public void createNewOrс() {
       this.orc = new Orc();
    }

    @Override
    public void buildName() {
        this.orc.setName(Faker.instance().lordOfTheRings().character());
    }

    @Override
    public void buildWeapon() {
        this.orc.setWeapon(dggf.createWeapon());
    }

    @Override
    public void buildArmor() {
        this.orc.setArmor(dggf.createArmor());
    }

    @Override
    public void buildBanner() {
        this.orc.setBanner(dggf.createBanner());
    }

    @Override
    public void buildStrength() {
        this.orc.setStrength(70);
    }

    @Override
    public void buildDexterity() {
        this.orc.setStrength(60);
    }

    @Override
    public void buildIq() {
        this.orc.setIq(35);
        
        
    }

    @Override
    public void buildHealth() {
        this.orc.setHealth(120);
        
    }

    @Override
    public Orc getOrc() {
        return this.orc;
    }
    
}
