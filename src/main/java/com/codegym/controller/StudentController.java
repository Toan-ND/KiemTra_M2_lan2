package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class StudentController {
    @Autowired
     private StudentService studentService;

    @GetMapping("/student")   public ModelAndView listCustomer(){
        Iterable<Student> students = studentService.findAll();
        ModelAndView modelAndView = new ModelAndView("student/index");
        modelAndView.addObject("student", students);
        return modelAndView;
    }

    @GetMapping("/create-student")
    public ModelAndView createStudent(){
        ModelAndView modelAndView = new ModelAndView("student/create");
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }

    @PostMapping("/create-student")
    public ModelAndView saveStudent(@ModelAttribute("student") Student student){
        studentService.save(student);

        ModelAndView modelAndView = new ModelAndView("student/create");
        modelAndView.addObject("student", new Student());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }
    @GetMapping("/edit-student/{id}")
    public ModelAndView editCustomer(@PathVariable Long id){
        Student student = studentService.findById(id);
        if (student != null){
            ModelAndView modelAndView = new ModelAndView("student/edit");
            modelAndView.addObject("student", student);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
    @PostMapping("/edit-student")
    public ModelAndView updateStudent(@ModelAttribute("student") Student student){
        studentService.save(student);
        ModelAndView modelAndView = new ModelAndView("student/edit");
        modelAndView.addObject("student", student);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-student/{id}")
    public ModelAndView deleteStudent(@PathVariable Long id){
        Student student = studentService.findById(id);
        if (student != null){
            ModelAndView modelAndView = new ModelAndView("student/delete");
            modelAndView.addObject("student", student);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-student")
    public String deleteStuden(@ModelAttribute("student") Student student){
        studentService.remote(student.getId());
        return "redirect:customers";
    }


}
