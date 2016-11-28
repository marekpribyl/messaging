package cz.board.sandbox.messaging;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

//@Component
public class EnveloperBuilderFactory {

    //@Autowired from config - list of bank holidays
    Set<LocalDate> bankHolidays = new HashSet<LocalDate>() {{
        add(LocalDate.of(2017, 1, 1));
        add(LocalDate.of(2017, 5, 1));
    }};

    //@autowired from config working hours
    LocalTime from = LocalTime.of(7, 0);
    LocalTime to = LocalTime.of(22, 0);

    public EnvelopeBuilder envelopeBuilder() {
        return new EnvelopeBuilder(from, to, bankHolidays);
    }

}
