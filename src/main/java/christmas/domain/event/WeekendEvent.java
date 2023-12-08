package christmas.domain.event;

import christmas.domain.UserOrder;

public class WeekendEvent {

    public int discount(UserOrder userOrder) {
            int mainCount = userOrder.getMainCount();
            return mainCount * 2023;
    }
}
