package Utils.AllureUtils;

import Utils.FileUtil.FileClass;
import Utils.LogUtil.LogClass;
import io.qameta.allure.Allure;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import static Utils.TerminalUtil.TerminalClass.executeTerminal;

public class AllureClass {
    //add log to allure
    public static void addLogToAllure() {
        File logFile = FileClass.getLastFile(LogClass.logPath);

        try {
            assert logFile != null;
            Allure.addAttachment("logFile", Files.readString(logFile.toPath()));
            LogClass.info("log added to allure report");
        } catch (Exception e) {
            LogClass.error("fail to add allure log" + e.getMessage());
        }

    }

    //add screenshot to allure
    public static void addScreenshotToAllure(String screenName, String screenPath) {
        try {
            Allure.addAttachment(screenName, Files.newInputStream(Path.of(screenPath)));
            LogClass.info("screenshot added to allure report");
        } catch (Exception e) {
            LogClass.error("fail to add allure screenshot" + e.getMessage());
        }
    }

    //generate allure
    static String ALLURE_Path = "test-output/target/allure-results/";
    static String ALLURE_Report = "test-output/allure-report/";
    static String USER_HOME = System.getProperty("user.home");
    static String Allure_Bin = USER_HOME + File.separator + ".m2" + File.separator + "repository" + File.separator + "allure" + File.separator + "allure-2.34.1" + File.separator + "bin" + File.separator + "allure";
    //C:\Users\Mahmoud\.m2\repository\allure\allure-2.34.1\bin

    public static void generateAllure() {
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            String ALLURE_WIn = Allure_Bin + ".bat";
            executeTerminal(ALLURE_WIn, "generate", ALLURE_Path, "-o", ALLURE_Report, "--clean", "--single-file");
            LogClass.info("allure report generated on platform windows ");
        } else {
            executeTerminal(Allure_Bin, "generate", ALLURE_Path, "-o", ALLURE_Report, "--clean", "--single-file");
            LogClass.info("allure report generated on platform linux ");
        }
    }


    //open allure
    public static void openAllure() {
        String Allure_Index = ALLURE_Report + File.separator + "index.html";
        if (System.getProperty("openAllure").equals("true")) {
            executeTerminal("cmd", "/c", "start", Allure_Index);
            LogClass.info("allure report opened");
        } else {
            LogClass.info("allure report not opened");
        }


    }


}
