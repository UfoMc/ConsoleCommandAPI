package de.matga.command.commands;

import de.matga.command.Commands;
import de.matga.command.imp.CommandImp;

public class Help extends CommandImp {

    public Help() {
        super("You see what I do right now");
    }

    @Override
    public void execute(String... args) {

        System.out.println();



        //System.out.println("———————————————————————————————————————————————————————————");
        Commands.instance.getCommands().forEach((name, command)-> {
            System.out.println("▌ " + name + "  ->  " + arrowLength(name) + command.getDiscription());
        });
        //System.out.println("———————————————————————————————————————————————————————————");

        System.out.println();

    }

    private String arrowLength(String name) {
        return " ".repeat(
                Math.max(0, Commands.instance.getLongestCommand()) - name.length()
        );
    }

}
