import java.sql.Time;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.sql.Date;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IncorrectArgumentException {



        Scanner sc = new Scanner(System.in);
        System.out.println(" Введите задачу на день");
        String OneTameTask = sc.nextLine();
        System.out.println("Задача на сегодня: " + OneTameTask);
        System.out.println("ТИП Задачи - Личная или рабочая");
        String Type = sc.nextLine();
        System.out.println(" Тип задачи " + Type);
        System.out.println(" Номер задачи " );
        Integer id = Integer.valueOf(sc.nextLine());
        System.out.println(" Номер задачи "+id);
        System.out.println("Введите дату в формате дд.мм.гггг");
        String dateTime = sc.nextLine();
        System.out.println(" Дата "+ dateTime);
        System.out.println("Введите описание задачи");
        String description = sc.nextLine();
        System.out.println(" Описание задачи "+ description);

        OneTameTask oneTameTask = new OneTameTask(" Покупка",null,  LocalDateTime.now(), "хлеб и колбаса");
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Введите задачу на месяц");
        String MonthlyTask = sc.nextLine();
        System.out.println("Задача на месяц: " + MonthlyTask);
        System.out.println("ТИП Задачи - Личная или рабочая ");
        String type  = sc.nextLine();
        System.out.println(" Тип задачи " + Type);
        System.out.println( " Номер задачи ");
        Integer id2 = Integer.valueOf(sc.nextLine());
        System.out.println(" Номер задачи "+id2);
        System.out.println("Введите дату в формате дд.мм.гггг");
        String dateTime2 = sc.nextLine();
        System.out.println(" Дата "+ dateTime);
        System.out.println("Введите описание задачи");
        String description2 = sc.nextLine();
        System.out.println(" Описание задачи "+ description);

        MonthlyTask monthlyTask = new MonthlyTask(" Покупка", null, 2, LocalDateTime.now(), " Купить диван");
        Set<Task> tasks = new HashSet<>();
        tasks.add(oneTameTask);
        tasks.add(monthlyTask);
        for (Task task : tasks) {
            System.out.println(task);
        }
       // Iterator<Task> iterator = tasks.iterator();
      //  while (iterator.hasNext()) {
       //     System.out.println(iterator.next());
       // }


    }



}