package mvc.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import mvc.dao.Studentdao;
import mvc.dto.Student;

//Service same as component @component
@Service
public class student_service {
	@Autowired
	Studentdao studentdao;

	public ModelAndView save(Student student, String date) {
//		Date cannot parse because we have util.date and java.sql.date pkg we need parse by logic
		student.setDob(Date.valueOf(date));
		student.setAge(Period.between(LocalDate.parse(date), LocalDate.now()).getYears());
		studentdao.save(student);
		ModelAndView view = new ModelAndView();
		view.setViewName("Home");
		view.addObject("success", "Data added Succefully");
		return view;
	}

	public ModelAndView Fetchall() {
		ModelAndView view = new ModelAndView();

		List<Student> s = studentdao.fetchall();
		if (s.isEmpty()) {
			view.addObject("fail", "No Data Found");
			view.setViewName("Home");
		} else {
			view.setViewName("fetchall");
			view.addObject("list", s);
		}
		return view;
	}

	public ModelAndView delete(int id) {
		ModelAndView view = new ModelAndView();
		studentdao.delete(id);
		List<Student> s = studentdao.fetchall();
		if (s.isEmpty()) {
			view.addObject("fail", "Deleted Success No Data Found");
			view.setViewName("Home");
		} else {
			view.setViewName("fetchall");
			view.addObject("success", "deleted success");
			view.addObject("list", s);
		}
		return view;
	}

	public ModelAndView FetchByName(String name) {
		ModelAndView view = new ModelAndView();
		List<Student> s = studentdao.Fetchbyname(name);
		if (s.isEmpty()) {
			view.addObject("fail", "No Data Found");
			view.setViewName("fetchname");
		} else {
			view.setViewName("fetchall");
			view.addObject("list", s);
		}
		return view;
	}

	public ModelAndView edit(int id) {
		ModelAndView view = new ModelAndView("Edit");
		Student student = studentdao.fetchbyid(id);
		view.addObject("student", student);
		return view;
	}

	public ModelAndView update(Student student,String date) {
		student.setDob(Date.valueOf(date));
		student.setAge(Period.between(LocalDate.parse(date), LocalDate.now()).getYears());
		studentdao.Update(student);
		ModelAndView view = new ModelAndView();
		view.setViewName("fetchall");
		view.addObject("list",studentdao.fetchall());
		view.addObject("success", "Data updated");
		return view;
	}
}
