public class Main {
    public static void main(String[] args) {
        Character hero = new Character("Hero", 100, 45, 12);
        Character boss = new Character("Cyber_Ghost", 120, 40, 10);

        BattleSystem arena = new BattleSystem();

        arena.startBattle(hero, boss);
    }
}