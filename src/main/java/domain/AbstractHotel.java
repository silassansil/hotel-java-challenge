package domain;

public abstract class AbstractHotel {

    protected final String name;
    protected final Short rating;

    public AbstractHotel(String name, Short rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return this.name;
    }
}
