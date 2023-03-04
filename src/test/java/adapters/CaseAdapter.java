package adapters;

import io.restassured.mapper.ObjectMapperType;
import models.Case;
import org.apache.http.HttpStatus;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class CaseAdapter {

    public Case add(Case addCase, int sectionId) {
        return given()
                .pathParam("section_id", sectionId)
                .body(addCase, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.ADD_CASE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Case.class, ObjectMapperType.GSON);
    }

    public void delete(int caseID) {
        given()
                .pathParam("case_id", caseID)
                .when()
                .post(Endpoints.DELETE_CASE)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    public Case get(int caseID) {
        return given()
                .pathParam("case_id", caseID)
                .get(Endpoints.GET_CASE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Case.class, ObjectMapperType.GSON);
    }

    public Case update(int caseID, Case updateCase) {
        return given()
                .pathParam("case_id", caseID)
                .body(updateCase, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.UPDATE_CASE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Case.class);
    }

    public void moveCaseToSection(Case caseTest, int sectionID) {
        given()
                .pathParam("section_id", sectionID)
                .body(caseTest)
                .when()
                .post(Endpoints.MOVE_CASES_TO_SECTION)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}
