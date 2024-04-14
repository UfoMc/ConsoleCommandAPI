package de.matga.command.imp;

import de.matga.command.Commands;

import java.util.Map;

public class CommandLine {

    public void execute(String command) {


        if (command.isEmpty()){
            return;
        }

        Map<String, CommandImp> commands = Commands.instance.getCommands();

        String[] args = command.split(" ");

        for (String key : commands.keySet()){
            if (key.equalsIgnoreCase(args[0])) {
                commands.get(args[0]).execute(args);
                return;
            }
        }

        System.out.println("[SYSTEM] not a valid command");

    }

}
