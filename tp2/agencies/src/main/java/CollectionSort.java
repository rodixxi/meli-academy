import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CollectionSort {

    public static <T extends Comparable<T>> Collection<T> sort (Collection<T> collection) {
        List<T> list = new ArrayList<T>(collection);
        Collections.sort(list);
        return list;
    }
}
