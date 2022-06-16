package part1.task6;

import java.util.function.Function;

@FunctionalInterface
public interface UnaryOperator<T> extends Function<T, T> {
}
