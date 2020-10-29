package csc.processor.command;

import csc.processor.register.Register;

public class SubtractCommand extends ValueCommand {
    public SubtractCommand(String name) {
        super(name);
    }

    @Override
    protected void execute0(Register accumulator, int value) {
        accumulator.addValue(-value);
    }
}
