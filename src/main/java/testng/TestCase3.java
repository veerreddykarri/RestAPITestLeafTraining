package testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestCase3 {
    @Test(dependsOnMethods = {"testng.TestCase1.testCase1","testng.TestCase2.testCase2"})
    public void testCase3(){
        System.out.println("Test Case3");
    }
}
