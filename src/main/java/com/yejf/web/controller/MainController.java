package com.yejf.web.controller;

import com.yejf.web.service.HelloService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@Validated
public class MainController {
    @Resource
    HelloService helloService;
    @PostMapping("/sum")
    public String sum(@RequestParam int i, @RequestParam int j) {
        return String.valueOf(i + j);
    }

    @PostMapping("/hello")
    public String hello(@RequestParam @Size(min = 3,max = 5) String test, @Max(2) Integer test2) {
        String hello = null;
        try {
            hello = helloService.hello(test);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hello;
    }

    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
    public String upload(HttpServletRequest request, @RequestPart MultipartFile file,
                         @RequestPart @Valid MetaData meta) throws IOException {
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
        File data = Paths.get(realPath, "data", meta.getName() + ".txt").toFile();
        data.delete();
        Files.createDirectories(data.toPath());
        data.createNewFile();
        file.transferTo(data);
        return "ok!";
    }
}
