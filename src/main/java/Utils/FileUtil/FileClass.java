package Utils.FileUtil;

import Utils.LogUtil.LogClass;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class FileClass {

    //get last file
    public static File getLastFile(String file) {
        File file1 = new File(file);
        if (!file1.exists()) {
            LogClass.info("File does not exist");
            return null;
        }

        File[] files = file1.listFiles();
        assert files != null;
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        return files[0];

    }


    //delete folder
    public static void deleteFolder(File folder) {
        try {
            FileUtils.deleteQuietly(folder);
            LogClass.info("Deleting folder " + folder);
        } catch (Exception e) {
            LogClass.error("Exception occured while deleting folder " + e.getMessage());
        }
    }


}
