package io.caster.mockito;


public class OddEvenLogger {

    private Analytics analytics;

    public OddEvenLogger(Analytics analytics) {
        this.analytics = analytics;
    }

    public void logEvent(int number) {

        AnalyticsEvent analyticsEvent = new AnalyticsEvent();

        if (isEvenNumber(number)) {
            analyticsEvent.type = "even";
        } else {
            analyticsEvent.type = "odd";
        }

        analytics.addEvent(analyticsEvent);
    }

    private boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }

}
