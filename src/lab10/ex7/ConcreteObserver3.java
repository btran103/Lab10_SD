package lab10.ex7;

public class ConcreteObserver3 implements ProgramAdditionObserver, ProgramRemovalObserver {
    @Override
    public void showAdded(Iterable<Show> pShows) {
        System.out.println("[Observer3] Added   -> " + ConcreteObserver1.describe(pShows));
    }

    @Override
    public void showRemoved(Iterable<Show> pShows) {
        System.out.println("[Observer3] Removed -> " + ConcreteObserver1.describe(pShows));
    }

    @Override
    public void programCleared() {
        System.out.println("[Observer3] Program cleared");
    }
}