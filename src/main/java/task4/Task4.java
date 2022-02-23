package task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Task4 {

    // медод ращета кол-тва шагов
    public static int check(float cast, ArrayList<Integer> nums) {
        int paths = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) < cast) {
                int dif1 = (int) cast - nums.get(i);
                paths = paths + dif1;
            } else if (nums.get(i) > cast) {
                int dif2 = nums.get(i) - (int) cast;
                paths = paths + dif2;
            }
        }
        return paths;
    }

    public static void main(String[] args) throws FileNotFoundException {
        // Считывем аргумент с командной строки и записываем элементы файла в массив
        String FilePath = args[0];
        ArrayList<Integer> nums = new ArrayList<>();
        File fl = new File(FilePath);
        Scanner sc = new Scanner(fl);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            nums.add(Integer.parseInt(String.valueOf(line)));
        }
        // Определяем сумму всех элементов массива
        int arrSum = 0;
        for (int arr : nums) {
            arrSum += arr;
        }
        // находим среднее арифметическое элементов массива
        float cast1 = (float) Math.ceil(((float) arrSum) / nums.size());
        float cast2 = (float) Math.floor(((float) arrSum) / nums.size());

        // Определяем в кукую сторону нужно округлить значение, к которому будем приводить элементы массива
        int v1 = check(cast1, nums);
        int v2 = check(cast2, nums);
        int cast = 0;
        if (v1 <= v2) {
            cast = (int) cast1;
        } else {
            cast = (int) cast2;
        }

        // Пошагово меняем элементы массива
        int counter = 0;
        for (int i = 0; i < nums.size(); ) {
            for (int s : nums) {
            }
            if (nums.get(i) < cast) {
                nums.set(i, (nums.get(i) + 1));
                counter++;
            } else if (nums.get(i) > cast) {
                nums.set(i, (nums.get(i) - 1));
                counter++;
            } else i++;
        }
        // Выводим ко-ство действий в консоль
        System.out.println("кол-ство действий = " + counter);
        sc.close();
    }
}
