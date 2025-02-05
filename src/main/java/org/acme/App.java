package org.acme;

import io.quarkus.runtime.StartupEvent;
import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.interceptor.Interceptor;
import org.jboss.logging.Logger;

@ApplicationScoped
public class App {
    @Inject
    GreetingConfig config;
    private static final Logger log = Logger.getLogger( App.class );

    public void onStart(@Observes @Priority(Interceptor.Priority.LIBRARY_BEFORE) StartupEvent startupEvent){
        log.info("$ config " + config.message());
    }
}
