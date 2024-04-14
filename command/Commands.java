package de.matga.command;

import de.matga.command.imp.CommandImp;
import de.matga.command.imp.CommandLine;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ScanResult;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Getter
public class Commands {

    public static Commands instance;
    public Map<String, CommandImp> commands;
    public int longestCommand;

    public void boot() {

        instance = this;
        commands = new HashMap<>();

        try (ScanResult scanResult =
                     new ClassGraph()
                             .enableAllInfo()
                             .acceptPackages("de.matga.command.commands")
                             .scan()) {

            for (ClassInfo routeClassInfo : scanResult.getAllClasses()) {

                if (routeClassInfo.loadClass().getConstructor().newInstance() instanceof CommandImp command) {

                    String[] arrays = routeClassInfo.getName().split("\\.");
                    String name = arrays[arrays.length -1];

                    commands.put(name.toLowerCase(), command);

                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        this.longestCommand = longestCommand();

        while (true) {
            System.out.print("> ");
            new CommandLine().execute(new Scanner(System.in).nextLine());
        }
    }

    private int longestCommand() {
        int currentMax = 0;

        for (String s : commands.keySet()){
            if (s.length() >= currentMax){
                currentMax = s.length();
            }
        }

        return currentMax;

    }

}
