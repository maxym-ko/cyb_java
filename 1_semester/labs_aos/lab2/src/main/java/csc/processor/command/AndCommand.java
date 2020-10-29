package csc.processor.command;

import csc.processor.register.Register;

public class AndCommand extends ValueCommand {
    public AndCommand(String name) {
        super(name);
    }

    @Override
    protected void execute0(Register accumulator, int value) {
        accumulator.setValue(accumulator.getValue() & value);
    }
}
