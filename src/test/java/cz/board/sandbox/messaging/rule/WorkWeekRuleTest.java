package cz.board.sandbox.messaging.rule;

import static java.time.LocalDateTime.of;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

public class WorkWeekRuleTest {

    static final LocalDateTime TUESDAY = of(2016, 11, 29, 12, 45);
    static final LocalDateTime SATURDAY = of(2016, 11, 19, 12, 45);
    static final LocalDateTime SUNDAY = of(2016, 11, 20, 12, 45);

    WorkWeekRule rule;

    @Before
    public void setUp() throws Exception {
        rule = new WorkWeekRule();
    }

    @Test
    public void shouldRetrunTrueForTuesday() throws Exception {
        assertTrue(rule.canDeliverAt(TUESDAY));
    }

    @Test
    public void shouldRetrunFalseForWeekend() throws Exception {
        assertFalse(rule.canDeliverAt(SATURDAY));
        assertFalse(rule.canDeliverAt(SUNDAY));
    }
}