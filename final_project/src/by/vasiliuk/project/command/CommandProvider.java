package by.vasiliuk.project.command;

import by.vasiliuk.project.command.impl.DefaultCommand;

public class CommandProvider {

   public static Command getCommand(String commandStr) {
       Command command;
       try {
           CommandType commandType = CommandType.valueOf(commandStr);
           command = commandType.getCommand();
       } catch (IllegalArgumentException e) {
           command = new DefaultCommand();
       }
       return command;
   }
}
