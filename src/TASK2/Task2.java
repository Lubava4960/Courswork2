package TASK2;
//Напишите приложение, которое на вход через консоль, получит текст и выдаст статистику:

 //       1. Количество слов в тексте
 //       2. TOP10 самых часто упоминаемых слов, упорядоченных по количеству упоминаний в
  //      обратном порядке. В случае одинакового количества упоминаний слова должны быть отсортированы по алфавиту.
   //     yourapp the quick brown fox jumps over the lazy dog



import javax.naming.Name;
import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;
import java.util.Map.Entry;

public class Task2 {


    public static void main(String[] args) throws IOException {
        String words = "yourapp the quick brown fox jumps over the lazy dog";
         String[] wordsArray = words.split(" ");
         Map<String, Integer> frequency = new HashMap<>();
          for (String word : wordsArray) {
            if (frequency.containsKey(word)) {
               frequency.put(word, frequency.get(word) + 1);
           } else {
               frequency.put(word, 1);
          }
         }
          System.out.println("Top 10:");
          for (Entry<String, Integer> word : frequency.entrySet()) {
              System.out.println(word.getKey() + "-" + word.getValue());
           }

        // Напишите программу для проверки является ли число –числом Армстронга. Армстронг - это число,
        // в котором сумма кубов отдельных цифр числа равна самому числу.
        // 153= (1*1*1)+(5*5*5)+(3*3*3)
        // 370= (3*3*3)+(7*7*7)+(0*0*0)
        //  чтобы определить, является ли число числом Армстронга или нет.

          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //входящий поток с клавиатуры
         System.out.println("Введите число");
          int num = Integer.parseInt(br.readLine());//Число с клавиатуры выводится на консоли
          int number, digit, sum = 0;
         number =num;//в переменной хранится каждая цифра соответствующего числа
         while (number != 0) {
               digit = number % 10;
           sum= sum + digit * digit * digit;//Затем число возводится в куб,
           // чтобы найти куб соответствующей цифры, которая хранится в другой переменной итога
           number /= 10;//общее количество проверяется с соответствующим исходным номером.
        // Цифры получают одну за другой, получая число, деленное на 10 на каждом шаге,
        // а затем получая остаток от числа и затем кубируя число, чтобы получить куб
         }
            if (sum == num) {
               System.out.println( num+ " Является числом Armstrong ");
          } else {
               System.out.println( num+ " Не является числом Armstrong ");

          }
        //Дан List<String>names.
        //   Удалите первую букву из каждого
        //   имени и верните отсортированный список.

        List<String> names = new  ArrayList<>();
        String name = ("Maks");
        name= name.substring(1);
        String name2 =("Aleks");
        name2= name2.substring(1);
        names.add(name);
        names.add(name2);
        System.out.println(names);










    }

   }






