package genericUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerUtility extends BaseClass implements ITestListener, ISuiteListener {

	public ExtentReports report;
	public static ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("========"+result.getName()+"=======");
		test = report.createTest(result.getName());
		test.log(Status.INFO,result.getName()+"=====STARTED=====");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		 TakesScreenshot ts = (TakesScreenshot)driver;
		String filepath= ts.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(filepath,result.getName()+"_"+time);
		test.log(Status.FAIL, result.getName()+"=====FAILED=====");
	}

	@Override
	public void onStart(ISuite suite) {
	
		System.out.println("===Report configuration===");
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report"+time+".html");
		spark.config().setDocumentTitle("VTiger Test suite Result");
		spark.config().setReportName("VTiger report");
		spark.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS","Windows-10");
		report.setSystemInfo("BROWSER","chrome");
		
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}
	

}
