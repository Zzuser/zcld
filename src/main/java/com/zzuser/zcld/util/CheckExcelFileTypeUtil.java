package com.zzuser.zcld.util;

import java.util.HashMap;

/**
 * @author guoxk
 * @version 创建时间 2016年7月17日 上午10:47:26
 * <p>
 * 类描述：获取和判断文件头信息
 * |--文件头是位于文件开头的一段承担一定任务的数据，一般都在开头的部分。
 * |--头文件作为一种包含功能函数、数据接口声明的载体文件，用于保存程序的声明(declaration),而定义文件用于保存程序的实现(implementation)。
 * |--为了解决在用户上传文件的时候在服务器端判断文件类型的问题，故用获取文件头的方式，直接读取文件的前几个字节，来判断上传文件是否符合格式。
 */
public class CheckExcelFileTypeUtil {
    // 缓存文件头信息-文件头信息
    public static final HashMap<String, String> mFileTypes = new HashMap<String, String>();

    static {
        mFileTypes.put("inode/directory", "文件夹");
        mFileTypes.put("text/plain", "纯文本文档");
        mFileTypes.put("image/png", "PNG图像");
        mFileTypes.put("image/jpeg", "JPEG图像");
//        mFileTypes.put("image/png", "PNG图像");
//        mFileTypes.put("image/png", "PNG图像");
//        mFileTypes.put("image/png", "PNG图像");
        mFileTypes.put("application/wps-office.doc", "MS word");
        mFileTypes.put("application/wps-office.docx", "MS word");
        mFileTypes.put("application/wps-office.xls", "MS Excel");
        mFileTypes.put("application/wps-office.xlsx", "MS Excel");
        mFileTypes.put("application/wps-office.ppt", "MS PPT");
        mFileTypes.put("application/wps-office.pptx", "MS PPT");
        mFileTypes.put("video/x-flv", "FLASH影片");
        mFileTypes.put("application/x-executable", "可执行文件"); // CAD
        mFileTypes.put("application/octet-stream", "二进制文件");
        mFileTypes.put("application/zip", "ZIP归档文件");
        mFileTypes.put("text/x-csrc", "C 源代码");
        mFileTypes.put("application/x-shellscript", "shell脚本");
        mFileTypes.put("application/xml", "XML文档");
        mFileTypes.put("text/x-java", "Java源代码");
        mFileTypes.put("text/html", "HTML文档");
        mFileTypes.put("image/vnd.microsoft.icon", "Windows icon");
        mFileTypes.put("text/css", "CSS样式表");
        mFileTypes.put("application/javascript", "Javascript程序");
        mFileTypes.put("application/x-virtualbox-vbox", "VirtualBox Machine Definition");
        mFileTypes.put("application/x-virtualbox-vdi", "Virtual Disk Image");
        mFileTypes.put("text/x-log", "应用程序日志");
        mFileTypes.put("application/x-java-archive", "JAVA归档文件");
        mFileTypes.put("application/x-sharedlib", "共享库");
        mFileTypes.put("application/x-sqlite3", "SQLite3数据库");
        mFileTypes.put("application/postscript", "PS文档");
        mFileTypes.put("application/pdf", "PDF文档");
//        mFileTypes.put("", "");
//        mFileTypes.put("", "");
//        mFileTypes.put("", "");
//        mFileTypes.put("", "");
//        mFileTypes.put("", "");
//        mFileTypes.put("", "");

    }
public static String getType(String type){
        String type_a=mFileTypes.get(type);
        if (type_a==null){
            return type;
        }else {
            return type_a;
        }

}
}
