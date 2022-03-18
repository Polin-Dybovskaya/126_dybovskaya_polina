import org.junit.*;

public class Task1_Tests extends Assert {

//DynamicArray...................
//.............

    @Test
    public void  createArray_CreateArrayWithoutSize_SizeEqualsDefaultSize(){
        DynamicArray<Integer> array = new DynamicArray<>();
        assertEquals(1024, array.getSize());
    }

    @Test// works
    public void  createArray_CreateArrayWithSize_SizeEqualsNumber() {
        DynamicArray<Integer> array = new DynamicArray<>(1);
        assertEquals(1, array.getSize());
    }
    @Test//no work
    public void createArray_TryToGetValueOut_GetIndexOutOfBoundsException() {
        DynamicArray<Integer> array = new DynamicArray<>(1);
        try {
            array.get(1);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertEquals("mistake", e.getMessage());
        }
    }

}


