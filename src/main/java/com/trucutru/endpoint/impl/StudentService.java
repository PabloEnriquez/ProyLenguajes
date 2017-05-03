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
	
	public Estudiante insertaEstud(Estudiante estud){
		
//		Estudiante estudiante = new Estudiante();
//		estudiante.setNombre(estud.getNombre());
//		estudiante.setPromedioGlobal(estud.getPromedioGlobal());
//		estudiante.setMateriasCursando(estud.getMateriasCursando());
//		estudiante.setMateriaAInscribir(estud.getMateriaAInscribir());
		//estudiante.setMaestro(estud.getMaestro());
		
//		List<Recomendacion> recoms = new ArrayList<Recomendacion>();
//		estud.setRecomendaciones(recoms);
		
//		Recomendacion recomendacion = new Recomendacion();
//   	 	recomendacion.setEstudiante(estud);
//   	 	recoms.add(recomendacion);
		
		try{
            //get session from context
            KieSession kSession = droolsInitializer.getKsession();
//            System.out.println(">> kSession: " + kSession);
//          printKieSessionAllFacts(kSession);
//            System.out.println(">> Estudiante: " + estudiante);
            //Insert rule parameters.
            kSession.insert(estud);
//            kSession.insert(recomendacion);
            //fire rules
//            kSession.fireAllRules();
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
	
	public EstudInscripcion inscribirEstud(EstudInscripcion estud){
//		RecomendacionFuturo recomendacion = new RecomendacionFuturo();
//   	 	recomendacion.setEstudiante(estud);
   	 	try{
         //get session from context
   	 		KieSession kSession = droolsInitializer.getKsession();
//         System.out.println(">> kSession: " + kSession);
//       printKieSessionAllFacts(kSession);
//         System.out.println(">> Estudiante: " + estudiante);
         //Insert rule parameters.
   	 		kSession.insert(estud);
//   	 		kSession.insert(recomendacion);
         //fire rules
//         kSession.fireAllRules();
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
	
	public List<EstudInscripcion> getEstudiantesInscripcion(){
		KieSession kSession = droolsInitializer.getKsession();
		kSession.fireAllRules();
		List<EstudInscripcion> estudiantes = new ArrayList<EstudInscripcion>();
		for (Object o : kSession.getObjects()) {
            if (o instanceof EstudInscripcion) {
            	estudiantes.add((EstudInscripcion) o);
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
	
	public Estudiante getEstudId(Map<String, String> inputMap){
		KieSession kSession = droolsInitializer.getKsession();
		kSession.fireAllRules();
		int idEstud = Integer.parseInt(inputMap.get("id"));
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
	
	public EstudInscripcion getEstudInscripcionId(Map<String, String> inputMap){
		KieSession kSession = droolsInitializer.getKsession();
		kSession.fireAllRules();
		int idEstud = Integer.parseInt(inputMap.get("id"));
		for (Object o : kSession.getObjects()) {
            if (o instanceof EstudInscripcion) {
            	EstudInscripcion estudiante = (EstudInscripcion) o;
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
		int idMateria = Integer.parseInt(inputMap.get("id"));
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

}
