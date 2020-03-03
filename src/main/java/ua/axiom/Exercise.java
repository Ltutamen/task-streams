package ua.axiom;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class Exercise {
    public static double ex1v1(int[] arr) {
        double avg = Arrays.
                stream(arr).
                average().orElse(0.);

        return avg;
    }

    public static double ex1v2(int[] arr) {
        double avg = Arrays.
                stream(arr).
                asDoubleStream().
                reduce(0., (sum, i) -> sum + (i / (double)arr.length));

        return avg;
    }

    public static int[] ex2v1(int[] arr) {
        class IndexedInts {
            int i;
            int val;

            public IndexedInts(int i, int val) {
                this.i = i;
                this.val = val;
            }

            public int getVal() {
                return val;
            }
        }

        AtomicInteger lastIndex = new AtomicInteger();

        IndexedInts min = Arrays.
                stream(arr).
                boxed().
                map(i -> new IndexedInts(lastIndex.getAndIncrement(), i)).
                min(Comparator.comparing(IndexedInts::getVal)).
                orElse(new IndexedInts(-1, Integer.MIN_VALUE));

        //  System.out.format("arr[%d] = %d", min.i, min.val);

        return new int[]{min.i, min.val};

    }

    public static int ex3v1(int[] arr) {
        return generalExV1(arr, (scount, i) -> i == 0 ? ++scount : scount);
        /*
        int count = Arrays.
                stream(arr).
                reduce(0, (scount, i) -> i == 0 ? ++scount : scount);

        return count;
        */
    }

    public static int ex3v2(int[] arr) {
        return generalExV2(arr, i -> i == 0);
        /*
        int count = (int)Arrays.
                stream(arr).
                filter(i -> i == 0).
                count();

        return count;

        */
    }

    public static int ex4v1(int[] arr) {
        return generalExV1(arr, (counter, i) -> i > 0 ? ++counter : counter);
    }

    public static int ex4v2(int[] arr) {
        return generalExV2(arr, i -> i > 0);
    }

    public static int generalExV1(int[] arr, BiFunction<Integer, Integer, Integer> bf) {
        int count = Arrays.
                stream(arr).
                reduce(0, bf::apply);

        return count;
    }

    public static int generalExV2(int[] arr, Predicate<Integer> filter) {
        int count = (int)Arrays.
                stream(arr).
                filter(filter::test).
                count();

        return count;
    }

    public static int[] ex5v1(int[] arr, int num) {
        return Arrays.
                stream(arr).
                map(i -> i * num).
                toArray();
    }


}
