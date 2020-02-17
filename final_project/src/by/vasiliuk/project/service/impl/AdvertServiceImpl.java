package by.vasiliuk.project.service.impl;

import by.vasiliuk.project.dao.impl.AdvertDaoImpl;
import by.vasiliuk.project.dao.AdvertDao;
import by.vasiliuk.project.dao.DaoException;
import by.vasiliuk.project.model.Advert;
import by.vasiliuk.project.service.ServiceException;

import java.util.List;
import java.util.Optional;

public class AdvertServiceImpl {

    private static final AdvertServiceImpl INSTANCE = new AdvertServiceImpl();

    public static AdvertServiceImpl getInstance() {
        return INSTANCE;
    }

    public List<Advert> findAllAds() throws ServiceException {
        AdvertDao advertDao = null;
        try {
            advertDao = AdvertDaoImpl.getInstance();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        try {
            return advertDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public Optional<Advert> getAdById(long id)throws ServiceException{
        AdvertDao advertDao = null;
        try {
            advertDao = AdvertDaoImpl.getInstance();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return advertDao.findById(id);
    }

    public List<Advert> findBySectionId(long id)throws ServiceException{
        AdvertDao advertDao = null;
        try {
            advertDao = AdvertDaoImpl.getInstance();
            return advertDao.findBySectionId(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void saveAdvert(String title, String text, long userId)throws ServiceException{
        AdvertDao advertDao = null;
        try {
            advertDao = AdvertDaoImpl.getInstance();
            advertDao.save(title, text, userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
