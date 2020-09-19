import domain.AbstractHotel;
import domain.Hotel;
import domain.HotelQuotation;
import input.CustomerDataInput;
import mock.HotelMocks;

import java.util.List;

public class AClass {

    public static String doExecute(final String args) {
        final List<Hotel> hotels = HotelMocks.loadHotels();
        final CustomerDataInput input = new CustomerDataInput(args);

        return hotels.stream()
                .map(hotel -> hotel.quote(input.getCustomerType(), input.dayOfWeekType()))
                .min(HotelQuotation::compareTo)
                .map(AbstractHotel::getName)
                .orElse("something wrong happened");
    }
}
