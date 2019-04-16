public class Operator {

    public static <T extends Comparable<T>> T smallest(T[] array){
        if (array.length <= 0) {
            throw new ArrayIndexOutOfBoundsException("array is empty.");
        }
        T lowest = array[0];
        for (T e: array) {
            if (e == null) continue;
            if (e.compareTo(lowest) < 0){
                lowest = e;
            }
        }
        return lowest;
    }

    public static <T extends Comparable<T>> T biggest(T[] array){
        if (array.length <= 0) {
            throw new ArrayIndexOutOfBoundsException("array is empty.");
        }
        T highest = array[0];
        for (T e: array) {
            if (e == null) continue;
            if (e.compareTo(highest) > 0){
                highest = e;
            }
        }
        return highest;
    }

    public static <T extends Comparable<T>> int index(T[] array, T obj){
        if (array.length <= 0) {
            throw new ArrayIndexOutOfBoundsException("array is empty.");
        }
        for (int i = 0 ; i < array.length ; i++) {
            if (array[i] == null) continue;
            if (array[i].compareTo(obj) == 0){
                return i;
            }
        }
        return -1;
    }
}
