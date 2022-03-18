import org.junit.*;

public class Task1_Tests extends Assert {

    private int getIntValue(ListNode<Integer> item) {
        return ((Node<Integer>) item).getData();
    }
//DynamicArray...................
//.............

    @Test
    public void  createArray_CreateArrayWithoutSize_SizeEqualsDefaultSize(){
        DynamicArray<Integer> array = new DynamicArray<>();
        assertEquals(1024, array.getSize());
    }

}


