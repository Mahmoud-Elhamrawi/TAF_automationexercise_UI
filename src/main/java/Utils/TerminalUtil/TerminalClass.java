package Utils.TerminalUtil;

import Utils.LogUtil.LogClass;

public class TerminalClass {
    public static void executeTerminal(String ...commands) {
     try {
         ProcessBuilder processBuilder = new ProcessBuilder(commands);
         processBuilder.inheritIO();
         Process process = processBuilder.start();
         process.waitFor();
         LogClass.info("executing terminal commands");
     }catch (Exception e)
     {
         LogClass.error("failed to execute terminal "+e.getMessage());
     }



    }

}
