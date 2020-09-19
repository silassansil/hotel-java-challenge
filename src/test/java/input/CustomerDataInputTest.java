package input;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class CustomerDataInputTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void validInputCustomerDataTest() {
        final CustomerDataInput customerDataInput = new CustomerDataInput(
                "Regular: 16Mar2020(mon), 17Mar2020(tues),18Mar2020(wed)");

        assertNotNull(customerDataInput.getCustomerType());
        assertFalse(customerDataInput.dayOfWeekType().isEmpty());
    }

    @Test
    public void validInputCustomerDataWithOutWhiteSpaceTest() {
        final CustomerDataInput customerDataInput = new CustomerDataInput(
                "Regular:16Mar2020(mon),17Mar2020(tues),18Mar2020(wed)");

        assertNotNull(customerDataInput.getCustomerType());
        assertFalse(customerDataInput.dayOfWeekType().isEmpty());
    }

    @Test
    public void invalidInputCustomerTypeTest() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Invalid data format");

        new CustomerDataInput("Test: 16Mar2020(mon), 17Mar2020(tues),18Mar2020(wed)");
    }

    @Test
    public void invalidInputDateFormatTest() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Invalid data format");

        new CustomerDataInput("Fidelidade: Mar2020(mon), 17Mar2020(tues),18Mar2020(wed)");
    }
}