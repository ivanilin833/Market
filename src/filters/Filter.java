package filters;

import java.util.List;

public interface Filter<T, S> {
    List<T> filter(List<T> t, S value);
}
