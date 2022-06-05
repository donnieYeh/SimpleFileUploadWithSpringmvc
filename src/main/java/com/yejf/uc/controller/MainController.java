package com.yejf.uc.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class MainController {
    @PostMapping("/sum")
    public String sum(@RequestParam int i, @RequestParam int j) {
        return String.valueOf(i + j);
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/doUpload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public String upload(HttpServletRequest request, @RequestParam MultipartFile file,
                         @RequestParam String name) throws IOException {
        long size = file.getSize();
        System.out.println("file size = " + size);
        try (InputStream in = file.getInputStream()) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            bufferedReader.lines().forEach(s -> {
                System.out.println(s);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        String realPath = request.getServletContext().getRealPath("WEB-INF");
        File data = Paths.get(realPath, "data", name + ".txt").toFile();
        data.delete();
        Files.createDirectories(data.toPath());
        data.createNewFile();
        file.transferTo(data);
        return "ok!";
    }
}
