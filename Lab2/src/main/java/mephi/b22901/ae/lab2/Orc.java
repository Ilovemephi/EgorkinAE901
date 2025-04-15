
package mephi.b22901.ae.lab2;


public class Orc {
    private String name;
    private Weapon weapon;
    private Armor armor;
    private Banner banner;
    private int strength;
    private int dexterity;
    private int iq;
    private int health;
    
    
    public Orc() {
        
    }

    
    public void setName(String name){
        this.name = name;
    }
    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }
    public void setArmor(Armor armor){
        this.armor = armor;
    }
    public void setBanner(Banner banner){
        this.banner = banner;
    }
    public void setStrength(int strength){
        this.strength = strength;
    }
    public void setDexterity(int dexterity){
        this.dexterity = dexterity;
    }
    public void setIq(int iq){
        this.iq = iq;
    }
    public void setHealth(int health){
        this.health = health;
    }
    
    public String getName(){
        return name;
    }
    public Weapon getWeapon(){
        return weapon;
    }
    public Armor getArmor(){
        return armor;
    }
    public Banner getBanner(){
        return banner;
    }
    public int getStrength(){
        return strength;
    }
    public int getDexterity(){
        return dexterity;
    }
    public int getIq(){
        return iq;
    }
    public int getHealth(){
        return health;
    }
    
    public String getRole() {
        if (banner != null && weapon instanceof Ax) {
            return "Командир";
        } else if (weapon instanceof Bow) {
            return "Разведчик";
        } else {
            return "Базовый";
        }
    }
    
    
    @Override
public String toString() {
    return String.format(
        "Орк: %s%n" +
        name != null ? name : "Безымянный орк"// Если имя не задано, используем "Безымянный орк"
        
    );
}
    
    
    
}
