package main.java.by.vasiliuk.converter;

import main.java.by.vasiliuk.dto.AdvertTo;
import main.java.by.vasiliuk.model.Advert;
import main.java.by.vasiliuk.service.UserService;

public class AdvertToConverter implements Converter<AdvertTo, Advert> {

    private static final AdvertToConverter INSTANCE = new AdvertToConverter();

    public static AdvertToConverter getInstance() {
        return INSTANCE;
    }

    @Override
    public AdvertTo convert(Advert advert) {
        UserService userService = UserService.getInstance();
        String username = userService.getUsernameById(advert.getUserId()).orElse(null);
        return new main.java.by.vasiliuk.dto.AdvertTo(advert.getId(), advert.getText(), advert.getTitle(), username);
    }
}
