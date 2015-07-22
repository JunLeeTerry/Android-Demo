package com.sinaapp.terryspace.javadesignpattern;

import java.util.UUID;

/**
 * Created by terry on 6/28/15.
 */
public class DesignPattern {
    private UUID id;
    private String name;
    private String type;
    private String content;

    public DesignPattern(String name,String type,String content){
        this.id = UUID.randomUUID();
        this.name = name;
        this.type = type;
        this.content = content;
    }
    public String getTypeName(){
        return this.type;
    }

    public void setType(String typeName){
        this.type = typeName;
    }
    public void setContent(String content){
        this.content = content;
    }
    public String getContent(){
        return this.content;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public UUID getID(){
        return this.id;
    }
    @Override
    public String toString() {
        return this.name+" Pattern";
    }
}
