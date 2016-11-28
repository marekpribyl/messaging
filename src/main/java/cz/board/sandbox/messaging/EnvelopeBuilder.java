package cz.board.sandbox.messaging;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

import cz.board.sandbox.messaging.rule.BankHolidaysRule;
import cz.board.sandbox.messaging.rule.CompoundDeliveryRule;
import cz.board.sandbox.messaging.rule.NotBeforeRule;
import cz.board.sandbox.messaging.rule.WorkWeekRule;
import cz.board.sandbox.messaging.rule.WorkingHoursRule;

public class EnvelopeBuilder {

    private final Set<LocalDate> bankHolidays;
    private final LocalTime from;
    private final LocalTime to;

    private Object payload;

    private CompoundDeliveryRule compoundDeliveryRule;

    EnvelopeBuilder(LocalTime from, LocalTime to, Set<LocalDate> bankHolidays) {
        this.from = from;
        this.to = to;
        this.bankHolidays = bankHolidays;
    }

    public EnvelopeBuilder withPayload(Object payload) {
        return this;
    }

    public EnvelopeBuilder noBankHolidays() {
        compoundDeliveryRule.addRule(new BankHolidaysRule(bankHolidays));
        return this;
    }

    public EnvelopeBuilder workWeekOnly() {
        compoundDeliveryRule.addRule(new WorkWeekRule());
        return this;
    }

    public EnvelopeBuilder workingHoursOnly() {
        compoundDeliveryRule.addRule(new WorkingHoursRule(from, to));
        return this;
    }

    public EnvelopeBuilder notBefore(LocalDateTime threshold) {
        compoundDeliveryRule.addRule(new NotBeforeRule(threshold));
        return this;
    }

    public MessageEnvelope build() {
        return new MessageEnvelope(payload, compoundDeliveryRule);
    }

}
