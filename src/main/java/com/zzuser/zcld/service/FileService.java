package com.zzuser.zcld.service;

import com.zzuser.zcld.model.filemodel.MyFile;

import java.util.List;

public interface FileService {
    boolean deleteByFilePath(String filePath);

    boolean insertFile(String filePath);

    boolean insertDir(String filePath);

    MyFile selectByFilePath(String filePath);

    List<MyFile> selectAll(String fileParentPath, boolean all);

    void copyByFilePath(String sourceFilePath, String targetFilePath);
}
