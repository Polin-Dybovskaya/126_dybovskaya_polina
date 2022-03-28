import org.junit.*;

public class Task3_Tests extends Assert {
    class TestComparator implements MyComparator<Integer>{
        @Override
        public int compare(Integer first, Integer second) {
            return first - second;
        }
    }
    //................ Quick Sort...........
    @Test
    public void QuickSort_SortNotNeed_SortCorrect(){//w
        Integer[] arr= {1,1,1};
        QuickSort<Integer> qs = new QuickSort();
        qs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{1,1,1}, arr);
    }
    @Test
    public void quickSort_sortArrayWithTwoNumbers_SortCorrect() {//12 24 - 13 14
        Integer[] arr = new Integer[]{5, 3};
        QuickSort<Integer> qs = new QuickSort();
        qs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{3, 5}, arr);
    }
    @Test
    public void QuickSort_sortArrayDifNumbers_SortCorrect(){// w
        Integer[] arr = {2,3,5,4,1};
        QuickSort<Integer> qs = new QuickSort();
        qs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{1,2,3,4,5}, arr);
    }
    @Test
    public void QuickSort_sortArrayWithSameNumbers_SortCorrect(){//25 29
        Integer[] arr = {2,4,1,3,1};
        QuickSort<Integer> qs = new QuickSort();
        qs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{1,1,2,3,4}, arr);
    }
    @Test
    public void QuickSort_SortNotNeed_NumbersOnRightPositions(){//тест на всякий случай к первому
        Integer[] arr = {1,2,3,4,5};
        QuickSort<Integer>bs= new QuickSort<>();
        bs.sort(arr,new TestComparator());
        assertArrayEquals(new Integer[]{1,2,3,4,5}, arr);
    }
    //..........HeapSort...............
    @Test
    public void HeapSort_SortNotNeed_SortCorrect(){//10
        Integer[] arr= {1,1,1};
        HeapSort<Integer> qs = new HeapSort();
        qs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{1,1,1}, arr);
    }
    @Test
    public void HeapSort_sortArrayWithTwoNumbers_SortCorrect() {
        Integer[] arr = new Integer[]{5, 3};
        HeapSort<Integer> qs = new HeapSort();
        qs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{3, 5}, arr);
    }
    @Test
    public void HeapSort_sortArrayDifNumbers_SortCorrect(){//17
        Integer[] arr = {2,3,5,4,1};
        HeapSort<Integer> qs = new HeapSort();
        qs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{1,2,3,4,5}, arr);
    }
    @Test
    public void HeapSort_sortArrayWithSameNumbers_SortCorrect(){
        Integer[] arr = {2,4,1,3,1};
        HeapSort<Integer> qs = new HeapSort();
        qs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{1,1,2,3,4}, arr);
    }

    @Test
    public void HeapSort_SortNotNeed_NumbersOnRightPositions(){//18
        Integer[] arr = {1,2,3,4,5,6};
        HeapSort<Integer>bs= new HeapSort<>();
        bs.sort(arr,new TestComparator());
        assertArrayEquals(new Integer[]{1,2,3,4,5,6}, arr);
    }
    @Test
    public void HeapSort_sortArray_SortCorrect(){
        Integer[] arr = {4,1,1,3,4};
        HeapSort<Integer> qs = new HeapSort();
        qs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{1,1,3,4,4}, arr);
    }
    @Test
    public void HeapSort_sortArrayB_SortCorrect() {
        Integer[] arr = new Integer[]{5, 1, 2, 3, 1, 5, 5, 2};
        HeapSort<Integer> hs = new HeapSort();
        hs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{1, 1, 2, 2, 3, 5, 5, 5}, arr);
    }
    //...........MergeSort.............

}
