package csc.coprocessor.command;

public class CosCommand extends FuncCommand {
    public CosCommand() {
        super("FCOS", "### Обчислюємо косинус від значення, котре зберігається на вершині стеку");
    }

    @Override
    public double func(double x) {
        return Math.cos(x);
    }
}
