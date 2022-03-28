public class QuickSort<T> implements Sort<T> {
    MyComparator<T> comparator;
    @Override
    public void sort(T[] data, MyComparator<T> comparator) {
        this.comparator = comparator;
        qSortRec(data, 0, data.length - 1);
    }

    private void qSortRec(T[] data, int b, int e) {
        if(b >= e)
            return;
        int base = split(data,b,e);//m
        qSortRec(data, b, base - 1);//m
        qSortRec(data, base + 1, e);//m
    }

    private int split(T[] data, int b, int e) {
        int baseElem = b;
        int left = b;
        int right = e;
        while (left < right) {
            while (left <= right && comparator.compare(data[left], data[baseElem]) <= 0)
                left++;
            swap(data, left-1, baseElem);//m
            baseElem = left-1;//m
            while (right > left && comparator.compare(data[right], data[baseElem]) > 0)
                right--;
            if(left < right)
                swap(data, left , right);//m
        }
        return baseElem;
    }

    private void swap(T[] data, int i1, int i2) {
        T tmp = data[i1];
        data[i1] = data[i2];
        data[i2] = tmp;
    }
}