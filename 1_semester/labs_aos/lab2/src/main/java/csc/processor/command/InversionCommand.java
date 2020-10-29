package csc.processor.command;

import csc.processor.register.Register;

public class InversionCommand extends ValueCommand {
    public InversionCommand(String name) {
        super(name);
    }

    @Override
    protected void execute0(Register accumulator, int value) {
        StringBuilder binary = new StringBuilder(
                String.format("%" + accumulator.getSize() + "s", Integer.toBinaryString(accumulator.getValue()), 2)
                        .replace(" ", "0"));
        int indicator = value;
        int i = indicator == 0 ? binary.length() - 2 : binary.length() - 1;
        for (; i > -1; i -= 2) {
            char change = binary.charAt(i) == '0' ? '1' : '0';
            binary.setCharAt(i, change);
        }
        accumulator.setValue(Integer.parseInt(binary.toString(), 2));
    }

//    @Override
//    public void execute(String operand, Map<String, Register> registerMap) {
//        Register accumulator = registerMap.get("A");
//        StringBuilder binary = new StringBuilder(
//                String.format("%" + accumulator.getSize() + "s", Integer.toBinaryString(accumulator.getValue()), 2)
//                        .replace(" ", "0"));
//        int indicator = Integer.parseInt(operand);
//        int i = indicator == 0 ? 0 : 1;
//        System.out.println(binary);
//        for (; i < binary.length(); i += 2) {
//            char change = binary.charAt(i) == '0' ? '1' : '0';
//            binary.setCharAt(i, change);
//        }
//        System.out.println(binary);
//        accumulator.setValue(Integer.parseInt(binary.toString(), 2));
//    }
}
