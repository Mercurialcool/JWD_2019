package by.vasiliuk.project.converter;

import by.vasiliuk.project.model.Advert;
import by.vasiliuk.project.service.ServiceException;
import by.vasiliuk.project.service.impl.UserService;
import by.vasiliuk.project.model.AdvertTo;

public class AdvertToConverter implements Converter<AdvertTo, Advert> {

    private static final AdvertToConverter INSTANCE = new AdvertToConverter();

    public static AdvertToConverter getInstance() {
        return INSTANCE;
    }

    @Override
    public AdvertTo convert(Advert advert) throws ServiceException {
        UserService userService = UserService.getInstance();
        String username = userService.findUsernameById(advert.getUserId()).orElse(null);
        return new AdvertTo(advert.getId(), advert.getText(), advert.getTitle(), username);
    }
}
