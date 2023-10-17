import Pages.P01HomePage;
import Pages.P05OrderPage;
import org.testng.annotations.Test;

public class C04Order extends C01TestBase {

    protected P05OrderPage order;

    @Test()
    public void Order ()
    {
        home = new P01HomePage(driver);

        order = new P05OrderPage(driver);

        home.closePopup();
        home.registerBtn();

        order.EnterEmail("keroemad451@gmail.com");
        order.EnterPass("Asd@12312");
        order.submitBtn();
        home.closePopup();
        order.GetYBtn();
        order.shopBtn();
        order.Gift1Btn();
        order.cart1Btn();
        order.shopBtn();
        order.basketBtn();
        order.cart2Btn();
        order.viewCartBtn();
        order.addCoupon("1010");
        order.applyBtn();
        order.cashBtn();
        order.acceptBtn();
        order.checkOutBtn();
        order.orderListBtn();
    }
}
