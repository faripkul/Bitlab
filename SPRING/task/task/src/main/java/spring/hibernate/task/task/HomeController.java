package spring.hibernate.task.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private OperatorRepository operatorRepository;

    @GetMapping(value = "/homeApplic")
    public String home(Model model) {
        List<BitlabApplications> applications = applicationRepository.findAll();
        model.addAttribute("applicationz", applications);
        return "/firstpage";
    }

    @GetMapping(value = "/operators")
    public String operator(Model model) {
        return "/operatory";
    }

    @GetMapping(value = "/addAplic")
    public String addAplicat(Model model) {
        List<BitlabCourses> courses=courseRepository.findAll();
        model.addAttribute("coursez", courses);
        return "/addAplic";
    }

    @PostMapping(value = "/addAplication")
    public String addAplica(BitlabApplications aplic) {
        applicationRepository.save(aplic);
        return "redirect:/homeApplic";
    }

    @GetMapping(value = "/detailsStr")
    public String Details(Model model, @RequestParam(name = "id") Long id) {
        BitlabApplications application = applicationRepository.findById(id).orElse(null);
        model.addAttribute("applicationz", application);

        List<BitlabCourses> courses = courseRepository.findAll();
        model.addAttribute("coursez", courses);

        List<BitlabOperators> operators = operatorRepository.findAll();
        operators.removeAll(application.getOperators());
        model.addAttribute("operatorz", operators);

        return "/details";
    }

    @PostMapping(value = "/saveApplic")
    public String saveApplicc(BitlabApplications application) {
        applicationRepository.save(application);
        return "redirect:/homeApplic";
    }

    @PostMapping(value = "/deleteApplic")
    public String deleteApplic(BitlabApplications application) {
        applicationRepository.delete(application);
        return "redirect:/homeApplic";
    }


    @PostMapping(value = "/handled")
    public String handled(@RequestParam(name = "id") Long id) {
        BitlabApplications application = applicationRepository.findById(id).orElse(null);
        application.setHandled(true);
        applicationRepository.save(application);
        return "redirect:/homeApplic";
    }

    @GetMapping(value = "/homeApplic1")
    public String fff(Model model) {
        List<BitlabApplications> applications = applicationRepository.findAllByHandledIsFalse();
        model.addAttribute("applicationz", applications);
        return "/firstpage";
    }

    @GetMapping(value = "/homeApplic2")
    public String ttt(Model model) {
        List<BitlabApplications> applications = applicationRepository.findAllByHandledIsTrue();
        model.addAttribute("applicationz", applications);
        return "/firstpage";
    }


    @PostMapping(value = "/unassign-operator")
    public String unassignOper(@RequestParam(name="application_id")Long applicId,
                           @RequestParam(name = "operator_id")Long opratorId){
        
    BitlabApplications application = applicationRepository.findById(applicId).orElseThrow();
    BitlabOperators operator = operatorRepository.findById(opratorId).orElseThrow();

    List<BitlabOperators>operators=application.getOperators();
    if(operators==null){
        operators=new ArrayList<>();
    }
    operators.remove(operator);
    applicationRepository.save(application);

    return "redirect:/detailsStr?id="+applicId;
 }

   @PostMapping(value = "/assign-operator")
    public String assignOper(@RequestParam(name="application_id")Long applicId,
                               @RequestParam(name = "operator_id")Long opratorId){

        BitlabApplications application = applicationRepository.findById(applicId).orElseThrow();
        BitlabOperators operator = operatorRepository.findById(opratorId).orElseThrow();

        List<BitlabOperators>operators=application.getOperators();
        if(operators==null){
            operators=new ArrayList<>();
        }
        operators.add(operator);
        applicationRepository.save(application);

        return "redirect:/detailsStr?id="+applicId;
    }
}
