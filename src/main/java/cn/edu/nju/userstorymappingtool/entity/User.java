package cn.edu.nju.userstorymappingtool.entity;

/**
 * @Author: wx
 * @Date: 2018/12/18 13:26
 * @Version 1.0
 */
public class User {
    private int userid;
    private String username;
    private String password;
    private int tasking; //记录用户目前还未完成的subtask

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTasking() {
        return tasking;
    }

    public void setTasking(int tasking) {
        this.tasking = tasking;
    }
}
