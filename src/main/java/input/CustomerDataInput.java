package input;

import enums.CustomerType;
import enums.DayOfWeekType;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static enums.CustomerType.byValue;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class CustomerDataInput {

    private static final String RETRIEVE_WISHED_DATE_EXP = "((^.*)(?=\\(\\w{3,4}\\)))";
    private static final String VALID_INPUT_DATA_EXP = "(?:(Regular|Fidelidade))(?::\\s?)(?:(\\d{1,2}\\w{3}\\d{4}\\(\\w{3,4}\\)(?:,?\\s?)))+";
    private static final String COMMA = ",";
    public static final String COLON = ":";
    private static final String DATE_PATTERN = "ddMMMyyyy";

    private final CustomerType customerType;
    private final Set<DayOfWeek> dates;

    public CustomerDataInput(String customerDataRaw) {
        this.validateUserDataFormat(customerDataRaw);

        this.customerType = byValue(customerDataRaw.split(COLON)[0]);
        this.dates = this.buildWishesDateFromStringData(customerDataRaw.split(COLON)[1]);
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public List<DayOfWeekType> dayOfWeekType() {
        return this.dates.stream()
                .map(DayOfWeekType::fromDayOfWeek)
                .collect(toList());
    }

    private Set<DayOfWeek> buildWishesDateFromStringData(final String wishedDates) {
        final Pattern pattern = Pattern.compile(RETRIEVE_WISHED_DATE_EXP);
        return stream(wishedDates.trim().split(COMMA))
                .map(value -> this.mapWeekNameToDayOfWeek(value, pattern))
                .filter(Objects::nonNull)
                .collect(toSet());
    }

    private DayOfWeek mapWeekNameToDayOfWeek(final String dateWished, final Pattern pattern) {
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
        final Matcher matcher = pattern.matcher(dateWished.trim());
        if (matcher.find())
            return LocalDate.parse(matcher.group(), dateTimeFormatter).getDayOfWeek();

        return null;
    }

    private void validateUserDataFormat(String userDataRaw) {
        final Pattern compile = Pattern.compile(VALID_INPUT_DATA_EXP);
        final Matcher matcher = compile.matcher(userDataRaw);
        if (!matcher.matches())
            throw new IllegalArgumentException("Invalid data format");
    }
}
