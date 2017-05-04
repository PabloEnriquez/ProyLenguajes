package com.trucutru.endpoint.impl;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.droolsRestful.droolsUtilities.DroolsInitializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.trucutru.model.*;

@Service
public class StudentService {
	
	@Autowired
    private DroolsInitializer droolsInitializer;
	
	//--------------------POST de objetos--------------------------------
	
	public Estudiante insertaEstud(Estudiante estud){
		try{
            //get session from context
            KieSession kSession = droolsInitializer.getKsession();
            //Insert rule parameters.
            kSession.insert(estud);
            //fire rules
            int fired = kSession.fireAllRules();
            System.out.println(">> Fired: " + fired);
            //Close session. Don't close session as this is a service.
            //kSession.dispose();
            return estud;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
	
	public Materia insertaMateria(Materia materia){
		try{
			 //get session from context
            KieSession kSession = droolsInitializer.getKsession();
            //Insert rule parameters.
            kSession.insert(materia);
            //fire rules
            int fired = kSession.fireAllRules();
            System.out.println(">> Fired: " + fired);
            //Close session. Don't close session as this is a service.
            //kSession.dispose();
            return materia;
		}catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
	
	public Tema insertaTema(Tema tema){
		try{
			//get session from context
			KieSession kSession = droolsInitializer.getKsession();
			//Insert rule parameters.
			kSession.insert(tema);
			//fire rules
			int fired = kSession.fireAllRules();
			System.out.println(">> Fired: " + fired);
			//Close session. Don't close session as this is a service.
			//kSession.dispose();
			return tema;
		}catch (Exception e) {
           e.printStackTrace();
           return null;
       }
	}
	
	public Tarea insertaTarea(Tarea tarea){
		try{
			 //get session from context
			KieSession kSession = droolsInitializer.getKsession();
			//Insert rule parameters.
			kSession.insert(tarea);
			//fire rules
			int fired = kSession.fireAllRules();
			System.out.println(">> Fired: " + fired);
			//Close session. Don't close session as this is a service.
			//kSession.dispose();
			return tarea;
		}catch (Exception e) {
          e.printStackTrace();
          return null;
		}
	}
	
	public Estudiante_materia insertaEstudMateria(Estudiante_materia est_mat){
		try{
			//get session from context
			KieSession kSession = droolsInitializer.getKsession();
			//Insert rule parameters.
			kSession.insert(est_mat);
			//fire rules
			int fired = kSession.fireAllRules();
			System.out.println(">> Fired: " + fired);
			//Close session. Don't close session as this is a service.
			//kSession.dispose();
			return est_mat;
		}catch (Exception e) {
         e.printStackTrace();
         return null;
		}
	}
	
	public Tarea_estudiante insertaTareaEstud(Tarea_estudiante tar_est){
		try{
			//get session from context
			KieSession kSession = droolsInitializer.getKsession();
			//Insert rule parameters.
			kSession.insert(tar_est);
			//fire rules
			int fired = kSession.fireAllRules();
			System.out.println(">> Fired: " + fired);
			//Close session. Don't close session as this is a service.
			//kSession.dispose();
			return tar_est;
		}catch (Exception e) {
         e.printStackTrace();
         return null;
		}
	}
	
	public Tema_estudiante insertaTemaEstud(Tema_estudiante tem_est){
		try{
			//get session from context
			KieSession kSession = droolsInitializer.getKsession();
			//Insert rule parameters.
			kSession.insert(tem_est);
			//fire rules
			int fired = kSession.fireAllRules();
			System.out.println(">> Fired: " + fired);
			//Close session. Don't close session as this is a service.
			//kSession.dispose();
			return tem_est;
		}catch (Exception e) {
         e.printStackTrace();
         return null;
		}
	}
	
	//-----------------------------GET listas-------------------------------
	
	public List<Estudiante> getEstudiantes() {
		KieSession kSession = droolsInitializer.getKsession();
		kSession.fireAllRules();
        List<Estudiante> estudiantes = new ArrayList<Estudiante>();
        for (Object o : kSession.getObjects()) {
            if (o instanceof Estudiante) {
            	estudiantes.add((Estudiante) o);
            }
        }
        return estudiantes;
	}
	
	public List<Materia> getMaterias() {
		KieSession kSession = droolsInitializer.getKsession();
		kSession.fireAllRules();
        List<Materia> materias = new ArrayList<Materia>();
        for (Object o : kSession.getObjects()) {
            if (o instanceof Materia) {
            	materias.add((Materia) o);
            }
        }
        return materias;
	}
	
	public List<Tema> getTemas() {
		KieSession kSession = droolsInitializer.getKsession();
		kSession.fireAllRules();
        List<Tema> temas = new ArrayList<Tema>();
        for (Object o : kSession.getObjects()) {
            if (o instanceof Tema) {
            	temas.add((Tema) o);
            }
        }
        return temas;
	}
	
	public List<Tarea> getTareas() {
		KieSession kSession = droolsInitializer.getKsession();
		kSession.fireAllRules();
        List<Tarea> tareas = new ArrayList<Tarea>();
        for (Object o : kSession.getObjects()) {
            if (o instanceof Tarea) {
            	tareas.add((Tarea) o);
            }
        }
        return tareas;
	}
	
	public List<Estudiante_materia> getEstudiantesMaterias() {
		KieSession kSession = droolsInitializer.getKsession();
		kSession.fireAllRules();
        List<Estudiante_materia> est_tareas = new ArrayList<Estudiante_materia>();
        for (Object o : kSession.getObjects()) {
            if (o instanceof Estudiante_materia) {
            	est_tareas.add((Estudiante_materia) o);
            }
        }
        return est_tareas;
	}
	
	public List<Tarea_estudiante> getEstudiantesTareas() {
		KieSession kSession = droolsInitializer.getKsession();
		kSession.fireAllRules();
        List<Tarea_estudiante> tar_ests = new ArrayList<Tarea_estudiante>();
        for (Object o : kSession.getObjects()) {
            if (o instanceof Tarea_estudiante) {
            	tar_ests.add((Tarea_estudiante) o);
            }
        }
        return tar_ests;
	}
	
	public List<Tema_estudiante> getEstudiantesTemas() {
		KieSession kSession = droolsInitializer.getKsession();
		kSession.fireAllRules();
        List<Tema_estudiante> temas_ests = new ArrayList<Tema_estudiante>();
        for (Object o : kSession.getObjects()) {
            if (o instanceof Tema_estudiante) {
            	temas_ests.add((Tema_estudiante) o);
            }
        }
        return temas_ests;
	}
	
	//--------------------------GET objeto con id---------------------------------------------
	
	public Estudiante getEstudId(Map<String, String> inputMap){
		KieSession kSession = droolsInitializer.getKsession();
		kSession.fireAllRules();
		int idEstud = Integer.parseInt(inputMap.get("id_est"));
		for (Object o : kSession.getObjects()) {
            if (o instanceof Estudiante) {
            	Estudiante estudiante = (Estudiante) o;
            	if(estudiante.getId() == idEstud){
            		return estudiante;
            	}
            }
        }
		return null;
	}
	
	public Materia getMateriaId(Map<String, String> inputMap){
		KieSession kSession = droolsInitializer.getKsession();
		kSession.fireAllRules();
		int idMateria = Integer.parseInt(inputMap.get("id_mat"));
		for (Object o : kSession.getObjects()) {
            if (o instanceof Materia) {
            	Materia materia = (Materia) o;
            	if(materia.getId() == idMateria){
            		return materia;
            	}
            }
        }
		return null;
	}
	
	public Tarea getTareaId(Map<String, String> inputMap){
		KieSession kSession = droolsInitializer.getKsession();
		kSession.fireAllRules();
		int idTarea = Integer.parseInt(inputMap.get("id_tar"));
		for (Object o : kSession.getObjects()) {
            if (o instanceof Tarea) {
            	Tarea tarea = (Tarea) o;
            	if(tarea.getId_tarea() == idTarea){
            		return tarea;
            	}
            }
        }
		return null;
	}
	
	public Tema getTemaId(Map<String, String> inputMap){
		KieSession kSession = droolsInitializer.getKsession();
		kSession.fireAllRules();
		int idTema = Integer.parseInt(inputMap.get("id_tem"));
		for (Object o : kSession.getObjects()) {
            if (o instanceof Tema) {
            	Tema tema = (Tema) o;
            	if(tema.getId_tema() == idTema){
            		return tema;
            	}
            }
        }
		return null;
	}
	
	public Estudiante_materia getEst_MatId(Map<String, String> inputMap){
		KieSession kSession = droolsInitializer.getKsession();
		kSession.fireAllRules();
		int idEst = Integer.parseInt(inputMap.get("id_est"));
		int idMat = Integer.parseInt(inputMap.get("id_mat"));
		for (Object o : kSession.getObjects()) {
            if (o instanceof Estudiante_materia) {
            	Estudiante_materia est_mat = (Estudiante_materia) o;
            	if(est_mat.getId_estudiante() == idEst && est_mat.getId_materia() == idMat){
            		return est_mat;
            	}
            }
        }
		return null;
	}
	
	public Tarea_estudiante getTar_EstId(Map<String, String> inputMap){
		KieSession kSession = droolsInitializer.getKsession();
		kSession.fireAllRules();
		int idEst = Integer.parseInt(inputMap.get("id_est"));
		int idTar = Integer.parseInt(inputMap.get("id_tar"));
		int idTem = Integer.parseInt(inputMap.get("id_tem"));
		for (Object o : kSession.getObjects()) {
            if (o instanceof Tarea_estudiante) {
            	Tarea_estudiante tar_est = (Tarea_estudiante) o;
            	if(tar_est.getId_estudiante() == idEst && tar_est.getId_tarea() == idTar
            			&& tar_est.getId_tema() == idTem){
            		return tar_est;
            	}
            }
        }
		return null;
	}
	
	public Tema_estudiante getTem_EstId(Map<String, String> inputMap){
		KieSession kSession = droolsInitializer.getKsession();
		kSession.fireAllRules();
		int idEst = Integer.parseInt(inputMap.get("id_est"));
		int idTem = Integer.parseInt(inputMap.get("id_tem"));
		for (Object o : kSession.getObjects()) {
            if (o instanceof Tema_estudiante) {
            	Tema_estudiante tem_est = (Tema_estudiante) o;
            	if(tem_est.getId_estudiante() == idEst && tem_est.getId_tema() == idTem){
            		return tem_est;
            	}
            }
        }
		return null;
	}

}
