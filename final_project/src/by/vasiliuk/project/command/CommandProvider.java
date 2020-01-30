package by.vasiliuk.project.command;

public class CommandProvider {

   public static Command getCommand(String commandStr){
       Command command = null;
       CommandType commandType = CommandType.valueOf(commandStr);
       command = commandType.getCommand();
       return command;
   }
}
