public class Mage extends Character { //error karena diubah menjadi abstract class, jadi harus di override semua method abstractnya
    public Mage(String name) {
        super(
            name, 
            CalculateByPercentage(BaseHp, 0.1), 
            CalculateByPercentage(BaseAttack, 0.5), 
            CalculateByPercentage(BaseDefense, 0.1));
    }

    @Override
    public void attack(Character target) {
        System.out.println(this.name + " merapalkan sihir [Burst Fire]!");

        int baseMageDamage = (int) (this.attackPower * 0.8);
        int defenseMusuhYangDihitung = (int) (target.getDefense() * 0.5);
        int damageDealt = baseMageDamage - defenseMusuhYangDihitung;

        damageDealt = Math.max(1, damageDealt);
        target.takeDamage(damageDealt);
    }

    @Override
    public void specialAbility(Character target) {
        System.out.println(this.name + " memanggil sihir kuno [Meteor Strike]!");
        int damageSihir = (int) (target.getHp() * 0.25);
        damageSihir = Math.max(15, damageSihir);

        target.takeDamage(damageSihir);
    }
}