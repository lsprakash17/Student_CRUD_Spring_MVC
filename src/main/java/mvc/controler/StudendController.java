package mvc.controler;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mvc.dto.Student;
import mvc.service.student_service;

@Controller
public class StudendController 
{
//@RequestMapping(name="insert",method = RequestMethod.POST)
//@RequestMapping("insert") -->used in generic which accept both get post
//	private ModelAndView Save(@RequestParam String name,@RequestParam String Mobile) -->previous we ar eusing its lengthy
//@ResponseBody req.getwriter()
	
@Autowired
student_service service;
	
@PostMapping("insert")
private ModelAndView Save(@ModelAttribute Student s,@RequestParam String date) 
{
	return service.save(s, date);
}
@GetMapping("fetchall")
private String Fectchall(Model model)
{
	List<Student> l=service.Fetchall();
	model.addAttribute("details", l);
	return "fetchall.jsp";
}
}
