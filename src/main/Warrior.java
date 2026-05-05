public class Warrior extends Character {
    public Warrior(String name) {
        // Memanggil constructor Character: name, hp, attack, defense
        super(name, 150, 45, 25);
    }
    @Override
    public void attack(Character target) {
        // Kalkulasi spesifik Warrior
        int damageDealt = this.getAttackPower() - target.getDefense();
        
        // Sesuai aturan: minimum damage adalah 1 (bahkan jika defense musuh tinggi)
        if (damageDealt < 1) {
            damageDealt = 1;
        }

        System.out.println(this.getName() + " mengayunkan senjata dengan kuat!");
        target.takeDamage(damageDealt);
    }
}