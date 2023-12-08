package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.MenuReceiver;
import christmas.domain.event.WeekendEvent;
import christmas.domain.menu.MenuBoard;
import java.util.HashMap;
import org.junit.jupiter.api.Test;

public class WeekendEventTest {

    @Test
    void discountTest() {
        WeekendEvent weekendEvent =  new WeekendEvent();

        assertThat(weekendEvent.discount(MenuReceiver.receive("티본스테이크-3,바비큐립-3"))).isEqualTo(12138);
    }

}
