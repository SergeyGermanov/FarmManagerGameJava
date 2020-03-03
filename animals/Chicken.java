package ictgradschool.industry.assignment02.farmmanager.animals;
/**
 * This class defines a Chicken.
 * http://ascii.co.uk/art/chicken
 * +-------------------------------------+
 * |                 xx                  |
 * |                / .|_                |
 * |               /(_)_<                |
 * |              /  (                   |
 * |     ((____.-'    )                  |
 * |      \\         /                   |
 * |       \'-.-.-'`/                    |
 * |     _  \______/                     |
 * |    (_)   _|_\_                      |
 * +-------------------------------------+
 * A chicken has an initial value of $200, and a maximum value of $300.
 * The cost to feed a chicken is $3.
 * You can always collect eggs and earn $5 for each.
 *
 * @author Sergey Germanov.
 */

public class Chicken extends Animal implements IProductionAnimal {
    private final int MAX_VALUE = 300;


    public Chicken() { value = 200; }

    @Override
    public void feed() {
        if (value < MAX_VALUE) {
            value = value + (MAX_VALUE - value) / 2;
        }

    }

    @Override
    public int costToFeed() {
        return 3;
    }

    @Override
    public String getType() {
        return "Chicken";
    }

    @Override
    public String toString() {
        System.out.println("+-------------------------------------+");
        System.out.println("|                 xx                  |");
        System.out.println("|                / .|_                |");
        System.out.println("|               /(_)_<                |");
        System.out.println("|              /  (                   |");
        System.out.println("|     ((____.-'    )                  |");
        System.out.println("|      \\\\         /                   |");
        System.out.println("|       \\'-.-.-'`/                    |");
        System.out.println("|     _  \\______/                     |");
        System.out.println("|    (_)   _|_\\_                      |");
        System.out.println("+-------------------------------------+");
        return getType() + " - $" + value;
    }

    @Override
    public boolean harvestable() {
        return true;
    }

    @Override
    public int harvest() {
        return 5;
    }
}
