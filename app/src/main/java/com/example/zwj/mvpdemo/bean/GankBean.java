package com.example.zwj.mvpdemo.bean;

/**
 * <b>创建时间</b> 17/5/27 <br>
 *
 * @author zhouwenjun
 */

public class GankBean {

    public String _id;
    public String createdAt;
    public String desc;
    public String source;
    public String type;
    public String url;
    public boolean used;
    public String who;

    public GankBean() {
    }

    public GankBean(String _id, String createdAt, String desc, String source, String type, String url, boolean used, String who) {
        this._id = _id;
        this.createdAt = createdAt;
        this.desc = desc;
        this.source = source;
        this.type = type;
        this.url = url;
        this.used = used;
        this.who = who;
    }

    @Override
    public String toString() {
        return "Gank{" +
                "_id='" + _id + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", desc='" + desc + '\'' +
                ", source='" + source + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", used=" + used +
                ", who='" + who + '\'' +
                '}';
    }
}
