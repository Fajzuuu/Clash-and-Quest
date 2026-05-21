public class Warrior extends Character {
    public Warrior(String name) {
        super(
            name, 
            CalculateByPercentage(BaseHp, 0.5), 
            CalculateByPercentage(BaseAttack, 0.25), 
            CalculateByPercentage(BaseDefense, 0.5));
    }

    @Override
    public void attack(Character target) {
        int damageDealt = this.attackPower - target.getDefense();
    
        damageDealt = Math.max(1, damageDealt);

        System.out.println(this.name + " menebas dengan pedang besi!");
        target.takeDamage(damageDealt);
    }

    @Override
    public void specialAbility(Character target) {
        System.out.println(this.name + " menggunakan skill [Iron Wall]!");
        int tambahanDefense = (int) (this.defense * 0.5);
        this.setDefense(this.defense + tambahanDefense);
        System.out.println("Defense " + this.name + " meningkat sebanyak " + tambahanDefense + " poin!");
    }
}