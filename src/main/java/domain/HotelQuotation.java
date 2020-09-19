package domain;

public class HotelQuotation extends AbstractHotel implements Comparable<HotelQuotation> {

    private final Integer dailyFee;

    public HotelQuotation(String name, Short rating, Integer dailyFee) {
        super(name, rating);
        this.dailyFee = dailyFee;
    }

    @Override
    public int compareTo(HotelQuotation o) {
        if (o.dailyFee.equals(this.dailyFee))
            return o.rating.compareTo(super.rating);

        return this.dailyFee.compareTo(o.dailyFee);
    }
}
