package ictgradschool.industry.assignment02.farmmanager;

import ictgradschool.industry.assignment02.farmmanager.animals.*;

import java.util.Arrays;

/**
 * @author Sergey Germanov
 */
public class Farm {
    private Animal[] animals;
    private final int STARTING_MONEY;
    private int money;

    /**
     * Constructor of Farm
     *
     * @param money The amount of money for starting the farm
     */
    public Farm( int money ) {
        this.money = money;
        this.STARTING_MONEY = money;
        this.animals = new Animal[10];
    }

    /**
     * Constructor of Farm. The default starting money is $10000.
     */
    public Farm() {
        this(10000);
    }

    /**
     * Returns how much money the farm currently has.
     *
     * @return amount of money the farm currently has.
     */
    public int getMoney() {
        return this.money;
    }

    /**
     * Returns how much money the farm started with.
     */
    public int getStartingMoney() {
        return this.STARTING_MONEY;
    }

    /**
     * Purchases an animal and bills the farm for it.
     *
     * @param animalType The name of the type of animal you wish to buy.
     * @return true if the animal can be bought, otherwise false.
     */
    public boolean buyAnimal( String animalType ) {
        Animal newAnimal = getAnimal(animalType);
        // Returns false if the animal type does not exist
        if (newAnimal == null) {
            return false;
        }
        // Calculates the price of the new animal
        int price = (int) (newAnimal.getValue() * 1.15);

        // Returns false if you have insufficient funds
        if (money < price) {
            return false;
        }


        // Add the new animal to the array and deduct the animal price if it is not full
        for (int i = 0; i < animals.length; i++) {
            Animal a = animals[i];

            if (a == null) {
                animals[i] = newAnimal;
                money -= price;
                break;
            }


        }

        return true;
    }

    /**
     * Returns an Animal object based on the given animal type.
     *
     * @param animalType name of the animal type.
     * @return an Animal object if the given animal type exists, otherwise null.
     */
    private Animal getAnimal( String animalType ) {
        switch (animalType.toLowerCase()) {
            case "cow":
                return new Cow();
            case "chicken":
                return new Chicken();
            case "griffin":
                return new Griffin();
            default:
                // Animal type does not exist;
                return null;
        }
    }

    /**
     * Sells all of the animals on the farm.
     *
     * @return the total price of all the animals on the farm.
     */
    public int sell() {
        // Calculate the value of all of your animals
        int totalPrice = 0;

        for (int i = 0; i < animals.length; i++) {
            Animal a = animals[i];
            if (a == null) {
                break;
            }
            totalPrice += a.getValue();
        }

        // Remove the animals from your farm and add their values to your money.
        // Using java.util.Arrays to set all elements in animals to null.
        Arrays.fill(animals, null);
        money += totalPrice;
        return totalPrice;
    }

    /**
     * Feeds all animals on the farm.
     */
    public void feedAll() {
        for (int i = 0; i < animals.length; i++) {
            Animal a = animals[i];
            // Stop going through if there is no more animal
            if (a == null) {
                break;
            }
            // See if you have enough money
            if (money >= a.costToFeed()) {
                // Subtract the cost to feed the animal
                money = money - a.costToFeed();
                a.feed();
            }
        }
    }

    /**
     * Feeds all animals of the type specified on the farm.
     */
    public void feed( String animalType ) {
 
        // Feeds each animal of the specified type if there is enough money to feed.
        for (int i = 0; i < animals.length; i++) {

            Animal a = animals[i];

            if (a == null) {
                break;
            } else if (animalType.equals(a)) {
            } else if (money >= a.costToFeed()) {
                money -= a.costToFeed();
                a.feed();
            }
        }
    }


    /**
     * Prints information for all animals on the farm.
     */
    public void printStock() {

        boolean printed = false;
        for (int i = 0; i < animals.length; i++) {
            Animal a = animals[i];
            if (a != null) {
                System.out.println(a.toString());
                printed = true;

            }

        }
        if (!printed) {
            System.out.println("No animals on the farm");
        }

    }

    /**
     * Harvests products from all animals that can produce products such as milk, eggs and gold nuggets.
     */
    public void harvestAll() {
        for (int i = 0; i < animals.length; i++) {
            Animal a = animals[i];
            if (a instanceof IProductionAnimal) {
                IProductionAnimal obj = (IProductionAnimal) a;
                money += obj.harvest();
            }
        }

    }
}
