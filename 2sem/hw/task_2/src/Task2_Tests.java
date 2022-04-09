import org.junit.Assert;
import org.junit.*;

public class Task2_Tests extends Assert{
    class TestComparator implements MyComparator<Integer>{
        @Override
        public int compare(Integer first, Integer second) {
            return first - second;
        }
    }

    private boolean isSorted(Integer[] data){
        for(int i=0; i<data.length-1; i++){
            if(data[i]>data[i+1])
                return false;
        }
        return true;
    }

    //-----------BubbleSort------------------------------------------------
    @Test
    public void bubbleSort_ArrayOnlyNumbersOne_ArrayNotChanged(){//5
        try {
            BubbleSort<Integer> bubbleSort = new BubbleSort<>();
            Integer[] arr = {1, 1, 1};
            bubbleSort.sort(arr, new TestComparator());
            assertArrayEquals(new Integer[]{1, 1, 1}, arr);
        }
        catch (Exception e){
            fail();
        }
    }

    @Test
    public void bubbleSort_InvertedArrayWithTheSameLastTheBiggestElement_GetSortedArray(){ //6
        BubbleSort<Integer> bubbleSort = new BubbleSort<>();
        Integer[] arr = {3, 2, 1, 4};
        bubbleSort.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3, 4}, arr);
    }

    @Test
    public void bubbleSort_InvertedArray_GetSortedArray(){//
        BubbleSort<Integer> bubbleSort = new BubbleSort<>();
        Integer[] arr = {3, 2, 1};
        bubbleSort.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, arr);
    }

    @Test
    public void bubbleSort_UnsortedArray_GetSortedArray(){
        BubbleSort<Integer> bubbleSort = new BubbleSort<>();
        Integer[] arr = {15,23,5,0};
        bubbleSort.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{0, 5, 15, 23}, arr);
    }

    //-----------------SelectionSort----------------------------------------------
    @Test
    public void selectionSort_ArrayWithTheFirstMaxElem_SortOk(){
        SelectionSort<Integer> ss = new SelectionSort<>();
        Integer[] data={5,4,2};
        ss.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{2,4,5}, data);
    }
    @Test
    public void selectionSort_UnsortedArrayWithTwoElements_SortOk(){
        SelectionSort<Integer> ss = new SelectionSort<>();
        Integer[] data={5,4};
        ss.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{4,5}, data);
    }
    @Test
    public void selectionSort_UnsortedArray_SortOk(){
        SelectionSort<Integer> ss = new SelectionSort<>();
        Integer[] data={5,4,1,2,3};
        ss.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1,2,3,4,5}, data);
    }

    //----------------InsertionSort---------------------------------
    @Test
    public void insertionSort_sortedArrayWithTwoElements_ArrayDoesNotChange(){
        InsertionSort<Integer> is = new InsertionSort<>();
        Integer[] data={4,5};
        is.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{4,5}, data);
    }
    @Test
    public void insertionSort_unsortedArrayWithTwoElements_SortIsOk(){
        InsertionSort<Integer> is = new InsertionSort<>();
        Integer[] data={5,4};
        is.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{4,5}, data);
    }

}