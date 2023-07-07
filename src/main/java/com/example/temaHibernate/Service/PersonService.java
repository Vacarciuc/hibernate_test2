package com.example.temaHibernate.Service;

import com.example.temaHibernate.database.Person;
import com.example.temaHibernate.database.PersonDAO;
import com.example.temaHibernate.database.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonService {
    @Autowired
    PersonDAO personDAO;

    public List<Person>findAllPerson(){
        return(List<Person>) personDAO.findAll();
    }

    public void registerPerson(String prenumele, int varsta, String adresa, double salariu){
        Person person=new Person();
        person.setPrenumele(prenumele);
        person.setVarsta(varsta);
        person.setAdresa(adresa);
        person.setSalariu(salariu);
        personDAO.save(person);
    }

    public void deletePerson(int id){
        Person person=new Person();
        personDAO.deleteById(id);
    }

    public void updatePerson(int id, String prenumele, int varsta, String adresa, double salariu){
        Person person=new Person();
        person.setId(id);
        person.setPrenumele(prenumele);
        person.setVarsta(varsta);
        person.setAdresa(adresa);
        person.setSalariu(salariu);
        personDAO.save(person);
    }

//    public List<Person>findByCategory(int numbCategory, String textCategory){
//        List<Person>personList = null;
//        if (numbCategory==1){
//            personList=personDAO.findByCategory(textCategory);
//        }
//        return personList;
//    }
}
