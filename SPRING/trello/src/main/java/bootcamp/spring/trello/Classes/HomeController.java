package bootcamp.spring.trello.Classes;

import bootcamp.spring.trello.Services.FolderServices;
import bootcamp.spring.trello.Services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    FolderServices folderServices;

    @Autowired
    TaskServices taskServices;

    @GetMapping(value = "/home")
    public String home(Model model){
        model.addAttribute("folderz", folderServices.getAllFolders());
        return "/trello/firstStr";
    }

    @PostMapping(value = "/add-folder")
    public String addFolder(BitlabFolders folders){
      folderServices.addFolders(folders);
      return "redirect:/home";
    }
    @GetMapping(value = "/folder-detail/{id}")
    public String folderDetail(@PathVariable("id")Long id, Model model){
        BitlabFolders folders = folderServices.getFolder(id);
        if(folders!=null) {
            List<BitlabTaskCategories> categories=folderServices.getCategories();  //это пока что не надо
            categories.removeAll(folders.getCategories());   //это пока что не надо
            model.addAttribute("categoriez", categories);  //это пока что не надо
            model.addAttribute("folder", folders);
            model.addAttribute("taskz", taskServices.getTasks(folders));
        }
      return "trello/folder-detail";
    }
    @PostMapping(value = "/add-task")
    public String addTask(BitlabTasks tasks){
        taskServices.addTask(tasks);
        return "redirect:/folder-detail/"+tasks.getFolder().getId();
    }
    @PostMapping(value = "/add-category")
    public String assignCategory(@RequestParam(name = "category_id")Long categoryId,
                              @RequestParam(name = "folder_id")Long folderId){
        folderServices.assignCategory(folderId,categoryId);
        return "redirect:/folder-detail/"+folderId;
    }
    @PostMapping(value = "/deleteCategory")
    public String unAssignCategory(@RequestParam(name = "category_id")Long categoryId,
                                 @RequestParam(name = "folder_id")Long folderId){
        folderServices.unAssignCategory(folderId, categoryId);
        return "redirect:/folder-detail/"+folderId;
    }
}
