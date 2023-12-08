package christmas;

import christmas.domain.MenuReceiver;
import christmas.domain.UserOrder;
import org.junit.jupiter.api.Test;

public class UserOrderTest {

    @Test
    void orderAmountTest() {

        UserOrder userOrder = MenuReceiver.receive("티본스테이크-2,타파스-2");
        System.out.println(userOrder.totalAmount());
    }
}
