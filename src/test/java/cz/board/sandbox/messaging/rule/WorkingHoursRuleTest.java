package cz.board.sandbox.messaging.rule;

import static java.time.LocalDateTime.of;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WorkingHoursRuleTest {

    public static final LocalDateTime AM_10_45 = of(2016, 10, 25, 10, 45, 50);

    static final LocalTime FROM = LocalTime.of(7, 0);

    static final LocalTime TO = LocalTime.of(22, 0);

    WorkingHoursRule rule;

    @Before
    public void setUp() throws Exception {
        rule = new WorkingHoursRule(FROM, TO);
    }

    @Test
    public void shouldReturnTrueForInstantWithinWorkingHours() throws Exception {
        Assert.assertTrue(rule.canDeliverAt(AM_10_45));
    }

    @Test
    public void shouldReturnTrueForInstantOutsideWorkingHours() throws Exception {
        Assert.assertFalse(rule.canDeliverAt(AM_10_45.minusHours(5)));
        Assert.assertFalse(rule.canDeliverAt(AM_10_45.plusHours(12)));
    }

    @Test
    public void shouldReturnFalseForEdgeCases() throws Exception {
        Assert.assertFalse(rule.canDeliverAt(of(2016, 10, 25, 7, 0, 0)));
        Assert.assertFalse(rule.canDeliverAt(of(2016, 10, 25, 22, 0, 0)));
    }

}