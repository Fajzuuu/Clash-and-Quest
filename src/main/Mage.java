public class Mage extends Character {
    public Mage(String name) {
        // Memanggil constructor Character: name, hp, attack, defense
        super(name, 90, 75, 15);
    }
    @Override
    public void attack(Character target) {
        // Kalkulasi spesifik Mage: 
        // 1. Base damage adalah 80% dari attack power
        int baseDamage = (int) (this.getAttackPower() * 0.8);
        
        // 2. Mengabaikan 50% defense musuh (musuh hanya pakai setengah defense-nya)
        int effectiveDefense = target.getDefense() / 2;
        
        // 3. Kalkulasi total damage yang masuk
        int damageDealt = baseDamage - effectiveDefense;
        
        // Memastikan damage minimal 0 (tidak menambah HP musuh jika def terlalu tinggi)
        if (damageDealt < 0) {
            damageDealt = 0;
        }

        System.out.println(this.getName() + " merapal sihir! Mengabaikan sebagian pertahanan lawan.");
        target.takeDamage(damageDealt);
    }
}