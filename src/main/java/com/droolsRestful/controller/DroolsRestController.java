package com.droolsRestful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.trucutru.model.*;
import com.trucutru.endpoint.impl.*;

@RestController
public class DroolsRestController {

    @Autowired
    StudentService estudService;
    
    //-----------------------------PUT-----------------------------
    
    @RequestMapping(value="estudiantes/editar/{id_est}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public Estudiante editarEstudiante(@RequestBody Estudiante estud, @PathVariable("id_est") String idEstudiante){
    	Map<String, String> input  = new HashMap<String, String>();
    	input.put("id_est", idEstudiante);
    	Estudiante result = estudService.editarEstudiante(estud, input);
    	return result;
    }

    //------------------------------POST------------------------------
    
    @RequestMapping(value="estudiantes/inserta", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Estudiante insertaEstudiante(@RequestBody Estudiante estud) {
    	try{
    		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
    		Matcher m = p.matcher(estud.getNombre());
    		boolean b = m.find();
    		if(!b){
    			Estudiante result = estudService.insertaEstud(estud);
               	return result;
    		}else{
    			estud.setNombre("El nombre contiene caracteres especiales inaceptables. Favor de cambiar");
    			return estud;
    		}
    	}catch (Exception e) {
            e.printStackTrace();
            estud.setNombre(e.toString());
            return estud;
        }
    } 
    
    @RequestMapping(value="materias/inserta", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Materia insertaMateria(@RequestBody Materia materia) {
    	try{
    		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
    		Matcher m = p.matcher(materia.getNombre());
    		boolean b = m.find();
    		if (!b){
    			Materia result = estudService.insertaMateria(materia);
            	return result;
    		}else{
    			materia.setNombre("El nombre contiene caracteres especiales inaceptables. Favor de cambiar");
    			return materia;
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
    		materia.setNombre(e.toString());
    		return materia;
    	}
    	
    }
    
    @RequestMapping(value="tareas/inserta", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Tarea insertaTarea(@RequestBody Tarea tarea) {
    	try{
    		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
    		Matcher m = p.matcher(tarea.getNombre());
    		boolean b = m.find();
    		if(!b){
            	Tarea result = estudService.insertaTarea(tarea);
            	return result;	
    		}else{
    			tarea.setNombre("El nombre contiene caracteres especiales inaceptables. Favor de cambiar");
    			return tarea;
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
    		tarea.setNombre(e.toString());
    		return tarea;
    	}
    }
    
    @RequestMapping(value="temas/inserta", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Tema insertaTema(@RequestBody Tema tema) {
    	try{
    		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
    		Matcher m = p.matcher(tema.getNombre());
    		boolean b = m.find();
    		if(!b){
            	Tema result = estudService.insertaTema(tema);
            	return result;	
    		}else{
    			tema.setNombre("El nombre contiene caracteres especiales inaceptables. Favor de cambiar");
    			return tema;
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
    		tema.setNombre(e.toString());
    		return tema;
    	}
    }
    
    @RequestMapping(value="estud_mat/inserta", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Estudiante_materia insertaEstud_Mat(@RequestBody Estudiante_materia est_mat) {
    	try{
        	Estudiante_materia result = estudService.insertaEstudMateria(est_mat);
        	return result;
    	}catch (Exception e){
    		e.printStackTrace();
    		return est_mat;
    	}
    }
    
    @RequestMapping(value="tarea_estud/inserta", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Tarea_estudiante insertaTarea_Estud(@RequestBody Tarea_estudiante tar_est) {
    	try{
        	Tarea_estudiante result = estudService.insertaTareaEstud(tar_est);
        	return result;
    	}catch (Exception e){
    		e.printStackTrace();
    		return tar_est;
    	}
    }
    
    @RequestMapping(value="tema_estud/inserta", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Tema_estudiante insertaTema_Estud(@RequestBody Tema_estudiante tema_est) {
    	try{
        	Tema_estudiante result = estudService.insertaTemaEstud(tema_est);
        	return result;
    	}catch (Exception e){
    		e.printStackTrace();
    		return tema_est;
    	}
    }
    
    //------------------------------GET id----------------------------
    
    @RequestMapping(value="estudiantes/{id_est}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Estudiante getEstudiante(@PathVariable("id_est") String idEstudiante){
    	Map<String, String> input  = new HashMap<String, String>();
    	input.put("id_est", idEstudiante);
    	Estudiante result = estudService.getEstudId(input);
    	return result;
    }
    
    @RequestMapping(value="materias/{id_mat}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Materia getMateria(@PathVariable("id_mat") String idMateria){
    	Map<String, String> input  = new HashMap<String, String>();
    	input.put("id_mat", idMateria);
    	Materia result = estudService.getMateriaId(input);
    	return result;
    }
    
    @RequestMapping(value="tareas/{id_tar}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Tarea getTarea(@PathVariable("id_tar") String idTarea){
    	Map<String, String> input  = new HashMap<String, String>();
    	input.put("id_tar", idTarea);
    	Tarea result = estudService.getTareaId(input);
    	return result;
    }
    
    @RequestMapping(value="temas/{id_tem}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Tema getTema(@PathVariable("id_tem") String idTema){
    	Map<String, String> input  = new HashMap<String, String>();
    	input.put("id_tem", idTema);
    	Tema result = estudService.getTemaId(input);
    	return result;
    }
    
    @RequestMapping(value="estud_mat/{id_est}/{id_mat}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Estudiante_materia getEstudMat(@PathVariable("id_est") String idEstud, @PathVariable("id_mat") String idMat){
    	Map<String, String> input  = new HashMap<String, String>();
    	input.put("id_est", idEstud);
    	input.put("id_mat", idMat);
    	Estudiante_materia result = estudService.getEst_MatId(input);
    	return result;
    }
    
    @RequestMapping(value="tarea_estud/{id_est}/{id_tem}/{id_tar}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Tarea_estudiante getTareaEstud(@PathVariable("id_est") String idEstud, @PathVariable("id_tar") String idTarea,
    		@PathVariable("id_tem") String idTema){
    	Map<String, String> input  = new HashMap<String, String>();
    	input.put("id_est", idEstud);
    	input.put("id_tar", idTarea);
    	input.put("id_tem", idTema);
    	Tarea_estudiante result = estudService.getTar_EstId(input);
    	return result;
    }
    
    @RequestMapping(value="tema_estud/{id_est}/{id_tem}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Tema_estudiante getTemaEstud(@PathVariable("id_est") String idEstud, @PathVariable("id_tem") String idTema){
    	Map<String, String> input  = new HashMap<String, String>();
    	input.put("id_est", idEstud);
    	input.put("id_tem", idTema);
    	Tema_estudiante result = estudService.getTem_EstId(input);
    	return result;
    }
    
    //----------------------------GET listas-------------------------------------------------
    
    @RequestMapping(value="estudiantes", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Estudiante> getEstudiantes() {
    	List<Estudiante> estudiantes = estudService.getEstudiantes();
    	return estudiantes;
    }
    
    @RequestMapping(value="materias", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Materia> getMaterias() {
    	List<Materia> materias = estudService.getMaterias();
    	return materias;
    }
    
    @RequestMapping(value="tareas", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Tarea> getTareas() {
    	List<Tarea> tareas = estudService.getTareas();
    	return tareas;
    }
    
    @RequestMapping(value="temas", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Tema> getTemas() {
    	List<Tema> temas = estudService.getTemas();
    	return temas;
    }
    
    @RequestMapping(value="estud_mat", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Estudiante_materia> getEstudiantesMaterias() {
    	List<Estudiante_materia> est_mats = estudService.getEstudiantesMaterias();
    	return est_mats;
    }
    
    @RequestMapping(value="tarea_estud", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Tarea_estudiante> getTareasEstudiantes() {
    	List<Tarea_estudiante> tarea_estuds = estudService.getEstudiantesTareas();
    	return tarea_estuds;
    }
    
    @RequestMapping(value="tema_estud", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Tema_estudiante> getTemasEstudiantes() {
    	List<Tema_estudiante> tema_estuds = estudService.getEstudiantesTemas();
    	return tema_estuds;
    }
}
