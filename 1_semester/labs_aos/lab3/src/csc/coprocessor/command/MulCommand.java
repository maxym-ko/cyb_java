package csc.coprocessor.command;

public class MulCommand extends BiFuncCommand {
    public MulCommand() {
        super("FMULP ST(0) ST(1)", "### Множимо два верхні значення зі стеку; результат залишається на вершині");
    }

    @Override
    public double func(double x, double y) {
        return x * y;
    }
}
