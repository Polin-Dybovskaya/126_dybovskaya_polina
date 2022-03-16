import java.util.Arrays;

public class Task_4 implements Task_4_base {
    @Override
    public int[] subtask_1_arrays(int size, int a0, int d) {
        // сгенерировать и вернуть массив размера size, содержащий элементы
        // арифметической прогрессии с первым членом a0 и разностью d
        int [] array = new int[size];
        array[0]=a0;
        for (int i =1; i<size; i++){
            array[i]=array[0]+d*i;
        }
        return array;
    }

    @Override
    public int[] subtask_2_arrays(int size) {
        // сгенерировать и вернуть массив размера size, первые два элемента
        // которого равны единице, а каждый следующий - сумме всех предыдущих
        int [] Arr1 = new int[size];
        Arr1[0]=1;
        if (size>1){
            Arr1[1]=1;
            for (int i=2;i<size;i++){
                Arr1[1]=1;
                Arr1[i]=Arr1[i-1]*2;
            }
        }
        return Arr1;
    }

    @Override
    public int[] subtask_3_arrays(int size) {
        // сгенерировать и вернуть массив размера size, содержащий первые
        // size чисел последовательности фибоначчи.
        // https://ru.wikipedia.org/wiki/Числа_Фибоначчи
        int  [] Fibonachi = new int [size];
        Fibonachi [0]=0;
        if (size>1) {
            Fibonachi[1] = 1;
            for (int i = 2; i < size; i++) {
                Fibonachi[i] = Fibonachi[i - 1] + Fibonachi[i - 2];
            }
        }

        return Fibonachi;

    }

    @Override
    public int subtask_4_arrays(int[] data) {
        // Для данного массива вычислить максимальный элемент
        int max= data[0];
        for (int i=1; i< data.length;i++){
            if (data[i]> max)
                max = data[i];
        }
        return max;
    }

    @Override
    public int subtask_5_arrays(int[] data, int k) {
        // Для данного массива вычислить максимальный элемент
        // кратный k. Гарантируется, что как минумум один такой элемент
        // в массиве есть
        int max=-222222222;
        for (int i=1; i< data.length;i++) {
            if ((data[i] > max) && (data[i] % k == 0))
                max = data[i];
        }
        return max;
    }

    @Override
    public int[] subtask_6_arrays(int[] arr1, int[] arr2) {
        // Даны два массива arr1, arr2.
        // Произвести слияние данных массивов в один отсортированный
        // по возрастанию массив.
        int [] array= new int[arr1.length+ arr2.length];
        for (int i=0;i< arr1.length;i++){
            array[i]=arr1[i];
        }
        for (int i=0;i< arr2.length;i++) {
            array[i+ arr1.length] = arr2[i];
        }
        Arrays.sort(array);
        return array;
    }

    @Override
    public int[] subtask_7_arrays(int[] arr1, int[] arr2) {
        // Даны два отсортированных по возрастанию массива arr1, arr2.
        // Произвести слияние данных массивов в один также отсортированный
        // по возрастанию массив.
        // Используйте алгоритм, время работы которого будет пропорционально сумме
        // размеров arr1 и arr2, а не их произведению
        int [] array = new int[arr1.length+ arr2.length];
        int n1=0;
        int n2=0;
        int i=0;
        while (i < (arr1.length + arr2.length)) {
            if (((n2 >= arr2.length) || ((n1 < arr1.length)) && arr1[n1] < arr2[n2])) {
                array[i] = arr1[n1];
                n1++;
            } else {
                array[i] = arr2[n2];
                n2++;
            }
            i++;
        }
        return array;
    }
}

