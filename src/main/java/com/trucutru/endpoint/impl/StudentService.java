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
	
	public Estudiante getEstudId(Map<String, String> inputMap, List<Estudiante> estudiantes){
		KieSession kSession = droolsInitializer.getKsession();
		kSession.fireAllRules();
		int idEstud = Integer.parseInt(inputMap.get("id"));
//		List<Estudiante> estudiantes = getEstudiantes();
		for (Object o : kSession.getObjects()) {
            if (o instanceof Estudiante) {
//            	estudiantes.add((Estudiante) o);
            	Estudiante estudiante = (Estudiante) o;
            	if(estudiante.getId() == idEstud){
            		return estudiante;
            	}
            }
        }
		return null;
	}

}
