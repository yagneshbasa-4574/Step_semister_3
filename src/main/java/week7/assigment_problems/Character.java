
package week7.assigment_problems;

public class Character {

    private int health;
    private final int maxHealth;

    public Character(int maxHealth) {
        if (maxHealth < 0) {
            this.maxHealth = 0;
        } else {
            this.maxHealth = maxHealth;
        }

        this.health = this.maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount > 0) {
            health -= amount;

            if (health < 0) {
                health = 0;
            }
        }
    }

    public void heal(int amount) {
        if (amount > 0) {
            health += amount;

            if (health > maxHealth) {
                health = maxHealth;
            }
        }
    }

    public int getHealth() {
        return health;
    }

    public static void main(String[] args) {

        Character c = new Character(100);

        c.takeDamage(30);
        System.out.println("After damage: " + c.getHealth());

        c.heal(50);
        System.out.println("After healing: " + c.getHealth());

        c.takeDamage(150);
        System.out.println("Final health: " + c.getHealth());
    }
}
