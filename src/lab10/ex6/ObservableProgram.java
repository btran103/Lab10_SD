package lab10.ex6;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import lab10.Day;

public class ObservableProgram {
    private final Map<Day, Show> aShows = new EnumMap<>(Day.class);
    private final List<ProgramObserver> aObservers = new ArrayList<>();

    public void addObserver(ProgramObserver pObserver) {
        assert pObserver != null;
        if (!aObservers.contains(pObserver)) {
            aObservers.add(pObserver);
        }
    }

    public void add(Show pShow, Day pDay) {
        assert pShow != null && pDay != null;
        if (aShows.containsKey(pDay)) {
            remove(pDay);
        }
        aShows.put(pDay, pShow);
        for (ProgramObserver observer : aObservers) {
            observer.showAdded(pShow, pDay); // push
        }
    }

    public void remove(Day pDay) {
        assert pDay != null;
        Show removed = aShows.remove(pDay);
        if (removed != null) {
            for (ProgramObserver observer : aObservers) {
                observer.showRemoved(removed, pDay); // push
            }
        }
    }

    public void clear() {
        aShows.clear();
        for (ProgramObserver observer : aObservers) {
            observer.programCleared();
        }
    }

    public Optional<Show> get(Day pDay) {
        return Optional.ofNullable(aShows.get(pDay));
    }
}