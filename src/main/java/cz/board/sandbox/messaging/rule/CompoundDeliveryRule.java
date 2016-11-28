package cz.board.sandbox.messaging.rule;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class CompoundDeliveryRule implements DeliveryRule {

    private final Set<DeliveryRule> rules;

    public CompoundDeliveryRule() {
        this.rules = new HashSet<>();
    }

    public void addRule(DeliveryRule rule) {
        rules.add(rule);
    }

    @Override
    public boolean canDeliverAt(LocalDateTime instant) {
        return rules.stream()
                .allMatch(rule -> rule.canDeliverAt(instant));
    }

}
