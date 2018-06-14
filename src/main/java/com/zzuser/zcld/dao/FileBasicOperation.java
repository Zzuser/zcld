package com.zzuser.zcld.dao;

import com.zzuser.zcld.model.filemodel.MyFile;

import java.io.File;
import java.util.List;

public interface FileBasicOperation {

    boolean deleteByFilePath(String filePath);

    boolean insertFile(String filePath);

    boolean insertDir(String filePath);

    MyFile selectByFilePath(String filePath);

    List<MyFile> selectAll(String fileParentPath, boolean all);

    void copyByFilePath(String sourceFilePath, String targetFilePath);
}
