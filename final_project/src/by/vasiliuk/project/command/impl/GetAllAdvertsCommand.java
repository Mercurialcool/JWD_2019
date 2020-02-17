package by.vasiliuk.project.command.impl;

import by.vasiliuk.project.command.Command;
import by.vasiliuk.project.command.CommandException;
import by.vasiliuk.project.converter.AdvertToConverter;
import by.vasiliuk.project.model.Advert;
import by.vasiliuk.project.service.ServiceException;
import by.vasiliuk.project.service.impl.AdvertServiceImpl;
import by.vasiliuk.project.model.AdvertTo;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static by.vasiliuk.project.command.JspPath.RETURN_PAGE;
import static by.vasiliuk.project.command.NameProvider.ADD_LIST;

public class GetAllAdvertsCommand implements Command {

   // private List<AdvertTo> advertTos;

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        List<AdvertTo> advertTos;

        AdvertServiceImpl advertServiceImpl = AdvertServiceImpl.getInstance();
        List<Advert> adverts = null;
        try {
            adverts = advertServiceImpl.findAllAds();
        } catch ( ServiceException e) {
            throw new CommandException(e);
        }
        AdvertToConverter advertToConverter = AdvertToConverter.getInstance();
        advertTos = new ArrayList<>();
        for(Advert advert : adverts){
            try {
                advertTos.add(advertToConverter.convert(advert));
            } catch (ServiceException e) {
                throw new CommandException(e);
            }
        }
        request.setAttribute(ADD_LIST, advertTos);
        return RETURN_PAGE;
    }
}
