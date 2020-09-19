package enums;

import static java.util.Arrays.stream;

public enum CustomerType {

    REGULAR("Regular"),
    LOYALTY("Fidelidade");

    private final String value;

    CustomerType(String value) {
        this.value = value;
    }

    public static CustomerType byValue(final String value) {
        return stream(values())
                .filter(x -> value.equals(x.value))
                .findFirst().get();
    }
}
