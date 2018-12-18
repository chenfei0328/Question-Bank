package com.SilverBullet.Problem_Management_System_0_0_1.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.SilverBullet.Problem_Management_System_0_0_1.BaseClass.ProblemInfo;
import com.SilverBullet.Problem_Management_System_0_0_1.Service.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * Created by delltest on 2017/5/21.
 */
@RestController
public class reviewController {
    @Autowired
    reviewService rs;
    @Autowired
    ProblemInsertService pis;
    @Autowired
    tempGetService tgs;
    @Autowired
    tempDeleteService tds;

    @RequestMapping(value = "/RefreshTemp", method = RequestMethod.POST)
    public List<ProblemInfo> refreshTemp() throws Exception{
        try {
            List<ProblemInfo> reviewList =  rs.getTempInfo();
            for(int i=0;i<reviewList.size();i++){
                System.out.println(reviewList.get(i));
            }
            return reviewList;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @RequestMapping(value = "/reviewSave", method = RequestMethod.POST)
    public String reviewSave(@RequestParam(value = "pid")String pid) throws Exception{
        try {
            System.out.println(pid);
            ProblemInfo p = tgs.tempGet(pid);
            if(p.getPid()!="") {
                pis.problemInsert(p);
                tds.tempDelete(pid);
            }
            return "yes";
        } catch (Exception ex) {
            throw ex;
        }
    }

    @RequestMapping(value = "/reviewDelete", method = RequestMethod.POST)
    public String reviewDelete(@RequestParam(value = "pid")String pid) throws Exception{
        try {
            String path1 = "f:/workplace/Problem_Management_System_0.0.2/target/classes/static/ProblemBank/Problem/"+pid+".png";
            File file = new File(path1);
            ProblemInfo p = tgs.tempGet(pid);
            if(p.getPid()!="")
            {
                if(file.exists())
                {
                    file.delete();
                }
            }
            tds.tempDelete(pid);
            return "no";
        } catch (Exception ex) {
            throw ex;
        }
    }
}
