package christmas.domain;

import java.util.List;

public class MenuReceiver {

    public static UserOrder receive(String userOrder) {
        userOrder = userOrder.replace(" ", "");
        List<String> order = List.of(userOrder.split(","));
        return new UserOrder(order);
    }

}
