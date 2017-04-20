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
public class PadreService {
	
	@Autowired
    private DroolsInitializer droolsInitializer;

	public Padre insertaPadre(Map<String, String> inputMap) {
		
		String padre = inputMap.get("padre");
		String hijo = inputMap.get("hijo");
		
		Padre padre1 = new Padre();
		padre1.setHijo(hijo);
		padre1.setPadre(padre);
		
		try{
            //get session from context
            KieSession kSession = droolsInitializer.getKsession();
            System.out.println(">> kSession: " + kSession);
//          printKieSessionAllFacts(kSession);
            System.out.println(">> User: " + padre1);
            //Insert rule parameters.
            kSession.insert(padre1);
            //fire rules
//            kSession.fireAllRules();
            int fired = kSession.fireAllRules();
            System.out.println(">> Fired: " + fired);
            //Close session. Don't close session as this is a service.
            //kSession.dispose();
            return padre1;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
	
	public Padre insertaPadre2(Padre pa){
		Padre padre1 = new Padre();
		padre1.setHijo(pa.getHijo());
		padre1.setPadre(pa.getPadre());
		
		try{
            //get session from context
            KieSession kSession = droolsInitializer.getKsession();
            System.out.println(">> kSession: " + kSession);
//          printKieSessionAllFacts(kSession);
            System.out.println(">> User: " + padre1);
            //Insert rule parameters.
            kSession.insert(padre1);
            //fire rules
//            kSession.fireAllRules();
            int fired = kSession.fireAllRules();
            System.out.println(">> Fired: " + fired);
            //Close session. Don't close session as this is a service.
            //kSession.dispose();
            return padre1;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
	
	public List<Padre> getPadres() {
		KieSession kSession = droolsInitializer.getKsession();
        List<Padre> padres = new ArrayList<Padre>();
        for (Object o : kSession.getObjects()) {
            if (o instanceof Padre) {
                padres.add((Padre) o);
            }
        }
        return padres;
    }
	
	public List<Hermano> getHermanos() {
		KieSession kSession = droolsInitializer.getKsession();
        List<Hermano> hermanos = new ArrayList<Hermano>();
        for (Object o : kSession.getObjects()) {
            if (o instanceof Hermano) {
                hermanos.add((Hermano) o);
            }
        }
        return hermanos;
    }
	
	public List<Abuelo> getAbuelos() {
		KieSession kSession = droolsInitializer.getKsession();
        List<Abuelo> abuelos = new ArrayList<Abuelo>();
        for (Object o : kSession.getObjects()) {
            if (o instanceof Abuelo) {
                abuelos.add((Abuelo) o);
            }
        }
        return abuelos;
    }
	
	public List<Ancestro> getAncestros() {
		KieSession kSession = droolsInitializer.getKsession();
        List<Ancestro> ancestros = new ArrayList<Ancestro>();
        for (Object o : kSession.getObjects()) {
            if (o instanceof Ancestro) {
                ancestros.add((Ancestro) o);
            }
        }
        return ancestros;
    }

}
