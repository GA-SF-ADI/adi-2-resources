import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

/**
 * Created by drewmahrt on 1/28/16.
 */
public class MainTest {
    @Test
    public void testFindLargestAndSmallest() {
        Assert.assertArrayEquals(new int[]{1,7},Main.findLargestAndSmallest(new int[]{1,5,7,2,3}));
        Assert.assertArrayEquals(new int[]{3,3},Main.findLargestAndSmallest(new int[]{3,3}));
        Assert.assertArrayEquals(new int[]{1,5},Main.findLargestAndSmallest(new int[]{1,2,3,4,5}));
        Assert.assertArrayEquals(new int[]{7,7},Main.findLargestAndSmallest(new int[]{7,7,7,7,7,7}));
        Assert.assertArrayEquals(new int[]{3,5},Main.findLargestAndSmallest(new int[]{5,4,3}));
        Assert.assertArrayEquals(new int[]{-5,5},Main.findLargestAndSmallest(new int[]{5,4,-5,3}));
    }

    @Test
    public void testRemoveDuplicatesFromArray(){
        Object[] arr1 = Main.removeDuplicatesFromArray(new int[]{1,4,3,2,1});
        Arrays.sort(arr1);
        Assert.assertArrayEquals(new Object[]{1,2,3,4},arr1);

        Object[] arr2 = Main.removeDuplicatesFromArray(new int[]{4,3,2,1});
        Arrays.sort(arr2);
        Assert.assertArrayEquals(new Object[]{1,2,3,4},arr2);

        Object[] arr3 = Main.removeDuplicatesFromArray(new int[]{1,1,1,1});
        Arrays.sort(arr3);
        Assert.assertArrayEquals(new Object[]{1},arr3);
    }

    @Test
    public void testSumOfTwoLargest(){
        Assert.assertEquals(0,Main.sumOfTwoLargest(new int[]{}));
        Assert.assertEquals(5,Main.sumOfTwoLargest(new int[]{5}));
        Assert.assertEquals(9,Main.sumOfTwoLargest(new int[]{5,4}));
        Assert.assertEquals(15,Main.sumOfTwoLargest(new int[]{1,7,5,2,-1,8}));
        Assert.assertEquals(-2,Main.sumOfTwoLargest(new int[]{-1,-7,-5,-2,-1,-8}));
    }
}
