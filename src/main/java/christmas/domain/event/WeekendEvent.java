package christmas.domain.event;

import christmas.domain.UserOrder;

public class WeekendEvent {

    public int discount(UserOrder userOrder) {
        int mainCount = userOrder.getMainCount();
        System.out.println(mainCount);
        return mainCount * 2023;
    }
}
