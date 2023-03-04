package tests;

import baseEntities.BaseApiTest;
import models.Case;
import models.Section;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.Collections;

public class CasesTest extends BaseApiTest {
    private int caseID;

    @Test
    public void getCase() {
        Case addCase = Case.builder()
                .title("Case_001")
                .priority_id(2)
                .estimate(null)
                .build();

        Case expectedCase = caseAdapter.add(addCase, 1);
        caseID = expectedCase.getId();

        Case actualCase = caseAdapter.get(caseID);

        Assert.assertEquals(actualCase, expectedCase);
    }

    @Test(dependsOnMethods = "getCase")
    public void updateCase() {
        Case expectedCase = Case.builder()
                .id(caseID)
                .title("Case_002")
                .priority_id(3)
                .estimate("10m")
                .build();

        Case actualCase = caseAdapter.update(caseID, expectedCase);

        Assert.assertEquals(actualCase, expectedCase);
    }

    @AfterTest
    public void deleteCase() {
        if (caseID > 0) {
            caseAdapter.delete(caseID);
        }
    }

    @Test
    public void moveCaseToSectionTest() {
        Case addCase = Case.builder()
                .title("Case_001")
                .priority_id(2)
                .estimate(null)
                .build();

        Section addSection = Section.builder()
                .name("newSection")
                .build();

        Section newSection = sectionAdapter.add(addSection, projectID);
        int sectionID = newSection.getId();

        Case expectedCase = caseAdapter.add(addCase, sectionID);
        caseID = expectedCase.getId();

        Case caseTest = Case.builder()
                .case_ids(Collections.singletonList(caseID))
                .build();

        caseAdapter.moveCaseToSection(caseTest, sectionID);
    }
}
