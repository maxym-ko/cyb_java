package csc.processor.register;

public class InstructionRegister extends Register {
    private String command;
    private String operand;

    public InstructionRegister(int size, String name) {
        super(name, 0, size);
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getOperand() {
        return operand;
    }

    public void setOperand(String operand) {
        this.operand = operand;
    }

    @Override
    public String toString() {
        try {
            operand = getBinaryFormatted(Integer.toBinaryString(Integer.parseInt(operand)));
        } catch (NumberFormatException e) {
            operand = getOperand();
        }
        return getName() + " = " + getCommand() + " | " + operand;
    }
}
