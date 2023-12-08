package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.WeekdayEvent;
import christmas.domain.menu.MenuBoard;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.Test;

public class WeekdayEventTest {

    @Test
    void discountTest() {
        WeekdayEvent weekdayEvent =  new WeekdayEvent();
        HashMap<MenuBoard, Integer> desertMenu = new HashMap<>();
        desertMenu.put(MenuBoard.orderMenu("초코케이크"), 3);
        desertMenu.put(MenuBoard.orderMenu("아이스크림"), 3);

        assertThat(weekdayEvent.discount(desertMenu)).isEqualTo(12138);
    }
}
