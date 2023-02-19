import TaskNotFoundExcepption.TaskNotFoundException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static java.nio.file.Files.readString;

public class Main {

    private static final TaskService TASK_SERVICE = new TaskService();
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("d.MM.yyyy");
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm");

    private static void printTaskForDate(Scanner scanner) {
    }

    public static void main(String[] args) throws IncorrectArgumentException, IOException {
        Scanner scanner = new Scanner(System.in);
        TASK_SERVICE.addTask(new OneTameTask("Одноразовая задача", Type.PERSONAL,
                LocalDateTime.now().plusHours(7), "Описание"));
        TASK_SERVICE.addTask(new DailyTask("Ежедневная задача", Type.PERSONAL,
                LocalDateTime.now().plusHours(3), "Описание"));
        TASK_SERVICE.addTask(new WeeklyTask("Еженедельная задача", Type.PERSONAL,
                LocalDateTime.now().plusHours(5), "Описание"));
        TASK_SERVICE.addTask(new MonthlyTask("Ежемесячная задача", Type.PERSONAL,
                LocalDateTime.now().plusHours(2), "Описание"));
        TASK_SERVICE.addTask(new YearlyTask("Ежегодная задача", Type.PERSONAL,
                LocalDateTime.now().plusHours(1), "Описание"));
        TASK_SERVICE.addTask(scanner);
        printTaskForDate(scanner);
    }
     TASK_SERVICE.addTask(Task task);
    private static void addTask (Scanner scanner){
        String title = ("Введите название задачи:", scanner scanner);
        String description = readString()("Введите описание задачи:", scanner);
        LocalDateTime taskDate = readDateTame(scanner);
        TaskType taskType = readType(scanner);
        Repeatability repeatability = readRepeatability(scanner);
        Task task;
        switch (repeatability) {
            case ONE_TIME:
                task = new OneTameTask(title, typeType, taskDate, description);
                break;
            case DAILY:
                task = new DailyTask(title, typeType, taskDate, description);
                break;
            case WEEKLY:
                task = new WeeklyTask(title, typeType, taskDate, description);
                break;
            case MONTHLY:
                task = new MonthlyTask(title, typeType,taskDate, description);
                break;
            case YEARLY:
                task = new YearlyTask(title, typeType,taskDate, description, );
                break;
            default:
                throw new IllegalArgumentException();
        }
        ;
        TASK_SERVICE.addTask(task);
    }


    private static Type readType (Scanner scanner {
        while (true) {
            try {
                System.out.println("Выберите тип задачи:");
                for (typeType:
                     readType()) {
                    System.out.printf("%s. %s%n", typeType.original(), localizeType(taskType));
                }
                System.out.println("Введите тип:");
                String ordinalLine = scanner.nextLine();
                int ordinal = Integer.parseInt(ordinalLine);
                return typeType.values[ordinal];
            } catch (NumberFormatException e) {
                System.out.println("введен неверный номер типа задачи");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Тип задачи не найден");
            }
        }
    }
    private static Repeatability readRepeatability (Scanner) {
        while (true) {
            try {
                System.out.println("Выберите тип повторяемости задачи:");
                for (Repeatability repeatability : Repeatability.values()) {
                    System.out.println(repeatability.ordinal() + ". " + localizeType(repeatability));
                }
                System.out.println("Введите тип:");
                String ordinalLine = sc.nextLine();
                int ordinal = Integer.parseInt(ordinalLine);
                return readRepeatability().values()[ordinal];
            } catch (NumberFormatException e) {
                System.out.println("введен неверный номер типа задачи");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Тип задачи не найден");
            }
        }

    }
        private static LocalTime addTask (Scanner scanner) throws IncorrectArgumentException {
            String title = readString("Введите название задачи:", scanner);
            Type typeType = readType(scanner);
            String description = readString("Введите описание задачи:", scanner);
            LocalDateTime taskDate = raedDate.scanner);

            Task task;
            switch (readRepeatability()) {
                case ONE_TIME:
                    task = new OneTameTask(title, typeType, taskDate, description, );
                    break;
                case Repeatability.DAILY:
                    task = new DailyTask(title, typeType, taskDate, description, );
                    break;
                case Repeatability.WEEKLY:
                    task = new WeeklyTask(title, typeType, taskDate, description, );
                    break;
                case Repeatability.MONTHLY:
                    task = new MonthlyTask(title, typeType, taskDate, description);
                    break;
                case Repeatability.YEARLY:
                    task = new YearlyTask(title, typeType, taskDate, description);
                    break;
                default:
                    throw new IllegalArgumentException();
            } ;



            private static LocalDateTime readDataTime (Scanner scanner){
            LocalDate localDate = readDateTame(scanner);
            LocalTime localTime = readTime(scanner);
            return localDate.atTime(localTime);
        }

            private static String readString(String message, Scanner scanner) {
                while (true) {
                    System.out.println(message);
                    String readString = scanner.nextLine();
                    if (readString == null || readString.isBlank()) {
                        System.out.println("Введено пустое значение");
                    } else {
                        return readString;
                    }
                }
            }

            public static void removeTasks (Scanner scanner){
            System.out.println("Все задачи:");
            for (Task task : TASK_SERVICE.getAllTasks()) {
                System.out.printf("%d. %s [%s](%s)%n",
                        task.getId(),
                        task.getTitle(),
                        localize LocalDateTime(task.getTitle()),
                        localize (task.getRepeatabilityType()));
            }
            while (true) {
                try {
                    System.out.println("Выберите задачу для удаления:");
                    String idLine = scanner.nextLine();
                    int id = Integer.parseInt(idLine);
                    TASK_SERVICE.removeTask(id);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Введен неверный id задачи");
                } catch (TaskNotFoundException e) {
                    System.out.println("Задача для удаления не найдена");
                }
            }
        }
            private static void printTaskForDate(Scanner scanner) {
            LocalDate localDate =LocalDate(scanner scanner);
            Collection<Task> tasksForDate = TASK_SERVICE.getTasksForDate(localDate);
            System.out.println("Задачи на " + localDate.format(DATE_FORMAT));
            for (Task task : tasksForDate) {
                System.out.printf("[%s]%s : %s (%s)%n",
                        localizeType(task.getTaskType()),
                        task.getTitle(),
                        task.getTaskDataTime().format(DATE_FORMAT),
                        task.getDescription());
            }
        }



            private static LocalDate readDate(Scanner scanner) {
            while (true) {
                try {
                    System.out.println("Введите дату задачи в формате d.MM.yyyy:");
                    String dateLine = scanner.nextLine();
                    return LocalDateTime.from(LocalTime.from(LocalDate.parse(dateLine, DATE_FORMAT)));
                } catch (DateTimeParseException e) {
                    System.out.println("Введена дата в неверном формате");
                }
            }
        }
            private static void printTaskForDate (Scanner scanner){
            LocalDate localDate = readDate(scanner);
            Collection<Task> tasksForDate = TASK_SERVICE.getTasksForDate(localDate);
            System.out.println("Задачи на " + localDate.format(DATE_FORMAT));
            for (Task task : tasksForDate) {
                System.out.printf("[%s]%s : %s (%s)%n",
                        localizeType(task.getTitle()),
                        task.getTitle(),
                        task.getTaskDateTime().getLong().format(DATE_FORMAT),
                        task.getDescription());
            }
        }

            private static LocalTime readTime(Scanner scanner) {
            while (true) {
                try {
                    System.out.println("Введите время задачи в формате hh:mm:");
                    String dateLine = scanner.nextLine();
                    return LocalTime.parse(dateLine,TIME_FORMAT);
                } catch (DateTimeParseException e) {
                    System.out.println("Введено время в неверном формате");
                }
            }
        }

            private static String localizeRepeatability(Repeatability) {
            String type = null;
            switch (Repeatability) {
                case ONE_TIME:
                    type = "Разовая";
                    break;
                case Repeatability.DAILY:
                    type = "Ежедневная";
                    break;
                case Repeatability.WEEKLY:
                    type = "Еженедельная";
                    break;
                case Repeatability.MONTHLY:
                    type = "Ежемесячная";
                    break;
                case Repeatability.YEARLY:
                    type = "Ежегодная";
                    break;
            }

            return Type;


        }



    

}

}
















