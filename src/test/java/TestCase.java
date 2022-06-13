import org.testng.annotations.Test;

public class TestCase {

    @Test(priority = 1)
    void setup() {
        System.out.println("inside setup");
    }

    @Test(priority = 2)
    void begin() {
        System.out.println("start test here");
    }

    @Test(priority = 3)
    void end() {
        System.out.println("Test ends here");
    }
}
