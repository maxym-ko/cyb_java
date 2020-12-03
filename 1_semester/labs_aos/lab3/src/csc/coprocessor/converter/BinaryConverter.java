package csc.coprocessor.converter;

public class BinaryConverter {
    private final int characteristicCapacity;
    private final int mantissaCapacity;
    private final double maxValue;
    private final double minValue;
    private final double maxAccuracy;
    private final String zeroBinary;
    private final String positiveInfinityBinary;
    private final String negativeInfinityBinary;

    public BinaryConverter(int characteristicCapacity, int mantissaCapacity) {
        this.characteristicCapacity = characteristicCapacity;
        this.mantissaCapacity = mantissaCapacity;
        maxValue = Math.pow(2, Math.pow(2, characteristicCapacity) - Math.pow(2, characteristicCapacity - 1));
        minValue = -maxValue;
        maxAccuracy = Math.pow(2, characteristicCapacity);
        zeroBinary = getZeoBinary();
        positiveInfinityBinary = getPositiveInfinityBinary();
        negativeInfinityBinary = getNegativeInfinityBinary();
    }

    public String convertToIEEE754(double x) {
        if (x == 0) return zeroBinary;
        if (x > maxValue) return positiveInfinityBinary;
        if (x < minValue) return negativeInfinityBinary;

        // calc sign bit
        String signBit = "0";
        if (x < 0) {
            signBit = "1";
        }

        // calc characteristic bits
        long k = (long) Math.ceil(Math.log(1. / Math.abs(x)) / Math.log(2));
        long bias = (long) Math.pow(2, characteristicCapacity - 1) - 1;
        long characteristic = bias - k > 0 ? bias - k : 0;

        String characteristicBits =
                String.format("%0" + characteristicCapacity + "d", Long.parseLong(Long.toBinaryString(characteristic)));

        double m = Math.abs(x) * Math.pow(2, k);
        double mantissa = m - 1;
        String mantissaBits = binaryOfFraction(mantissa, mantissaCapacity);

        return signBit + " " + characteristicBits + " " + mantissaBits;
    }

    private String binaryOfFraction(double x, int accuracy) {
        StringBuilder res = new StringBuilder();

        int integralPart = (int) x;
        double fractionalPart = x - integralPart;
        for (int i = 0; i < accuracy; i++) {
            x = fractionalPart * 2;
            integralPart = (int) (x);
            res.append(integralPart);
            fractionalPart = x - integralPart;
        }

        return res.toString();
    }

    private String getZeoBinary() {
        StringBuilder res = new StringBuilder("0 ");
        for (int i = 0; i < characteristicCapacity; i++) {
            res.append('0');
        }
        res.append(" ");
        for (int i = 0; i < mantissaCapacity; i++) {
            res.append('0');
        }

        return res.toString();
    }

    private String getPositiveInfinityBinary() {
        return "0 " + getInfinityBinary();
    }


    private String getNegativeInfinityBinary() {
        return "1 " + getInfinityBinary();
    }

    private String getInfinityBinary() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < characteristicCapacity; i++) {
            res.append('1');
        }
        res.append(" ");
        for (int i = 0; i < mantissaCapacity; i++) {
            res.append('0');
        }

        return res.toString();
    }

    public double getMaxValue() {
        return maxValue;
    }

    public double getMinValue() {
        return minValue;
    }
}
