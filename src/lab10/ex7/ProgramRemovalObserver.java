package lab10.ex7;

public interface ProgramRemovalObserver {
    void showRemoved(Iterable<Show> pShows);

    void programCleared();
}