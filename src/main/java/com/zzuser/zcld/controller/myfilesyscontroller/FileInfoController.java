package com.zzuser.zcld.controller.myfilesyscontroller;

import com.zzuser.zcld.model.filemodel.MyFile;
import com.zzuser.zcld.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class FileInfoController {
    @Autowired
    FileService fileService;

    @RequestMapping("/listAllFiles")
    @CrossOrigin
    public List<MyFile> listAllFiles(@RequestParam("fileParentPath") String fileParentPath,
                                     @RequestParam("all") String all) {
        return fileService.selectAll(fileParentPath,Boolean.parseBoolean(all));
    }
}
