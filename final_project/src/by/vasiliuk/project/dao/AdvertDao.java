package by.vasiliuk.project.dao;

import by.vasiliuk.project.model.Advert;

import java.util.List;
import java.util.Optional;

public interface AdvertDao {
    List<Advert> findAll() throws DaoException;
    Optional<Advert> findById(long id);
    void save(String advertTitle, String advertText, long userId) throws DaoException;
    List<Advert> findBySectionId(long id) throws DaoException;
}
