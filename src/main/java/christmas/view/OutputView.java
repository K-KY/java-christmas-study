package christmas.view;

import christmas.domain.Discount;
import christmas.domain.DiscountHistory;
import christmas.domain.UserOrder;
import christmas.domain.event.ChristmasBadge;

public class OutputView {

    public static void orderedMenu(String orders) {
        System.out.println("<주문 메뉴>");
        System.out.println(orders);
        System.out.println();
    }

    public static void beforeDiscount(UserOrder userOrder) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(userOrder.totalAmount());
        System.out.println();
    }

    public static void discountHistory(DiscountHistory discountHistory) {
        System.out.println("<혜택 내역>");
        if (discountHistory.toString().length() == 0) {
            System.out.println("없음");
            return;
        }
        System.out.println(discountHistory.toString());
        System.out.println();
    }

    public static void promotionHisTory(String promotion) {
        System.out.println("<증정 메뉴>");
        System.out.println(promotion);
        System.out.println();
    }

    public static void totalDiscount(Discount discount) {
        System.out.println("<총혜택 금액>");
        System.out.println(discount.getDiscount());
        System.out.println();
    }

    public static void afterDiscount(Discount discount, UserOrder userOrder) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(userOrder.totalAmount() - discount.getDiscount() + "원");
        System.out.println();
    }

    public static void grantBadge(Discount discount) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(ChristmasBadge.getBadge(discount.getDiscount()).getBadgeName());
    }
}
