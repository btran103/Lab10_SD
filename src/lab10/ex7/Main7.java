package lab10.ex7;

import lab10.Day;

public class Main7 {
    public static void main(String[] args) {
        ObservableProgram program = new ObservableProgram();
        ConcreteObserver3 both = new ConcreteObserver3();
        program.addObserver(new ConcreteObserver1());
        program.addObserver(new ConcreteObserver2());
        // Phải ép kiểu để chọn đúng overload vì Observer3 implements cả hai interface
        program.addObserver((ProgramAdditionObserver) both);
        program.addObserver((ProgramRemovalObserver) both);

        program.add(new Show("Movie", Day.FRIDAY));
        program.add(new Show("News", Day.MONDAY));
        program.remove(Day.FRIDAY);
        program.clear();
    }
}