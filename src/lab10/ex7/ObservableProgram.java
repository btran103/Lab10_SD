package lab10.ex7;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import lab10.Day;

public class ObservableProgram implements Iterable<Show> {
    private final Map<Day, Show> aShows = new EnumMap<>(Day.class);
    private final List<ProgramAdditionObserver> aAdditionObservers = new ArrayList<>();
    private final List<ProgramRemovalObserver> aRemovalObservers = new ArrayList<>();

    public void addObserver(ProgramAdditionObserver pObserver) {
        assert pObserver != null;
        if (!aAdditionObservers.contains(pObserver)) {
            aAdditionObservers.add(pObserver);
        }
    }

    public void addObserver(ProgramRemovalObserver pObserver) {
        assert pObserver != null;
        if (!aRemovalObservers.contains(pObserver)) {
            aRemovalObservers.add(pObserver);
        }
    }

    public void add(Show pShow) {
        assert pShow != null;
        if (aShows.containsKey(pShow.day())) {
            remove(pShow.day());
        }
        aShows.put(pShow.day(), pShow);
        for (ProgramAdditionObserver observer : aAdditionObservers) {
            observer.showAdded(this); // pull
        }
    }

    public void remove(Day pDay) {
        assert pDay != null;
        if (aShows.remove(pDay) != null) {
            for (ProgramRemovalObserver observer : aRemovalObservers) {
                observer.showRemoved(this);
            }
        }
    }

    public void clear() {
        aShows.clear();
        for (ProgramRemovalObserver observer : aRemovalObservers) {
            observer.programCleared();
        }
    }

    public Optional<Show> get(Day pDay) {
        return Optional.ofNullable(aShows.get(pDay));
    }

    @Override
    public Iterator<Show> iterator() {
        return new ArrayList<>(aShows.values()).iterator(); // thứ tự Monday..Sunday
    }
}