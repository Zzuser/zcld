package com.zzuser.zcld.model.filemodel;

import com.zzuser.zcld.util.CheckExcelFileTypeUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.*;
import java.text.DecimalFormat;
import java.util.Set;

public class MyFileImpl extends File implements MyFile {

    //    private String fileName;
//    private boolean dir;
    private String icon;
    //    private boolean fileHidden;
    private boolean canWrite;
    //    private String filePath;
    private String owner;
    private String fileType;
    private String permissions;
    private String fileLength;
    private String creationTime;
    private String lastAccessTime;
    private String lastModifiedTime;


    public MyFileImpl(String pathname) throws IOException {
        super(pathname);
        MyFileCoreImpl(pathname, "");
    }

    public MyFileImpl(String pathname, String icon) throws IOException {
        super(pathname);
        MyFileCoreImpl(pathname, icon);
    }

    private void MyFileCoreImpl(String pathname, String icon) throws IOException {
        Path paths = Paths.get(pathname);
        BasicFileAttributeView basicView = Files.getFileAttributeView(
                paths, BasicFileAttributeView.class);
        FileOwnerAttributeView onerView = Files.getFileAttributeView(
                paths, FileOwnerAttributeView.class);
        Set<PosixFilePermission> filePerm = Files.getPosixFilePermissions(paths);
        BasicFileAttributes basicAttributes = basicView.readAttributes();
        this.icon = icon;
        canWrite = this.canWrite();
        owner = onerView.getOwner().toString();
        fileType = CheckExcelFileTypeUtil.getType(Files.probeContentType(paths));
        permissions = PosixFilePermissions.toString(filePerm);
        if (this.isDirectory()) {
            File[] all = this.listFiles();
            if (all==null){
                fileLength = "0项";
            }else {
                fileLength = String.valueOf(all.length) + "项";
            }

        } else {
            fileLength = getDataSize(this.length());
        }
        creationTime = basicAttributes.creationTime().toString();
        lastAccessTime = basicAttributes.lastAccessTime().toString();
        lastModifiedTime = basicAttributes.lastModifiedTime().toString();
    }

    /**
     * 返回byte的数据大小对应的文本
     *
     * @param size
     * @return
     */
    public static String getDataSize(long size) {
        DecimalFormat formater = new DecimalFormat("####.00");
        if (size < 1024) {
            return size + "bytes";
        } else if (size < 1024 * 1024) {
            float kbsize = size / 1024f;
            return formater.format(kbsize) + "KB";
        } else if (size < 1024 * 1024 * 1024) {
            float mbsize = size / 1024f / 1024f;
            return formater.format(mbsize) + "MB";
        } else if (size < 1024 * 1024 * 1024 * 1024) {
            float gbsize = size / 1024f / 1024f / 1024f;
            return formater.format(gbsize) + "GB";
        } else {
            return "size: error";
        }
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }


    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getFileLength() {
        return fileLength;
    }

    public void setFileLength(String fileLength) {
        this.fileLength = fileLength;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(String lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public String getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(String lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public boolean isCanWrite() {
        return canWrite;
    }

    public void setCanWrite(boolean canWrite) {
        this.canWrite = canWrite;
    }

}
