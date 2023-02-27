package restApi.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import restApi.practice.service.WorkTimeParserService;

import java.text.ParseException;

@Controller
public class WorkTimeParserController {
    private static final String[][] arr = {
            {"Fari", "10:00-12:00", "11:00-14:00", "10:00-11:00", "10:00-14:00", "", "", ""},
            {"Fari", "12:00-18:00", "12:00-18:00", "12:00-18:00", "", "", "", ""},
    };

    @Autowired
    WorkTimeParserService workTimeParserService;

    @GetMapping(value = "/home")
    public String getSchedule(Model model) throws ParseException {
        String[][] result = workTimeParserService.handle(arr);
        model.addAttribute("results", result);

        return "/WorkTimeParser";
    }
}
