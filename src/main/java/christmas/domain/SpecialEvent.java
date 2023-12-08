package christmas.domain;

import christmas.Date;

public class SpecialEvent {

    public int discount(Date date) {
        if (date.isStared()) {
            return 1000;
        }
        return 0;
    }
}
