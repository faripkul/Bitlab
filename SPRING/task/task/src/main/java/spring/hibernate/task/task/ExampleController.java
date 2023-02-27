package spring.hibernate.task.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.ParseException;
import java.util.List;

@Controller
public class ExampleController {

    @Autowired
    private WorkTimeParserService workTimeParserService;



    @GetMapping(value = "/example")
    public String example(Model model) {

        List<Example> examples = workTimeParserService.prepareWorkTime();
        model.addAttribute("examplez", examples);
        return "/example";
    }
}
