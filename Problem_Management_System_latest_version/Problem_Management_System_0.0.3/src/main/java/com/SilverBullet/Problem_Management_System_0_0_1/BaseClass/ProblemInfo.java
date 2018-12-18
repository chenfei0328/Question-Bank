package com.SilverBullet.Problem_Management_System_0_0_1.BaseClass;


import org.springframework.stereotype.Service;

/**
 * Created by 22823 on 2016/10/29.
 */

//@Service
public class ProblemInfo {
    private String pid;
    private String difficulty;
    private String classification;
    private String faculty;
    private String subject;
    private String question;

    public ProblemInfo() {}
    public ProblemInfo(String pid,String classification,String faculty,String subject,String question, String difficulty) {

        this.pid = pid;
        //this.cid = cid;
        //this.chapter = chapter;
        this.difficulty = difficulty;
        this.classification = classification;
        this.faculty = faculty;
        this.subject = subject;
        this.question =question;

    }
    public void setPid(String pid) {
        this.pid = pid;
    }
    public String getPid() {
        return pid;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
    public String getClassification() {
        return classification;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
    public String getFaculty() {
        return faculty;
    }

    public void setSubject(String subject) {this.subject = subject;}
    public String getSubject() {return subject;}

    public void setQuestion(String question) {this.question = question;}
    public String getQuestion() {
        return question;
    }

    /*public void setCid(String cid) {
        this.cid = cid;
    }
    public String getCid() {
        return cid;
    }
    public void setChapter(String chapter) {
        this.chapter = chapter;
    }
    public String getChapter() {
        return chapter;
    }*/

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
    public String getDifficulty() {
        return difficulty;
    }

    /*public static ProblemInfo convertFromString(String s) {
        ProblemInfo p = new ProblemInfo();
        p.setPid(Integer.parseInt(s.substring(0, s.indexOf(","))));
        p.setDifficulty(s.substring(s.lastIndexOf(",") + 1, s.length()));
        s = s.substring(s.indexOf(",") + 1, s.lastIndexOf(","));
        p.setCid(s.substring(0, s.indexOf(",")));
        p.setChapter(s.substring(s.indexOf(",") + 1));
        return p;
    }*/
}
