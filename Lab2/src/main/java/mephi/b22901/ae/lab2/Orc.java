
package mephi.b22901.ae.lab2;


public class Orc {
    private String name;
    private String weapon;
    private String armor;
    private String banner;
    private int strength;
    private int dexterity;
    private int iq;
    private int health;
    
    public Orc(){
        
    }
    
    public void setName(String name){
        this.name = name;
    }
    public void setWeapon(String weapon){
        this.weapon = weapon;
    }
    public void setArmor(String armor){
        this.armor = armor;
    }
    public void setBanner(String banner){
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
    public String getWeapon(){
        return weapon;
    }
    public String getArmor(){
        return armor;
    }
    public String getBanner(){
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
    
}
