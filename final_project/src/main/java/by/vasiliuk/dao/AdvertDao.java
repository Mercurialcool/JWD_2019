package main.java.by.vasiliuk.dao;

import main.java.by.vasiliuk.model.Advert;

import java.util.List;
import java.util.Optional;

public interface AdvertDao {
    List<Advert> findAll();
    Optional<Advert> findById(long id);
    void save(String advertTitle, String advertText, long userId);
    List<Advert> findBySectionId(long id);
}
