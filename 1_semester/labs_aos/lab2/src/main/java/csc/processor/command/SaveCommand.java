package csc.processor.command;

import csc.processor.register.Register;

import java.util.Map;

public class SaveCommand extends OperandCommand {
    @Override
    protected void execute0(Map<String, Register> registerMap, Register accumulator, String operand) {
        Register dataRegister = registerMap.get(operand);
        dataRegister.setValue(accumulator.getValue());
    }
}
