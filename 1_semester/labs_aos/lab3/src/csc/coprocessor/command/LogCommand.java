package csc.coprocessor.command;

public class LogCommand extends FuncCommand {
    public LogCommand() {
        super("FLOGE", "### Обчислюємо натуральний логарифм від значення, котре зберігається на вершині стеку");
    }

    @Override
    public double func(double x) {
        return Math.log(x);
    }
}
