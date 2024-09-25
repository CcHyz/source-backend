package com.cc.go_api.User.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@RestController
public class UserController {

    @GetMapping("/login")
    public ResponseEntity<String> test(HttpServletResponse response) throws IOException {
        String fileNamePre = "";
        String fileName = "";
        FileInputStream fileInputStream = new FileInputStream(fileNamePre + fileName);
        BufferedInputStream br = new BufferedInputStream(fileInputStream);
        byte[] buf = new byte[1024];
        int len = 0;

        response.setContentType("application/x-msdownload");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        OutputStream out = response.getOutputStream();
        while ((len = br.read(buf)) > 0)
            out.write(buf, 0, len);

        return ResponseEntity.ok().body("欢迎欢迎");


    }

}
