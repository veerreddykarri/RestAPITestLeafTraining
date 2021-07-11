package testng;

import org.testng.annotations.Test;

public class TestCase2 {
    @Test(dependsOnMethods = {"testng.TestCase1.testCase1"})
    public void testCase2(){
        System.out.println("Test Case2");
    }
}
