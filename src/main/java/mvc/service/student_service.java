package mvc.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import mvc.dao.Studentdao;
import mvc.dto.Student;

//Service same as component @component
@Service
public class student_service 
{
	@Autowired
	Studentdao studentdao;
	
	public ModelAndView save(Student student,String date)
	{
//		Date cannot parse because we have util.date and java.sql.date pkg we need parse by logic
		student.setDob(Date.valueOf(date));
		student.setAge(Period.between(LocalDate.parse(date), LocalDate.now()).getYears());
		studentdao.save(student);
		ModelAndView view =new ModelAndView();
		view.setViewName("Home.jsp");
		view.addObject("success", "Data added Succefully");
		return view;
	}
	public List<Student> Fetchall() 
	{
	return studentdao.fetchall();	
	}
   
}
