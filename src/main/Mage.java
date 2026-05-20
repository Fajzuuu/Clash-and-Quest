public class Mage extends Character {
    public Mage(String name) {
        super(
            name, 
            CalculateByPercentage(BaseHp, 0.1), 
            CalculateByPercentage(BaseAttack, 0.5), 
            CalculateByPercentage(BaseDefense, 0.1));
    }

    // ==========================================
    // TUGAS ANGGOTA 2: Override Method Attack
    // ==========================================
    @Override
    public void attack(Character target) {
        System.out.println(this.name + " merapalkan sihir [Burst Fire]!");

        // Logika Mage: Mengabaikan 50% defense musuh (Defense Piercing)
        int defenseMusuhYangDihitung = (int) (target.getDefense() * 0.5);

        // Menggunakan konsep persentase: Tambahan damage sebesar 10% dari sisa HP musuh
        int bonusPersenDamage = (int) (target.getHp() * 0.1);

        int damageDealt = (this.attackPower + bonusPersenDamage) - defenseMusuhYangDihitung;
        damageDealt = Math.max(1, damageDealt);

        target.takeDamage(damageDealt);
    }

    // ==========================================
    // TUGAS ANGGOTA 2: Tambah Special Ability
    // ==========================================
    @Override
    public void specialAbility(Character target) {
        System.out.println(this.name + " memanggil sihir kuno [Meteor Strike]!");
        // Efek: Kerusakan murni berbasis persentase (25% dari total HP maks/sisa musuh murni)
        int damageSihir = (int) (target.getHp() * 0.25);
        damageSihir = Math.max(15, damageSihir); // Minimal damage ledakan sihir

        target.takeDamage(damageSihir);
    }
}