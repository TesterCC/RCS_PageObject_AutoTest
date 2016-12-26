package com.rcstest.utils;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

/**
 * Created by Li Yanxi on 2016/3/28.
 * Class is for create directory and file.
 */
public class FileUtil {
    private static final Logger logger  =  Logger.getLogger(FileUtil.class);

    public static boolean createFile(String destFileName) {
        File file = new File(destFileName);
        if (file.exists()) {
            logger.error("Create single file " + destFileName + " Failed. File is existed.");
            return false;
        }
        if (destFileName.endsWith(File.separator)) {
            logger.error("Create single file " + destFileName + " Failed. File cannot be a directory.");
            return false;
        }

        //determing the path directory of target file is existed or not.
        if(!file.getParentFile().exists()){
            //if the parent directory of target file is not existed, create parent dirctory.
            logger.info("Parent directory is not existed. Prepared to create it.");

            if(!file.getParentFile().mkdirs()){
                logger.error("Create target file parent directory failed.");
                return false;
            }

        }


        //Create target file
        try {
            if (file.createNewFile()){
                logger.info("Create file "+destFileName+" success.");
                return true;
            } else {
                logger.error("Create file "+destFileName+" failed.");
                return false;
            }
        }catch (IOException e){
            e.printStackTrace();
            logger.error("Create single file " + destFileName + "failed." + e.getMessage());
            return false;

        }
    }


    public static boolean createDir(String destDirName){
        File dir = new File(destDirName);
        if (dir.exists()){
            logger.error("Create directory "+destDirName+" failed, target is existed.");
            return  false;
        }

        //create directory
        if (dir.mkdirs()){
            logger.info("Create directory " +destDirName+ " success.");
            return true;
        }else{
            logger.error("Create directory "+destDirName+" failed.");
            return false;
        }
    }

}
