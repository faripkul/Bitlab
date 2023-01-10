package com.example.demo.controller.task1;


import com.example.demo.beans.Somebean;
import com.example.demo.controller.task2.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeContoller {

    @Autowired
    private Somebean somebean;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private SubjectRepository subjectRepository;

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
        List<BitlabItems> items = itemRepository.findAll();
       // List<BitlabItems> items = itemRepository.findAllByPriceGreaterThanEqual(111);
//        List<BitlabItems> items = itemRepository.getBestPrice(120, 1000);
        model.addAttribute("itemz", items);
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
        itemRepository.save(item);
        return "redirect:/itemss";

    }

    @GetMapping(value = "/detailss")
    public String Details(Model model,
                          @RequestParam(name = "id") Long id) {
   BitlabItems item = itemRepository.findById(id).orElse(null);
//    BitlabItems item = itemRepository.findByIdAndAndPriceBetween(id, 1, 10000);
    model.addAttribute("itemz", item);

    List<BitlabFaculty> faculties = facultyRepository.findAll();
    model.addAttribute("facultiz", faculties);

    List<BitlabSubject> subjects = subjectRepository.findAll();
    subjects.removeAll(item.getSubjects());
    model.addAttribute("sujectz", subjects);

    return "/task1/details";

    }

    @GetMapping(value = "/addItem")
    public String addItem(Model model){
        List<BitlabFaculty>faculties = facultyRepository.findAll();
        model.addAttribute("facultiz", faculties);
        return "task1/addItem";
}


    @PostMapping(value = "/saveItem")
    public String saveItem(BitlabItems item){
     itemRepository.save(item);
     return "redirect:/itemss";
    }

    @PostMapping(value = "/deleteItem")
    public String deleteItem(@RequestParam(name = "id") Long id){
        itemRepository.deleteById(id);
        return "redirect:/itemss";
    }

    @PostMapping(value = "/assign-subject")
    public String assignStudent(@RequestParam(name="item_id")Long itemId,
                                @RequestParam(name="subject_id")Long subjectId) {

        BitlabItems item = itemRepository.findById(itemId).orElseThrow();
        BitlabSubject subject = subjectRepository.findById(subjectId).orElseThrow();


        List<BitlabSubject>subjects=item.getSubjects();
        if(subjects==null){
            subjects=new ArrayList<>();
        }
        subjects.add(subject);
        itemRepository.save(item);

        return "redirect:/detailss?id="+itemId;
    }

    @PostMapping(value = "/unassign-subject")
    public String unassignStudent(@RequestParam(name="item_id")Long itemId,
                                @RequestParam(name="subject_id")Long subjectId) {

        BitlabItems item = itemRepository.findById(itemId).orElseThrow();
        BitlabSubject subject = subjectRepository.findById(subjectId).orElseThrow();


        List<BitlabSubject>subjects=item.getSubjects();
        if(subjects==null){
            subjects=new ArrayList<>();
        }
        subjects.remove(subject);
        itemRepository.save(item);

        return "redirect:/detailss?id="+itemId;
    }

    @GetMapping(value = "/search")
    public String search(@RequestParam(name = "key", required = false, defaultValue = "")String key,
                         @RequestParam(name = "order", required = false, defaultValue = "ask")String order,
                         Model model){
       List<BitlabItems> items = null;
        if(order!=null){
            if(order.equals("desk")){
                items = itemRepository.searchItemsDesk("%"+key.toLowerCase()+"%");
            }
        }
          if(items==null){
              items = itemRepository.searchItemsAsc("%"+key.toLowerCase()+"%");
          }
          model.addAttribute("itemz", items);
           return "task1/search";
    }

}


