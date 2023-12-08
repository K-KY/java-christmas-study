package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.event.PromotionEvent;
import org.junit.jupiter.api.Test;

public class PromotionEventTest {

    @Test
    void discountTest() {
        PromotionEvent promotionEvent = new PromotionEvent();
        assertThat(promotionEvent.discount()).isEqualTo(25000);
    }
}
