package main.java.by.vasiliuk.command;

public class CommandProvider {

    public static final String ADLIST = "ad_list_page.jsp";
    public static final String ADVERTLIST = "advertList";
    public static final String SID = "sid";

   public static Command getCommand(String commandStr){
       Command command = null;
       CommandType commandType = CommandType.valueOf(commandStr);
       command = commandType.getCommand();
       return command;
   }
}
