package christmas.domain.menu;

import java.util.List;

/*
* <애피타이저>
양송이수프(6,000), 타파스(5,500), 시저샐러드(8,000)

<메인>
티본스테이크(55,000), 바비큐립(54,000), 해산물파스타(35,000), 크리스마스파스타(25,000)

<디저트>
초코케이크(15,000), 아이스크림(5,000)

<음료>
제로콜라(3,000), 레드와인(60,000), 샴페인(25,000)
*/
public enum MenuBoard {
    MUSHROOM_SOUP("양송이수프", 6_000, "APPETIZER"),
    TAPAS("타파스", 5_500, "APPETIZER"),
    CAESAR_SALAD("시저샐러드", 8_000, "APPETIZER"),

    T_BONE_STAKE("티본스테이크", 55_000, "MAIN"),
    BARBEQUE_LIP("바비큐립", 54_000, "MAIN"),
    SEA_FOOD_PASTA("해산물파스타", 35_000, "MAIN"),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000, "MAIN"),

    CHOCOLATE_CAKE("초코케이크", 15_000, "DESSERT"),
    ICE_CREAM("아이스크림", 5_000, "DESSERT"),
    ZERO_COKE("제로콜라", 3_000, "BEVERAGE"),
    RED_WINE("레드와인", 60_000, "BEVERAGE"),
    CHAMPAGNE("샴페인", 25_000, "BEVERAGE");

    private static final List<MenuBoard> menuBoards = List.of(values());
    private String menuName;
    private int menuPrice;
    private String menuCategory;

    MenuBoard(String menuName, int menuPrice, String menuCategory) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuCategory = menuCategory;
    }

    public static MenuBoard orderMenu(String menuName) {
        return menuBoards.stream()
                .filter(menuBoard -> menuBoard.menuName.equals(menuName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."));
    }

    public boolean isMain(MenuBoard menuBoard) {
        return this.menuCategory.equals("MAIN");
    }

    public boolean isDessert(MenuBoard menuBoard) {
        return this.menuCategory.equals("DESSERT");
    }

    public boolean isBeverage() {
        return this.menuCategory.equals("BEVERAGE");
    }

    public int getMenuPrice() {
        return this.menuPrice;
    }
    public String getMenuName() {
        return this.menuName;
    }
}
