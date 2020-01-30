package main.java.by.vasiliuk.command.impl;

import main.java.by.vasiliuk.command.Command;
import main.java.by.vasiliuk.dao.DaoException;
import main.java.by.vasiliuk.dto.AdvertTo;
import main.java.by.vasiliuk.model.Advert;
import main.java.by.vasiliuk.service.AdvertService;
import main.java.by.vasiliuk.service.ServiceException;
import main.java.by.vasiliuk.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GetAdvertsBySectionIdCommand implements Command {

    private static final String ADVERTS_BY_SECTION = "ad_list_by_section";

    private  long id;
    public List<AdvertTo> advertTos;

    public List<AdvertTo> getAdvertTos() {
        return advertTos;
    }

    public GetAdvertsBySectionIdCommand(long id) {
        this.id = id;
        advertTos = new ArrayList<>();
    }

    @Override
    public String execute(HttpServletRequest request)throws DaoException, ServiceException {
        AdvertService advertService = new AdvertService();

        List<Advert> adverts = advertService.getBySectionId(id);
        UserService userService = new UserService();
        Optional<String> username;
        for(Advert advert : adverts){
            username = userService.getUsernameById(advert.getUserId());
            if(username.isPresent()){
                advertTos.add(new AdvertTo(advert.getId(), advert.getTitle(),
                        advert.getText(), username.get()));
            }
            else{
                //throw exception
            }
        }
        return ADVERTS_BY_SECTION;
    }
}
