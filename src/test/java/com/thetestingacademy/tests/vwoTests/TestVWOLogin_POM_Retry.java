package com.thetestingacademy.tests.vwoTests;

import com.thetestingacademy.base.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.listeners.RetryAnalyzer;
import com.thetestingacademy.pages.pageObjectModel.LoginPage_POM;
import com.thetestingacademy.utils.PropertyReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestVWOLogin_POM_Retry extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_POM_Retry.class);


    @Test(groups = "qa")
    @Owner("Promode")
    @Description("TC1 - Verify with the invalid login, error message is displayed.")
    public void testLoginNegativeVWO() {
        logger.info("Starting the Testcases");
        String key = System.getenv("Password");

        LoginPage_POM loginPagePom = new LoginPage_POM(DriverManager.getDriver());
        logger.info("Opening the URL");
        String error_msg_text = loginPagePom.loginToVWOInvalidCreds(PropertyReader.readKey("invalid_username"), PropertyReader.readKey("invalid_password"));
        logger.info("Verifying the Username is the" +error_msg_text);
        assertThat(error_msg_text).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg_text, PropertyReader.readKey("error_message"));

    }

    @Test(groups = {"sanity","P0"})
    @Owner("Promode")
    @Description("TC1 - Verify with the invalid login, error message is displayed.")
    public void testLoginNegativeVW2() {
        Assert.assertEquals(true,false);
    }

    @Test(groups = {"smoke","P0"})
    @Owner("Promode")
    @Description("TC1 - Verify with the invalid login, error message is displayed.")
    public void testLoginNegativeVW3() {
        Assert.assertEquals(true,false);
    }

}
