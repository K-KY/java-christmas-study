package christmas.domain;

import christmas.domain.menu.MenuBoard;
import java.util.HashMap;
import java.util.List;

public class WeekdayEvent {

    public int discount(HashMap<MenuBoard, Integer> orderedMenus) {
        List<MenuBoard> dessertMenu = getDessertCount(orderedMenus);
        int dessertCount = dessertMenu.stream()
                .mapToInt(orderedMenus::get).sum();
        System.out.println(dessertCount);
        return dessertCount * 2023;
    }

    private static List<MenuBoard> getDessertCount(HashMap<MenuBoard, Integer> orderedMenus) {
        return orderedMenus.keySet()
                .stream()
                .filter(menuBoard -> menuBoard.isDessert(menuBoard))
                .toList();
    }
}
