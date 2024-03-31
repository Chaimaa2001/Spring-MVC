package com.emsi.patientsmvc20.web;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import com.emsi.patientsmvc20.entities.Patient;
import com.emsi.patientsmvc20.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;
    @GetMapping(path="/index")
    public String patients(Model model,
                           @RequestParam(name="page",defaultValue = "0") int page,
                           @RequestParam(name="size",defaultValue = "5") int size,
                            @RequestParam(name="keyword",defaultValue="") String keyword)
    {

        Page<Patient> pagepatients=patientRepository.findByNameContains(keyword, PageRequest.of(page,size));
        model.addAttribute("listPatients",pagepatients.getContent());
        model.addAttribute("pages",new int [pagepatients.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "patients";
    }
    @GetMapping("/delete")
    public String delete(Long id,String keyword,int page)
    {
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }
    @GetMapping("/")
    public String home()
    {

        return "redirect:/index";
    }

    @GetMapping("/patients")
    @ResponseBody
    public List<Patient>listPatiens()
    {
        return patientRepository.findAll();
    }
}
