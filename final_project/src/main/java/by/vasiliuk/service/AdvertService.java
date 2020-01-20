package main.java.by.vasiliuk.service;

import main.java.by.vasiliuk.dao.AdvertDao;
import main.java.by.vasiliuk.dao.impl.AdvertDaoImpl;
import main.java.by.vasiliuk.model.Advert;

import java.util.List;
import java.util.Optional;

public class AdvertService {

    private static final AdvertService INSTANCE = new AdvertService();

    public static AdvertService getInstance() {
        return INSTANCE;
    }

    public List<Advert> getAllAds(){
        AdvertDao advertDao = AdvertDaoImpl.getInstance();
        return advertDao.getAll();
    }

    public Optional<Advert> getAdById(long id){
        AdvertDao advertDao = AdvertDaoImpl.getInstance();
        return advertDao.getById(id);
    }

    public List<Advert> getBySectionId(long id){
        AdvertDao advertDao = AdvertDaoImpl.getInstance();
        return advertDao.getBySectionId(id);
    }

    public void saveAdvert(String title, String text, long userId){
        AdvertDao advertDao = AdvertDaoImpl.getInstance();
        advertDao.save(title, text, userId);
    }
}
