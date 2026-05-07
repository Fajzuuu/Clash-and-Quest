public class Archer extends Character {
    private double criticalChance;

    public Archer(String name) {
        // Mengirim data ke constructor Character (name, hp, attackPower, defense)
        // Archer: HP 125, Attack 40, Defense 15 (Statistik sedang/menengah)
        super(name, 125, 40, 15);
        this.criticalChance = 0.35; // Peluang kritikal 35%
    }

    // Method tambahan untuk melihat status khusus Archer
    public void displaySpecialStat() {
        System.out.println("Critical Chance: " + (criticalChance * 100) + "%");
    }
}