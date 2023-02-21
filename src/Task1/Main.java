package Task1;

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


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TASK_SERVICE.addTask(new OneTimeTask("Одноразовая задача", "Описание",
                LocalDateTime.now().plusHours(7), TaskType.PERSONAL));
        TASK_SERVICE.addTask(new DailyTask("Ежедневная задача", "Описание",
                LocalDateTime.now().plusHours(3), TaskType.PERSONAL));
        TASK_SERVICE.addTask(new WeeklyTask("Еженедельная задача", "Описание",
                LocalDateTime.now().plusHours(5), TaskType.PERSONAL));
        TASK_SERVICE.addTask(new MonthlyTask("Ежемесячная задача", "Описание",
                LocalDateTime.now().plusHours(2), TaskType.PERSONAL));
        TASK_SERVICE.addTask(new YearlyTask("Ежегодная задача", "Описание",
                LocalDateTime.now().plusHours(1), TaskType.PERSONAL));
        addTask(scanner);
        printTaskForDate(scanner);
    }

    private static void addTask(Scanner scanner) {
        String title = readString("Введите название задачи:", scanner);
        String description = readString("Введите описание задачи:", scanner);
        LocalDateTime taskDate = readDataTime(scanner);
        TaskType taskType = readType(scanner);
        Repeatability repeatability = readRepeatability(scanner);
        Task task;
        switch (repeatability) {
            case ONE_TIME:
                task = new OneTimeTask(title, description, taskDate, taskType);
                break;
            case DAILY:
                task = new DailyTask(title, description, taskDate, taskType);
                break;
            case WEEKLY:
                task = new WeeklyTask(title, description, taskDate, taskType);
                break;
            case MONTHLY:
                task = new MonthlyTask(title, description, taskDate, taskType);
                break;
            case YEARLY:
                task = new YearlyTask(title, description, taskDate, taskType);
                break;
            default:
                throw new IllegalArgumentException();
        };
        TASK_SERVICE.addTask(task);
    }

    private static TaskType readType(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Выберите тип задачи:");
                for (TaskType taskType : TaskType.values()) {
                    System.out.println(taskType.ordinal() + ". " + localizeType(taskType));
                }
                System.out.println("Введите тип:");
                String ordinalLine = scanner.nextLine();
                int ordinal = Integer.parseInt(ordinalLine);
                return TaskType.values()[ordinal];
            } catch (NumberFormatException e) {
                System.out.println("введен неверный номер типа задачи");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Тип задачи не найден");
            }
        }
    }

    private static Repeatability readRepeatability(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Выберите тип повторяемости задачи:");
                for (Repeatability repeatability : Repeatability.values()) {
                    System.out.println(repeatability.ordinal() + ". " + localizeRepeatability(repeatability));
                }
                System.out.println("Введите тип:");
                String ordinalLine = scanner.nextLine();
                int ordinal = Integer.parseInt(ordinalLine);
                return Repeatability.values()[ordinal];
            } catch (NumberFormatException e) {
                System.out.println("введен неверный номер типа задачи");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Тип задачи не найден");
            }
        }
    }

    private static LocalDateTime readDataTime(Scanner scanner) {
        LocalDate localDate = readDate(scanner);
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

    public static void removeTasks(Scanner scanner) {
        System.out.println("Все задачи:");
        for (Task task : TASK_SERVICE.getAllTasks()) {
            System.out.printf("%d. %s [%s](%s)%n",
                    task.getId(),
                    task.getTitle(),
                    localizeType(task.getTaskType()),
                    localizeRepeatability(task.getRepeatabilityType()));
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
        LocalDate localDate = readDate(scanner);
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
                return LocalDate.parse(dateLine, DATE_FORMAT);
            } catch (DateTimeParseException e) {
                System.out.println("Введена дата в неверном формате");
            }
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
    private static String localizeType(TaskType taskType) {
        String type = null;
        switch (taskType) {
            case WORK:
                type = "Рабочая задача";
                break;
            case PERSONAL:
                type = "Персональная задача";
                break;
        };
        return type;
    }

    private static String localizeRepeatability(Repeatability repeatability) {
        String type = null;
        switch (repeatability) {
            case ONE_TIME:
                type = "Разовая";
                break;
            case DAILY:
                type = "Ежедневная";
                break;
            case WEEKLY:
                type = "Еженедельная";
                break;
            case MONTHLY:
                type = "Ежемесячная";
                break;
            case YEARLY:
                type = "Ежегодная";
                break;
        };
        return type;
    }
}












