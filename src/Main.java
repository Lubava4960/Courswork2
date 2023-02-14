import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.sql.Date;
import java.util.Set;

public class Main {

    private static Type type;

    public static void main(String[] args) throws IncorrectArgumentException {



        Scanner sc = new Scanner(System.in);
        System.out.println(" Введите срочную задачу ");
        String OneTameTask = sc.nextLine();
        System.out.println("Задача сейчас: " + OneTameTask);
        System.out.println("ТИП Задачи - Личная или рабочая");
        String type = (sc.nextLine());
        System.out.println(" Тип задачи " + type);
        System.out.println(" Номер задачи " );
        int id = Integer.parseInt((sc.nextLine()));
        System.out.println(" Номер задачи "+id);
        System.out.println("Введите дату в формате дд.мм.гггг");
        String dateTime = sc.nextLine();
        System.out.println(" Дата "+ dateTime);
        System.out.println("Введите описание задачи");
        String description = sc.nextLine();
        System.out.println(" Описание задачи "+ description);

        Scanner scanner = new Scanner(System.in);

        System.out.println(" Введите  задачу на месяц");
        String MonthlyTask = sc.nextLine();
        System.out.println("Задача на месяц: " + MonthlyTask);
        System.out.println("ТИП Задачи - Личная или рабочая ");
        String type2 = (sc.nextLine());
        System.out.println(" Тип задачи " + type2);
        System.out.println( " Номер задачи ");
        int id2 = Integer.parseInt((sc.nextLine()));
        System.out.println(" Номер задачи "+id2);
        System.out.println("Введите дату в формате дд.мм.гггг");
        String dateTime2 = sc.nextLine();
        System.out.println(" Дата "+ dateTime);
        System.out.println("Введите описание задачи");
        String description2 = sc.nextLine();
        System.out.println(" Описание задачи "+ description);

        OneTameTask oneTameTask =new OneTameTask(" Покупка", Type.PERSONAL, 1, LocalDateTime.now(), " хлеб и колбаса");
        MonthlyTask monthlyTask= new MonthlyTask(" Покупка", Type.PERSONAL,2, LocalDateTime.now(), " Купить диван");
        DailyTask dailyTask=new DailyTask(" Отчёт",Type.WORK,3,LocalDateTime.now(), " О прибыли и убытках");
        WeeklyTask weeklyTask=new WeeklyTask(" Сдать балланс",Type.WORK,4,LocalDateTime.now()," Балланс за 2022год");
        YearlyTask yearlyTask = new YearlyTask(" Поменять профессию",Type.PERSONAL,5,LocalDateTime.now(), " Выучить язык Java");
        Set<Task> tasks = new HashSet<>();
        tasks.add(oneTameTask);
        tasks.add(monthlyTask);
        tasks.add(dailyTask);
        tasks.add(weeklyTask);
        tasks.add(yearlyTask);

        for (Task task : tasks) {
            System.out.println(task);

        }
      //  Iterator<Task> iterator = tasks.iterator();
     //  while (iterator.hasNext()) {
       //     System.out.println(iterator.next());
       // }


    }



}