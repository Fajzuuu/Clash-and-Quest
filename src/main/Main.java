public class Main {
    public static void main(String[] args) {
        // 1. Membuat object karakter dari subclass yang kamu buat
        Warrior arthur = new Warrior("Arthur (Warrior)");
        Mage merlin = new Mage("Merlin (Mage)");

        // 2. Menampilkan status awal
        System.out.println("=== STATUS AWAL ===");
        System.out.println(arthur.getName() + " | HP: " + arthur.getHp() + " | Atk: " + arthur.getAttackPower() + " | Def: " + arthur.getDefense());
        System.out.println(merlin.getName() + " | HP: " + merlin.getHp() + " | Atk: " + merlin.getAttackPower() + " | Def: " + merlin.getDefense());
        System.out.println();

        // 3. Test serangan manual untuk melihat hasil Override milikmu
        System.out.println("=== TEST CUSTOM ATTACK (OVERRIDE) ===");
        arthur.attack(merlin);
        merlin.attack(arthur);
        System.out.println();

        // 4. Masukkan ke dalam BattleSystem buatan kelompokmu
        System.out.println("=== MASUK KE ARENA BATTLE SYSTEM ===");
        BattleSystem arena = new BattleSystem();
        
        // Karena Warrior dan Mage adalah turunan (extends) dari Character, 
        // mereka bisa dimasukkan ke parameter yang meminta tipe Character.
        arena.startBattle(arthur, merlin);
    }
}