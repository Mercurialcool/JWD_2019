package by.vadim.shapesB.specification;

import by.vadim.shapesB.entity.Tetrahedron;

import java.util.function.BiPredicate;

public class AcceptableSpecification<T extends Tetrahedron,U> implements Specification<T> {
    private U maxValue;
    private U minValue;
    private BiPredicate<U, T> firstCondition;
    private BiPredicate<U, T> secondCondition;

    @Override
    public boolean isSatisfiedBy(T figure) {
        return (firstCondition.test(maxValue, figure) && (secondCondition.test(minValue, figure)));
    }

    public AcceptableSpecification(U maxValue, U minValue, BiPredicate<U, T> firstCondition, BiPredicate<U, T> secondCondition) {
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.firstCondition = firstCondition;
        this.secondCondition = secondCondition;
    }
}
