package main.java.by.vasiliuk.command.impl;

import main.java.by.vasiliuk.command.Command;
import main.java.by.vasiliuk.converter.AdvertToConverter;
import main.java.by.vasiliuk.dao.DaoException;
import main.java.by.vasiliuk.dto.AdvertTo;
import main.java.by.vasiliuk.model.Advert;
import main.java.by.vasiliuk.service.AdvertService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class GetAllAdvertsCommand implements Command {

    private static final String ADD_LIST = "add_list";
    private static final String RETURN_PAGE = "some_page.jsp";

   // private List<AdvertTo> advertTos;

    @Override
    public String execute(HttpServletRequest request) throws DaoException {
        List<AdvertTo> advertList;
        List<AdvertTo> advertTos;




        AdvertService advertService = AdvertService.getInstance();
        List<Advert> adverts = advertService.getAllAds();
        AdvertToConverter advertToConverter = AdvertToConverter.getInstance();
        advertTos = new ArrayList<>();
        for(Advert advert : adverts){
            advertTos.add(advertToConverter.convert(advert));
        }
        request.setAttribute(ADD_LIST, advertTos);
        return RETURN_PAGE;
    }
}
