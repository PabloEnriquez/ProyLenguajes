package com.droolsRestful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    //------------------------------POST------------------------------
    
    @RequestMapping(value="estudiantes/inserta", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Estudiante insertaEstudiante(@RequestBody Estudiante estud) {
    	Estudiante result = estudService.insertaEstud(estud);
    	return result;
    } 
    
    @RequestMapping(value="materias/inserta", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Materia insertaMateria(@RequestBody Materia materia) {
    	Materia result = estudService.insertaMateria(materia);
    	return result;
    }
    
    @RequestMapping(value="tareas/inserta", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Tarea insertaTarea(@RequestBody Tarea tarea) {
    	Tarea result = estudService.insertaTarea(tarea);
    	return result;
    }
    
    @RequestMapping(value="temas/inserta", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Tema insertaTema(@RequestBody Tema tema) {
    	Tema result = estudService.insertaTema(tema);
    	return result;
    }
    
    @RequestMapping(value="estud_mat/inserta", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Estudiante_materia insertaEstud_Mat(@RequestBody Estudiante_materia est_mat) {
    	Estudiante_materia result = estudService.insertaEstudMateria(est_mat);
    	return result;
    }
    
    @RequestMapping(value="tarea_estud/inserta", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Tarea_estudiante insertaTarea_Estud(@RequestBody Tarea_estudiante tar_est) {
    	Tarea_estudiante result = estudService.insertaTareaEstud(tar_est);
    	return result;
    }
    
    @RequestMapping(value="tema_estud/inserta", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Tema_estudiante insertaTema_Estud(@RequestBody Tema_estudiante tema_est) {
    	Tema_estudiante result = estudService.insertaTemaEstud(tema_est);
    	return result;
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
