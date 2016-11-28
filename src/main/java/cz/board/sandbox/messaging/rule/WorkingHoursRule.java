package cz.board.sandbox.messaging.rule;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class WorkingHoursRule implements DeliveryRule {

    private final LocalTime from;

    private final LocalTime to;

    public WorkingHoursRule(LocalTime from, LocalTime to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean canDeliverAt(LocalDateTime instant) {
        LocalTime asLocalTime = instant.toLocalTime();

        return asLocalTime.isAfter(from) && asLocalTime.isBefore(to);
    }

}
