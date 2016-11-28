package cz.board.sandbox.messaging.rule;

import static java.time.LocalDateTime.of;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

public class NotBeforeRuleTest {

    static final LocalDateTime THRESHOLD = of(2016, 10, 25, 12, 45);

    NotBeforeRule rule;

    @Before
    public void setUp() throws Exception {
        rule = new NotBeforeRule(THRESHOLD);
    }

    @Test
    public void shouldRetrunFalseForInstantBeforeThreshold() {
        assertFalse(rule.canDeliverAt(THRESHOLD));
        assertFalse(rule.canDeliverAt(THRESHOLD.minusMinutes(1)));
    }

    @Test
    public void shouldRetrunTrueForInstantBeforeThreshold() {
        assertTrue(rule.canDeliverAt(THRESHOLD.plusMinutes(1)));
    }

}