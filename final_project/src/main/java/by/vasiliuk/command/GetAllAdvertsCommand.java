package main.java.by.vasiliuk.command;

import main.java.by.vasiliuk.converter.AdvertToConverter;
import main.java.by.vasiliuk.dto.AdvertTo;
import main.java.by.vasiliuk.model.Advert;
import main.java.by.vasiliuk.service.AdvertService;
import java.util.ArrayList;
import java.util.List;

public class GetAllAdvertsCommand implements Command {

    private List<AdvertTo> advertTos;

    public List<AdvertTo> getAdverts() {
        return advertTos;
    }

    @Override
    public void execute() {
        AdvertService advertService = AdvertService.getInstance();
        List<Advert> adverts = advertService.getAllAds();
        AdvertToConverter advertToConverter = AdvertToConverter.getInstance();
        advertTos = new ArrayList<>();
        for(Advert advert : adverts){
            advertTos.add(advertToConverter.convert(advert));
        }
    }
}
