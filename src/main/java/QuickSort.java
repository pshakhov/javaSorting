import java.util.Random;

public class QuickSort {

    public static int array_length = 10; // задаем длину массива в 10 элементов
    private static int[] array = new int[array_length]; // создаем новый массив с заданной длинной
    private static Random generator = new Random(); // создаем генератор случайных чисел

    public static void initArray() { // инициализируем массив
        for (int i=0; i<array_length; i++) {
            array[i] = generator.nextInt(10); // наполняем его случайными числами от 0 до 10
        }
    }

    public static void printArray() { // метод вывода массива
        for (int i=0; i<array_length-1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array_length-1]);
    }

    public static void quickSort() { // метод быстрой сортировки
        int firstIndex = 0; // задаем начальный индекс
        int lastIndex = array_length - 1; // задаем конечный индекс
        doSort(firstIndex, lastIndex); // выполняем сортировку массива от начального до конечного индекса
    }

    private static void doSort(int low, int high) { // метод сортировки массива с входными параметрами
        if (low >= high)
            return;
        int i = low, j = high;
        int current = i - (i - j) / 2; // выбор опорного элемента - средний "индекс"

        // разбиваем на 2 массива
        while (i < j) {
            while (i < current && (array[i] <= array[current])) { // в каждой итерации определяем число "слева" от медианы, которого большее нее
                i++;
            }
            while (j > current && (array[current] <= array[j])) { // в каждой итерации определяем число "справа" от медианы, которое меньше нее
                j--;
            }

            // по завершении поиска меняем эти числа местами
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i == current)
                    current = j;
                else if (j == current)
                    current = i;
            }
        }
        doSort(low, current); // рекурсивно вызываем метод сортировки для "левой" половины массива
        doSort(current+1, high); // а здесь - для "правой"
    }

    public static void main(String[] args) {
        initArray(); // инициализируем исходный массив
        printArray(); // выводим его
        quickSort(); // вызываем метод быстрой сортировки
        printArray(); // выводим результат
    }
}
