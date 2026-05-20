public class Character {
    protected String name;
    protected int hp;
    protected int attackPower;
    protected int defense;

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
    
    public void attack(Character target) {
        int damage = this.attackPower - target.getDefense();
        if (damage < 1) {
            damage = 1;
        }
        System.out.println(this.name + "Menyerang " + target.getName() + "!");
        target.takeDamage(damage);
    }
    public void specialAbility(Character target) {
    int damage = (int)(this.attackPower * 1.2) - target.getDefense();
    if (damage < 1) {
        damage = 1;
    }

    System.out.println(this.name + " menggunakan ability dasar!");
    target.takeDamage(damage);
    }

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
    
}