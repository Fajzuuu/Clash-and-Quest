public class Warrior extends Character {
    public Warrior(String name) {
        super(
            name, 
            CalculateByPercentage(BaseHp, 0.5), 
            CalculateByPercentage(BaseAttack, 0.25), 
            CalculateByPercentage(BaseDefense, 0.5));
    }

    // ==========================================
    // TUGAS ANGGOTA 2: Override Method Attack
    // ==========================================
    @Override
    public void attack(Character target) {
        // Warrior: damage normal (dikurangi defense, minimal 1)
        int damageDealt = this.attackPower - target.getDefense();
        
        // Aturan khusus dari tugas: Minimal damage 1
        damageDealt = Math.max(1, damageDealt);

        System.out.println(this.name + " menebas dengan pedang besi!");
        target.takeDamage(damageDealt);
    }

    // ==========================================
    // TUGAS ANGGOTA 2: Tambah Special Ability
    // ==========================================
    @Override
    public void specialAbility(Character target) {
        System.out.println(this.name + " menggunakan skill [Iron Wall]!");
        // Efek: Meningkatkan defense sendiri sebesar 50% (berbasis persentase)
        int tambahanDefense = (int) (this.defense * 0.5);
        this.setDefense(this.defense + tambahanDefense);
        System.out.println("Defense " + this.name + " meningkat sebanyak " + tambahanDefense + " poin!");
    }
}