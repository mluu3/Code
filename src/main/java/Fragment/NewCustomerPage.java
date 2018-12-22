package Fragment;

import static Ultil.WaitUtils.waitForElementVisible;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.name;

import org.jboss.arquillian.graphene.Graphene;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewCustomerPage {

    @FindBy(name = "name")
    WebElement nameInput;

    @FindBy(name = "rad1")
    List<WebElement> sexs;

    @FindBy(name = "addr")
    WebElement address;

    @FindBy(name = "city")
    WebElement city;

    @FindBy(name = "state")
    WebElement state;

    @FindBy(name = "pinno")
    WebElement pin;

    @FindBy(name = "telephoneno")
    WebElement telephoneNumber;


    public static final NewCustomerPage getInstance(SearchContext context) {
        return Graphene.createPageFragment(NewCustomerPage.class,
                waitForElementVisible(className("layout"), context));
    }

    public NewCustomerPage setName(String name) {
        waitForElementVisible(nameInput).clear();
        waitForElementVisible(nameInput).sendKeys(name);
        return this;
    }

    public NewCustomerPage setSex(boolean isFemale) {
        if (isFemale) {
            setSex("f");
        } else {
            setSex("m");
        }
        return this;
    }

    private void setSex(String sexLetter) {
        sexs.stream()
                .filter(sex -> sex.getAttribute("value").equals(sexLetter))
                .findFirst()
                .get()
                .click();
    }
}
