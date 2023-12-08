package christmas.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class DiscountHistory {
    private final List<String> history = new ArrayList<>();

    public void addHistory(String discountHistory) {

        history.add(discountHistory);
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        history.forEach(stringJoiner::add);
        return stringJoiner.toString();
    }
}
