package in.bm.StudentManagementSystem.MyController;

import in.bm.StudentManagementSystem.Entity.Student;
import in.bm.StudentManagementSystem.Service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class Controller1 {

    @Autowired
    private StudentService studentService;


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String AdminLogin(@RequestParam String username,
                             @RequestParam String password,
                             RedirectAttributes redirectAttributes,
                              HttpServletRequest Request ) {
        if ("Bharat".equals(username) && "Bharat123".equals(password)) {
            HttpSession session = Request.getSession();
            session.setAttribute("admin",username);

            return "profile";
        }
        redirectAttributes.addFlashAttribute("error", "Invalid credentials");
        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String goToProfile() {
        return "profile";
    }


    @GetMapping("/ViewStudents")
    public String viewStudents(Model model) {
        List<Student> students = studentService.fetchAll();
        model.addAttribute("students", students);
        return "View";
    }


    @GetMapping("/AddStudents")
    public String addStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "Add";
    }

    @PostMapping("/AddStudents")
    public String addStudent(@ModelAttribute Student student, RedirectAttributes redirectAttributes) {
        studentService.insert(student);
        redirectAttributes.addFlashAttribute("success", "Successfully Added");
        return "redirect:/AddStudents";
    }


    @GetMapping("/RemoveStudents")
    public String removeStudentForm() {
        return "Remove";
    }

    @PostMapping("/removeStudent")
    public String removeStudent(@RequestParam long id,
                                @RequestParam String firstName,
                                @RequestParam String secondName,
                                RedirectAttributes redirectAttributes) {
        try {
            Student removed = studentService.remove(id, firstName, secondName);
            redirectAttributes.addFlashAttribute("success", "Removed Successfully");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/RemoveStudents";
    }
    @GetMapping("/backProfile")
    public String back(){

        return "profile";
    }


    @GetMapping("/UpdateStudents")
    public String showEnterIdForm() {
        return "UpdateID";
    }


    @PostMapping("/UpdateStudents/fetch")
    public String fetchStudentById(@RequestParam("studentId") long id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Student> studentOpt = studentService.findById(id);
        if (studentOpt.isPresent()) {
            model.addAttribute("student", studentOpt.get());
            return "Update";
        } else {
            redirectAttributes.addFlashAttribute("error", "Student not found");
            return "redirect:/UpdateStudents";
        }
    }


    @PostMapping("/UpdateStudents/save")
    public String updateStudent(@ModelAttribute Student student, RedirectAttributes redirectAttributes) {
        try {
            studentService.update(student.getStudentId(), student);
            redirectAttributes.addFlashAttribute("success", "Updated Successfully");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", "Update failed: " + e.getMessage());
        }
        return "redirect:/UpdateStudents";
    }

    @GetMapping("/GoToProfile")
    public String goback(){
        return "profile";
    }
    // Logout
    @GetMapping("/logout")
    public String logout() {


        return "redirect:/login";
    }

}
