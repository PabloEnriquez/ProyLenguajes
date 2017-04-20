package com.droolsRestful.droolsUtilities;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

/**
 * Created by Anoop on 08-03-2017.
 */
@Service
public class DroolsInitializer {

    private KieSession session;

    public DroolsInitializer() {

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();

        //load which session to run
        session = kContainer.newKieSession("arithmetic-session");
    }

    public KieSession getKsession() {
        return this.session;
    }
}
