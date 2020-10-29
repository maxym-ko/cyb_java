package csc.processor.command;

import csc.processor.register.Register;

import java.util.Map;

public abstract class ValueCommand implements Command {
    @Override
    public void execute(String operand, Map<String, Register> registerMap) {
        Register accumulator = registerMap.get("A");
        int value = Integer.parseInt(operand);
        execute0(accumulator, value);

        Register programSate = registerMap.get("PS");
        programSate.setValue(accumulator.getOlderBit());
    }
    protected abstract void execute0(Register accumulator, int value);
}
