package com.example.healthlife.listview;

public class InfoClass {

    private String title;
    private String content;

    public InfoClass()
    {
    }
    public InfoClass(String title, String content){
        this.title=title;
        this.content=content;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(){
        this.title=title;
    }

    public String getContent(){
        return content;
    }

    public void setContent(){
        this.content=content;
    }
}
