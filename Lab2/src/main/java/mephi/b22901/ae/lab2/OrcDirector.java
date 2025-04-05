
package mephi.b22901.ae.lab2;



public class OrcDirector {
    private OrcBuilder builder;
    
    public OrcDirector (OrcBuilder builder){
        this.builder = builder;
    }
    
    public void setBuilder(OrcBuilder builder) {
        this.builder = builder;
    }
    
    public Orc createBasicOrk() {
        builder.buildName();
        builder.buildWeapon();
        builder.buildArmor();
        builder.buildStrength();
        builder.buildDexterity();
        builder.buildIq();
        builder.buildHealth();
        return builder.getOrc();
    }
    
    public Orc createLeaderOrk() {
        builder.buildName();
        builder.buildWeapon(); 
        builder.buildArmor();
        builder.buildBanner(); 
        builder.buildLeaderWeapon();
        builder.buildStrength();
        builder.buildDexterity();
        builder.buildIq();
        builder.buildHealth();
        return builder.getOrc();
    }
    
    public Orc createScoutOrk() {
        builder.buildName();
        builder.buildScoutWeapon();
        builder.buildArmor();
        builder.buildStrength();
        builder.buildDexterity();
        builder.buildIq();
        builder.buildHealth();
        return builder.getOrc();
    }
    
   
    
    
}
