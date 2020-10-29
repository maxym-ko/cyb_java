package csc.processor.command;

import csc.processor.register.Register;

public class ModCommand extends ValueCommand {
    public ModCommand(String name) {
        super(name);
    }

    @Override
    protected void execute0(Register accumulator, int value) {
        accumulator.setValue(accumulator.getValue() % value);
    }
}
