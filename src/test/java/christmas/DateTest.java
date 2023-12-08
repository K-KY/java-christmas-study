package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class DateTest {

    @Test
    void beforeChristmasTest() {
        Date date = new Date(25);
        assertThat(date.isBeforeChristmas()).isTrue();
    }
    @Test
    void afterChristmasTest() {
        Date date = new Date(26);
        assertThat(date.isBeforeChristmas()).isFalse();
    }

    @Test
    void orderedDateTest() {
        Date date = new Date(24);
        assertThat(date.orderedDate()).isEqualTo("일요일");
    }

    @Test
    void discountTest() {
        Date date = new Date(25);
        assertThat(date.christmasDiscount()).isEqualTo(3400);
    }
    @Test
    void noDiscountTest() {
        Date date = new Date(26);
        assertThat(date.christmasDiscount()).isEqualTo(0);
    }

    @Test
    void christmasDay() {
        Date date = new Date(25);
        assertThat(date.christmasDay()).isTrue();
    }
    @Test
    void christmasAfter() {
        Date date = new Date(26);
        assertThat(date.christmasDay()).isFalse();
    }

}
