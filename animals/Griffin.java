package ictgradschool.industry.assignment02.farmmanager.animals;

/**
 * This class defines a Griffin
 * http://ascii.co.uk/art/griffin
 * +-------------------------------------+
 * |                 ___                 |
 * |    __.--/)  .-~~   ~~>>>>>>>>   .-. |
 * |   (._\~  \ (        ~~>>>>>>>>.~.-' |
 * |     -~}   \_~-,    )~~>>>>>>>' /    |
 * |       {     ~/    /~~~~~~. _.-~     |
 * |        ~.(   `--~~/      /~ ~.      |
 * |   .--~~~~_\  \--~(   -.-~~-.  \     |
 * |   ```-'~~ /  /    ~-.  \ .--~ /     |
 * |        (((_.'    (((__.' ```-'      |
 * +-------------------------------------+
 * is a legendary creature with the body, tail, and back legs of a lion; the head and wings of an eagle; and an eagle's talons as its front feet.
 * A griffin has an initial value of $2000, and a maximum value of $8000.
 * The cost to feed a griffin is $250.
 * Griffins lay eggs in burrows on the grounds and these nests contain gold nuggets.
 * A griffin can lay eggs only if its value has reached 7000. The money you can make from collecting gold nuggets which are worth $500.
 *
 * @author Sergey Germanov.
 */

public class Griffin extends Animal implements IProductionAnimal {
    private final int MAX_VALUE = 8000;

    public Griffin() {
        value = 2000;
    }

    @Override
    public void feed() {
        if (value < MAX_VALUE) {
            value = value + (MAX_VALUE - value) / 20;
        }

    }

    @Override
    public int costToFeed() {
        return 250;
    }

    @Override
    public String getType() {
        return "Griffin";
    }

    @Override
    public String toString() {
        System.out.println("+-------------------------------------+");
        System.out.println("|                 ___                 |");
        System.out.println("|    __.--/)  .-~~   ~~>>>>>>>>   .-. |");
        System.out.println("|   (._\\~  \\ (        ~~>>>>>>>>.~.-' |");
        System.out.println("|     -~}   \\_~-,    )~~>>>>>>>' /    |");
        System.out.println("|       {     ~/    /~~~~~~. _.-~     |");
        System.out.println("|        ~.(   `--~~/      /~ ~.      |");
        System.out.println("|   .--~~~~_\\  \\--~(   -.-~~-.  \\     |");
        System.out.println("|   ```-'~~ /  /    ~-.  \\ .--~ /     |");
        System.out.println("|        (((_.'    (((__.' ```-'      |");
        System.out.println("+-------------------------------------+");
        return getType() + " - $" + value;
    }

    @Override
    public boolean harvestable() {
        if (value >= 7000) {
            return true;
        }
        return false;
    }

    @Override
    public int harvest() {
        if (harvestable()) {
            return 500;
        }
        return 0;
    }

}
