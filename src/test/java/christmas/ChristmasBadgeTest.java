package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.event.ChristmasBadge;
import org.junit.jupiter.api.Test;

public class ChristmasBadgeTest {

    @Test
    void badgeReturnTest() {
        assertThat(ChristmasBadge.getBadge(1000)).isEqualTo(ChristmasBadge.NO_BADGE);
        assertThat(ChristmasBadge.getBadge(4999)).isEqualTo(ChristmasBadge.NO_BADGE);
        assertThat(ChristmasBadge.getBadge(5000)).isEqualTo(ChristmasBadge.STAR);
        assertThat(ChristmasBadge.getBadge(9999)).isEqualTo(ChristmasBadge.STAR);
        assertThat(ChristmasBadge.getBadge(10000)).isEqualTo(ChristmasBadge.TREE);
        assertThat(ChristmasBadge.getBadge(19999)).isEqualTo(ChristmasBadge.TREE);
        assertThat(ChristmasBadge.getBadge(20000)).isEqualTo(ChristmasBadge.SANTA);
        assertThat(ChristmasBadge.getBadge(30000)).isEqualTo(ChristmasBadge.SANTA);
    }
}
