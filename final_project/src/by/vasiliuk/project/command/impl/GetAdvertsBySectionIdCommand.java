package by.vasiliuk.project.command.impl;

import by.vasiliuk.project.command.Command;
import by.vasiliuk.project.service.ServiceException;
import by.vasiliuk.project.service.impl.UserService;
import by.vasiliuk.project.command.CommandException;
import by.vasiliuk.project.dao.DaoException;
import by.vasiliuk.project.model.Advert;
import by.vasiliuk.project.model.AdvertTo;
import by.vasiliuk.project.service.impl.AdvertService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static by.vasiliuk.project.command.NameProvider.ADVERTS_BY_SECTION;

public class GetAdvertsBySectionIdCommand implements Command {

   private  long id;
//    public List<AdvertTo> advertTos;
//    public List<AdvertTo> getAdvertTos() {
//        return advertTos;
//    }todo: do it inside method


    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        List<AdvertTo> advertTos = new ArrayList<>();

        AdvertService advertService = new AdvertService();
        //long id = ADVERTS_BY_SECTION;//todo
        List<Advert> adverts ;
        try {
            try {
                adverts = advertService.findBySectionId(id);
            } catch (DaoException e) {
                throw new CommandException(e);
            }

            UserService userService = new UserService();
        Optional<String> username;
        for(Advert advert : adverts){
            username = userService.findUsernameById(advert.getUserId());
            if(username.isPresent()){
                advertTos.add(new AdvertTo(advert.getId(), advert.getTitle(),
                        advert.getText(), username.get()));
            }
            else{
                //throw exception
            }
        }
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return ADVERTS_BY_SECTION;
    }
}
