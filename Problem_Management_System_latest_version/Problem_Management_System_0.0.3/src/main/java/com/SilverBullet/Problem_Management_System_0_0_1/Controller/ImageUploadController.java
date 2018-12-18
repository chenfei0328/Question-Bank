package com.SilverBullet.Problem_Management_System_0_0_1.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;

import com.SilverBullet.Problem_Management_System_0_0_1.BaseClass.*;
import com.SilverBullet.Problem_Management_System_0_0_1.Service.tempInsertService;

/**
 * Created by delltest on 2017/5/12.
 */

@RestController
public class ImageUploadController {

    @Autowired
    tempInsertService tis;

    //@Autowired
    //ProblemInfo p;

    @RequestMapping(value = "/upload" , method = RequestMethod.POST)
    public String upload(HttpServletRequest request, @RequestParam(value = "image_input",required = false)MultipartFile file) {

        System.out.println("开始");
        String path = request.getSession().getServletContext().getRealPath("/");
        String fileName = file.getOriginalFilename();
        System.out.println(path);
        File targetFile = new File(path, fileName);

        if (!targetFile.exists()){
            try {
                targetFile.createNewFile();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        // 保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }

    @RequestMapping(value = "/imageSave" , method = RequestMethod.POST)
    /*public String imageSave(HttpServletRequest request, @RequestParam(value = "strings")String s,@RequestParam(value = "stringname")String pid,
                            @RequestParam(value = "stringclassification")String classification,@RequestParam(value = "stringfaculty")String faculty,
                            @RequestParam(value = "stringsubject")String subject, @RequestParam(value = "stringquestion")String question,
                            @RequestParam(value = "stringdifficulty")String difficulty) {
                            */
    public String imageSave(HttpServletRequest request, @RequestParam(value = "strings")String s,@ModelAttribute("p")ProblemInfo p,@RequestParam(value = "pid")String name) {
        System.out.println(s);

       // p.setPid(pid);
       // p.setClassification(classification);
       // p.setFaculty(faculty);
       // p.setSubject(subject);
       // p.setQuestion(question);
       // p.setDifficulty(difficulty);

        String path = request.getSession().getServletContext().getRealPath("/"+s);
        System.out.println(path);
        String path1 = "/home/silverbullet/Desktop/Problem_Management_System_0.0.2/target/classes/static/ProblemBank/Problem/"+name+".png";
     //   File copyFile = new File(path);
        File pasteFile = new File(path1);
        if(!pasteFile.exists())
        {
            try {
                pasteFile.createNewFile();
                Copy(path,path1);
                tis.tempInsert(p);
                System.out.println("success");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return "true";
    }

    public  static   void  Copy(String oldPath,String newPath)
    {
        FileInputStream fi = null;
        FileOutputStream fo = null;
        FileChannel in = null;
        FileChannel out = null;
        try {
            fi = new FileInputStream(oldPath);
            fo = new FileOutputStream(newPath);
            in = fi.getChannel();
            out = fo.getChannel();
            in.transferTo(0, in.size(), out);//连接两个通道，并且从in通道读取，然后写入out通道
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fi.close();
                in.close();
                fo.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
