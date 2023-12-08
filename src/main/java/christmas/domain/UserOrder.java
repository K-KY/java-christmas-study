package christmas.domain;

import christmas.domain.menu.MenuBoard;
import christmas.util.validator.NumberValidator;
import java.util.HashMap;
import java.util.List;

public class UserOrder {
    private final HashMap<MenuBoard, Integer> userOrder = new HashMap<>();
    public UserOrder(List<String> orders) {
        orders.forEach(this::splitOrder);
        validateMaxAmount();
        onlyBeverage();
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
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void isInRange(int amount) {
        if (amount > 20 || amount < 1) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public int totalAmount() {
        return userOrder.keySet().stream().mapToInt(key -> key.getMenuPrice() * userOrder.get(key)).sum();
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        userOrder.keySet().forEach(key -> sb.append(key.getMenuName())
                .append(" ")
                .append(userOrder.get(key)).append("개")
                .append("\n"));
        return sb.toString();
    }

    public void validateMaxAmount() {
        int totalAmount = userOrder.keySet().stream().mapToInt(userOrder::get).sum();
        if (totalAmount > 20) {
            throw new IllegalArgumentException("[ERROR] 메뉴의 개수는 20개를 넘을 수 없습니다.");
        }
    }

    public void onlyBeverage() {
        int beverageCount = (int) userOrder.keySet().stream().filter(MenuBoard::isBeverage).count();
        if (userOrder.size() == beverageCount) {
            throw new IllegalArgumentException("[ERROR] 음료만 주문 할 수 없습니다.");
        }
    }
}
