package ictgradschool.industry.assignment02.farmmanager.animals;

/**
 * This class defines a Cow.
 * http://ascii.co.uk/art/cow
 * +-------------------------------------+
 * |    _(__)_        V                  |
 * |   '-e e -'__,--.__)                 |
 * |    (o_o)        )                   |
 * |       \\. /___.  |                  |
 * |        ||| _)/_)/                   |
 * |       //_(/_(/_(                    |
 * +-------------------------------------+
 * A cow has an initial value of $1000, and a maximum value of $1500.
 * The cost to feed a cow is $50.
 * You may modify this class according to the assignment.
 *
 * @author Sergey Germanov.
 */
public class Cow extends Animal implements IProductionAnimal {
    private final int MAX_VALUE = 1500;

    public Cow() {
        value = 1000;
    }

    public void feed() {
        if (value < MAX_VALUE) {
            value += 100;
        }
    }

    public int costToFeed() {
        return 50;
    }

    public String getType() {
        return "Cow";
    }

    public String toString() {
        System.out.println("+-------------------------------------+");
        System.out.println("|    _(__)_        V                  |");
        System.out.println("|   '-e e -'__,--.__)                 |");
        System.out.println("|    (o_o)        )                   |");
        System.out.println("|       \\. /___.  |                   |");
        System.out.println("|        ||| _)/_)/                   |");
        System.out.println("|       //_(/_(/_(                    |");
        System.out.println("+-------------------------------------+");
        return getType() + " - $" + value;
    }

    @Override
    public boolean harvestable() {
        if (value == MAX_VALUE){
            return true;
        }
            return false;

    }

    @Override
    public int harvest() {
        if (harvestable()) {
            return 20;
        }
        return 0;
    }
}
