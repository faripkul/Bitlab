package bootcamp.spring.trello.Services;

import bootcamp.spring.trello.Classes.BitlabFolders;
import bootcamp.spring.trello.Classes.BitlabTasks;
import bootcamp.spring.trello.Classes.TaskStatus;
import bootcamp.spring.trello.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServices {
    @Autowired
    private TaskRepository taskRepository;

    public List<BitlabTasks> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<BitlabTasks> getTasks(BitlabFolders folders) {
        return taskRepository.findAllByFolderOrderByTitleAsc(folders);
    }

    public BitlabTasks addTask(BitlabTasks tasks){
        tasks.setStatus(TaskStatus.TODO);
        return taskRepository.save(tasks);
    }
}
