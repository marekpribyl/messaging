package cz.board.sandbox.messaging.rule;

import static java.time.LocalDateTime.of;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class BankHolidaysRuleTest {

    static final LocalDate NEW_YEAR_EVE = LocalDate.of(2017, 1, 1);

    static final LocalDate LABOUR_DAY = LocalDate.of(2017, 5, 1);

    BankHolidaysRule rule;

    @Before
    public void setUp() throws Exception {
        rule = new BankHolidaysRule(NEW_YEAR_EVE, LABOUR_DAY);
    }

    @Test
    public void shouldReturnFalseForBankHolidays() throws Exception {
        assertFalse(rule.canDeliverAt(of(2017, 1, 1, 10, 45)));
        assertFalse(rule.canDeliverAt(of(2017, 5, 1, 0, 0)));
    }

    @Test
    public void shouldReturnTrueForDaysOtherThanBankHolidays() throws Exception {
        assertTrue(rule.canDeliverAt(of(2017, 1, 2, 0, 0)));
        assertTrue(rule.canDeliverAt(of(2017, 5, 30, 10, 0)));
    }

    @Test
    public void shouldReturnTrueForBankHolidaysOtherYear() throws Exception {
        assertTrue(rule.canDeliverAt(of(2018, 1, 1, 10, 45)));
        assertTrue(rule.canDeliverAt(of(2018, 5, 1, 0, 0)));
    }


}