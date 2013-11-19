package com.kwc.testen;

import com.kwc.testen.rest.FavIcoService;
import com.kwc.testen.rest.TestResultService;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Initializes Rest services
 * @author Marius Kristensen
 */
@SuppressWarnings("unused")
public class RestApplicationConfiguration extends Application {
    private static Set<Object> services = new HashSet<>();

    public RestApplicationConfiguration() {
        services.add(new TestResultService());
        services.add(new FavIcoService());
    }

    @Override
    public Set getSingletons() {
        return services;
    }

    public static Set getServices() {
        return services;
    }
}
