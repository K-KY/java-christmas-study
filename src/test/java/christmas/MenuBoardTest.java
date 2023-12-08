package christmas;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.domain.menu.MenuBoard;
import org.junit.jupiter.api.Test;

public class MenuBoardTest {

    @Test
    void menuReturnTest() {
        assertThat(MenuBoard.orderMenu("샴페인")).isEqualTo(MenuBoard.CHAMPAGNE);
        assertThatThrownBy(() -> MenuBoard.orderMenu("갈치조림"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
