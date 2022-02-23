package task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task2 {

    public static void main(String args[]) throws FileNotFoundException {
        // считываем аргументы с командной строки
        String circle = args[0];
        String points = args[1];

        // Считываем из файла  координаты и радиус окружности
        File fl1 = new File(circle);
        Scanner sc1 = new Scanner(fl1);
        float rx = Float.parseFloat(sc1.next());
        float ry = Float.parseFloat(sc1.next());
        float crd = Float.parseFloat(sc1.next());

        // Считываем из файла  координаты точек
        File fl2 = new File(points);
        Scanner sc2 = new Scanner(fl2);
        while (sc2.hasNextLine()) {
            while (sc2.hasNextFloat()) {
                float cr1 = sc2.nextFloat();
                float cr2 = sc2.nextFloat();
                float DistanceToCenter = (float) Math.sqrt(Math.pow(cr1 - rx, 2) + Math.pow(cr2 - ry, 2));
                int result=0;
                if (DistanceToCenter == crd) {
                    result=0;
                }
                if (DistanceToCenter < crd) {
                    result=1;
                }
                if (DistanceToCenter > crd) {
                    result=2;
                }
                System.out.print("result = " + result + '\n');
            }
        }
        sc1.close();
        sc2.close();
    }
}