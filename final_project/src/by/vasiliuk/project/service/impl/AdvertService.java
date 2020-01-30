package by.vasiliuk.project.service.impl;

import by.vasiliuk.project.dao.impl.AdvertDaoImpl;
import by.vasiliuk.project.dao.AdvertDao;
import by.vasiliuk.project.dao.DaoException;
import by.vasiliuk.project.model.Advert;
import by.vasiliuk.project.service.ServiceException;

import java.util.List;
import java.util.Optional;

public class AdvertService {

    private static final AdvertService INSTANCE = new AdvertService();

    public static AdvertService getInstance() {
        return INSTANCE;
    }

    public List<Advert> findAllAds() throws ServiceException, DaoException {
        AdvertDao advertDao = AdvertDaoImpl.getInstance();
        return advertDao.findAll();
    }

    public Optional<Advert> getAdById(long id)throws ServiceException, DaoException{
        AdvertDao advertDao = AdvertDaoImpl.getInstance();
        return advertDao.findById(id);
    }

    public List<Advert> findBySectionId(long id)throws ServiceException, DaoException{
        AdvertDao advertDao = AdvertDaoImpl.getInstance();
        return advertDao.findBySectionId(id);
    }

    public void saveAdvert(String title, String text, long userId)throws ServiceException, DaoException{
        AdvertDao advertDao = AdvertDaoImpl.getInstance();
        advertDao.save(title, text, userId);
    }
}
