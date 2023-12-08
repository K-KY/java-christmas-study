package christmas.domain.event;

import christmas.domain.UserOrder;

public class WeekdayEvent {

    public int discount(UserOrder userOrder) {
        int dessertCount = userOrder.getDessertCount();
        System.out.println(dessertCount);
        return dessertCount * 2023;
    }

}
