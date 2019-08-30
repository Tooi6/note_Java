package com.tooi.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
public class UploadController {

    @RequestMapping("/uploadPage")
    public String uploadPage() {
        return "uploadPage";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest request,
                         @RequestParam("file") MultipartFile file, Model m) {
        try {
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            String destFileName = request.getServletContext().getRealPath("") + "uploaded" + File.separator + fileName;
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdir();
            file.transferTo(destFile);

            m.addAttribute("fileName", fileName);
            System.out.println(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "上传失败，" + e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败，" + e.getMessage();
        }
        return "showImg";
    }
}
