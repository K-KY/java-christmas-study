package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.MenuReceiver;
import christmas.domain.event.WeekdayEvent;
import org.junit.jupiter.api.Test;

public class WeekdayEventTest {

    @Test
    void discountTest() {
        WeekdayEvent weekdayEvent =  new WeekdayEvent();
        Date date = new Date(26);
        assertThat(weekdayEvent.discount(MenuReceiver.receive("초코케이크-3,아이스크림-3"), date)).isEqualTo(12138);
    }
}
