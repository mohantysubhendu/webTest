package com.my.Controller;

import java.util.Map;

import javax.xml.ws.BindingType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.my.model.Stdentu;
import com.my.service.StudentService;

@Controller
@RequestMapping(value="/")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/index")
	public String setUpForm(Map<String,Object> map)
	{
		Stdentu student=new Stdentu();
		map.put("Student",student);
		map.put("studentList",studentService.getAllStudent());
		return "student";
	}
	@RequestMapping(value="/student",method=RequestMethod.POST)
	public String doAction(@ModelAttribute Stdentu student,BindingResult result,@RequestParam int action,Map<String,Object> map)
	{
		Stdentu studentResult=new Stdentu();
		int b=action;
		switch (b) {
		case 1:
			studentService.add(student);
			studentResult=student;
			break;
		case 2:
			studentService.edit(student);
			studentResult=student;
			break;
		case 3:
			studentService.delete(student.getID());
			studentResult=student;
			break;
		case 4:
			Stdentu searcedStudent=	studentService.getStudent(student.getID());
			studentResult=searcedStudent!=null?searcedStudent: new Stdentu();
			break;
		}
		map.put("Student",student);
		map.put("studentList",studentService.getAllStudent());
		return "student";
		
	}
	

}
