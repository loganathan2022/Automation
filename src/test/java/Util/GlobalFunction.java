
package Util;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import cucumber.api.Scenario;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class GlobalFunction  {
    public static WebDriver driver;

    public static GlobalFunction INSTANCE = new GlobalFunction();
    public static Scenario scenario;

    @Before
    public void startTest(Scenario scenario) throws IOException {
        GlobalFunction.scenario=scenario;
        System.out.println("***************************************************************");
        System.out.println(scenario.getId());
        System.out.println(scenario.getName());
        System.out.println(scenario.getStatus());
        System.out.println("***************************************************************");
        System.out.println("###############################################################");
        System.out.println("\n");

    }


    @After
    public static void TearDown() throws Exception {
        if (scenario.isFailed()) {
            try {

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                BufferedImage image = Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).getImage();
                ImageIO.write(image, "png", baos);
                baos.flush();
                scenario.embed(baos.toByteArray(), "image/png");
                //driver.quit();
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                driver.quit();
            }
        }
        driver.quit();

    }
    public static void Screenshot() {
        if (!scenario.isFailed()) {
            try {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                BufferedImage image = Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).getImage();
                ImageIO.write(image, "png", baos);
                baos.flush();
                scenario.embed(baos.toByteArray(), "image/png");

            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }

    //Create instance for Resuable function
    public static GlobalFunction getInstance() {
        return INSTANCE;
    }
}
