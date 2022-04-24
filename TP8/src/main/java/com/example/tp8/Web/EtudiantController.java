package com.example.tp8.Web;

import com.example.tp8.Entities.Etudiant;
import com.example.tp8.Repositories.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class EtudiantController {

    private EtudiantRepository etudiantRepository;

    @GetMapping(path = "/user/index")
    public String etudiants(Model model,
                           @RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "size", defaultValue = "5") int size,
                           @RequestParam(name = "keyword", defaultValue = "") String keyword ){
        Page<Etudiant> pageEtudiants=etudiantRepository.findByNomContains(keyword, PageRequest.of(page, size));
        model.addAttribute("listEtudiants",pageEtudiants.getContent());
        model.addAttribute("pages", new int[pageEtudiants.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "etudiants";
    }

    @GetMapping("/admin/delete")
  // @RequestMapping(value = "/admin/delete", method = RequestMethod.DELETE)
    public String delete(Long id, String keyword, int page) {
        etudiantRepository.deleteById(id);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/user/etudiants")
    @ResponseBody
    public List<Etudiant> listEtudiants(){
        return etudiantRepository.findAll();
    }



    @GetMapping("/admin/formEtudiant")
    public String formEtudiant(Model model) {
        model.addAttribute("etudiant",new Etudiant());
        return "formEtudiant";
    }

    @PostMapping(path = "/admin/save")
    public String save( @Valid Etudiant etudiant, BindingResult bindingResult,
                       @RequestParam(name = "page", defaultValue = "0") int page,
                       @RequestParam(name = "keyword", defaultValue = "") String keyword ) {
        if(bindingResult.hasErrors()) return "formEtudiant";
        etudiantRepository.save(etudiant);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping( "/admin/edit")
    public String editEtudiant(Model model, Long id, int page,String keyword ) {
        Etudiant etudiant=etudiantRepository.findById(id).orElse(null);
        if(etudiant==null) throw new RuntimeException("etudiant introuvable");
        model.addAttribute("etudiant",etudiant);
        model.addAttribute("page",page);
        model.addAttribute("keyword",keyword);
        return "editStudent";

        }

}