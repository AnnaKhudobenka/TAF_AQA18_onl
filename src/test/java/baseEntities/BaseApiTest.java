package baseEntities;

import adapters.CaseAdapter;
import adapters.ProjectAdapter;
import adapters.SectionAdapter;
import configuration.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.Project;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.given;

public class BaseApiTest {
    protected CaseAdapter caseAdapter;
    protected ProjectAdapter projectAdapter;
    protected SectionAdapter sectionAdapter;
    protected Project project;
    protected int projectID;

    @BeforeTest
    public void setupApi() {
        RestAssured.baseURI = ReadProperties.getUrl();

        RestAssured.requestSpecification = given()
                .auth().preemptive()
                .basic(ReadProperties.username(), ReadProperties.password())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);

        caseAdapter = new CaseAdapter();
        projectAdapter = new ProjectAdapter();
        sectionAdapter = new SectionAdapter();

        project = projectAdapter.add(Project.builder()
                .nameA("Test_Project_001")
                .announcement("This is a description!!!")
                .type(1)
                .showAnnouncement(true)
                .build());

        projectID = project.getID();
    }

    @AfterSuite
    public void tearDown() {
        if (projectID > 0) {
            projectAdapter.delete(projectID);
        }
    }
}
