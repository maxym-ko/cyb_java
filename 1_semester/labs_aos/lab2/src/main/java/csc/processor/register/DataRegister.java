package csc.processor.register;

public class DataRegister extends Register {
    public DataRegister(int size, String name) {
        super(name, 0, size);
    }

    @Override
    public String toString() {
        return getName() + " = " + getBinaryFormatted(Integer.toBinaryString(getValue()));
    }
}
