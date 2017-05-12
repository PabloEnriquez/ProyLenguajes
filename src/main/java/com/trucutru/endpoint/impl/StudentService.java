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
	
	//--------------------PUT de objetos -------------------------------
	
	public Estudiante editarEstudiante(Estudiante estud, Map<String, String> inputMap){
		try{
			KieSession kSession = droolsInitializer.getKsession();
			int idEstud = Integer.parseInt(inputMap.get("id_est"));
			Estudiante estudModif = null;
			for (Object o : kSession.getObjects()) {
	            if (o instanceof Estudiante) {
	            	Estudiante estudiante = (Estudiante) o;
	            	if(estudiante.getId() == idEstud){
	            		estudiante.setNombre(estud.getNombre());
	            		//estudiante.setPromedioGlobal(estud.getPromedioGlobal());
	            		estudiante.setRecomendaciones(estud.getRecomendaciones());
	            		estudModif = estudiante;
	            		kSession.insert(estudModif);
	                    kSession.fireAllRules();
	            	}
	            }
	        }
			return estudModif;
		}catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
	
	public Materia editarMateria(Materia materia, Map<String, String> inputMap){
		try{
			KieSession kSession = droolsInitializer.getKsession();
			int idMateria = Integer.parseInt(inputMap.get("id_mat"));
			Materia materiaModif = null;
			for (Object o : kSession.getObjects()) {
	            if (o instanceof Materia) {
	            	Materia materiaEncontrada = (Materia) o;
	            	if(materiaEncontrada.getId() == idMateria){
	            		materiaEncontrada.setMaestro(materia.getMaestro());
	            		materiaEncontrada.setNivelCurso(materia.getNivelCurso());
	            		materiaEncontrada.setNombre(materia.getNombre());
	            		materiaModif = materiaEncontrada;
	            		kSession.insert(materiaModif);
	            		kSession.fireAllRules();
	            	}
	            }
	        }
			return materiaModif;
		}catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
	
	public Tarea editarTarea(Tarea tarea, Map<String, String> inputMap){
		try{
			KieSession kSession = droolsInitializer.getKsession();
			int idTarea = Integer.parseInt(inputMap.get("id_tar"));
			Tarea tareaModif = null;
			for (Object o : kSession.getObjects()) {
	            if (o instanceof Tarea) {
	            	Tarea tareaEncontrada = (Tarea) o;
	            	if(tareaEncontrada.getId_tarea() == idTarea){
	            		tareaEncontrada.setDificultad(tarea.getDificultad());
	            		//tareaEncontrada.setId_tema(tarea.getId_tema());
	            		tareaEncontrada.setNombre(tarea.getNombre());
	            		tareaModif = tareaEncontrada;
	            		kSession.insert(tareaModif);
	            		kSession.fireAllRules();
	            	}
	            }
	        }
			return tareaModif;
		}catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
	
	public Tema editarTema(Tema tema, Map<String, String> inputMap){
		try{
			KieSession kSession = droolsInitializer.getKsession();
			int idTema = Integer.parseInt(inputMap.get("id_tem"));
			Tema temaModif = null;
			for (Object o : kSession.getObjects()) {
	            if (o instanceof Tema) {
	            	Tema temaEncontrado = (Tema) o;
	            	if(temaEncontrado.getId_tema() == idTema){
	            		//temaEncontrado.setId_materia(tema.getId_materia());
	            		temaEncontrado.setNivel(tema.getNivel());
	            		temaEncontrado.setNombre(tema.getNombre());
	            		temaModif = temaEncontrado;
	            		kSession.insert(temaModif);
	            		kSession.fireAllRules();
	            	}
	            }
	        }
			return temaModif;
		}catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
	
	public Tarea_estudiante editarTareaEstudiante(Tarea_estudiante tar_estud, Map<String, String> inputMap){
		try{
			KieSession kSession = droolsInitializer.getKsession();
			kSession.fireAllRules();
			int idEst = Integer.parseInt(inputMap.get("id_est"));
			int idTarea = Integer.parseInt(inputMap.get("id_tar"));
			Tarea_estudiante tar_estModif = null;
			for (Object o : kSession.getObjects()) {
	            if (o instanceof Tarea_estudiante) {
	            	Tarea_estudiante tar_estEncontrada = (Tarea_estudiante) o;
	            	if(tar_estEncontrada.getId_estudiante() == idEst && tar_estEncontrada.getId_tarea() == idTarea){
	            		tar_estEncontrada.setCalificacion(tar_estud.getCalificacion());
	            		tar_estEncontrada.setCompleted(tar_estud.isCompleted());
	            		tar_estModif = tar_estEncontrada;
	            		kSession.insert(tar_estModif);
	            		kSession.fireAllRules();
	            	}
	            }
	        }
			return tar_estModif;
		}catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
	
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
	
	public List<Estudiante_materia> getEst_MatId(Map<String, String> inputMap){
		List<Estudiante_materia> lista_estud_mat = new ArrayList<Estudiante_materia>();
		KieSession kSession = droolsInitializer.getKsession();
		kSession.fireAllRules();
		int idEst = Integer.parseInt(inputMap.get("id_est"));
		for (Object o : kSession.getObjects()) {
            if (o instanceof Estudiante_materia) {
            	Estudiante_materia est_mat = (Estudiante_materia) o;
            	if(est_mat.getId_estudiante() == idEst){
            		lista_estud_mat.add(est_mat);
            	}
            }
        }
		return lista_estud_mat;
	}
	
	public List<Tarea_estudiante> getTar_EstId(Map<String, String> inputMap){
		List<Tarea_estudiante> list_tar_est = new ArrayList<Tarea_estudiante>();
		KieSession kSession = droolsInitializer.getKsession();
		kSession.fireAllRules();
		int idEst = Integer.parseInt(inputMap.get("id_est"));
		for (Object o : kSession.getObjects()) {
            if (o instanceof Tarea_estudiante) {
            	Tarea_estudiante tar_est = (Tarea_estudiante) o;
            	if(tar_est.getId_estudiante() == idEst){
            		list_tar_est.add(tar_est);
            	}
            }
        }
		return list_tar_est;
	}
	
	public List<Tema_estudiante> getTem_EstId(Map<String, String> inputMap){
		List<Tema_estudiante> list_tem_est = new ArrayList<Tema_estudiante>();
		KieSession kSession = droolsInitializer.getKsession();
		kSession.fireAllRules();
		int idEst = Integer.parseInt(inputMap.get("id_est"));
		for (Object o : kSession.getObjects()) {
            if (o instanceof Tema_estudiante) {
            	Tema_estudiante tem_est = (Tema_estudiante) o;
            	if(tem_est.getId_estudiante() == idEst){
            		list_tem_est.add(tem_est);
            	}
            }
        }
		return list_tem_est;
	}

}
