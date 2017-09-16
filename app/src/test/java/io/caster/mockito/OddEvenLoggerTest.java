package io.caster.mockito;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class OddEvenLoggerTest {

    @Test
    public void shouldAddEvenEventForEvenNumber2() {
        Analytics mockAnalytics = Mockito.mock(Analytics.class);
        OddEvenLogger testee = new OddEvenLogger(mockAnalytics);

        testee.logEvent(2);

        ArgumentCaptor<AnalyticsEvent> captor = ArgumentCaptor.forClass(AnalyticsEvent.class);
        Mockito.verify(mockAnalytics).addEvent(captor.capture());
        assertEquals("even", captor.getValue().type);
    }

    @Test
    public void shouldAddOddEventForOddNumber3() {
        Analytics mockAnalytics = Mockito.mock(Analytics.class);
        OddEvenLogger testee = new OddEvenLogger(mockAnalytics);
        ArgumentCaptor<AnalyticsEvent> captor = ArgumentCaptor.forClass(AnalyticsEvent.class);

        testee.logEvent(3);

        Mockito.verify(mockAnalytics).addEvent(captor.capture());

        assertEquals("odd", captor.getValue().type);
    }

}