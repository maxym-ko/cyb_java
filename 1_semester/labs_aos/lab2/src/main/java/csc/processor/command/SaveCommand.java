package csc.processor.command;

import csc.processor.register.Register;

import java.util.Map;

public class SaveCommand implements Command {
    @Override
    public void execute(String operand, Map<String, Register> registerMap) {
        Register accumulator = registerMap.get("A");
        Register dataRegister = registerMap.get(operand);
        dataRegister.setValue(accumulator.getValue());

        Register programSate = registerMap.get("PS");
        programSate.setValue(accumulator.getOlderBit());
    }
}
