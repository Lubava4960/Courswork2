import TaskNotFoundExcepption.TaskNotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class TaskService <T extends Task>{

    public Map<Integer, Task> tasks = new HashMap<>();
    private LocalDateTime LocalDate;


    public void addTask(Task task){

        this.tasks.put(task.getId(), task);

    }
    public Collection<Task>getAllTask(){
        return this.tasks.values();
    }
    public Collection<Task>getTasksForDate(LocalDate date){
        TreeSet<Task> tasksForDate = new ThreeSet();
        for(Task task:tasks.values()){
            if (task.appearsln(LocalDate)){
                tasksForDate.add(task);
            }
        }
        return tasksForDate;
    }
    public void removeTask(int id)throws TaskNotFoundException {
        if (this.tasks.containsKey(id)){
            this.tasks.remove(id);
        }else {
            throw new TaskNotFoundException();

        }


    }

    private class ThreeSet extends TreeSet<Task> {
    }


    //        - «Добавить задачу»,
    //        - «Получить задачи на день».
    //        - «Удалить задачу по id».
}
