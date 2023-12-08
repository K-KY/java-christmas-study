package christmas;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.domain.MenuReceiver;
import org.junit.jupiter.api.Test;

public class MenuReceiverTest {
    @Test
    void menuReceiveTest() {
        assertThatCode(() -> MenuReceiver.receive("티본스테이크-3,아이스크림-1")).doesNotThrowAnyException();
    }
    @Test
    void menuReceiveNotExistMenu() {
        assertThatThrownBy(() -> MenuReceiver.receive("갈치조림-3,아이스크림-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
