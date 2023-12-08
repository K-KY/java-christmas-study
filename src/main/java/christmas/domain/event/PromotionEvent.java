package christmas.domain.event;

public class PromotionEvent {

    public int discount(int discount) {
        if (discount >= 120000) {
            return 25000;
        }
        return 0;
    }
}
