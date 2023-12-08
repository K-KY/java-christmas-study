package christmas.domain;

import christmas.domain.menu.MenuBoard;
import christmas.util.validator.NumberValidator;
import java.util.HashMap;
import java.util.List;

public class UserOrder {
    private final HashMap<MenuBoard, Integer> userOrder = new HashMap<>();
    public UserOrder(List<String> orders) {
        orders.forEach(this::splitOrder);
    }

    private void splitOrder(String order) {
        String[] orderAndAmount = order.split("-");
        MenuBoard menuBoard = MenuBoard.orderMenu(orderAndAmount[0]);
        int amount = getAmount(orderAndAmount);
        userOrder.put(menuBoard, amount);
    }

    private int getAmount(String[] orderAndAmount) {
        validOrder(orderAndAmount);
        NumberValidator.validNumber(orderAndAmount[1]);
        int amount = Integer.parseInt(orderAndAmount[1]);
        isInRange(amount);
        return amount;
    }

    private void validOrder(String[] orderAndAmount) {
        if (orderAndAmount.length != 2) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다.");
        }
    }

    private void isInRange(int amount) {
        if (amount > 20 || amount < 1) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다.");
        }
    }

    public int totalAmount() {
        return userOrder.keySet().stream().mapToInt(MenuBoard::getMenuPrice).sum();
    }

    public int getDessertCount() {
        List<MenuBoard> dessertMenus =  userOrder.keySet()
                .stream()
                .filter(menuBoard -> menuBoard.isDessert(menuBoard))
                .toList();
        return dessertMenus.stream()
                .mapToInt(userOrder::get).sum();
    }

    public int getMainCount() {
        List<MenuBoard> mainMenus = userOrder.keySet()
                .stream()
                .filter(menuBoard -> menuBoard.isMain(menuBoard))
                .toList();
        return mainMenus.stream()
                .mapToInt(userOrder::get).sum();

    }



}
