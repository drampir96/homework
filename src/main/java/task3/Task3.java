package task3;

import java.io.FileNotFoundException;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.*;
import java.util.Scanner;

public class Task3 {

    // метод для считывания gson файлов в массив строк
    public static ArrayList<String> readJSON(String path) throws FileNotFoundException {
        File fl = new File(path);
        Scanner sc = new Scanner(fl);
        ArrayList<String> arrList = new ArrayList<>();
        while (sc.hasNext()) {
            arrList.add(sc.nextLine().trim());
        }
        for (String a : arrList) {
            System.out.println(a);
        }
        sc.close();
        return arrList;
    }

    public static void main(String[] args) throws FileNotFoundException {
        // cxbnsdftv fhuevtyns rjvfylyjq cnhjrb
        String testsPath = args[0];
        String valuesPath = args[1];

        // исползуем метод readJSON
        ArrayList<String> tests = readJSON(testsPath);
        ArrayList<String> values = readJSON(valuesPath);

        // находим в tests id и value
        for (int i=0; i<tests.size(); i++){
            String s1 = tests.get(i);
            Pattern patid = Pattern.compile(".*\\b" + "id" + "\\b.*");
            Matcher matcher = patid.matcher(s1);
            while(matcher.find()){
                String result = new String(s1.substring(matcher.start(), matcher.end()));
                System.out.println(result + " | " + " | " + tests.get(i+2));
            }
        }

        // находим в tests id и value
        for (int i=0; i<values.size(); i++){
            String s2 = values.get(i);
            Pattern patid = Pattern.compile(".*\\b" + "id" + "\\b.*");
            Matcher matcher = patid.matcher(s2);
            while(matcher.find()){
                String result = new String(s2.substring(matcher.start(), matcher.end()));
                System.out.println(result + " | " + values.get(i+1));
            }
        }

        // P.S. простите что не доделано((

        /*
        Зная номера строк мы уже можем дозаписать значения values
        в Arraylist "tests", а дальге все записать в выходной файл.

        пытался все реализовать через сторонние библиотеки для работы с json файлами,
        но разобраться за выделенные сроки не смог.

        способ у меня хоть и костыльный, но он в доделанном виде будет выполнять поставленную задачу

         */

    }
}


