package com.kwc.testen;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;

import javax.servlet.http.HttpServlet;

/**
 * This is the main entry point.
 * This class will create an embedded Jetty server and start the RestService.
 *
 * @author Marius Kristensen
 */
public class Testen extends HttpServlet {

    public static void main(String[] args) throws Exception {
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        ServletHolder servletHolder = new ServletHolder(new HttpServletDispatcher());
        servletHolder.setInitParameter("javax.ws.rs.Application", "com.kwc.testen.service.RestService");
        context.addServlet(servletHolder, "/*");

        server.start();
        server.join();
    }

}
