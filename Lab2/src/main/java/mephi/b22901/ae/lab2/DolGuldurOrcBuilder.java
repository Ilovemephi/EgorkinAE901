
package mephi.b22901.ae.lab2;

import com.github.javafaker.Faker;
import java.util.HashSet;
import java.util.Set;






public class DolGuldurOrcBuilder extends OrcBuilder {
    private DolGuldurGearFactory dggf;
    
    public DolGuldurOrcBuilder (DolGuldurGearFactory dggf){
        this.dggf = dggf;
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
        this.orc.setDexterity(50);
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

    @Override
    public void buildScoutWeapon() {
        this.orc.setWeapon(dggf.createScoutWeapon());
    }

    @Override
    public void buildLeaderWeapon() {
        this.orc.setWeapon(dggf.createLeaderWeapon());
        
    }
    
}
