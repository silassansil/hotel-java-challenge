package domain;

import enums.CustomerType;
import enums.DayOfWeekType;

import java.util.List;
import java.util.Map;

public class Hotel extends AbstractHotel {

    private final Map<CustomerType, Map<DayOfWeekType, Integer>> dailyFees;

    public Hotel(String name, Short rating, Map<CustomerType, Map<DayOfWeekType, Integer>> dailyFees) {
        super(name, rating);
        this.dailyFees = dailyFees;
    }

    public HotelQuotation quote(final CustomerType customerType, final List<DayOfWeekType> dayOfWeekType) {
        return new HotelQuotation(this.name, this.rating, this.lookupFeeByCustomerTypeDayOfWeekType(customerType, dayOfWeekType));
    }

    private Integer lookupFeeByCustomerTypeDayOfWeekType(final CustomerType customerType,
                                                         final List<DayOfWeekType> dayOfWeekType) {
        final Map<DayOfWeekType, Integer> feesByCustomerType = this.dailyFees.get(customerType);
        return dayOfWeekType.stream()
                .map(feesByCustomerType::get)
                .reduce(Integer::sum)
                .orElse(0);
    }
}
