package csc.coprocessor.register;

import csc.coprocessor.converter.BinaryConverter;

public class DataRegister {
    private double value;
    private final BinaryConverter binaryConverter;

    public DataRegister(double value, int characteristicCapacity, int mantissaCapacity) {
        this.value = value;
        binaryConverter = new BinaryConverter(characteristicCapacity, mantissaCapacity);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isOverflowed() {
        return value > binaryConverter.getMaxValue() || value < binaryConverter.getMinValue();
    }

    @Override
    public String toString() {
        return binaryConverter.convertToIEEE754(value);
    }
}