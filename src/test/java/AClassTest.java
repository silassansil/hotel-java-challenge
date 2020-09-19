import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AClassTest {

    @Test
    public void testCase1() {
        final String hotelName = AClass.doExecute("Regular: 16Mar2020(mon), 17Mar2020(tues),18Mar2020(wed)");
        assertEquals("Parque das flores", hotelName);
    }

    @Test
    public void testCase2() {
        final String hotelName = AClass.doExecute("Regular: 20Mar2020(fri), 21Mar2020(sat), 22Mar2020(sun)");
        assertEquals("Jardim Botânico", hotelName);
    }

    @Test
    public void testCase3() {
        final String hotelName = AClass.doExecute("Fidelidade: 26Mar2020(thur), 27Mar2020(fri), 28Mar2020(sat)");
        assertEquals("Mar Atlântico", hotelName);
    }

    @Test
    public void testCase4() {
        final String hotelName = AClass.doExecute("Regular:06Sep2020(sun),07Sep2020(mon),08Sep2020(thur)");
        assertEquals("Parque das flores", hotelName);
    }
}