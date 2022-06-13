import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class seleniumBlogTest {
            private WebDriver driver;
            private String userName = "vivi36";
            private  String email = "vivi36@mailinator.com";

        @BeforeTest
        public void begin() throws InterruptedException {
            //Locate Chrome Driver directory
            System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
            //Open your browser
            driver = new ChromeDriver();
            //enter application url
            driver.get("https://selenium-blog.herokuapp.com/");
            //Test 1: Verify the user input right url in the webpage
            if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/"))
                //pass
                System.out.println("Correct Web page");
            else
                //fail
                System.out.println("Wrong Webpage");
            Thread.sleep(5000);
            //maximise the screen
            driver.manage().window().maximize();
            Thread.sleep(5000);
            //click sign up
            driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
            //Test 2:Verify that when user clicks on the signup button, the user is directed to signup page
            if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/signup"))
                //pass
                System.out.println("Welcome to signup page");
            else
                //fail
                System.out.println("This is NOT a signup page");
            Thread.sleep(5000);
        }

        @Test(priority = 0)
        public void positiveSignUp()throws InterruptedException{
            driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
            System.out.println("Run positive Sign up");
            Thread.sleep(5000);
            //input Username
            driver.findElement(By.id("user_username")).sendKeys(userName);
            Thread.sleep(5000);
            //input email address
            driver.findElement(By.id("user_email")).sendKeys(email);
            Thread.sleep(5000);
            //input password
            driver.findElement(By.id("user_password")).sendKeys("admin");
            Thread.sleep(5000);
            //Test 7: Verify that user is successfully signed up when the valid details is inputted
            if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/signup"))
                //pass
                System.out.println("Welcome to Alpha blog Signup Successfully");
            else
                //fail
                System.out.println("Wrong Webpage");
            //click Sign up button
            driver.findElement(By.id("submit")).click();
            Thread.sleep(5000);
        }

        @Test(priority = 1)
        public void clickUser1() throws InterruptedException {
            //click users
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
            //Test 8: Verify that user1 item is present on the item list page
            String expectedUrlPage = "https://selenium-blog.herokuapp.com/users";
            String actualUrlPage =driver.getCurrentUrl();
            if (actualUrlPage.contains(expectedUrlPage))
                //pass
                System.out.println("User1 is present in the page");
            else
                //fail
                System.out.println("User1 is not present");
                Thread.sleep(5000);
        }

        @Test(priority = 2)
        public void verifyElementIsPresent()throws InterruptedException {
            //confirm element is present
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
            //Test 9:Verify that item searched for on the user1 page is present
            String expectedUrlPage = "https://selenium-blog.herokuapp.com/articles/59";
            String actualUrlPage =driver.getCurrentUrl();
            if (actualUrlPage.contains(expectedUrlPage))
                //pass
                System.out.println("Items are present in this page");
            else
                //fail
                System.out.println("Items are not  present in theis page");
            Thread.sleep(5000);
        }

        @Test(priority = 3)
        public void logOutSuccessfully()throws InterruptedException{
            //log out
            driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
            //Test
            String expectedUrlPage = "https://selenium-blog.herokuapp.com/";
            String actualUrlPage =driver.getCurrentUrl();
            if (actualUrlPage.contains(expectedUrlPage))
                //pass
                System.out.println("You have logged out");
            else
                //fail
                System.out.println("You have NOT logged out");
            Thread.sleep(5000);
        }

        @Test(priority = 4)
        public void InvalidSignUp()throws InterruptedException {
            driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
            System.out.println("Run negative Sign up Invalid details");
            Thread.sleep(5000);
            //input Username
            driver.findElement(By.id("user_username")).sendKeys("vi");
            Thread.sleep(5000);
            //input email address
            driver.findElement(By.id("user_email")).sendKeys("vi@mailator.com");
            Thread.sleep(5000);
            //input password
            driver.findElement(By.id("user_password")).sendKeys("ad");
            Thread.sleep(5000);
            //Test 7: Verify that user is successfully signed up when the valid details is inputted
            if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/signup"))
                //pass
                System.out.println("Welcome to Alpha blog Signup Successfully");
            else
                //fail
                System.out.println("Wrong Webpage");
            //click Sign up button
            driver.findElement(By.id("submit")).click();
            Thread.sleep(5000);

        }

        @Test(priority = 5)
        public void signUpWithBlankUsername()throws InterruptedException {
            System.out.println("Sign up with blank username");
            //click on sign up
            driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
           //Test : Verify the user cannot sign up with either/all the input blank
            Thread.sleep(5000);
            //input Username
            driver.findElement(By.id("user_username")).sendKeys("");
            Thread.sleep(5000);
            //input email address
            driver.findElement(By.id("user_email")).sendKeys(email);
            Thread.sleep(5000);
            //input password
            driver.findElement(By.id("user_password")).sendKeys("admin");
            Thread.sleep(5000);
            driver.findElement(By.id("submit")).click();
            Thread.sleep(5000);
        }


        @AfterTest
        public void closeBrowser(){
            //Quit your browser
            driver.quit();

        }
    }
