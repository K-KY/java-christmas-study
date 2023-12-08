package christmas.domain;

import christmas.domain.event.PromotionEvent;

public class Discount {

    private int discount = 0;

    public void addDiscount(int discount) {
        if (discount == 0) {
            return;
        }
        this.discount = Math.abs(this.discount) + discount;
    }

    public void promotion(int discount) {
        if (discount == 0) {
            return;
        }
        this.discount = Math.abs(this.discount) + discount;
    }

    public int getDiscount() {
        return Math.abs(discount);
    }
}
