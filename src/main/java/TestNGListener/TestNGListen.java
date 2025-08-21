package TestNGListener;

import Utils.AllureUtils.AllureClass;
import Utils.FileUtil.FileClass;
import Utils.LogUtil.LogClass;
import org.testng.*;

import java.io.File;

import static Utils.AllureUtils.AllureClass.generateAllure;
import static Utils.AllureUtils.AllureClass.openAllure;
import static Utils.DataUtil.ReadPropertiesFiles.loadPropertyFiles;
import static Utils.UtilPackage.UtilClass.takeScreenshot;

public class TestNGListen implements IExecutionListener, ITestListener, IInvokedMethodListener {

    File allurePath = new File("test-output/target/allure-results/");
    File logPath = new File("test-output/Logs/");

    @Override
    public void onExecutionStart() {
        LogClass.info("Execution started");
        loadPropertyFiles();

        FileClass.deleteFolder(allurePath);
        LogClass.info("Previous Allure files  deleted");

        FileClass.deleteFolder(logPath);
        LogClass.info("Previous Log files  deleted");

    }

    @Override
    public void onExecutionFinish() {
        LogClass.info("Execution finished");
        generateAllure();
        openAllure();
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            switch (testResult.getStatus()) {
                case ITestResult.SKIP -> takeScreenshot("Skipped" + testResult.getName());
                case ITestResult.SUCCESS -> takeScreenshot("Passed_" + testResult.getName());
                case ITestResult.FAILURE -> takeScreenshot("Failed_" + testResult.getName());
            }
            AllureClass.addLogToAllure();
        }


    }

    @Override
    public void onTestStart(ITestResult result) {
        LogClass.info("Test Case", result.getName(), "started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogClass.info("Test Case", result.getName(), "passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogClass.error("Test Case", result.getName(), "failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogClass.info("Test Case", result.getName(), "skipped");
    }

    @Override
    public void onStart(ITestContext context) {
        LogClass.info("Test Suite", context.getName(), "started");
    }

    @Override
    public void onFinish(ITestContext context) {
        LogClass.info("Test Suite", context.getName(), "finished");
    }


}
