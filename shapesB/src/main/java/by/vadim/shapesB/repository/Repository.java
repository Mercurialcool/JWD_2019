package by.vadim.shapesB.repository;

import by.vadim.shapesB.entity.Tetrahedron;
import by.vadim.shapesB.warehouse.Warehouse;
import by.vadim.shapesB.specification.Specification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public enum Repository {
    INSTANCE;
    private List<Tetrahedron> tetrahedronList;

    public void addTetrahedron(Tetrahedron tetrahedron) {
        tetrahedronList.add(tetrahedron);
        Warehouse.getInstance().putTetrahedron(tetrahedron);
    }


    public List<Tetrahedron> searchBySpecification(Specification<Tetrahedron>... specifications) {

        Stream<Tetrahedron> tetrahedronStream = tetrahedronList.stream();
        for (Specification<Tetrahedron> specification : specifications) {

            tetrahedronStream = tetrahedronStream.filter(specification::isSatisfiedBy);

        }
        return tetrahedronStream.collect(Collectors.toList());
    }


    public void sort(Comparator<Tetrahedron> ... comparators) {

        if(comparators.length==1) {

            tetrahedronList.sort(comparators[0]);

        }
        else {

            if(comparators.length>2){
                tetrahedronList.sort(comparators[0].thenComparing(comparators[1]));

            }
        }
    }
    public void sortById() {
        tetrahedronList.sort(Comparator.comparing(Tetrahedron::getId)
                .thenComparing(t2 -> Warehouse.getInstance().pickTetrahedronValuesById(t2.getId()).getVolume()));
    }

    public void sortByVolume() {
        tetrahedronList.sort(Comparator.comparing(tetrahedron -> Warehouse.getInstance().pickTetrahedronValuesById(tetrahedron.getId()).getVolume()));
    }

    public void sortBySurfaceArea() {
        tetrahedronList.sort(Comparator.comparing(tetrahedron -> Warehouse.getInstance().pickTetrahedronValuesById(tetrahedron.getId()).getSurfaceArea()));
    }

    public void sortByApexZ() {
        tetrahedronList.sort(Comparator.comparing((Tetrahedron tetrahedron) -> tetrahedron.getApex().getZ())
                .thenComparing(tetrahedron -> tetrahedron.getApex().getY())
                .thenComparing(tetrahedron -> tetrahedron.getApex().getX())
                .thenComparing(Tetrahedron::getId));

    }

    Repository() {
        tetrahedronList = new ArrayList<>();
    }
}
