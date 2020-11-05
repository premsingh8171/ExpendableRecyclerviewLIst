package com.example.chegg.modelactivity;

import java.util.ArrayList;

public class ChapterModel {
public String Chapter;
public ArrayList<ChapterSubModel> childList = new ArrayList<>();

    public ChapterModel() {
    }

    public String getChapter() {
        return Chapter;
    }

    public void setChapter(String chapter) {
        Chapter = chapter;
    }

    public ArrayList<ChapterSubModel> getChildList() {
        return childList;
    }

    public void setChildList(ArrayList<ChapterSubModel> childList) {
        this.childList = childList;
    }
}
