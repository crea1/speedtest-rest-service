package com.kwc.testen.rest;

import com.kwc.testen.common.CustomMediaType;
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
public class TestResultService {

    @GET
    @Produces(CustomMediaType.APPLICATION_JSON_UTF)
    public List<TestResult> getAllTestResults() {
        TestResultRepository repository = new TestResultRepository();
        return repository.getAllTestResults();
    }

    @GET
    @Path("/{param}")
    @Produces(CustomMediaType.APPLICATION_JSON_UTF)
    public TestResult getOneTestResult(@PathParam("param") int msg) throws SQLException {
        TestResultRepository repository = new TestResultRepository();
        return repository.getTestResult(msg);
    }

    @POST
    @Consumes(CustomMediaType.APPLICATION_JSON_UTF)
    public Response postTestResult(TestResult testResult) {

        String result = "Test result added";
        System.out.println("    ########    " + result);
        TestResultRepository repository = new TestResultRepository();
        if (repository.addTestResult(testResult)) {
            return Response.status(Response.Status.CREATED).entity(result).build();
        } else
            return Response.status(Response.Status.BAD_REQUEST).entity("Kunne ikke lagre test").build();
    }

}
