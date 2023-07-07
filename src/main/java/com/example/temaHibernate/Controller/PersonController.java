package com.example.temaHibernate.Controller;

import com.example.temaHibernate.Service.PersonService;
import com.example.temaHibernate.database.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PersonController {
    @Autowired
    PersonService personService;
//afiseaza toti angajatii
    @GetMapping("allPersons")
    public ModelAndView getAllPerson(){
        ModelAndView modelAndView=new ModelAndView("allPersons");
        List<Person> personList = personService.findAllPerson();
        modelAndView.addObject("personList", personList);
        return modelAndView;
    }
//adauga angajat
    @GetMapping("/insert-form")
    public ModelAndView registerActionPerson(@RequestParam("prenumele") String prenumele,
                                             @RequestParam("varsta") int varsta,
                                             @RequestParam("adresa") String adresa,
                                             @RequestParam("salariu") double salariu
    ){
        ModelAndView modelAndView=new ModelAndView("insertPerson");
        try {
            personService.registerPerson(prenumele, varsta, adresa, salariu);
        }catch (Exception e){
            modelAndView.addObject("message", e.getMessage());
            return modelAndView;
        }
        return new ModelAndView("redirect:insertPerson");
    }
    @GetMapping("insertPerson")
    public ModelAndView registerPerson(){
        return new ModelAndView("insertPerson");
    }
//sterge angajat
    @GetMapping("/delete-form")
    public ModelAndView deletePersonAction(@RequestParam("deleteID") int id){
        ModelAndView modelAndView=new ModelAndView("deletePerson");
        personService.deletePerson(id);
        return new ModelAndView("redirect:allPersons");
    }
    @GetMapping("deletePerson")
    public ModelAndView deletePerson(){return new ModelAndView("deletePerson");}
//modifica angajat
    @GetMapping("/update-form")
    public ModelAndView updateActionPerson(@RequestParam("id") int id,
                                             @RequestParam("prenumele") String prenumele,
                                             @RequestParam("varsta") int varsta,
                                             @RequestParam("adresa") String adresa,
                                             @RequestParam("salariu") double salariu
    ){
        ModelAndView modelAndView=new ModelAndView("updatePerson");
        try {
            personService.updatePerson(id, prenumele, varsta, adresa, salariu);
        }catch (Exception e){
            modelAndView.addObject("message", e.getMessage());
            return modelAndView;
        }
        return new ModelAndView("redirect:allPersons");
    }
    @GetMapping("updatePerson")
    public ModelAndView updatePerson(){
        return new ModelAndView("updatePerson");
    }
//cauta dupa criteriu
//    @GetMapping("/find-form")
//    public ModelAndView findByActionPerson(@RequestParam("set") int valCategory,
//                                           @RequestParam("categoriPersoana") String categoriPersoana
//                                          ){
//        ModelAndView modelAndView=new ModelAndView("finfByCategory");
//        List<Person> personList =personService.findByCategory(valCategory, categoriPersoana);
//        modelAndView.addObject("personListCategorie", personList);
//        return modelAndView;
//    }
//    @GetMapping("finfByCategory")
//    public ModelAndView findCategory(){
//        return new ModelAndView("finfByCategory");
//    }
}
