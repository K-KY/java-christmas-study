package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.SpecialEvent;
import org.junit.jupiter.api.Test;

public class SpecialEventTest {

    @Test
    void discountTest() {
        SpecialEvent specialEvent = new SpecialEvent();
        assertThat(specialEvent.discount(new Date(25))).isEqualTo(3400);
    }
}
