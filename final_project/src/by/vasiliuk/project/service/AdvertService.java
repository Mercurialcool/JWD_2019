package by.vasiliuk.project.service;

import by.vasiliuk.project.model.Advert;

import java.util.List;
import java.util.Optional;

public interface AdvertService {
    public List<Advert> findAllAds() throws ServiceException;
    public Optional<Advert> getAdById(long id) throws ServiceException;
    public List<Advert> findBySectionId(long id) throws ServiceException;
    public void saveAdvert(String title, String text, long userId) throws ServiceException;
}
