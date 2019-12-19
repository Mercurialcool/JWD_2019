package by.vadim.shapesB.specification;

import by.vadim.shapesB.entity.Tetrahedron;
import by.vadim.shapesB.warehouse.Warehouse;

import java.util.function.BiPredicate;
import java.util.function.Function;

public class SpecificationFactory {
    private <T, U extends Function<Tetrahedron, T>> Specification searchEqualByValue(T controlValue, U getSearchParameterFunction) {
        BiPredicate<T, Tetrahedron> condition = (t, tetrahedron) -> t.equals(getSearchParameterFunction.apply(tetrahedron));
        return new EqualSpecification<>(controlValue, condition);
    }

    public Specification searchEqualByIdSpecification(Long id) {

        return searchEqualByValue(id, (Tetrahedron::getId));

    }

    public Specification searchEqualByVolumeSpecification(double volume) {
        return searchEqualByValue(volume, (tetrahedron ->
                (Warehouse.getInstance().pickTetrahedronValuesById(tetrahedron.getId()).getVolume())));

    }

    public Specification searchEqualByPerimeterSpecification(double perimeter) {
        return searchEqualByValue(perimeter, (tetrahedron ->
                (Warehouse.getInstance().pickTetrahedronValuesById(tetrahedron.getId()).getPerimeter())));

    }

    public Specification searchEqualBySurfaceAreaSpecification(double surfaceArea) {
        return searchEqualByValue(surfaceArea, (tetrahedron ->
                (Warehouse.getInstance().pickTetrahedronValuesById(tetrahedron.getId()).getSurfaceArea())));


    }

    private  <T extends Comparable, U extends Function<Tetrahedron, T>>Specification searchInRangeSpecification(T minimal, T maximal, U getValueFunction) {
        BiPredicate<T, Tetrahedron> lessThenMaximalValueCondition = (t, tetrahedron) -> (t.compareTo(getValueFunction.apply(tetrahedron))<=0);
        BiPredicate<T, Tetrahedron> moreThanMinimalValueCondition = (t, tetrahedron) ->(t.compareTo(getValueFunction.apply(tetrahedron))>=0);
        return new AcceptableSpecification<>(minimal,maximal,lessThenMaximalValueCondition,moreThanMinimalValueCondition);
    }
    public Specification searchInRangeByIdSpecification(long minimalId, long maximalId) {
        return searchInRangeSpecification(minimalId,maximalId, Tetrahedron::getId);


    }

}
