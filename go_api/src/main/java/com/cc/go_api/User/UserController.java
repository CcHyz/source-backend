package com.cc.go_api.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class UserController {

    @GetMapping("/login")
    public ResponseEntity<String> test(HttpServletResponse response) throws IOException {
        String fileNamePre="";
        String fileName="";
        FileInputStream fileInputStream = new FileInputStream(fileNamePre + fileName);
        BufferedInputStream br = new BufferedInputStream(fileInputStream);
        byte[] buf = new byte[1024];
        int len = 0;

        response.setContentType("application/x-msdownload");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName,"UTF-8"));

        OutputStream out = response.getOutputStream();
        while ((len = br.read(buf)) > 0)
            out.write(buf, 0, len);

        return ResponseEntity.ok().body("欢迎欢迎");


    }


    private void readTheFile() throws IOException {
        Path path = Paths.get("");
        BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset());
        // ...
        reader.close();  // Noncompliant
        // ...
        Files.lines(Path.of("input.txt")).forEach(System.out::println); // Noncompliant: The stream needs to be closed
    }

    private void doSomething() {
        try {
            OutputStream stream = new FileOutputStream("kkk");
            stream.write(1);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
