package by.vasiliuk.project.converter;

import by.vasiliuk.project.model.Advert;
import by.vasiliuk.project.service.ServiceException;
import by.vasiliuk.project.service.impl.UserServiceImpl;
import by.vasiliuk.project.model.AdvertTo;

public class AdvertToConverter implements Converter<AdvertTo, Advert> {

    private static final AdvertToConverter INSTANCE = new AdvertToConverter();

    public static AdvertToConverter getInstance() {
        return INSTANCE;
    }

    @Override
    public AdvertTo convert(Advert advert) throws ServiceException {
        UserServiceImpl userServiceImpl = UserServiceImpl.getInstance();
        String username = userServiceImpl.findUsernameById(advert.getUserId()).orElse(null);
        return new AdvertTo(advert.getId(), advert.getText(), advert.getTitle(), username);
    }
}
