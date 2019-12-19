package by.vadim.shapesB.repository;

import by.vadim.shapesB.entity.Point;
import by.vadim.shapesB.entity.Tetrahedron;
import by.vadim.shapesB.factory.TetrahedronFactory;
import by.vadim.shapesB.processor.TetrahedronEventProcessor;
import by.vadim.shapesB.specification.SpecificationFactory;
import by.vadim.shapesB.warehouse.Warehouse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class RepositoryTest {


    TetrahedronEventProcessor eventProcessor;
    Warehouse warehouse;
    Repository repository;
    SpecificationFactory specificationFactory;
    TetrahedronFactory tetrahedronFactory;

    @BeforeClass
    public void setup() {
        eventProcessor = TetrahedronEventProcessor.INSTANCE;
        warehouse = Warehouse.getInstance();
        specificationFactory = new SpecificationFactory();
        tetrahedronFactory=new TetrahedronFactory();
        tetrahedronFactory.createTetrahedron(1,
                new Point(0, 0, 1), new Point(1, 0, 0), new Point(0, 1, 0), new Point(0, 0, 0));
        tetrahedronFactory.createTetrahedron(3,
                new Point(0, 0, 1), new Point(1, 0, 0), new Point(0, 1, 0), new Point(0, 0, 0));
        tetrahedronFactory.createTetrahedron(2,
                new Point(0, 0, 1), new Point(1, 0, 0), new Point(0, 1, 0), new Point(0, 0, 0));
    }

    @Test
    public void reposListTest() {
        Tetrahedron tetrahedron = new Tetrahedron(1,
                new Point(0, 0, 1), new Point(1, 0, 0), new Point(0, 1, 0), new Point(0, 0, 0));
        List<Tetrahedron> expected = List.of(tetrahedron);
        List actual = Repository.INSTANCE.searchBySpecification(specificationFactory.searchEqualByIdSpecification(1L));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void NegativeRepositoryTest() {

        List<Tetrahedron> expected = List.of();
        List actual = Repository.INSTANCE.searchBySpecification(specificationFactory.searchEqualByIdSpecification(4L));
        Assert.assertEquals(expected.size(), actual.size());
    }
    @Test
    public void SearchByRangeRepositoryTest() {

        List<Tetrahedron> expected = List.of(
                new Tetrahedron(1,
                        new Point(0, 0, 1),
                        new Point(1, 0, 0),
                        new Point(0, 1, 0),
                        new Point(0, 0, 0)),
                new Tetrahedron(2,
                        new Point(0, 0, 1),
                        new Point(1, 0, 0),
                        new Point(0, 1, 0),
                        new Point(0, 0, 0)));
        List actual = Repository.INSTANCE.searchBySpecification(specificationFactory.searchInRangeByIdSpecification(1L,2L));
        Assert.assertEquals(expected.size(), actual.size());
    }
    @Test
    public void CountWarhouseTest() {

        List<Tetrahedron> searchResult = Repository.INSTANCE.searchBySpecification(specificationFactory.searchInRangeByIdSpecification(1L,2L));
        Tetrahedron controlTetrahedron=searchResult.get(0);
        double beforeChanges=Warehouse.getInstance().pickTetrahedronValuesById(controlTetrahedron.getId()).getPerimeter();
        controlTetrahedron.setApex(new Point(0,0,2));
        double actual=Warehouse.getInstance().pickTetrahedronValuesById(controlTetrahedron.getId()).getPerimeter();
        Assert.assertNotEquals(beforeChanges,actual );
    }



}
