package christmas.domain;

import christmas.domain.menu.MenuBoard;
import java.util.HashMap;
import java.util.List;

public class WeekendEvent {

    public int discount(HashMap<MenuBoard, Integer> orderedMenus) {
        List<MenuBoard> mainMenus = getMainCount(orderedMenus);
        int mainCount = mainMenus.stream()
                .mapToInt(orderedMenus::get).sum();
        System.out.println(mainCount);
        return mainCount * 2023;
    }

    private static List<MenuBoard> getMainCount(HashMap<MenuBoard, Integer> orderedMenus) {
        return orderedMenus.keySet()
                .stream()
                .filter(menuBoard -> menuBoard.isMain(menuBoard))
                .toList();
    }

}
