package lab10.ex7;

public class ConcreteObserver1 implements ProgramAdditionObserver {
    @Override
    public void showAdded(Iterable<Show> pShows) {
        System.out.println("[Observer1] Added -> program now: " + describe(pShows));
    }

    static String describe(Iterable<Show> pShows) {
        StringBuilder sb = new StringBuilder();
        for (Show show : pShows) {
            sb.append(show.title()).append('(').append(show.day()).append(") ");
        }
        return sb.length() == 0 ? "<empty>" : sb.toString().trim();
    }
}