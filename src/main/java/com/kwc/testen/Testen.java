package com.kwc.testen;

import org.eclipse.jetty.security.ConstraintMapping;
import org.eclipse.jetty.security.ConstraintSecurityHandler;
import org.eclipse.jetty.security.HashLoginService;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.security.Constraint;
import org.eclipse.jetty.util.security.Credential;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;

import javax.servlet.http.HttpServlet;

/**
 * This is the main entry point.
 * This class will create an embedded Jetty server and start the RestApplicationConfiguration.
 *
 * @author Marius Kristensen
 */
public class Testen extends HttpServlet {

    public static void main(String[] args) throws Exception {
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");




        ServletHolder servletHolder = new ServletHolder(new HttpServletDispatcher());
        servletHolder.setInitParameter("javax.ws.rs.Application", "com.kwc.testen.RestApplicationConfiguration");
        context.addServlet(servletHolder, "/*");
        context.setSecurityHandler(createSecurityHandler());

        server.setHandler(context);

        server.start();
        server.join();
    }

    private static ConstraintSecurityHandler createSecurityHandler() {
        String[] roles = {"user"};

        HashLoginService loginService = new HashLoginService();
        loginService.setName("Sunday Drivers Testing Facility");
        loginService.putUser("user", Credential.getCredential("password"), roles);

        Constraint constraint = new Constraint();
        constraint.setAuthenticate(true);
        constraint.setName(Constraint.__BASIC_AUTH);
        constraint.setRoles(roles);

        ConstraintMapping constraintMapping = new ConstraintMapping();
        constraintMapping.setConstraint(constraint);
        constraintMapping.setPathSpec("/tests/");
        constraintMapping.setMethod("POST");

        ConstraintSecurityHandler securityHandler = new ConstraintSecurityHandler();
        securityHandler.addConstraintMapping(constraintMapping);
        securityHandler.setLoginService(loginService);

        return securityHandler;
    }

}
