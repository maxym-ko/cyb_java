package csc.processor.command;

import csc.processor.register.Register;

import java.util.Map;

public class AndCommand implements Command {
    @Override
    public void execute(String operand, Map<String, Register> registerMap) {
        Register accumulator = registerMap.get("A");
        int value = Integer.parseInt(operand);
        accumulator.setValue(accumulator.getValue() & value);

        Register programSate = registerMap.get("PS");
        programSate.setValue(accumulator.getOlderBit());
    }
}
