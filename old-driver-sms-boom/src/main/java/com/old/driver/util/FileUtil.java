package com.old.driver.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * @author finup
 *
 */
public class FileUtil {
    public static String FATHER_FILE_PATH = PropertiesUtil.getProps("FATHER_FILE");

    public static final String UTF_8 = "UTF-8";

    public static final String GBK = "GBK";

    private static Logger logger = Logger.getLogger(FileUtil.class);

    private FileUtil() {
    }

    /**
     * 生成文件
     * 
     * @param fileContent 文件的内容
     * @param filePath 文件路径；
     * @param fileName 文件的文件名；
     * @param isappendContent 是否追加
     */
    public static void writeStrings(String fileContent, String filePath, String fileName,
            boolean isappendContent) {
        try {
            // 创建文件夹
            File file = new File(filePath);
            if (!file.exists() || !file.isDirectory()) {
                makeDir(file);
            }
            logger.info(filePath + "创建成功！");
            FileUtils.write(new File(file, fileName), fileContent, UTF_8, isappendContent);
        } catch (IOException ex) {
            logger.error(ex.getMessage(), ex);
        }
    }

    /**
     * 生成文件
     * 
     * @param fileContent 文件的内容
     * @param fileName 文件的文件名；
     * @param isWriteNewContent 覆盖原文件 或追加新内容
     */
    public static void writeFile(String fileContent, String dir, String fileName, boolean isWriteNewContent,
            InputStream in) {
        File file = new File(dir);
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        try {
            if (isWriteNewContent) {

                FileUtils.write(new File(file, fileName), fileContent, UTF_8, false);

            } else {

                FileUtils.copyInputStreamToFile(in, new File(file, fileName));
            }

        } catch (IOException ex) {
            logger.error(ex.getMessage(), ex);
        }
    }

    /**
     * 读取文件
     * 
     * @param src
     * @return
     */
    public static String read(File src) {
        StringBuilder res = new StringBuilder();
        String line = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(src));
            while ((line = reader.readLine()) != null) {
                if (!line.trim().equals("")) {
                    String frist = line.substring(0, 1);
                    if (!frist.equals("#")) {
                        res.append(line + "\n").toString();
                    }
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage(), e);
        } catch (IOException ex) {
            logger.error(ex.getMessage(), ex);
        }
        return res.toString();
    }

    /**
     * 读取文件
     * 
     * @param src
     * @return
     */
    public static List<String> reads(File src) {
        List<String> res = new ArrayList<>();
        String line = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(src));
            while ((line = reader.readLine()) != null) {
                if (!line.trim().equals("")) {
                    String frist = line.substring(0, 1);
                    if (!frist.equals("#")) {
                        res.add(line.trim());
                    }
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage(), e);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return res;
    }

    /**
     * 重命名文件夹
     * 
     * @param src
     * @param dest
     * @return
     */
    public static boolean renameToNewFile(String src, String dest) {
        File srcDir = new File(src);
        boolean isOk = false;
        File newFile = new File(dest);
        isOk = srcDir.renameTo(newFile);
        logger.info("rename " + src + " to + " + dest + " is OK ? :" + isOk);
        return isOk;
    }

    /**
     * 重命名文件夹
     * 
     * @param src
     * @param dest
     * @return
     */
    public static boolean renameToNewFile(String path, String oldname, String newname) {
        File srcDir = new File(path + File.separator + oldname);
        boolean isOk = false;
        isOk = srcDir.renameTo(new File(path + File.separator + newname));
        logger.info("renameToNewFile is OK ? :" + isOk);
        return isOk;
    }

    public static File makeDir(File dir) throws IOException {
        if (!dir.exists() || !dir.isDirectory()) {
            dir.mkdirs();
        }
        return dir;
    }

    public static File makeDir(String dir) throws IOException {
        return makeDir(new File(dir));
    }

    public static File createFile(File file) throws IOException {
        if (!file.exists() || file.isDirectory()) {
            makeDir(file.getParentFile());
        }
        return file;
    }

    public static File createFile(String file) throws IOException {
        return createFile(new File(file));
    }

    /**
     * 返回 basepath/20151024/type, 日期是从进号里截取的
     * 
     * @author zhuyuhang
     * @param base
     * @param date
     * @return
     */
    public static String getCrawlerFilePath(String basePath, String applyNo, String type) {
        String date = applyNo.length() < 11 ? applyNo : applyNo.substring(3, 11);
        date = date + File.separatorChar + applyNo + File.separatorChar + type;
        return new File(StringUtils.isBlank(basePath) ? FATHER_FILE_PATH : basePath, date).getAbsolutePath();
    }

    public static String getCrawlerFilePath(String applyNo, String type) {
        return getCrawlerFilePath(null, applyNo, type);
    }
}
