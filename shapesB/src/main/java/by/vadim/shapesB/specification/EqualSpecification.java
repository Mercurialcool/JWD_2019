package by.vadim.shapesB.specification;

import by.vadim.shapesB.entity.Tetrahedron;

import java.util.function.BiPredicate;

public class EqualSpecification<T extends Tetrahedron,U> implements Specification<T> {
    private U controlValue;
    private BiPredicate<U, T> condition;

    @Override
    public boolean isSatisfiedBy(T figure) {
        return condition.test(controlValue, figure);
    }

    public EqualSpecification(U controlValue, BiPredicate<U, T> condition) {
        this.controlValue = controlValue;
        this.condition = condition;
    }
}
