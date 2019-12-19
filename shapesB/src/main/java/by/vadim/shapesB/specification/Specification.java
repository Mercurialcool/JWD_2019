package by.vadim.shapesB.specification;

import by.vadim.shapesB.entity.Tetrahedron;

public interface Specification<T extends Tetrahedron> {
     boolean isSatisfiedBy(T figure);

}
