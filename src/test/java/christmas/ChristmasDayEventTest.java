package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.event.ChristmasDayEvent;
import org.junit.jupiter.api.Test;

public class ChristmasDayEventTest {

    @Test
    void discountTest() {
        ChristmasDayEvent christmasDayEvent = new ChristmasDayEvent();
        assertThat(christmasDayEvent.discount(new Date(25))).isEqualTo(3400);
    }
}
