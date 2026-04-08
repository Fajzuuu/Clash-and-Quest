public final class Character {
    private final String name;
    private int hp;
    private int attackPower;
    private int defense;

    public Character(String name, int hp, int attackPower, int defense) {
        this.name = name;
        setHp(hp);
        setAttackPower(attackPower);
        setDefense(defense);
    }

    // Getter & Setter dengan Validasi (Encapsulation) 
    public String getName() { return name; }

    public int getHp() { return hp; }
    public void setHp(int hp) {
        // Validasi: HP tidak boleh di bawah 0
        this.hp = Math.max(0, hp); 
    }

    public int getAttackPower() { return attackPower; }
    public void setAttackPower(int attackPower) {
        if (attackPower > 0) this.attackPower = attackPower;
    }

    public int getDefense() { return defense; }
    public void setDefense(int defense) {
        if (defense > 0) this.defense = defense;
    }

    // Method Logika
    public boolean isAlive() {
        return this.hp > 0;
    }

    public void takeDamage(int finalDamage) {
        // HP tidak bisa di bawah 0 karena menggunakan setHp()
        setHp(this.hp - finalDamage);
        System.out.println(this.name + " menerima " + finalDamage + " damage. Sisa HP: " + this.hp);
    }
}