package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.event.PromotionEvent;
import org.junit.jupiter.api.Test;

public class PromotionEventTest {

    @Test
    void discountTest() {
        PromotionEvent promotionEvent = new PromotionEvent();
        assertThat(promotionEvent.discount(120000)).isEqualTo(25000);
        assertThat(promotionEvent.discount(110000)).isEqualTo(0);
    }
}
