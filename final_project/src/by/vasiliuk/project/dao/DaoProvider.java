package by.vasiliuk.project.dao;

public class DaoProvider {

    public static final String SQL_FIND_ALL = "SELECT advertId, advertTitle, advertText, userId FROM adverts";
    public static final String SQL_FIND_ADVERT_BY_ID = "SELECT advertId, advertTitle, advertText, userId FROM adverts WHERE advertId = ?";
    public static final String SQL_ADVERT_SAVE = "INSERT INTO adverts (advertTitle, advertText, userId) VALUES (?, ?, ?)";
    public static final String SQL_ADVERT_DELETE = "DELETE FROM adverts WHERE advertId = ?";
    public static final String SQL_FIND_BY_SECTION_ID = "SELECT a.advertId, a.advertTitle, a.advertText,\" +\n" +
            "                    \" a.userId FROM adverts a WHERE a.sectionId = ?";

    public static final String ADVERT_ID = "advertId";
    public static final String ADVERT_TEXT = "advertText";
    public static final String ADVERT_TITLE = "advertTitle";
    public static final String USER_ID= "userId";

    public static final String USER_NAME = "userName";
    public static final String USER_RATING = "userAverageRating";
    public static final String USER_PASS = "userPass";

    public static final String SQL_FIND_USER_BY_ID = "SELECT userId, userName, userAverageRating FROM users WHERE userId = ?";
    public static final String SQL_FIND_PASS_BY_USER_NAME = "SELECT userPass, userId FROM users WHERE userName = ?";
    public static final String SQL_FIND_BY_USER_NAME = "SELECT FROM users userId WHERE username = ?";
    public static final String SQL_USER_SAVE = "INSERT INTO users (userName, userPass, userAverageRating) VALUES (?,?,?)";
    public static final String SQL_USER_DELETE = "DELETE FROM users WHERE userId = ?";

}
