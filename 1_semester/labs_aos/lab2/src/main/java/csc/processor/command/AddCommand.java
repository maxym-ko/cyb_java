package csc.processor.command;

import csc.processor.register.Register;

public class AddCommand extends ValueCommand {
    public AddCommand(String name) {
        super(name);
    }

    @Override
    protected void execute0(Register accumulator, int value) {
        accumulator.addValue(value);
    }
}
