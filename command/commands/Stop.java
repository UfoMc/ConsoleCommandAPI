package de.matga.command.commands;

import de.matga.command.imp.CommandImp;

public class Stop extends CommandImp {
    public Stop() {
        super("The <stop> command will stop the rest api");
    }

    @Override
    protected void execute(String[] args) {
        System.exit(0);
    }
}
