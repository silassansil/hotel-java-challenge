package mock;

import domain.Hotel;
import enums.CustomerType;
import enums.DayOfWeekType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static enums.CustomerType.LOYALTY;
import static enums.CustomerType.REGULAR;
import static enums.DayOfWeekType.WEEKDAY;
import static enums.DayOfWeekType.WEEKEND;
import static java.util.Arrays.asList;

public class HotelMocks {

    public static List<Hotel> loadHotels() {

        // Parque das flores ------------------------------------------------------------------------------------------
        final Map<DayOfWeekType, Integer> regularParqueDasFlores = new HashMap<DayOfWeekType, Integer>() {{
            put(WEEKDAY, 110);
            put(WEEKEND, 90);
        }};
        final Map<DayOfWeekType, Integer> loyaltyParqueDasFlores = new HashMap<DayOfWeekType, Integer>() {{
            put(WEEKDAY, 80);
            put(WEEKEND, 80);
        }};
        final Map<CustomerType, Map<DayOfWeekType, Integer>> dailyFeesParqueDasFlores = new HashMap<>();
        dailyFeesParqueDasFlores.put(REGULAR, regularParqueDasFlores);
        dailyFeesParqueDasFlores.put(LOYALTY, loyaltyParqueDasFlores);


        // Jardim Botanico --------------------------------------------------------------------------------------------
        final Map<DayOfWeekType, Integer> regularJardimBotanico = new HashMap<DayOfWeekType, Integer>() {{
            put(WEEKDAY, 160);
            put(WEEKEND, 60);
        }};
        final Map<DayOfWeekType, Integer> loyaltyJardimBotanico = new HashMap<DayOfWeekType, Integer>() {{
            put(WEEKDAY, 110);
            put(WEEKEND, 50);
        }};
        final Map<CustomerType, Map<DayOfWeekType, Integer>> dailyFeesJardimBotanico = new HashMap<>();
        dailyFeesJardimBotanico.put(REGULAR, regularJardimBotanico);
        dailyFeesJardimBotanico.put(LOYALTY, loyaltyJardimBotanico);


        // Mar Atlântico ----------------------------------------------------------------------------------------------
        final Map<DayOfWeekType, Integer> regularMarAtlantico = new HashMap<DayOfWeekType, Integer>() {{
            put(WEEKDAY, 220);
            put(WEEKEND, 150);
        }};
        final Map<DayOfWeekType, Integer> loyaltyMarAtlantico = new HashMap<DayOfWeekType, Integer>() {{
            put(WEEKDAY, 100);
            put(WEEKEND, 40);
        }};
        final Map<CustomerType, Map<DayOfWeekType, Integer>> dailyFeesMarAtlantico = new HashMap<>();
        dailyFeesMarAtlantico.put(REGULAR, regularMarAtlantico);
        dailyFeesMarAtlantico.put(LOYALTY, loyaltyMarAtlantico);

        return asList(new Hotel("Parque das flores", (short) 3, dailyFeesParqueDasFlores),
                new Hotel("Jardim Botânico", (short) 4, dailyFeesJardimBotanico),
                new Hotel("Mar Atlântico", (short) 5, dailyFeesMarAtlantico));
    }
}
