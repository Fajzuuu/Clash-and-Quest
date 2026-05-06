public class Archer extends Character {
    private double criticalChance;

    public Archer(String name) {
        // Mengirim data ke constructor Character (name, hp, attackPower, defense)
        // Archer: HP 125, Attack 40, Defense 15 (Statistik sedang/menengah)
        super(name, 125, 40, 15);
        this.criticalChance = 0.35; // Peluang kritikal 35%
    }

    @Override
    public void attack(Character target) {
        // Menghitung damage dasar: (Attack Power Archer - Defense Target)
        int damageDealt = this.getAttackPower() - target.getDefense();
        
        // Logika Critical Hit
        if (Math.random() < this.criticalChance) {
            damageDealt = (int) (damageDealt * 1.8); // Damage dikalikan 1.8x
            System.out.println(this.getName() + " melakukan tembakan CRITICAL!");
        } else {
            System.out.println(this.getName() + " menembakkan panah!");
        }

        // Aturan: Damage minimal adalah 1
        if (damageDealt < 1) {
            damageDealt = 1;
        }

        // Memanggil method takeDamage milik target
        target.takeDamage(damageDealt);
    }

    // Method tambahan untuk melihat status khusus Archer
    public void displaySpecialStat() {
        System.out.println("Critical Chance: " + (criticalChance * 100) + "%");
    }
}