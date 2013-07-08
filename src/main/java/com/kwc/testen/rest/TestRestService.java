package com.kwc.testen.rest;

import com.kwc.testen.db.TestResultRepository;
import com.kwc.testen.model.TestResult;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

/**
 * @author Marius Kristensen
 */
@Path("/")
public class TestRestService {

    public TestResult testResult;

    @GET
    @Path("/")
    @Produces("application/json")
    public TestResult printMessage() {
        this.testResult = new TestResult(
                1,
                "VW",
                "Golf",
                "1999",
                "2500",
                250,
                310,
                "1400",
                2,
                175,
                "Wet",
                "2005",
                "Reidar"
        );
        TestResult testResult = this.testResult;


        return testResult;
    }

    @GET
    @Path("/{param}")
    @Produces("application/json")
    public int getOne(@PathParam("param") String msg) throws SQLException {
        TestResultRepository repository = new TestResultRepository();
        return repository.countRows();
    }

}
