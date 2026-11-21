package lab10.ex6;

import lab10.Day;

public interface ProgramObserver {
    void showAdded(Show show, Day day);

    void showRemoved(Show show, Day day);

    void programCleared();
}