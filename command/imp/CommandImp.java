package de.matga.command.imp;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class CommandImp {

    private String discription;
    protected abstract void execute(String[] args);

}
