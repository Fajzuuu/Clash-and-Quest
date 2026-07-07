package src.character;
import java.util.ArrayList;
import src.item.Item;

public abstract class Character {
    protected String name;
    protected int hp;
    protected int attackPower;
    protected int defense;

    protected int level;
    protected int exp;

    protected static int BaseHp = 100;
    protected static int BaseAttack = 40;
    protected static int BaseDefense = 20;

    protected static int CalculateByPercentage(int base, double percentage) {
        return (int)(base+(base * percentage));
    }

    public Character(String name, int hp, int attackPower, int defense) {
        this.name = name;
        this.hp = Math.max(0, hp);
        this.attackPower = attackPower > 0 ? attackPower : 0;
        this.defense = defense > 0 ? defense : 0;

        this.level = 1;
        this.exp = 0; 
    }

    // Getter & Setter
    public String getName() { return name; }

    public int getHp() { return hp; }
    public void setHp(int hp) {
        this.hp = Math.max(0, hp); 
    }

    public int getAttackPower() { return attackPower;}
    public void setAttackPower(int attackPower) {
        if (attackPower > 0) this.attackPower = attackPower;
    }

    public int getDefense() { return defense;}
    public void setDefense(int defense) {
        if (defense > 0) this.defense = defense;
    }
    
    public abstract void attack(Character target) ;
    
    public abstract void specialAbility(Character target) ;

    public boolean isAlive() {
        return this.hp > 0;
    }

    public void takeDamage(int finalDamage) {
        setHp(this.hp - finalDamage);
        System.out.println(this.name + " menerima " + finalDamage + " damage. Sisa HP: " + this.hp);
    }

    public int attack() {
        return this.attackPower;
    }

    public abstract String getClassName();

    public int getLevel() { return level; }
    public int getExp() { return exp; }

    public void gainExp(int amount) {
        this.exp += amount;
        System.out.println(this.name + " mendapatkan " + amount + " EXP!");
        
        if (this.exp >= 100) {
            levelUp();
        }
    }

    private void levelUp() {
        this.level++;
        this.exp -= 100; 
        
        int hpBaru = CalculateByPercentage(this.hp, 0.20);
        int attackBaru = CalculateByPercentage(this.attackPower, 0.15); 
        int defenseBaru = CalculateByPercentage(this.defense, 0.15); 
        
        this.setHp(hpBaru);
        this.setAttackPower(attackBaru);
        this.setDefense(defenseBaru);

        System.out.println("\n>> LEVEL UP! " + this.name + " naik ke Level " + this.level + " <<");
        System.out.println("Status Meningkat: HP (" + this.hp + "), Atk (" + this.attackPower + "), Def (" + this.defense + ")\n");
    }

    protected ArrayList<Item> inventory = new ArrayList<>();

    public ArrayList<Item> getInventory() {
    return inventory;
    }

    public void addItem(Item item) {
    inventory.add(item);
    System.out.println(item.getName() + " ditambahkan ke inventory.");
    }

    public void showInventory() {
    System.out.println("=== INVENTORY " + name + " ===");

    if (inventory.isEmpty()) {
        System.out.println("Kosong");
        return;
    }

    for (int i = 0; i < inventory.size(); i++) {
        System.out.println((i + 1) + ". " + inventory.get(i).getName());
    }
    }

    public void useItem(int index) {
    if (index < 0 || index >= inventory.size()) {
        System.out.println("Item tidak valid!");
        return;
    }

    Item item = inventory.get(index);
    item.use(this);

    inventory.remove(index);
    System.out.println(item.getName() + " berhasil digunakan.");
    }
}