package com.angular.springbootrest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/hospital")
public class HospitalController {
  @Autowired
  private HospitalRepository repo;
  
  @RequestMapping(method = RequestMethod.GET)
  public List<Hospital> findItems() {
    return repo.findAll();
  }
  
  @RequestMapping(value = "/{id}",method = RequestMethod.GET)
  public Hospital findone(@PathVariable Integer id) {
    return  repo.findOne(id);
  }
  
  @RequestMapping(method = RequestMethod.POST)
  public Hospital addItem(@RequestBody Hospital hospital) {
	  hospital.setId(null);
    return repo.saveAndFlush(hospital);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public Hospital updateHospital(@RequestBody Hospital updatedHospital, @PathVariable Integer id) {
    updatedHospital.setId(id);
    return repo.saveAndFlush(updatedHospital);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deleteItem(@PathVariable Integer id) {
    repo.delete(id);
  }
}