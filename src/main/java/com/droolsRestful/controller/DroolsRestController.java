package com.droolsRestful.controller;

import com.droolsRestful.droolsUtilities.DroolsRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.trucutru.model.*;
import com.trucutru.endpoint.impl.*;

@RestController
public class DroolsRestController {

    @Autowired
    DroolsRules droolsRules;
    @Autowired
    UserService userService;
    @Autowired
    PadreService padreService;
    @Autowired
    StudentService estudService;

    DecimalFormat format = new DecimalFormat("0.#");

    @RequestMapping(value="doMaths/{operation}/{num1:.+}/{num2:.+}", method = RequestMethod.GET,
        produces = "application/json")
    public Map basicOperation(@PathVariable("operation") String operation, @PathVariable("num1") String num1, @PathVariable("num2") String num2) {

        Map<String, String> input  = new HashMap<String, String>();
        input.put("operator",  operation);
        input.put("num1", num1);
        input.put("num2", num2);
        Double result  = droolsRules.executeOperation(input);

        Map<String, String> resultMap = new HashMap<String, String>();
        resultMap.put("result", format.format(result));
        return resultMap;
    }

    @RequestMapping(value="users/categorize/{name}/{age}", method = RequestMethod.POST, /*consumes = "application/json",*/
            produces = "application/json")
    public User categorizeUser(@PathVariable("name") String name, @PathVariable("age") String age) {
    	 Map<String, String> input  = new HashMap<String, String>();
    	 input.put("name", name);
    	 input.put("age", age);
    	 User result = userService.categorizeUser(input);
    	 return result;
    }
    
    @RequestMapping(value="users", method = RequestMethod.GET, produces = "application/json")
    public List<User> getUsers() {
    	List<User> users = userService.getUsers();
    	return users;
    }
    
//    @RequestMapping(value="padres/inserta/{padre}/{hijo}", method = RequestMethod.POST, /*consumes = "application/json",*/
//            produces = "application/json")
//    public Padre insertaPadre(@PathVariable("padre") String padre, @PathVariable("hijo") String hijo) {
//    	
//    	 Map<String, String> input  = new HashMap<String, String>();
//    	 input.put("padre", padre);
//    	 input.put("hijo", hijo);
//    	 Padre result = padreService.insertaPadre(input);
//
//    	 return result;
//    }
    
    @RequestMapping(value="padres/inserta", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Padre insertaPadre(@RequestBody Padre padre) {
    	 Padre result = padreService.insertaPadre2(padre);
    	 return result;
    }
    
    @RequestMapping(value="padres", method = RequestMethod.GET/*, produces = "application/json"*/)
    @ResponseBody
    public List<Padre> getPadres() {
    	List<Padre> padres = padreService.getPadres();
    	return padres;
    }
    
    @RequestMapping(value="padres/hermanos", method = RequestMethod.GET/*, produces = "application/json"*/)
    @ResponseBody
    public List<Hermano> getHermanos() {
    	List<Hermano> hermanos = padreService.getHermanos();
    	return hermanos;
    }
    
    @RequestMapping(value="padres/abuelos", method = RequestMethod.GET/*, produces = "application/json"*/)
    @ResponseBody
    public List<Abuelo> getAbuelos() {
    	List<Abuelo> abuelos = padreService.getAbuelos();
    	return abuelos;
    }

    @RequestMapping(value="padres/ancestros", method = RequestMethod.GET/*, produces = "application/json"*/)
    @ResponseBody
    public List<Ancestro> getAncestros() {
    	List<Ancestro> ancestros = padreService.getAncestros();
    	return ancestros;
    }
    
//    ---------------------------------------------------------------------------------------------------------
    
    @RequestMapping(value="estudiantes/inserta", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Estudiante insertaEstudiante(@RequestBody Estudiante estud) {
    	 Estudiante result = estudService.insertaEstud(estud);
    	 return result;
    }  
    
    @RequestMapping(value="estudiantes", method = RequestMethod.GET/*, produces = "application/json"*/)
    @ResponseBody
    public List<Estudiante> getEstudiantes() {
    	List<Estudiante> estudiantes = estudService.getEstudiantes();
    	return estudiantes;
    }
}
