package cz.board.sandbox.messaging.rule;

import static java.util.Arrays.asList;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class BankHolidaysRule implements DeliveryRule {

    private final Set<LocalDate> bankHolidays;

    public BankHolidaysRule(LocalDate... dates) {
        this.bankHolidays = new HashSet<>();
        this.bankHolidays.addAll(asList(dates));
    }

    public BankHolidaysRule(Set<LocalDate> bankHolidays) {
        this.bankHolidays = bankHolidays;
    }

    @Override
    public boolean canDeliverAt(LocalDateTime instant) {
        return bankHolidays.stream()
                .noneMatch(localDate -> instant.toLocalDate().equals(localDate));
    }

}
