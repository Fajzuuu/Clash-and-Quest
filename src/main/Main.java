public class Main {
    public static void main(String[] args) {
        // Inisialisasi Karakter (Data bebas)
        Character hero = new Character("Yona", 100, 45, 12);
        Character boss = new Character("Cyber_Ghost", 120, 40, 10);

        // Inisialisasi System Battle
        BattleSystem arena = new BattleSystem();

        // Jalankan Battle 
        arena.startBattle(hero, boss);
    }
}