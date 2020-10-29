package csc.processor.command;

import csc.processor.register.Register;

public class OrCommand extends ValueCommand {
    @Override
    protected void execute0(Register accumulator, int value) {
        accumulator.setValue(accumulator.getValue() | value);
    }
}
