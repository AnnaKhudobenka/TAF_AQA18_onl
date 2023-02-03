package baseEntities;

import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

public class BaseStep{
    protected ProductsPage productsPage;
    protected CartPage cartPage;
    protected CheckoutPage checkoutPage;
    protected LoginPage loginPage;

    public BaseStep() {
        productsPage = new ProductsPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        loginPage = new LoginPage();
    }

}
