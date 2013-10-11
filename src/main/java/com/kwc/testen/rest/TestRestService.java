package com.kwc.testen.rest;

import com.kwc.testen.db.TestResultRepository;
import com.kwc.testen.model.TestResult;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Marius Kristensen
 */
@Path("/tests/")
public class TestRestService {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TestResult> getAllTestResults() {
        TestResultRepository repository = new TestResultRepository();
        return repository.getAllTestResults();
    }

    @GET
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public TestResult getOneTestResult(@PathParam("param") int msg) throws SQLException {
        TestResultRepository repository = new TestResultRepository();
        return repository.getTestResult(msg);
    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postTestResult(TestResult testResult) {

        String result = "Test result added";
        System.out.println("    ########    " + result);
        TestResultRepository repository = new TestResultRepository();
        if (repository.addTestResult(testResult)) {
            return Response.status(Response.Status.CREATED).entity(result).build();
        } else
            return Response.status(Response.Status.BAD_REQUEST).entity("Kunne ikke lagre test").build();
    }

    @GET
    @Path("favicon.ico")
    public void favicon() {
        // empty method to avoid error logs from browsers requesting a favicon..
    }

}
