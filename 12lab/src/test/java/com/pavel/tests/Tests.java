package com.pavel.tests;

import com.pavel.model.User;
import com.pavel.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.pavel.page.HomePage;


public class Tests extends CommonConditions {

    @Test
    public void AHasAutority(){
        User user = new User("psharilov@mail.ru", "asdfghjk");
        String name = new HomePage(driver)
                .openPage()
                .visitLoginPage()
                .login(user)
                .checkLoginText();
        Assert.assertNotEquals("Личный кабинет (вход)",name);
    }

    @Test
    public void BAddReview(){
        String review = new HomePage(driver)
                .openPage()
                .findProduct("337427")
                .goProductOnly()
                .goReviewPage()
                .addReview("Pavel", "AutomationTest(StudentUniversityTask)", "PleaseNotBanned", "+asdasdasdasdasdasdasd", "-asdasdasdasdasdasdasd")
                .getReviewText();
        Assert.assertEquals("Добавить отзыв",review);
    }

    @Test
    public void COpenSalesPage(){
        String sum = new HomePage(driver)
                .openPage()
                .visitSalesPage()
                .getPageUrl();
        Assert.assertEquals("https://scentre.by/catalogs/discounts",sum);
    }

    @Test
    public void DaddToShoppingCart(){
        String productname = new HomePage(driver)
                .openPage()
                .findProduct("337157")
                .addToShopCartClick()
                .goToShopCart()
                .getProductName();

        String productname2 = new HomePage(driver)
                .openPage()
                .findProduct("337159")
                .addToShopCartClick()
                .goToShopCart()
                .getProductName2();

        Assert.assertEquals("Фотоаппарат Sony ZV-1 Lite kit", productname2);
        Assert.assertEquals("Фотоаппарат Sony ZV-1", productname);

    }


    @Test
    public void FLogOut(){
        String name = new HomePage(driver)
                .openPage()
                .visitLogoutPage()
                .checkLoginText();
        Assert.assertNotEquals("perm_identity Личный(вход)",name);

    }

    @Test
    public void LowAndHighRegSearching (){
        String productname = new HomePage(driver)
                .openPage()
                .findProduct("PLAYSTATION")
                .addToShopCartClick()
                .goToShopCart()
                .getProductName();

        String productname2 = new HomePage(driver)
                .openPage()
                .findProduct("playstation")
                .addToShopCartClick()
                .goToShopCart()
                .getProductName2();

        Assert.assertEquals(productname, productname2);


    }

    //Добавление товара во вкладку "Избранное"
    @Test
    public void addToFavorite(){
        String favorite = new HomePage(driver)
                .openPage()
                .findProduct("337427")
                .addToFavorites()
                .FindFavorite();
        Assert.assertEquals(null ,favorite);
    }

    @Test
    public void tSearchReg(){

    }

    @Test
    public void Gaddcount(){
        String productname = new HomePage(driver)
                .openPage()
                .findProduct("337427")
                .addToShopCartClickwithCount()
                .goToShopCart()
                .getProductCount();
        Assert.assertEquals("70", productname);
    }


    @Test
    public void findProductByCode(){
        String favorite = new HomePage(driver)
                .openPage()
                .findProduct("337427")
                .findName();
        Assert.assertEquals("Беззеркальный фотоаппарат Sony a7 III Body",favorite);
    }

    @Test
    public void addToShoppingCart(){
        String productname = new HomePage(driver)
                .openPage()
                .findProduct("337427")
                .addToShopCartClick()
                .goToShopCart()
                .getProductName();
        Assert.assertEquals("Беззеркальный фотоаппарат Sony a7 III Body", productname);


    }

}
