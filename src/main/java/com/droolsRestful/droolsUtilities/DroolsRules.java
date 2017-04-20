package com.droolsRestful.droolsUtilities;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Anoop on 07-03-2017.
 */
@Service
public class DroolsRules {

    @Autowired
    private DroolsInitializer droolsInitializer;

    public Double executeOperation(Map<String, String> inputMap) {

        String operation = inputMap.get("operator");
        Double num1  = Double.parseDouble(inputMap.get("num1"));
        Double num2  = Double.parseDouble(inputMap.get("num2"));

        ArithmeticOperations operations = new ArithmeticOperations();
        operations.setOperationType(operation);
        operations.setNum1(num1);
        operations.setNum2(num2);

        try{
            //get session from context
            KieSession kSession = droolsInitializer.getKsession();
            //Insert rule parameters.
            kSession.insert(operations);

            //fire rules
            kSession.fireAllRules();

            Double result =  operations.getResult();
            System.out.println(operations.getResult());

            //Close session. Don't close session as this is a service.
            //kSession.dispose();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
