package christmas.domain;

import christmas.Date;

public class ChristmasDayEvent {

    public int discount(Date date) {
        if (date.isBeforeChristmas()) {
            return date.christmasDiscount();
        }
        return 0;
    }
}
