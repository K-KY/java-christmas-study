package christmas.domain.event;

import christmas.Date;
import christmas.domain.UserOrder;

public class WeekdayEvent {

    public int discount(UserOrder userOrder, Date date) {
        if (!date.isWeekend()) {
            int dessertCount = userOrder.getDessertCount();
            return dessertCount * 2023;
        }
        return 0;
    }

}
