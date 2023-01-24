package bootcamp.spring.trello.Services;

import bootcamp.spring.trello.Classes.BitlabFolders;
import bootcamp.spring.trello.Classes.BitlabTaskCategories;
import bootcamp.spring.trello.Repository.FoldersRepository;
import bootcamp.spring.trello.Repository.TaskCategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FolderServices {
    @Autowired
    private FoldersRepository foldersRepository;

    @Autowired
    private TaskCategoriesRepository taskCategoriesRepository;

    public List<BitlabFolders> getAllFolders(){

        return foldersRepository.findAll();
    }

    public BitlabFolders addFolders(BitlabFolders folders){

        return foldersRepository.save(folders);
    }

    public BitlabFolders getFolder(Long id){
        return foldersRepository.findById(id).orElseThrow();
    }

    public List<BitlabTaskCategories>getCategories(){
        return taskCategoriesRepository.findAll();
    }

    public void assignCategory(Long folderId,Long categoryId){
        BitlabFolders folders = getFolder(folderId);
        if(folders!=null){
            BitlabTaskCategories categories = taskCategoriesRepository.findById(categoryId).orElseThrow();
            if(categories!=null){
                List<BitlabTaskCategories>taskCategories=folders.getCategories();
                if(taskCategories==null){
                    taskCategories=new ArrayList<>();
                }
                taskCategories.add(categories);
                folders.setCategories(taskCategories);
                foldersRepository.save(folders);
            }
        }
    }
    public void unAssignCategory(Long folderId, Long categoryId){
        BitlabFolders folders = getFolder(folderId);
        if(folders!=null){
            BitlabTaskCategories categories = taskCategoriesRepository.findById(categoryId).orElseThrow();
            if(categories!=null){
                List<BitlabTaskCategories>taskCategories=folders.getCategories();
//                if(taskCategories==null){
//                    taskCategories=new ArrayList<>();
//                }
                taskCategories.remove(categories);
                folders.setCategories(taskCategories);
                foldersRepository.save(folders);
            }
        }
    }
}
