package cz.board.sandbox.messaging.rule;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class WorkWeekRule implements DeliveryRule {

    @Override
    public boolean canDeliverAt(LocalDateTime instant) {
        DayOfWeek dayOfWeek = instant.getDayOfWeek();

        return !(dayOfWeek == SATURDAY || dayOfWeek == SUNDAY);
    }

}
