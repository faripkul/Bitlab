package kz.bitlab.servlets.task3;

import java.util.ArrayList;
import java.util.Iterator;

public class DBManager {

    private static ArrayList<Tasks>tasks=new ArrayList<>();
    private static Long id=4L;

    static {
        tasks.add(new Tasks(1L, ";lksdfjg","fl;kg","dflkgj"));
        tasks.add(new Tasks(2L, ";lksdfjg","fl;kg","dflkgj"));
        tasks.add(new Tasks(3L, ";lksdfjg","fl;kg","dflkgj"));

    }
    public static Tasks getTask(Long id) {
        for (Tasks tas: tasks) {
            if(tas.getId()==id) {
                return tas;
            }
        }
        return null;
    }

   public static void addTask(Tasks task){
        task.setId(id);
        tasks.add(task);
        id++;

   }

    public static ArrayList<Tasks> getAllTasks(){
        return tasks;

    }
    public static void DeleteTask(Long id) {
        Iterator<Tasks> tasksIterator= tasks.iterator();
        while (tasksIterator.hasNext()){
            Tasks nextTasks=tasksIterator.next();
            if(nextTasks.getId()==id){
                tasksIterator.remove();
            }
        }

    }
    public static void SaveTask(Tasks task){
        for (Tasks tas: tasks){
            if(task.getId()==tas.getId()){
                tas.setName(tas.getName());
                tas.setDescription(tas.getDescription());
                tas.setDeadlineDate(tas.getDeadlineDate());
            }
        }
    }
}
