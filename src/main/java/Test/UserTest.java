package Test;

import static org.testng.Assert.assertEquals;

import abstracts.AbstractProjectTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTest extends AbstractProjectTest {

    @BeforeClass(alwaysRun = true)
    public void loadProperties() {
        System.out.print("Minh");
    }

    @Test(dependsOnGroups = "createProject")
    public void createNewCustomer() {
        initNewCustomerPage()
                .setName("Minh")
                .setSex(false);
        assertEquals(1, 2);
    }
}
