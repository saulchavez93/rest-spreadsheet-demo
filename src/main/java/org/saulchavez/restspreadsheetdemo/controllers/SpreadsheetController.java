package org.saulchavez.restspreadsheetdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
public class SpreadsheetController {

    @Value("${app.upload.dir:${user.home}}")
    public String uploadDir;

    @GetMapping("/hello")
    public String getHello() {
        return "Hello world!";
    }

    @PostMapping("/spreadsheet")
    public String uploadSpreadsheet(@RequestParam("file") MultipartFile file) throws IOException {
        Path copyLocation = Paths
                .get(uploadDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
        Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
        return "Success!!";
    }
}
