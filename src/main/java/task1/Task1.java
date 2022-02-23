package task1;
import java.util.ArrayList;

public class Task1 {
    public static void main(String[] args) {
        // считываем аргументы с командной строки
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1])%n;

        // проверка корректности значений "n" и "m"
        if (m==n || n<2 || m<=1){
            System.out.println("error value of 'n' or 'm'");
            return;
        }

        //созадем массив из поледовательних чисел до 'n'
        int[] array1 = new int[n];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = i + 1;
        }


        // записываем путь начальных элементов из пройденных интервалов
        ArrayList<Integer> array3 = new ArrayList<>(); //
        for (int i = 0; true; i = i + m) {
            if (i < array1.length) {
                array3.add(array1[i]);
                i = i - 1;
            } else if (i > array1.length) {
                i = i - array1.length;
                array3.add(array1[i]);
                i = i - 1;
            } else if (i == array1.length) {
                break;
            }
        }

        // выводм пройденный путь в консоль
        String path = "";
        for (int i = 0; i < array3.size(); i++) {
            path += String.valueOf(array3.get(i));
        }
        System.out.println("Пройденный путь:" + path);
    }
}
