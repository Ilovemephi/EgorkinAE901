package mephi.b22901.ae.lab2;

import com.github.javafaker.Faker;

public abstract class OrcBuilder { 
    protected Orc orc;
    
    public OrcBuilder(){
        this.orc = new Orc();
    }
       

    public void buildName(){
        this.orc.setName(Faker.instance().lordOfTheRings().character() + "morg");
    }
    public abstract void buildWeapon();
    public abstract void buildScoutWeapon();
    public abstract void buildLeaderWeapon();
    public abstract void buildArmor();
    public abstract void buildBanner();
    public abstract void buildStrength();
    public abstract void buildDexterity();
    public abstract void buildIq();
    public abstract void buildHealth();
    
    public Orc getOrc(){
        return this.orc;
    }
    
    
}
