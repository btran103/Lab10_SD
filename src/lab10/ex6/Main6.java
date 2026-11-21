package lab10.ex6;

import lab10.Day;

public class Main6 {
    public static void main(String[] args) {
        ObservableProgram program = new ObservableProgram();
        program.addObserver(new ConcreteProgramObserver());
        program.add(new Show("News"), Day.MONDAY);
        program.add(new Show("Movie"), Day.FRIDAY);
        program.add(new Show("Sports"), Day.MONDAY); // thay thế News
        program.remove(Day.FRIDAY);
        program.clear();
    }
}