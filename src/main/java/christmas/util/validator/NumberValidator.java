package christmas.util.validator;

public class NumberValidator {
    private static final String DIGIT = "[0-9]+";
    private static final String NOT_ALLOWED = "0";

    public static void validNumber(String input) {
        if (input.matches(DIGIT)) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}
