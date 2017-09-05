package com.comic.web.bean;

import java.util.Date;

public class PublicCai {
    private Integer id;
    private String title;
    private String des;
    private String author;
    private String op1;
    private String op2;
    private String op3;
    private String op4;
    private String op5;
    private String op6;
    private Integer op1Num;
    private Integer op2Num;
    private Integer op3Num;
    private Integer op4Num;
    private Integer op5Num;
    private Integer op6Num;
    private Integer mySelect; //自己的选择
    private Date creatDate;
    private Date resultDate;
    private Integer useOpNum;
    private Integer resultOpNum;
    private Integer caiKind;
    private Integer state;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getOp1() {
        return op1;
    }

    public void setOp1(String op1) {
        this.op1 = op1 == null ? null : op1.trim();
    }

    public String getOp2() {
        return op2;
    }

    public void setOp2(String op2) {
        this.op2 = op2 == null ? null : op2.trim();
    }

    public String getOp3() {
        return op3;
    }

    public void setOp3(String op3) {
        this.op3 = op3 == null ? null : op3.trim();
    }

    public String getOp4() {
        return op4;
    }

    public void setOp4(String op4) {
        this.op4 = op4 == null ? null : op4.trim();
    }

    public String getOp5() {
        return op5;
    }

    public void setOp5(String op5) {
        this.op5 = op5 == null ? null : op5.trim();
    }

    public String getOp6() {
        return op6;
    }

    public void setOp6(String op6) {
        this.op6 = op6 == null ? null : op6.trim();
    }

    public Integer getOp1Num() {
        return op1Num;
    }

    public void setOp1Num(Integer op1Num) {
        this.op1Num = op1Num;
    }

    public Integer getOp2Num() {
        return op2Num;
    }

    public void setOp2Num(Integer op2Num) {
        this.op2Num = op2Num;
    }

    public Integer getOp3Num() {
        return op3Num;
    }

    public void setOp3Num(Integer op3Num) {
        this.op3Num = op3Num;
    }

    public Integer getOp4Num() {
        return op4Num;
    }

    public void setOp4Num(Integer op4Num) {
        this.op4Num = op4Num;
    }

    public Integer getOp5Num() {
        return op5Num;
    }

    public void setOp5Num(Integer op5Num) {
        this.op5Num = op5Num;
    }

    public Integer getMySelect() {
        return mySelect;
    }

    public void setMySelect(Integer mySelect) {
        this.mySelect = mySelect;
    }

    public Integer getOp6Num() {
        return op6Num;
    }

    public void setOp6Num(Integer op6Num) {
        this.op6Num = op6Num;
    }


    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public Date getResultDate() {
        return resultDate;
    }

    public void setResultDate(Date resultDate) {
        this.resultDate = resultDate;
    }

    public Integer getUseOpNum() {
        return useOpNum;
    }

    public void setUseOpNum(Integer useOpNum) {
        this.useOpNum = useOpNum;
    }

    public Integer getResultOpNum() {
        return resultOpNum;
    }

    public void setResultOpNum(Integer resultOpNum) {
        this.resultOpNum = resultOpNum;
    }

    public Integer getCaiKind() {
        return caiKind;
    }

    public void setCaiKind(Integer caiKind) {
        this.caiKind = caiKind;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}