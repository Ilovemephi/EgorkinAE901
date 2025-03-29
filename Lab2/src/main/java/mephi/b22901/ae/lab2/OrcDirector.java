
package mephi.b22901.ae.lab2;



public class OrcDirector {
    private OrcBuilder builder;
    
    public OrcDirector (OrcBuilder builder){
        this.builder = builder;
    }
    
    // Метод для установки строителя
    public void setBuilder(OrcBuilder builder) {
        this.builder = builder;
    }
    
    public Orc createBasicOrk() {
        builder.createNewOrс();
        builder.buildName();
        builder.buildWeapon();
        builder.buildArmor();
        builder.buildBanner();
        builder.buildStrength();
        builder.buildDexterity();
        builder.buildIq();
        builder.buildHealth();
        return builder.getOrc();
    }
    
    public Orc createLeaderOrk() {
        builder.createNewOrс();
        builder.buildName();
        builder.buildWeapon(); 
        builder.buildArmor();
        builder.buildBanner(); 
        builder.buildSpecialWeapon(new Horn());
        builder.buildStrength();
        builder.buildDexterity();
        builder.buildIq();
        builder.buildHealth();
        return builder.getOrc();
    }
    
    public Orc createScoutOrk() {
        builder.createNewOrс();
        builder.buildName();
        builder.buildSpecialWeapon(new Bow());
        builder.buildArmor();
        builder.buildStrength();
        builder.buildDexterity();
        builder.buildIq();
        builder.buildHealth();
        return builder.getOrc();
    }
    
   
    
    
}
