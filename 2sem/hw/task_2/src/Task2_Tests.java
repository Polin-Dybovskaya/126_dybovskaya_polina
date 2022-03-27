import org.junit.*;

public class Task2_Tests extends Assert {
    //.................BubbleSort.java...................
    class TestComparator implements MyComparator<Integer>{
        @Override
        public int compare(Integer first, Integer second) {
            return first - second;
        }
    }
    @Test
    public void BubbleSort_SortNotNeed_SortCorrect(){//5
        Integer[] data = {1,1,1};
        BubbleSort<Integer>bs= new BubbleSort<>();
        bs.sort(data,new TestComparator());
        assertArrayEquals(new Integer[]{1,1,1}, data);
    }
    @Test
    public void BubbleSort_SortNotNeed_NumbersOnRightPositions(){//6
        Integer[] data = {1,2,3,4,5};
        BubbleSort<Integer>bs= new BubbleSort<>();
        bs.sort(data,new TestComparator());
        assertArrayEquals(new Integer[]{1,2,3,4,5}, data);
    }
    @Test
    public void BubbleSort_sortDats_SortCorrect(){//4
        Integer[] data = {2,3,5,4,1};
        BubbleSort<Integer>bs= new BubbleSort<>();
        bs.sort(data,new TestComparator());
        assertArrayEquals(new Integer[]{1,2,3,4,5}, data);
    }
    private boolean isSorted (Integer[] data){
        for (int i=0; i<data.length - 1;++i){
            if (data[i]>data[i-1])
                return false;
        }
        return true;
    }
    //.................InsertionSort.java...................
    @Test
    public void InsertionSort_SortNotNeed_SortCorrect(){//6
        Integer[] data = {1,1,1};
        InsertionSort<Integer> is= new InsertionSort<>();
        is.sort(data,new TestComparator());
        assertArrayEquals(new Integer[]{1,1,1}, data);
    }
    @Test
    public void InsertionSort_SortNotNeed_NumbersOnRightPositions(){//WORK
        Integer[] data = {1,2,3,4,5};
        InsertionSort<Integer> is = new InsertionSort<>();
        is.sort(data,new TestComparator());
        assertArrayEquals(new Integer[]{1,2,3,4,5}, data);
    }
    @Test
    public void InsertionSort_sortDats_SortCorrect(){//8
        Integer[] data = {2,3,5,4,1};
        InsertionSort<Integer> is = new InsertionSort<>();
        is.sort(data,new TestComparator());
        assertArrayEquals(new Integer[]{1,2,3,4,5}, data);
    }

    //.................SelectionSort.java...................
    @Test
    public void SelectionSort_SortNotNeed_SortCorrect(){//work
        Integer[] data = {1,1,1};
        SelectionSort<Integer>ss= new SelectionSort<>();
        ss.sort(data,new TestComparator());
        assertArrayEquals(new Integer[]{1,1,1}, data);
    }

    @Test
    public void SelectionSort_SortDats_SortOk(){//5
        Integer[] data = {3,2,1};
        SelectionSort<Integer>ss= new SelectionSort<>();
        ss.sort(data,new TestComparator());
        assertArrayEquals(new Integer[]{1,2,3}, data);
    }
    @Test
    public void SelectionSort_sortTwoNumbers_SortCorrect(){//4 11 10
        Integer[] data = {2,1};
        SelectionSort<Integer>ss= new SelectionSort<>();
        ss.sort(data,new TestComparator());
        assertArrayEquals(new Integer[]{1,2}, data);
    }
    @Test
    public void SelectionSort_sortDats_SortCorrect(){//8
        Integer[] data = {2,3,5,4,1};
        SelectionSort<Integer>ss= new SelectionSort<>();
        ss.sort(data,new TestComparator());
        assertArrayEquals(new Integer[]{1,2,3,4,5}, data);
    }
    @Test
    public void SelectionSort_SortNotNeed_NumbersOnRightPositions(){//
        Integer[] data = {1,2,3,4,5};
        SelectionSort<Integer>ss= new SelectionSort<>();
        ss.sort(data,new TestComparator());
        assertArrayEquals(new Integer[]{1,2,3,4,5}, data);
    }
}
