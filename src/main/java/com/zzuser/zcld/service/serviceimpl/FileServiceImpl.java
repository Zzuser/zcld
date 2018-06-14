package com.zzuser.zcld.service.serviceimpl;

import com.zzuser.zcld.dao.FileBasicOperation;
import com.zzuser.zcld.model.filemodel.MyFile;
import com.zzuser.zcld.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    FileBasicOperation fileBasicOperation;

    @Override
    public boolean deleteByFilePath(String filePath) {
        return fileBasicOperation.deleteByFilePath(filePath);
    }

    @Override
    public boolean insertFile(String filePath) {
        return fileBasicOperation.insertFile(filePath);
    }

    @Override
    public boolean insertDir(String filePath) {
        return fileBasicOperation.insertDir(filePath);
    }

    @Override
    public MyFile selectByFilePath(String filePath) {
        return fileBasicOperation.selectByFilePath(filePath);
    }

    @Override
    public List<MyFile> selectAll(String fileParentPath,boolean all) {
        return fileBasicOperation.selectAll(fileParentPath,all);
    }

    @Override
    public void copyByFilePath(String sourceFilePath, String targetFilePath) {
        fileBasicOperation.copyByFilePath(sourceFilePath, targetFilePath);
    }
}
