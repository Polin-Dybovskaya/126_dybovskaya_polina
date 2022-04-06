import org.junit.*;
import org.junit.Assert;

public class Task1_Tests extends Assert {

//..................DynamicArray.................


    @Test
    public void createArray_CreateArrayWithoutSize_SizeEqualsDefaultSize() {//11
        DynamicArray<Integer> array = new DynamicArray<>();
        assertEquals(1024, array.getSize());
    }

    @Test// works
    public void createArray_CreateArrayWithSize_SizeEqualsNumber() {//-
        DynamicArray<Integer> array = new DynamicArray<>(100);
        assertEquals(100, array.getSize());
    }

    @Test
    public void resize_SizeNumber_NewSizeCorrect() {//21 27
        try {
            DynamicArray<Integer> array = new DynamicArray<>(100);
            array.resize(200);
            assertEquals(200, array.getSize());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void createArray_GetOutOfBounds_GetIndexOutOfBoundsException() {//30
        DynamicArray<Integer> array = new DynamicArray<>(100);
        try {
            array.get(100);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index out of bounds", e.getMessage());
        }
    }

    @Test
    public void createArray_SetOutOfBounds_GetIndexOutOfBoundsException() {//35
        DynamicArray<Integer> array = new DynamicArray<>(100);
        try {
            array.set(100, 1);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index out of bounds", e.getMessage());
        }
    }

    @Test
    public void setNumbers_SetTwoNumbers_NumbersCorrect() {//15
        DynamicArray<Integer> array = new DynamicArray<>(111);
        array.set(0, 100);
        array.set(1, 200);
        assertEquals(100, array.get(0).intValue());
        assertEquals(200, array.get(1).intValue());
    }
    @Test
    public void insert_TryToInsertValueOutOfRange_GettingIndexOutOfBoundsException() {//40 !!!!!
        DynamicArray<Integer> array = new DynamicArray<>(10);
        try {
            array.insert(10, 1);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index out of bounds", e.getMessage());
        }
    }
    @Test//42
    public void insert_NumbersWithIndexEqualsSize_ThrowsException(){//40 no
        DynamicArray<Integer> array = new DynamicArray<>(5);
        try {
            array.insert(5, 6);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }
    @Test// 42 49
    public void insert_insertNumbers_NumbersCorrect(){//42 49
        DynamicArray<Integer> array = new DynamicArray<>(1000);
        array.set(0, 100);
        array.set(1, 200);
        array.set(2, 400);
        array.insert(2, 300);

        assertEquals(300, array.get(2).intValue());
        assertEquals(400, array.get(3).intValue());
    }
    @Test
    public void pushBack_pushBackNumber_NumberCorrect() {// 52 56
        DynamicArray<Integer> array = new DynamicArray<>(11);
        array.set(0, 100);
        array.set(1, 200);
        array.pushBack(400);

        assertEquals(400, array.get(11).intValue());
    }
    @Test
    public void popBack_popBackNumberFromEmptyArray_GetUnsupportedOperationException() {//60
        try {
            DynamicArray<Integer> array = new DynamicArray<>(0);
            array.popBack();
            fail();
        } catch (Exception e) {
            assertEquals("Array is empty", e.getMessage());
        }
    }

    @Test
    public void popBack_GetPopedBackNumber_LastIsOutOfBound() {
        DynamicArray<Integer> array = new DynamicArray<>(3);
        array.set(0, 100);
        array.set(1, 200);
        array.set(2, 300);
        array.popBack();
        assertEquals(2, array.getSize());
    }
    @Test
    public void remove_RemoveIndexOutOfBounds_GetIndexOutOfBoundsException() {//66
        try {
            DynamicArray<Integer> array = new DynamicArray<>(3);
            array.set(0, 1);
            array.set(1, 2);
            array.set(2, 3);
            array.remove(3);
            fail();
        } catch (Exception e) {
            assertEquals("Index out of bounds", e.getMessage());
        }
    }

    @Test
    public void remove_RemoveOneNumber_NumberCorrect() {
        DynamicArray<Integer> array = new DynamicArray<>(10);
        array.set(0, 1);
        array.set(1, 2);
        array.set(2, 3);
        array.remove(1);

        assertEquals(1, array.get(0).intValue());
        assertEquals(3, array.get(1).intValue());

    }

//....................DoubleLinkedList ...................

    @Test
    public void createList_CreateEmptyList_SizeIsEmpty() {
       DoubleLinkedList<Integer> List = new DoubleLinkedList<>();
        assertEquals(true, List.isEmpty());
    }
    @Test
    public void pushFront_PushFrontToEmptyList_EmptyIsFalse() {//11
        DoubleLinkedList<Integer> List = new DoubleLinkedList<>();
        List.pushFront(100);
        assertEquals(false,List.isEmpty());
    }
    @Test
    public void getNextAndPrev_getDataOfNextAndPrevNumber_Correct(){//node13-14
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        Node<Integer> num1 = list.pushFront(100);
        Node<Integer> num3 = list.pushFront(300);
        Node<Integer> num = new Node<Integer>(200, num1, num3);

        Node<Integer> next = (Node<Integer>) num.getNext();
        Node<Integer> prev = (Node<Integer>) num.getPrev();

        assertEquals(100, next.getData().intValue());
        assertEquals(300, prev.getData().intValue());
    }
    @Test
    public void getSize_GetSizeTwo_SizeCorrect() {
        DoubleLinkedList<Integer> List = new DoubleLinkedList<>();
        List.pushFront(100);
        List.pushFront(200);
        assertEquals(2, List.getSize());
    }
    @Test
    public void pushBack_pushToEmptyList_SizeEqualsOne(){//33
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(20);
        assertEquals(1, list.getSize());
    }
    @Test
    public void pushFront_pushToEmptyList_SizeEqualsOne(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(20);
        assertEquals(1, list.getSize());

    }
    @Test
    public void get_getNumberByIndexEqualsSize_IndexOutOfBoundsException(){//24
        DoubleLinkedList<Integer> List = new DoubleLinkedList<>();
        List.pushFront(100);
        List.pushFront(200);
        try {
            List.get(2);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }

    @Test
    public void get_getNumberByIndex_GetCorrectNumber() {//41 44 17 20
        DoubleLinkedList<Integer> List = new DoubleLinkedList<>();
        List.pushFront(10);
        List.pushFront(20);
        List.pushFront(30);
        Node<Integer> num = (Node<Integer>) List.get(0);
        assertEquals(30, num.getData().intValue());
    }
    @Test
    public void get_getSecondNumberByIndex_GetCorrectNumber() {//28
        DoubleLinkedList<Integer> List = new DoubleLinkedList<>();
        List.pushBack(10);
        List.pushBack(20);
        List.pushBack(30);
        Node<Integer> num = (Node<Integer>) List.get(1);
        assertEquals(20, num.getData().intValue());
    }
    @Test
    public void getHeadAndTail_GetNumbers_HeadAndTailCorrect() {
        DoubleLinkedList<Integer> List = new DoubleLinkedList<>();
        List.pushFront(100);
        List.pushFront(200);
        List.pushFront(300);
        Node<Integer> head = (Node<Integer>) List.getHead();
        Node<Integer> tail = (Node<Integer>) List.getTail();
        assertEquals(300, head.getData().intValue());
        assertEquals(100, tail.getData().intValue());
    }
    @Test
    public void pushFront_pushToEmptyList_HeadAndTailIsCorrect() {
        DoubleLinkedList<Integer> List = new DoubleLinkedList<>();
        List.pushFront(100);
        Node<Integer> head = (Node<Integer>) List.getHead();
        Node<Integer> tail = (Node<Integer>) List.getTail();
        assertEquals(100, head.getData().intValue());
        assertEquals(100, tail.getData().intValue());
        assertEquals(head, tail);
    }

    @Test
    public void remove_removeNumbersFromList_CheckingNextAndPrev(){//47 48
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        Node<Integer> num2 = (Node<Integer>) list.pushBack(500);
        Node<Integer> prev = (Node<Integer>) list.insertBefore(num2, 400);
        Node<Integer> next = (Node<Integer>) list.insertAfter(num2, 600);
        list.remove(num2);
        Node<Integer> num3 = (Node<Integer>) next.getPrev();
        Node<Integer> num1 = (Node<Integer>) prev.getNext();
        assertEquals(600, num1.getData().intValue());
        assertEquals(400, num3.getData().intValue());
    }
    @Test
    public void remove_RemoveFirstNumber_SizeIsCorrect() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(100);
        list.pushFront(200);
        list.pushFront(300);
        list.remove(list.get(0));
        assertEquals(2, list.getSize());
    }
    @Test
    public void remove_removeNumberFromListWithOneElement_SizeEqualsZero() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        Node<Integer> num = (Node<Integer>) list.pushBack(10);
        list.remove(num);
        assertEquals(0, list.getSize());
    }
    @Test
    public void insertListAfter_insertListAfterFirstList_CheckingOrderOfNumbers(){//55 56 62

        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();

        list1.pushBack(10);
        list1.pushBack(20);
        list1.pushBack(30);
        list1.pushBack(40);

        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        list2.pushBack(50);
        list2.pushBack(60);
        list2.pushBack(70);

        list1.insertListAfter(list1.get(3), list2);

        Node<Integer> zero = (Node<Integer>) list1.get(0);
        Node<Integer> one = (Node<Integer>) list1.get(1);
        Node<Integer> two = (Node<Integer>) list1.get(2);
        Node<Integer> three = (Node<Integer>) list1.get(3);
        Node<Integer> four = (Node<Integer>) list1.get(4);
        Node<Integer> five = (Node<Integer>) list1.get(5);
        Node<Integer> six = (Node<Integer>) list1.get(6);

        assertEquals(10, zero.getData().intValue());
        assertEquals(20, one.getData().intValue());
        assertEquals(30, two.getData().intValue());
        assertEquals(40, three.getData().intValue());
        assertEquals(50, four.getData().intValue());
        assertEquals(60, five.getData().intValue());
        assertEquals(70, six.getData().intValue());
    }
    @Test
    public void insertListBefore_insertListBeforeFirstList_CheckingOrderOfNumbers(){//55 56 62

        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();

        list1.pushBack(40);
        list1.pushBack(50);
        list1.pushBack(60);
        list1.pushBack(70);

        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        list2.pushBack(10);
        list2.pushBack(20);
        list2.pushBack(30);

        list1.insertListBefore(list1.get(0), list2);

        Node<Integer> zero = (Node<Integer>) list1.get(0);
        Node<Integer> one = (Node<Integer>) list1.get(1);
        Node<Integer> two = (Node<Integer>) list1.get(2);
        Node<Integer> three = (Node<Integer>) list1.get(3);
        Node<Integer> four = (Node<Integer>) list1.get(4);
        Node<Integer> five = (Node<Integer>) list1.get(5);
        Node<Integer> six = (Node<Integer>) list1.get(6);

        assertEquals(10, zero.getData().intValue());
        assertEquals(20, one.getData().intValue());
        assertEquals(30, two.getData().intValue());
        assertEquals(40, three.getData().intValue());
        assertEquals(50, four.getData().intValue());
        assertEquals(60, five.getData().intValue());
        assertEquals(70, six.getData().intValue());
    }

}


