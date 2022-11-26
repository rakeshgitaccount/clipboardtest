package in.amazon.clipboard.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SampleTestNgTests {
	
	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void initTest(String browser) {
		System.out.println(browser);
	}

    @Test
    public void aTest(){
        System.out.println("a test");
    }

    @Test
    public void bTest(){
        System.out.println("b test");
    }
}
