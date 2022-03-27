public class SelectionSort<T> implements Sort<T> {
    @Override
    public void sort(T[] data, MyComparator<T> comparator) {
        for(int sortedSize = 0; sortedSize < data.length - 1; ++sortedSize) {//m
            int maxInd = 0;//
            for(int i = 1; i < data.length - sortedSize; ++i) {
                if(comparator.compare(data[i], data[maxInd]) > 0)
                    maxInd = i;//m
            }
            T tmp = data[data.length - sortedSize-1];//m
            data[data.length- sortedSize-1] = data[maxInd];//m
            data[maxInd] = tmp;
        }
    }
}