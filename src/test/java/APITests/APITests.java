package APITests;

import APITests.models.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tools.Randomizer;

import java.util.Properties;


public class APITests {

    // class variables
    Properties apiProps = new Properties();
    private final int ownerId = Integer.parseInt(apiProps.getProperty("authUserId"));
    private final String baseUrl = apiProps.getProperty("baseUrl");
    private final String authUser = apiProps.getProperty("authUser");
    private final String authPassword = apiProps.getProperty("authPass");
    private final String jsonrpcVersion = apiProps.getProperty("jsonrpcVersion");
    private int userId;
    private int projectId;
    private int taskId;

    @BeforeMethod
    public void setUp(){
        //create base data with authorization as admin to all requests & connect allure report
        RestAssured.baseURI = baseUrl;
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType("application/json")
                .build()
                .given().auth().basic(authUser,authPassword)
                .filter(new AllureRestAssured());
    }

    @Test (testName = "Create User", priority = 1)
    public void createUser() {
        // build parameters to createUser request body with role app-admin
        CreateUserParams parameters = CreateUserParams.builder()
                .username(Randomizer.generateUsername())
                .password(Randomizer.generateInt(10000,1000000))
                .role("app-admin")
                .build();

        // build createUser request body
        BaseRequest body = BaseRequest.builder()
                .jsonrpc(jsonrpcVersion)
                .method("createUser")
                .id(Randomizer.generateInt(1,10000))
                .params(parameters)
                .build();

        // send createUser request
        Response response = RestAssured
                .given()
                .body(body)
                .post();

        // validate createUser response
        response.then().statusCode(200);
        response.prettyPrint();

        // get userId from createUser response
        userId = response.jsonPath().get("result");
    }

    @Test (testName = "Create Project", priority = 2)
    public void createProject() {
        // build parameters to createProject request body
        CreateProjectParams parameters = CreateProjectParams.builder()
                .name(Randomizer.generateCompanyName())
                .owner_id(ownerId)
                .build();

        // build createProject request body
        BaseRequest body = BaseRequest.builder()
                .jsonrpc(jsonrpcVersion)
                .method("createProject")
                .id(Randomizer.generateInt(1,10000))
                .params(parameters)
                .build();

        // send createProject request
        Response response = RestAssured
                .given()
                .body(body)
                .post();

        // validate createProject response
        response.then().statusCode(200);
        response.prettyPrint();

        // get projectId from createProject response
        projectId = response.jsonPath().get("result");
    }

    @Test (testName = "Create Task", priority = 3)
    public void createTask() {
        // build parameters to createTask request body
        CreateTaskParams parameters = CreateTaskParams.builder()
                .title(Randomizer.generateTaskName())
                .project_id(projectId)
                .owner_id(ownerId)
                .creator_id(ownerId)
                .build();

        // build createTask request body
        BaseRequest body = BaseRequest.builder()
                .jsonrpc(jsonrpcVersion)
                .method("createTask")
                .id(Randomizer.generateInt(1,10000))
                .params(parameters)
                .build();

        // send createTask request
        Response response = RestAssured
                .given()
                .body(body)
                .post();

        // validate createTask response
        response.then().statusCode(200);
        response.prettyPrint();

        // get taskId from createTask response
        taskId = response.jsonPath().get("result");
    }

    @Test (testName = "Remove Task", priority = 4)
    public void removeTask() {
        // build parameters to removeTask request body
        RemoveTaskParams parameters = RemoveTaskParams.builder()
                .task_id(taskId)
                .build();

        // build parameters to removeTask request body
        BaseRequest body = BaseRequest.builder()
                .jsonrpc(jsonrpcVersion)
                .method("removeTask")
                .id(Randomizer.generateInt(1,10000))
                .params(parameters)
                .build();

        // send removeTask request
        Response response = RestAssured
                .given()
                .body(body)
                .post();

        // validate removeTask response
        response.then().statusCode(200);
        response.prettyPrint();
        // validate that task was removed successfully
        Assert.assertEquals(response.jsonPath().get("result"),true);
    }

    @Test (testName = "Remove Project", priority = 5)
    public void removeProject() {
        // build parameters to removeUser request body
        RemoveProjectParams parameters = RemoveProjectParams.builder()
                .project_id(projectId)
                .build();

        // build parameters to removeProject request body
        BaseRequest body = BaseRequest.builder()
               .jsonrpc(jsonrpcVersion)
               .method("removeProject")
               .id(Randomizer.generateInt(1,10000))
               .params(parameters)
               .build();

        // send removeProject request
        Response response = RestAssured
               .given()
               .body(body)
               .post();

        // validate removeProject response
        response.then().statusCode(200);
        response.prettyPrint();
        // validate that project was removed successfully
        Assert.assertEquals(response.jsonPath().get("result"),true);
    }

    @Test (testName = "Remove User", priority = 6)
    public void removeUser() {
        // build parameters to removeUser request body
        RemoveUserParams parameters = RemoveUserParams.builder()
                .user_id(userId)
                .build();

        // build removeUser request body
        BaseRequest body = BaseRequest.builder()
                .jsonrpc(jsonrpcVersion)
                .method("removeUser")
                .id(Randomizer.generateInt(1,10000))
                .params(parameters)
                .build();

        // send removeUser request
        Response response = RestAssured
                .given()
                .body(body)
                .post();

        // validate removeUser response
        response.then().statusCode(200);
        response.prettyPrint();
        // validate that user was removed successfully
        Assert.assertEquals(response.jsonPath().get("result"),true);
    }
}
