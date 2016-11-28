package cz.board.sandbox.messaging.rule;

import static java.time.LocalDateTime.of;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

public class CompoundDeliveryRuleTest {

    static final LocalDateTime FIRST_OF_JUNE = of(2017, 6, 1, 8, 45);

    static final LocalDateTime THRESHOLD = of(2017, 5, 30, 7, 0);

    static final LocalTime FROM = LocalTime.of(7, 0);

    static final LocalTime TO = LocalTime.of(22, 0);

    static final LocalDate LABOUR_DAY = LocalDate.of(2017, 5, 1);

    CompoundDeliveryRule rule;

    @Before
    public void setUp() throws Exception {
        rule = new CompoundDeliveryRule();
        rule.addRule(new WorkingHoursRule(FROM, TO));
        rule.addRule(new WorkWeekRule());
        rule.addRule(new NotBeforeRule(THRESHOLD));
        rule.addRule(new BankHolidaysRule(LABOUR_DAY));
    }

    @Test
    public void shouldRetrunTrueForNoWrappedRules() throws Exception {
        rule = new CompoundDeliveryRule();

        assertTrue(rule.canDeliverAt(FIRST_OF_JUNE));
    }

    @Test
    public void shouldRetrunFalseForWorkingHoursWeekend() throws Exception {
        assertFalse(rule.canDeliverAt(FIRST_OF_JUNE.plusDays(2)));
    }

    @Test
    public void shouldRetrunFalseOutOfWorkingHoursWorkDay() throws Exception {
        assertFalse(rule.canDeliverAt(FIRST_OF_JUNE.minusHours(2)));
    }

    @Test
    public void shouldRetrunFalseWorkingHoursBankHoliday() throws Exception {
        assertFalse(rule.canDeliverAt(FIRST_OF_JUNE.minusMonths(1)));
    }

    @Test
    public void shouldRetrunFalseForinstantBeforeThreshold() throws Exception {
        assertFalse(rule.canDeliverAt(FIRST_OF_JUNE.minusDays(3)));
    }


}