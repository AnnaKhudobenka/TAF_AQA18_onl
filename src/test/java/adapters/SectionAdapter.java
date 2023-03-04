package adapters;

import io.restassured.mapper.ObjectMapperType;
import models.Section;
import org.apache.http.HttpStatus;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class SectionAdapter {

    public Section add(Section section, int project_id) {
        return given()
                .pathParam("project_id", project_id)
                .body(section, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.ADD_SECTION)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Section.class, ObjectMapperType.GSON);
    }
}
