package com.xqn.entities;

import lombok.Data;

@Data
public class Evoc {
    public String stuname;
    public String teaname;
    public String content;
    public String time;

    public Evoc(String stuname, String teaname, String content, String time, String rank) {
        this.stuname = stuname;
        this.teaname = teaname;
        this.content = content;
        this.time = time;
        this.rank = rank;
    }

    public  String rank;

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public void setTeaname(String teaname) {
        this.teaname = teaname;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
