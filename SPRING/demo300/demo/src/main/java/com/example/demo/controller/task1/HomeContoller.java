package com.example.demo.controller.task1;


import com.example.demo.beans.Somebean;
import com.example.demo.controller.task2.*;
import com.example.demo.service.FacultyService;
import com.example.demo.service.ItemService;
import com.example.demo.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class HomeContoller {

    @Autowired
    private Somebean somebean;

    @Autowired
    private ItemService itemService;

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private SubjectService subjectService;

    @GetMapping(value = "/test-bean")
    public String testBean(Model model){

        Somebean somebean = new Somebean();
        somebean.setName("Iliyas");
        somebean.setAmount(10);
        model.addAttribute("result", somebean.getData());

        return "testZad/test";
    }

    @GetMapping(value = "/set-bean")
    public String setBean(){
        somebean.setName("Serik");
        somebean.setAmount(99);
        return "redirect:/test-bean";

    }

    @GetMapping(value = "/itemss")
    public String home(Model model) {
       // List<BitlabItems> items = itemRepository.findAllByPriceGreaterThanEqual(111);
//        List<BitlabItems> items = itemRepository.getBestPrice(120, 1000);
        model.addAttribute("itemz", itemService.getAllItems());
        return "/task1/items";
    }

    @PostMapping(value = "/addItem")
    public String addItem(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "price") Double price) {
        Items it = new Items();
        it.setName(name);
        it.setDescription(description);
        it.setPrice(price);
        DBManager.addItems(it);

        return "redirect:/itemss";
    }

    @PostMapping(value = "/addItem-v2")
    public String addItem(BitlabItems item) {
        item = itemService.addItem(item);
        return "redirect:/itemss";

    }

    @GetMapping(value = "/detailss")
    public String Details(Model model,
                          @RequestParam(name = "id") Long id) {
   BitlabItems item = itemService.getItems(id);
//    BitlabItems item = itemRepository.findByIdAndAndPriceBetween(id, 1, 10000);
    model.addAttribute("itemz", item);

    List<BitlabFaculty> faculties = facultyService.getFaculties();
    model.addAttribute("facultiz", faculties);

    List<BitlabSubject> subjects = subjectService.getSubjects();
    subjects.removeAll(item.getSubjects());
    model.addAttribute("sujectz", subjects);

    return "/task1/details";

    }

    @GetMapping(value = "/addItem")
    public String addItem(Model model){
//        List<BitlabFaculty>faculties = facultyRepository.findAll();
        model.addAttribute("facultiz", facultyService.getFaculties());
        return "task1/addItem";
}


    @PostMapping(value = "/saveItem")
    public String saveItem(BitlabItems item){
     item = itemService.saveItem(item);
     return "redirect:/itemss";
    }

    @PostMapping(value = "/deleteItem")
    public String deleteItem(BitlabItems item){
     itemService.deleteItem(item);
        return "redirect:/itemss";
    }

    @PostMapping(value = "/assign-subject")
    public String assignStudent(@RequestParam(name="item_id")Long itemId,
                                @RequestParam(name="subject_id")Long subjectId) {
      BitlabItems item = itemService.assignSubject(itemId,subjectId);
      return "redirect:/detailss?id="+itemId;
    }

    @PostMapping(value = "/unassign-subject")
    public String unassignStudent(@RequestParam(name="item_id")Long itemId,
                                @RequestParam(name="subject_id")Long subjectId) {
        BitlabItems item = itemService.unAssignSubject(itemId,subjectId);
        return "redirect:/detailss?id="+itemId;
    }

    @GetMapping(value = "/search")
    public String search(@RequestParam(name = "key", required = false, defaultValue = "")String key,
                         @RequestParam(name = "order", required = false, defaultValue = "ask")String order,
                         Model model){
        model.addAttribute("itemz", itemService.search(key, order));
        return "task1/search";
    }
}


