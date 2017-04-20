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
public class UserService {
	
	@Autowired
    private DroolsInitializer droolsInitializer;
    
	public User categorizeUser(Map<String, String> inputMap) {
		
		String name = inputMap.get("name");
		int age = Integer.parseInt(inputMap.get("age"));
		
		User user = new User();
		user.setName(name);
		user.setAge(age);
  
        try{
            //get session from context
            KieSession kSession = droolsInitializer.getKsession();
            System.out.println(">> kSession: " + kSession);
//          printKieSessionAllFacts(kSession);
            System.out.println(">> User: " + user);
            //Insert rule parameters.
            kSession.insert(user);
            //fire rules
//            kSession.fireAllRules();
            int fired = kSession.fireAllRules();
            System.out.println(">> Fired: " + fired);
            String cat = user.getCategory();
            System.out.println(cat);
            //Close session. Don't close session as this is a service.
            //kSession.dispose();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }
	
	public List<User> getUsers() {
		KieSession kSession = droolsInitializer.getKsession();
    	
        List<User> users = new ArrayList<User>();
        for (Object o : kSession.getObjects()) {
            if (o instanceof User) {
                users.add((User) o);
            }
        }
//        kSession.dispose();
        return users;
    }

}
