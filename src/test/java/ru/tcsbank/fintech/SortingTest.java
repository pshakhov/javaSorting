package ru.tcsbank.fintech;

import org.junit.Test;
import org.hamcrest.MatcherAssert;
import java.util.Arrays;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class SortingTest {

    QuickSort sort = new QuickSort();

    @Test
    public void testTwo() {
        int[] expected = new int[] { 1, 2 };
        int[] array = new int[] { 2, 1 };
        sort.quickSort(array);
        MatcherAssert.assertThat("Ошибка!",false);//assertTrue(Arrays.equals(expected, array));
    }

    @Test
    public void testQuickSort() {
        int [] input = new int[]{6,1,7,9,3,8,2,5,4,0};
        int[] sortedArray = sort.quickSort(input);

        String str = sortedArray.toString();

            assertEquals("0:1:2:3:4:5:6:7:8:9:", str);
    }

    @Test
    public void testQuickSortZero() {
        int [] input = new int[]{0,0,0,0,0,0,0,0,0,0};
        int[] sortedArray = sort.quickSort(input);

        String str = sortedArray.toString();

        assertEquals("0:0:0:0:0:0:0:0:0:0:", str);
    }

    @Test(expected = NullPointerException.class)
    public void testNull() {
        QuickSort sort = new QuickSort();
        sort.quickSort(null);
    }

    @Test
    public void testEmpty() {
        int[] orig = new int[0];
        int[] array = orig.clone();
        sort.quickSort(array);
        assertTrue(Arrays.equals(orig, array));
    }

    @Test
    public void testThree() {
        int[] expect = new int[] { Integer.MIN_VALUE, 0, Integer.MAX_VALUE };
        int[] array = new int[] { 0, Integer.MAX_VALUE, Integer.MIN_VALUE };
        sort.quickSort(array);
        assertTrue(Arrays.equals(expect, array));
    }

    @Test
    public void testThree2() {
        int[] expect = new int[] { 1, 1, 1 };
        int[] array = new int[] { 1, 1, 1 };
        sort.quickSort(array);
        assertTrue(Arrays.equals(expect, array));
    }

    @Test
    public void testThree3() {
        int[] expect = new int[] { 1, 2, 2 };
        int[] array = new int[] { 1, 2, 2 };
        sort.quickSort(array);
        assertTrue(Arrays.equals(expect, array));
    }

    @Test
    public void testThree4() {
        int[] expect = new int[] { 1, 2, 2 };
        int[] array = new int[] { 2, 2, 1 };
        sort.quickSort(array);
        assertTrue(Arrays.equals(expect, array));
    }

    @Test
    public void testThree5() {
        int[] expect = new int[] { 1, 2, 2 };
        int[] array = new int[] { 2, 1, 2 };
        sort.quickSort(array);
        assertTrue(Arrays.equals(expect, array));
    }

    @Test
    public void testFour() {
        int[] expect = new int[] { Integer.MIN_VALUE, -100, 0,
                Integer.MAX_VALUE };
        int[] array = new int[] { 0, Integer.MAX_VALUE, Integer.MIN_VALUE, -100 };
        sort.quickSort(array);
        assertTrue(Arrays.equals(expect, array));
    }

    @Test
    public void testSame() {
        int[] expect = new int[] { 1, 1, 1, 1, 1, 1, 1 };
        int[] array = expect.clone();
        sort.quickSort(array);
        assertTrue(Arrays.equals(expect, array));
    }

}