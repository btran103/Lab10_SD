package lab10.ex6;

import lab10.Day;

public class ConcreteProgramObserver implements ProgramObserver {
    @Override
    public void showAdded(Show pShow, Day pDay) {
        System.out.println("[Observer] Added   : " + pShow.title() + " on " + pDay);
    }

    @Override
    public void showRemoved(Show pShow, Day pDay) {
        System.out.println("[Observer] Removed : " + pShow.title() + " from " + pDay);
    }

    @Override
    public void programCleared() {
        System.out.println("[Observer] Program cleared");
    }
}