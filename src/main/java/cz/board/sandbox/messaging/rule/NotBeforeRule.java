package cz.board.sandbox.messaging.rule;

import java.time.LocalDateTime;

public class NotBeforeRule implements DeliveryRule {

    private final LocalDateTime threshold;

    public NotBeforeRule(LocalDateTime threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean canDeliverAt(LocalDateTime instant) {
        return instant.isAfter(threshold);
    }
}
