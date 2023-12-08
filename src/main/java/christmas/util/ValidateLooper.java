package christmas.util;

import java.util.function.Supplier;

public class ValidateLooper {

    public <T> T loop(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return loop(supplier);
        }
    }
}
