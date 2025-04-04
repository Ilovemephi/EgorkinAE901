
package mephi.b22901.ae.lab2;

import com.github.javafaker.Faker;


public class MistyMountainsOrcBuilder implements OrcBuilder {
    private Orc orc;
    private MistyMountainsGearFactory mmgf;
    
    public MistyMountainsOrcBuilder(MistyMountainsGearFactory mmgf){
        this.mmgf = mmgf;
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
        this.orc.setWeapon(mmgf.createWeapon());
    }

    @Override
    public void buildArmor() {
        this.orc.setArmor(mmgf.createArmor());
    }

    @Override
    public void buildBanner() {
        this.orc.setBanner(mmgf.createBanner());
    }

    @Override
    public void buildStrength() {
        this.orc.setStrength(60);
    }

    @Override
    public void buildDexterity() {
        this.orc.setDexterity(80);
    }

    @Override
    public void buildIq() {
        this.orc.setIq(40);
    }

    @Override
    public void buildHealth() {
        this.orc.setHealth(100);
    }

    @Override
    public Orc getOrc() {
        return this.orc;
        
    }

    @Override
    public void buildScoutWeapon() {
        this.orc.setWeapon(mmgf.createScoutWeapon());
    }

    @Override
    public void buildLeaderWeapon() {
        this.orc.setWeapon(mmgf.createScoutWeapon());
    }
    
}
