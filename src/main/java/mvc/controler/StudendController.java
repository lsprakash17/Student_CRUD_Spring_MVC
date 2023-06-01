package mvc.controler;

import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mvc.dto.Student;

@Controller
public class StudendController 
{
//@RequestMapping(name="insert",method = RequestMethod.POST)
//@RequestMapping("insert") -->used in generic which accept both get post
//	private ModelAndView Save(@RequestParam String name,@RequestParam String Mobile) -->previous we ar eusing its lengthy
@PostMapping("insert")
@ResponseBody
private String Save(@ModelAttribute Student s,@RequestParam String date) 
{
s.setDob(Date.valueOf(date));
return s.toString();
}
}
