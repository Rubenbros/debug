package noMirar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * DEJA DE MIRAR ESTA CLASE. ES COMO VER LA CARA DE UN ANGEL
 */
public class CreaObjetos {

    final static Set<Object> cache = new HashSet<>();

    public static List<Object> getList(final int size) {
        final List<Object> list = new ArrayList<>();

        for (int i = 0; i < size - 1; i++) {
            list.add((Math.random() * 100000));
        }

        return list;
    }

    public static Object[] getArray(final int size) {
        final Object[] array = new Object[size];

        for (int i = 0; i < size - 1; i++) {
            array[i] = Math.random() * 100000;
        }

        array[(int) (Math.random() * (size - 1))] = null;

        return array;
    }

    public static Double[] getDoubleArray(final int size) {
        final Double[] array = new Double[size];

        return array;
    }

    public static Float[] getFloatArray(final int size) {
        final Float[] array = new Float[size];

        cache.add(array);

        return array;
    }

    public static Long[] getLongArray(final int size) {
        final Long[] array = new Long[size];

        return array;
    }
}