package csc.processor;

import csc.processor.command.*;
import csc.processor.register.DataRegister;
import csc.processor.register.InstructionRegister;
import csc.processor.register.Register;
import csc.processor.register.SpecialPurposeRegister;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    private static final Map<String, Register> registerMap = new TreeMap<>();
    private static final Map<String, Command> commandMap = new TreeMap<>();
    private static final int SIZE = 18;

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 1) System.out.println("There should be one argument (file name)");

        init();
        CommandReader commandReader = new CommandReader(args[0]);
        Scanner scanner = new Scanner(System.in);

        String command;
        String code;
        String operand;
        while ((command = commandReader.nextCommand()) != null) {
            scanner.nextLine();

            registerMap.get("TC").setValue(1);

            code = commandReader.getCode();
            operand = commandReader.getOperand();


            updateInstructionRegister(code, operand);
            printState(command);
            scanner.nextLine();

            Command commandExecutor = commandMap.get(code);
            commandExecutor.execute(operand, registerMap);
            registerMap.get("TC").addValue(1);
            printState(command);

            registerMap.get("PC").addValue(1);
        }

    }

    private static void updateInstructionRegister(String command, String operand) {
        InstructionRegister instructionRegister = (InstructionRegister) registerMap.get("IR");
        instructionRegister.setCommand(command);
        instructionRegister.setOperand(operand);
    }

    private static void init() {
        registerMap.put("IR", new InstructionRegister(SIZE, "IR")); // instructionRegister
        registerMap.put("R1", new DataRegister(SIZE, "R1")); // register1
        registerMap.put("R2", new DataRegister(SIZE, "R2")); // register2
        registerMap.put("R3", new DataRegister(SIZE, "R3")); // register3
        registerMap.put("R4", new DataRegister(SIZE, "R4")); // register4
        registerMap.put("PC", new SpecialPurposeRegister(SIZE, "PC", 1)); // programCounter
        registerMap.put("TC", new SpecialPurposeRegister(SIZE, "TC")); // timeCounter
        registerMap.put("PS", new SpecialPurposeRegister(SIZE, "PS")); // programSate
        registerMap.put("A", new DataRegister(SIZE, "A ")); // accumulator

        commandMap.put("mov", new MoveCommand());
        commandMap.put("save", new SaveCommand());
        commandMap.put("inv", new InversionCommand());
        commandMap.put("add", new AddCommand());
        commandMap.put("sub", new SubtractCommand());
        commandMap.put("mod", new ModCommand());
        commandMap.put("and", new AndCommand());
        commandMap.put("or", new OrCommand());
    }

    private static void printState(String command) {
        System.out.println("Command = " + command);
        System.out.print(registerMap.get("R1") + "\t\t\t");
        System.out.println(registerMap.get("IR"));
        System.out.print(registerMap.get("R2") + "\t\t\t");
        System.out.println(registerMap.get("PC"));
        System.out.print(registerMap.get("R3") + "\t\t\t");
        System.out.println(registerMap.get("TC"));
        System.out.print(registerMap.get("R4") + "\t\t\t");
        System.out.println(registerMap.get("PS"));
        System.out.println(registerMap.get("A"));
    }

    private static class CommandReader {
        private final Scanner scanner;
        private String[] commandArray;

        CommandReader(String fileName) throws FileNotFoundException {
            scanner = new Scanner(new File(fileName));
        }

        String nextCommand() {
            if (!scanner.hasNext()) return null;
            String command = scanner.nextLine();
            commandArray = command.split("\\s");

            return command;
        }

        String getCode() {
            return commandArray[0];
        }

        String getOperand() {
            return commandArray[1];
        }
    }
}
