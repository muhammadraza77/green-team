package com.example.mujtaba.greenteam;

import java.io.Serializable;

/**
 * Created by users12 on 10/8/2018.
 */
@SuppressWarnings("serial")
public class newInfo implements Serializable {

    public String thumbnail,title,content,meta;

    public newInfo(String thumbnail, String title, String content,String meta) {
        this.thumbnail = thumbnail;
        this.title = title;
        this.content = content;
        this.meta = meta;
    }

    public newInfo(String thumbnail, String heading) {
        this.thumbnail = thumbnail;
        this.title = heading;
    }

    public newInfo() {
    }
}
