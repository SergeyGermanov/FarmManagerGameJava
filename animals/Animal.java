package ictgradschool.industry.assignment02.farmmanager.animals;

public abstract class Animal {
    // Value of the animal
    protected int value;

    /**
     * Feeds the animal, which in turn increases the value of the animal.
     */
    public abstract void feed();

    /**
     * Returns the cost to feed the animal.
     * @return cost to feed the animal.
     */
    public abstract int costToFeed();

    /**
     * Returns the type of the animal.
     * @return type of animal.
     */
    public abstract String getType();

    /**
     * Returns the current value of the animal.
     * @return the current value of the animal.
     */
    public int getValue() {
        return value;
    }

}
