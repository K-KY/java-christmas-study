package christmas.domain;

import java.util.List;

/*5천 원 이상: 별
1만 원 이상: 트리
2만 원 이상: 산타
*/
public enum ChristmasBadge {
    SANTA("산타", 20_000),
    TREE("트리", 10_000),
    STAR("별", 5_000),
    NO_BADGE("NO_BADGE", 0);

    private String badgeName;
    private int badgeCondition;
    private static final List<ChristmasBadge> christmasBadges = List.of(values());

    ChristmasBadge(String badgeName, int badgeCondition) {
        this.badgeName = badgeName;
        this.badgeCondition = badgeCondition;
    }

    public static ChristmasBadge getBadge(int benefit) {
        return christmasBadges.stream()
                .filter(badge -> badge.badgeCondition <= benefit)
                .findFirst().orElse(SANTA);
    }
}
