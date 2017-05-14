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
	
	//org.kie.api.runtime.rule.FactHandle estudianteHandle = null;
	
	//--------------------PUT de objetos -------------------------------
	
	public Estudiante editarEstudiante(Estudiante estud, Map<String, String> inputMap){
		try{
			KieSession kSession = droolsInitializer.getKsession();
			int idEstud = Integer.parseInt(inputMap.get("id_est"));
			for (Object o : kSession.getObjects()) {
	            if (o instanceof Estudiante) {
	            	if(((Estudiante) o).getId() == idEstud){
	            		((Estudiante) o).setNombre(estud.getNombre());
	            		//estudiante.setPromedioGlobal(estud.getPromedioGlobal());
	            		((Estudiante) o).setRecomendaciones(estud.getRecomendaciones());
	            		org.kie.api.runtime.rule.FactHandle tarEstHandle = kSession.getFactHandle( (Estudiante) o);
	            		kSession.update(tarEstHandle, (Estudiante) o);
	            		return (Estudiante) o;
	            	}
	            }
	        }
			return null;
		}catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
	
	public Materia editarMateria(Materia materia, Map<String, String> inputMap){
		try{
			KieSession kSession = droolsInitializer.getKsession();
			int idMateria = Integer.parseInt(inputMap.get("id_mat"));
			for (Object o : kSession.getObjects()) {
	            if (o instanceof Materia) {
	            	if(((Materia) o).getId() == idMateria){
	            		((Materia) o).setMaestro(materia.getMaestro());
	            		((Materia) o).setNivelCurso(materia.getNivelCurso());
	            		((Materia) o).setNombre(materia.getNombre());
	            		org.kie.api.runtime.rule.FactHandle tarEstHandle = kSession.getFactHandle( (Materia) o);
	            		kSession.update(tarEstHandle, (Materia) o);
	            		return (Materia) o;
	            	}
	            }
	        }
			return null;
		}catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
	
	public Tarea editarTarea(Tarea tarea, Map<String, String> inputMap){
		try{
			KieSession kSession = droolsInitializer.getKsession();
			int idTarea = Integer.parseInt(inputMap.get("id_tar"));
			for (Object o : kSession.getObjects()) {
	            if (o instanceof Tarea) {
	            	if(((Tarea) o).getId() == idTarea){
	            		((Tarea) o).setDificultad(tarea.getDificultad());
	            		((Tarea) o).setNombre(tarea.getNombre());
	            		org.kie.api.runtime.rule.FactHandle tarEstHandle = kSession.getFactHandle( (Tarea) o);
	            		kSession.update(tarEstHandle, (Tarea) o);
	            		return (Tarea) o;
	            	}
	            }
	        }
			return null;
		}catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
	
	public Tema editarTema(Tema tema, Map<String, String> inputMap){
		try{
			KieSession kSession = droolsInitializer.getKsession();
			int idTema = Integer.parseInt(inputMap.get("id_tem"));
			for (Object o : kSession.getObjects()) {
	            if (o instanceof Tema) {
	            	if(((Tema) o).getId() == idTema){
	            		((Tema) o).setNivel(tema.getNivel());
	            		((Tema) o).setNombre(tema.getNombre());
	            		org.kie.api.runtime.rule.FactHandle tarEstHandle = kSession.getFactHandle( (Tema) o);
	            		kSession.update(tarEstHandle, (Tema) o);
	            		return (Tema) o;
	            	}
	            }
	        }
			return null;
		}catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
	
	public Tarea_estudiante editarTareaEstudiante(Tarea_estudiante tar_estud, Map<String, String> inputMap){
		try{
			KieSession kSession = droolsInitializer.getKsession();
			int idEst = Integer.parseInt(inputMap.get("id_est"));
			int idTarea = Integer.parseInt(inputMap.get("id_tar"));
			for (Object o : kSession.getObjects()) {
				if (o instanceof Estudiante){
					((Estudiante) o).setPromedioGlobal(0.0);
					org.kie.api.runtime.rule.FactHandle tarEstHandle = kSession.getFactHandle( (Estudiante) o);
	            	kSession.update(tarEstHandle, (Estudiante) o);	
				}
				if (o instanceof Materia){
					org.kie.api.runtime.rule.FactHandle tarEstHandle = kSession.getFactHandle( (Materia) o);
            		kSession.update(tarEstHandle, (Materia) o);
				}
				if (o instanceof Tema){
					org.kie.api.runtime.rule.FactHandle tarEstHandle = kSession.getFactHandle( (Tema) o);
            		kSession.update(tarEstHandle, (Tema) o);
				}
				if (o instanceof Tarea){
					org.kie.api.runtime.rule.FactHandle tarEstHandle = kSession.getFactHandle( (Tarea) o);
            		kSession.update(tarEstHandle, (Tarea) o);
				}
				if (o instanceof Estudiante_materia){
					((Estudiante_materia) o).setPromedioAlumno(0.0);
					((Estudiante_materia) o).setPorcentajeCompletado(0.0);
					org.kie.api.runtime.rule.FactHandle tarEstHandle = kSession.getFactHandle((Estudiante_materia) o);
            		kSession.update(tarEstHandle, (Estudiante_materia) o);
				}
				if (o instanceof Tema_estudiante){
					((Tema_estudiante) o).setPromedioEjercicios(0.0);
					org.kie.api.runtime.rule.FactHandle tarEstHandle = kSession.getFactHandle((Tema_estudiante) o);
            		kSession.update(tarEstHandle, (Tema_estudiante) o);
				}
	            if (o instanceof Tarea_estudiante) {
	            	if(((Tarea_estudiante) o).getIdEstudiante() == idEst && ((Tarea_estudiante) o).getIdTarea() == idTarea){
	            		((Tarea_estudiante) o).setCalificacion(tar_estud.getCalificacion());
	            		((Tarea_estudiante) o).setCompleted(tar_estud.isCompleted());
	            		org.kie.api.runtime.rule.FactHandle tarEstHandle = kSession.getFactHandle((Tarea_estudiante) o);
	            		kSession.update(tarEstHandle, (Tarea_estudiante) o);
//	            		KieSession kSession2 = kSession.getKieBase().newKieSession();
//	                	kSession2.fireAllRules();
	            		return (Tarea_estudiante) o;
	            	}
	            }
	        }
//			kSession.fireAllRules();
			return null;
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
//            int fired = kSession.fireAllRules();
//            System.out.println(">> Fired: " + fired);
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
//            int fired = kSession.fireAllRules();
//            System.out.println(">> Fired: " + fired);
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
//			int fired = kSession.fireAllRules();
//			System.out.println(">> Fired: " + fired);
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
//			int fired = kSession.fireAllRules();
//			System.out.println(">> Fired: " + fired);
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
			int idEst = est_mat.getIdEstudiante();
			int idMat = est_mat.getIdMateria();
			int idTema = 0;
			int idTarea = 0;
			for (Object o : kSession.getObjects()) {
	            if (o instanceof Tema) {
	            	if( idMat == ((Tema) o).getIdMateria() ){
	            		idTema = ((Tema) o).getId();
		            	Tema_estudiante tema_est = new Tema_estudiante(idTema, idEst, idMat, 0.0);
		            	insertaTemaEstud(tema_est);
	            	}
	            }
	            if (o instanceof Tarea){
	            	if ( idTema == ((Tarea) o).getIdTema() ){
	            		idTarea = ((Tarea) o).getId();
	            		Tarea_estudiante tar_est = new Tarea_estudiante(idTarea, idTema, idEst, idMat, 0.0, false);
	        			insertaTareaEstud(tar_est);
	            	}
	            }
	        }
			//fire rules
//			int fired = kSession.fireAllRules();
//			System.out.println(">> Fired: " + fired);
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
//			int fired = kSession.fireAllRules();
//			System.out.println(">> Fired: " + fired);
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
//			int fired = kSession.fireAllRules();
//			System.out.println(">> Fired: " + fired);
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
        List<Estudiante> estudiantes = new ArrayList<Estudiante>();
        for (Object o : kSession.getObjects()) {
            if (o instanceof Estudiante) {
            	estudiantes.add((Estudiante) o);
            }
        }
//        KieSession kSession2 = kSession.getKieBase().newKieSession();
//    	kSession2.fireAllRules();
        kSession.fireAllRules();
        return estudiantes;
	}
	
	public List<Materia> getMaterias() {
		KieSession kSession = droolsInitializer.getKsession();
        List<Materia> materias = new ArrayList<Materia>();
        for (Object o : kSession.getObjects()) {
            if (o instanceof Materia) {
            	materias.add((Materia) o);
            }
        }
        kSession.fireAllRules();
        return materias;
	}
	
	public List<Tema> getTemas() {
		KieSession kSession = droolsInitializer.getKsession();
        List<Tema> temas = new ArrayList<Tema>();
        for (Object o : kSession.getObjects()) {
            if (o instanceof Tema) {
            	temas.add((Tema) o);
            }
        }
        kSession.fireAllRules();
        return temas;
	}
	
	public List<Tarea> getTareas() {
		KieSession kSession = droolsInitializer.getKsession();
        List<Tarea> tareas = new ArrayList<Tarea>();
        for (Object o : kSession.getObjects()) {
            if (o instanceof Tarea) {
            	tareas.add((Tarea) o);
            }
        }
        kSession.fireAllRules();
        return tareas;
	}
	
	public List<Estudiante_materia> getEstudiantesMaterias() {
		KieSession kSession = droolsInitializer.getKsession();
        List<Estudiante_materia> est_tareas = new ArrayList<Estudiante_materia>();
        for (Object o : kSession.getObjects()) {
            if (o instanceof Estudiante_materia) {
            	est_tareas.add((Estudiante_materia) o);
            }
        }
        kSession.fireAllRules();
        return est_tareas;
	}
	
	public List<Tarea_estudiante> getEstudiantesTareas() {
		KieSession kSession = droolsInitializer.getKsession();
        List<Tarea_estudiante> tar_ests = new ArrayList<Tarea_estudiante>();
        for (Object o : kSession.getObjects()) {
            if (o instanceof Tarea_estudiante) {
            	tar_ests.add((Tarea_estudiante) o);
            }
        }
        kSession.fireAllRules();
        return tar_ests;
	}
	
	public List<Tema_estudiante> getEstudiantesTemas() {
		KieSession kSession = droolsInitializer.getKsession();
        List<Tema_estudiante> temas_ests = new ArrayList<Tema_estudiante>();
        for (Object o : kSession.getObjects()) {
            if (o instanceof Tema_estudiante) {
            	temas_ests.add((Tema_estudiante) o);
            }
        }
        kSession.fireAllRules();
        return temas_ests;
	}
	
	//--------------------------GET objeto con id---------------------------------------------
	
	public Estudiante getEstudId(Map<String, String> inputMap){
		KieSession kSession = droolsInitializer.getKsession();
		int idEstud = Integer.parseInt(inputMap.get("id_est"));
		for (Object o : kSession.getObjects()) {
            if (o instanceof Estudiante) {
            	Estudiante estudiante = (Estudiante) o;
            	if(estudiante.getId() == idEstud){
            		kSession.fireAllRules();
            		return estudiante;
            	}
            }
        }
		return null;
	}
	
	public Materia getMateriaId(Map<String, String> inputMap){
		KieSession kSession = droolsInitializer.getKsession();
		int idMateria = Integer.parseInt(inputMap.get("id_mat"));
		for (Object o : kSession.getObjects()) {
            if (o instanceof Materia) {
            	Materia materia = (Materia) o;
            	if(materia.getId() == idMateria){
            		kSession.fireAllRules();
            		return materia;
            	}
            }
        }
		return null;
	}
	
	public Tarea getTareaId(Map<String, String> inputMap){
		KieSession kSession = droolsInitializer.getKsession();
		int idTarea = Integer.parseInt(inputMap.get("id_tar"));
		for (Object o : kSession.getObjects()) {
            if (o instanceof Tarea) {
            	Tarea tarea = (Tarea) o;
            	if(tarea.getId() == idTarea){
            		kSession.fireAllRules();
            		return tarea;
            	}
            }
        }
		return null;
	}
	
	public Tema getTemaId(Map<String, String> inputMap){
		KieSession kSession = droolsInitializer.getKsession();
		int idTema = Integer.parseInt(inputMap.get("id_tem"));
		for (Object o : kSession.getObjects()) {
            if (o instanceof Tema) {
            	Tema tema = (Tema) o;
            	if(tema.getId() == idTema){
            		kSession.fireAllRules();
            		return tema;
            	}
            }
        }
		return null;
	}
	
	public List<Estudiante_materia> getEst_MatId(Map<String, String> inputMap){
		List<Estudiante_materia> lista_estud_mat = new ArrayList<Estudiante_materia>();
		KieSession kSession = droolsInitializer.getKsession();
		int idEst = Integer.parseInt(inputMap.get("id_est"));
		for (Object o : kSession.getObjects()) {
            if (o instanceof Estudiante_materia) {
            	Estudiante_materia est_mat = (Estudiante_materia) o;
            	if(est_mat.getIdEstudiante() == idEst){
            		lista_estud_mat.add(est_mat);
            	}
            }
        }
		kSession.fireAllRules();
		return lista_estud_mat;
	}
	
	public List<Tarea_estudiante> getTar_EstId(Map<String, String> inputMap){
		List<Tarea_estudiante> list_tar_est = new ArrayList<Tarea_estudiante>();
		KieSession kSession = droolsInitializer.getKsession();
		int idEst = Integer.parseInt(inputMap.get("id_est"));
		for (Object o : kSession.getObjects()) {
            if (o instanceof Tarea_estudiante) {
            	Tarea_estudiante tar_est = (Tarea_estudiante) o;
            	if(tar_est.getIdEstudiante() == idEst){
            		list_tar_est.add(tar_est);
            	}
            }
        }
		kSession.fireAllRules();
		return list_tar_est;
	}
	
	public List<Tema_estudiante> getTem_EstId(Map<String, String> inputMap){
		List<Tema_estudiante> list_tem_est = new ArrayList<Tema_estudiante>();
		KieSession kSession = droolsInitializer.getKsession();
		int idEst = Integer.parseInt(inputMap.get("id_est"));
		for (Object o : kSession.getObjects()) {
            if (o instanceof Tema_estudiante) {
            	Tema_estudiante tem_est = (Tema_estudiante) o;
            	if(tem_est.getIdEstudiante() == idEst){
            		list_tem_est.add(tem_est);
            	}
            }
        }
		kSession.fireAllRules();
		return list_tem_est;
	}

}
