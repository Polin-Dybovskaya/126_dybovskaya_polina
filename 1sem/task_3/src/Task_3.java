public class Task_3 implements Task_3_base {
    @Override
    public int subtask_1_for(int n1, int n2, int a, int b) {
        // подсчитать, сколько чисел, кратных a, но не кратных b,
        // находится между числами n1 и n2 включительно
        int count =0;
        if (n1<n2) {
            for (int chislo = n1; chislo <= n2; chislo++)
                if ((chislo % a == 0) && (chislo % b != 0))
                    count++;
        }
        if (n1>n2) {
            for (int chislo = n2; chislo <= n1; chislo++)
                if ((chislo % a == 0) && (chislo % b != 0))
                    count++;
        }
        return count;
    }

    @Override
    public int subtask_2_for(int num) {
        // Последовательность чисел строится следующим образом:
        // сначала идет одна единица,
        // потом две двойки,
        // потом три тройки,
        // ...
        // потом n раз число n
        // ...
        // Найти, какое число будет находиться в этой последовательности
        // на позиции num
        int r=1;
        if (num ==1)
            return 1;
        for (int i=2; i<=num; i++){
            for (int j =1; j<=i; j++){
                r++;
                if (r==num)
                    return i;
            }
        }
        return num;
    }

    @Override
    public int subtask_3_for(int num, int d, int cnt) {
        // Дана последовательность
        // a(0) = num
        // a(n) = a(n - 1) * d + 1
        // Найти сумму первых cnt элементов последовательности
        int summa=0;
        int n=num;
        for (int i=1;i<=cnt;i++){
            summa=summa+n;
            n=n*d+1;
        }
        return summa;
    }

    @Override
    public int subtask_4_for(int n) {
        // Вычислить сумму
        // S(n) = 1 + 1 * 2 + 1 * 2 * 3 + ... + n!
        // для заданного n
        // (n! - это n-факториал. Кто не знает - гуглите)
        if (n==1)
            return 1;
        int summa=0;
        int k=1;
        for (int chislo=1;chislo<=n;chislo++){
            k=1;
            for (int ch2=1;ch2<=chislo;ch2++)
                k=k*ch2;
                summa+=k;
        }
        return summa;
    }
}
