package abstracts;

import static java.lang.String.format;

import Fragment.LoginFragment;
import Fragment.NewCustomerPage;
import org.json.JSONException;

public abstract class AbstractUITest extends AbstractTest {

    protected static final String PAGE_NEW_CUSTOMER = "addcustomerpage.php";

    protected void signIn(String userID, String password) throws JSONException {
        openUrl(getRootUrl());
        LoginFragment.getInstance(browser).login(userID, password);
    }

    public NewCustomerPage initNewCustomerPage() {
        openUrl(PAGE_NEW_CUSTOMER);
        return NewCustomerPage.getInstance(browser);
    }
}
