package domain;

import mock.HotelMocks;
import org.junit.Test;

import static enums.CustomerType.LOYALTY;
import static enums.CustomerType.REGULAR;
import static enums.DayOfWeekType.WEEKDAY;
import static enums.DayOfWeekType.WEEKEND;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;


public class HotelTest {

    @Test
    public void retrieveHotelQuotationRegularWeekdayWeekend() {
        final String bestChoice = HotelMocks.loadHotels()
                .stream()
                .map(hotel -> hotel.quote(REGULAR, asList(WEEKDAY, WEEKEND)))
                .min(HotelQuotation::compareTo)
                .map(AbstractHotel::getName)
                .get();

        assertEquals("Parque das flores", bestChoice);
    }

    @Test
    public void retrieveHotelQuotationLoyaltyWeekdayWeekend() {
        final String bestChoice = HotelMocks.loadHotels()
                .stream()
                .map(hotel -> hotel.quote(LOYALTY, asList(WEEKDAY, WEEKEND)))
                .min(HotelQuotation::compareTo)
                .map(AbstractHotel::getName)
                .get();

        assertEquals("Mar Atlântico", bestChoice);
    }

    @Test
    public void retrieveHotelQuotationRegularWeekday() {
        final String bestChoice = HotelMocks.loadHotels()
                .stream()
                .map(hotel -> hotel.quote(REGULAR, singletonList(WEEKDAY)))
                .min(HotelQuotation::compareTo)
                .map(AbstractHotel::getName)
                .get();

        assertEquals("Parque das flores", bestChoice);
    }

    @Test
    public void retrieveHotelQuotationLoyaltyWeekday() {
        final String bestChoice = HotelMocks.loadHotels()
                .stream()
                .map(hotel -> hotel.quote(LOYALTY, singletonList(WEEKDAY)))
                .min(HotelQuotation::compareTo)
                .map(AbstractHotel::getName)
                .get();

        assertEquals("Parque das flores", bestChoice);
    }

    @Test
    public void retrieveHotelQuotationRegularWeekend() {
        final String bestChoice = HotelMocks.loadHotels()
                .stream()
                .map(hotel -> hotel.quote(REGULAR, singletonList(WEEKEND)))
                .min(HotelQuotation::compareTo)
                .map(AbstractHotel::getName)
                .get();

        assertEquals("Jardim Botânico", bestChoice);
    }

    @Test
    public void retrieveHotelQuotationLoyaltyWeekend() {
        final String bestChoice = HotelMocks.loadHotels()
                .stream()
                .map(hotel -> hotel.quote(LOYALTY, singletonList(WEEKEND)))
                .min(HotelQuotation::compareTo)
                .map(AbstractHotel::getName)
                .get();

        assertEquals("Mar Atlântico", bestChoice);
    }
}