package com.SilverBullet.Problem_Management_System_0_0_1.Service;

import com.SilverBullet.Problem_Management_System_0_0_1.BaseClass.Paper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by silverbullet on 5/23/17.
 */
@Service
public class CreatePaperService {
    public String create(Paper p) {
        try {
            String[] pids;
            int i;
            pids = p.getPids().split(";");
            String cmdstring = "bash /home/silverbullet/Desktop/TEX/shell " + pids.length + " " + p.getPaperName();
            System.out.println(cmdstring);
            for(i=0; i<pids.length; i++) {
                cmdstring += " " + pids[i];
            }
            System.out.println(cmdstring);
            Process proc = Runtime.getRuntime().exec(cmdstring);
            System.out.println("...");
            proc.waitFor();
            return p.getPaperName() + ".pdf";
        } catch (IOException ex) {
            ex.printStackTrace();
            return "-1";
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            return "-1";
        }
    }
}
