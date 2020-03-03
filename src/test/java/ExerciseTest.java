import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.axiom.Exercise;

import java.util.Random;

public class ExerciseTest {
    private static int[] arr;
    @BeforeClass
    public static void initArray() {
        Random rand = new Random(123L);
        arr = new int[127];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(64);
        }
    }

    @Test
    public void ex1Test() {
        double resultV1 = Exercise.ex1v1(arr);

        double resultV2 = Exercise.ex1v2(arr);

        Assert.assertEquals(resultV1, resultV2, 0.0001);
    }

    @Test
    public void ex1v1test() {
        double result = Exercise.ex1v1(arr);

        Assert.assertEquals(result, 30.36, 0.01);
    }

    @Test
    public void ex1v2Test() {
        double result = Exercise.ex1v2(arr);

        Assert.assertEquals(result, 30.36, 0.01);
    }

    @Test
    public void ex2v1Test() {
        int[] res = Exercise.ex2v1(arr);

        Assert.assertEquals(2, res.length);

        Assert.assertEquals(37, res[0]);
        Assert.assertEquals(0, res[1]);
    }

    @Test
    public void ex3Test() {
        int countV1 = Exercise.ex3v1(arr);
        int countV2 = Exercise.ex3v2(arr);

        Assert.assertEquals(countV1, countV2);

    }

    @Test
    public void ex3v1Test() {
        int count = Exercise.ex3v1(arr);

        Assert.assertEquals(2, count);
    }

    @Test
    public void ex3v2Test() {
        int count = Exercise.ex3v2(arr);

        Assert.assertEquals(2, count);
    }

    @Test
    public void ex4Test() {
        int count1 = Exercise.ex4v1(arr);
        int count2 = Exercise.ex4v2(arr);

        Assert.assertEquals(count1, count2);
    }

    @Test
    public void ex5Test() {
        int[] testArr = new int[] {1, 2, 3, -5, 0, -1};
        int[] resArr = new int[] {-2, -4, -6, 10, 0, 2};

        int[] result = Exercise.ex5v1(testArr, -2);
        Assert.assertArrayEquals(resArr, result);
    }


}
