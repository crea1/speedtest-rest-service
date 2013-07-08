package com.kwc.testen.service;

import com.kwc.testen.rest.TestRestService;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Initializes Rest services
 * @author Marius Kristensen
 */
@SuppressWarnings("unused")
public class RestService extends Application {
    private static Set<Object> services = new HashSet<>();

    public RestService() {
        services.add(new TestRestService());
    }

    @Override
    public Set getSingletons() {
        return services;
    }

    public static Set getServices() {
        return services;
    }
}
