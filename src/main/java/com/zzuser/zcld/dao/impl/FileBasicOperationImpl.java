package com.zzuser.zcld.dao.impl;

import com.zzuser.zcld.dao.FileBasicOperation;
import com.zzuser.zcld.model.filemodel.MyFile;
import com.zzuser.zcld.model.filemodel.MyFileImpl;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileBasicOperationImpl implements FileBasicOperation {

    @Override
    public boolean deleteByFilePath(String filePath) {
        File file = new File(filePath);
        return file.delete();
    }

    @Override
    public boolean insertFile(String filePath) {
        File file = new File(filePath);
        try {
            return file.createNewFile();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean insertDir(String filePath) {
        File file = new File(filePath);
        try {
            return file.mkdir();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public MyFile selectByFilePath(String filePath) {
        try {
            return new MyFileImpl(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<MyFile> selectAll(String fileParentPath,boolean all) {
        List<MyFile> myFileList = new ArrayList<>();
        File parent = new File(fileParentPath);
        File[] myFiles = parent.listFiles();
        if (myFiles == null) {
            return null;
        }
        for (File file : myFiles) {
            MyFile myFile= null;
            try {
                myFile = new MyFileImpl(file.getPath());
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
            if(all){
                if (((MyFileImpl) myFile).isHidden()){
                    continue;
                }
            }
            myFileList.add(myFile);
        }
        return myFileList;
    }

    @Override
    public void copyByFilePath(String sourceFilePath, String targetDirPath) {

        File sourceFile = new File(sourceFilePath);
        File targetDir = new File(targetDirPath);
        if (!targetDir.exists()) {
            targetDir.mkdir();
        }

        if (sourceFile.isDirectory()) {
            File des = new File(targetDir.getPath() + File.separator
                    + sourceFile.getName());
            des.mkdir(); // 在目标文件夹中创建相同的文件夹
            File[] files = sourceFile.listFiles();
            for (File file : files) {
                copyByFilePath(file.getPath(), des.getPath());
            }
        } else {
            File targetFile = new File(targetDir.getPath() + "/" + sourceFile.getName());
            fileCopy(sourceFile, targetFile);
        }
    }

    private void fileCopy(File s, File t) {
        FileInputStream fi = null;

        FileOutputStream fo = null;

        FileChannel in = null;

        FileChannel out = null;

        try {

            fi = new FileInputStream(s);

            fo = new FileOutputStream(t);

            in = fi.getChannel();//得到对应的文件通道

            out = fo.getChannel();//得到对应的文件通道

            in.transferTo(0, in.size(), out);//连接两个通道，并且从in通道读取，然后写入out通道

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (fi != null) {
                    fi.close();
                }

                if (in != null) {
                    in.close();
                }

                if (fo != null) {
                    fo.close();
                }

                if (out != null) {
                    out.close();
                }

            } catch (IOException e) {

                e.printStackTrace();

            }

        }
    }
}
