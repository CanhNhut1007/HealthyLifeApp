package com.example.sdkfacebook.tab_my_record;

public class Info_class {
    private String title;
    private String content;
    public Info_class(){

    }
    public Info_class(String title, String content){
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
