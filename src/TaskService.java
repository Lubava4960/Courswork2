import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class TaskService <T extends Task>{

    public Collection<Task> getRemovedTasks() {
        return null;
    }

    public Map<Integer, Set<Task>> getTaskMap() {

        return taskMap;
    }

    public void setTaskMap(Map<Integer, Set<Task>> taskMap) {

        this.taskMap = taskMap;
    }

    public TaskService() {

        this.taskMap = null;
    }

    private Map<Integer, Set<Task>>taskMap;
    Collection<Task>removedTasks;

    @Override
    public String toString() {
        return "TaskService{" +
                "taskMap=" + taskMap +
                ", removedTasks=" + removedTasks +
                '}';
    }



    // В сервисе добавлены методы:
    public void addTask() {

        System.out.println("");
    }

    public void getTaskOneDay() {

        System.out.println("");
    }
    public Task removeId (int id) {
        return null;
    }


    //        - «Добавить задачу»,
    //        - «Получить задачи на день».
    //        - «Удалить задачу по id».
}
