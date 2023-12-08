package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.WeekdayEvent;
import christmas.domain.WeekendEvent;
import christmas.domain.menu.MenuBoard;
import java.util.HashMap;
import org.junit.jupiter.api.Test;

public class WeekendEventTest {

    @Test
    void discountTest() {
        WeekendEvent weekendEvent =  new WeekendEvent();
        HashMap<MenuBoard, Integer> mainMenu = new HashMap<>();
        mainMenu.put(MenuBoard.orderMenu("티본스테이크"), 3);
        mainMenu.put(MenuBoard.orderMenu("바비큐립"), 3);

        assertThat(weekendEvent.discount(mainMenu)).isEqualTo(12138);
    }

    @Test
    void noDiscountTest() {
        WeekendEvent weekendEvent =  new WeekendEvent();
        HashMap<MenuBoard, Integer> mainMenu = new HashMap<>();

        assertThat(weekendEvent.discount(mainMenu)).isEqualTo(0);
    }

}
