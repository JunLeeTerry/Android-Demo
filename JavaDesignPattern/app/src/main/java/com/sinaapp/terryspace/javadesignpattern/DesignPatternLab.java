package com.sinaapp.terryspace.javadesignpattern;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by terry on 6/29/15.
 */
public class DesignPatternLab  {
    private static DesignPatternLab designPatternLab = null;
    private ArrayList<DesignPattern> designPatterns;

    private DesignPatternLab(){
        designPatterns = JDPDatabaseUtil.getInstance().getDesignPatterns();
    }
    public static DesignPatternLab getInstance(){
        if(designPatternLab == null){
            designPatternLab = new DesignPatternLab();
        }

        return designPatternLab;
    }

    public ArrayList<DesignPattern> getDesignPatternList(String name){
        ArrayList<DesignPattern> patterns = new ArrayList<>();
        for(DesignPattern pattern : designPatterns){
            if(pattern.getTypeName().equals(name)){
                patterns.add(pattern);
            }
        }
        return patterns;
    }

    public DesignPattern getDesignPattern(UUID uuid){
        for(DesignPattern designPattern:designPatterns){
            if(uuid.equals(designPattern.getID())){
                return designPattern;
            }
        }
        return null;
    }
}
