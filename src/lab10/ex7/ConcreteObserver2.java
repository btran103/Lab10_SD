package lab10.ex7;

public class ConcreteObserver2 implements ProgramRemovalObserver {
    @Override
    public void showRemoved(Iterable<Show> pShows) {
        System.out.println("[Observer2] Removed -> program now: " + ConcreteObserver1.describe(pShows));
    }

    @Override
    public void programCleared() {
        System.out.println("[Observer2] Program cleared");
    }
}