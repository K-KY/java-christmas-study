package christmas.controller;

import christmas.Date;
import christmas.domain.Discount;
import christmas.domain.DiscountHistory;
import christmas.domain.UserOrder;
import christmas.domain.event.ChristmasDayEvent;
import christmas.domain.event.PromotionEvent;
import christmas.domain.event.SpecialEvent;
import christmas.domain.event.WeekdayEvent;
import christmas.domain.event.WeekendEvent;
import christmas.util.ValidateLooper;
import christmas.view.InputView;
import christmas.view.OutputView;

public class PlannerController {
    private final DiscountHistory discountHistory = new DiscountHistory();

    public void start() {
        ValidateLooper validateLooper = new ValidateLooper();
        Date date = validateLooper.loop(InputView::visitDate);
        UserOrder userOrder = validateLooper.loop(InputView::orderMenu);
        OutputView.orderedMenu(userOrder.toString());
        Discount discount = discount(date, userOrder);
        history(userOrder, discount);
    }

    private void history(UserOrder userOrder, Discount discount) {
        OutputView.beforeDiscount(userOrder);
        OutputView.discountHistory(discountHistory);
        OutputView.totalDiscount(discount);
        OutputView.afterDiscount(discount, userOrder);
        OutputView.grantBadge(discount);
    }

    private Discount discount(Date date, UserOrder userOrder) {
        Discount discount = new Discount();
        discount.addDiscount(weekendDiscount(date, userOrder));
        discount.addDiscount(weekDayDiscount(date, userOrder));
        christmasDiscount(discount, date);
        specialDiscount(discount, date);
        promotionDiscount(userOrder, discount);
        return discount;
    }

    private void promotionDiscount(UserOrder userOrder, Discount discount) {
        if (userOrder.totalAmount() >= 120000) {
            OutputView.promotionHisTory("샴페인 1개");
            discountHistory.addHistory("증정 이벤트: -25000원");
            discount.promotion(new PromotionEvent().discount());
            return;
        }
        OutputView.promotionHisTory("없음");

    }

    private int weekDayDiscount(Date date, UserOrder userOrder) {
        int discounted = -new WeekdayEvent().discount(userOrder, date);
        if (!date.isWeekend() && discounted != 0) {
            discountHistory.addHistory("평일 할인: " + discounted + "원");
        }
        return 0;
    }

    private int weekendDiscount(Date date, UserOrder userOrder) {
        int discounted = -new WeekendEvent().discount(userOrder);
        if (date.isWeekend() && discounted != 0) {
            discountHistory.addHistory("주말 할인: " + discounted + "원");
            return discounted;
        }
        return 0;
    }

    private void christmasDiscount(Discount discount, Date date) {
        if (date.isBeforeChristmas()) {
            int discounted = -new ChristmasDayEvent().discount(date);
            discount.addDiscount(discounted);
            discountHistory.addHistory("크리스마스 디데이 할인: " + discounted + "원");
        }
    }

    private void specialDiscount(Discount discount, Date date) {
        if (date.isStared()) {
            int discounted = -new SpecialEvent().discount(date);

            discount.addDiscount(discounted);
            discountHistory.addHistory("특별 할인: " + discounted + "원");

        }
    }

}
