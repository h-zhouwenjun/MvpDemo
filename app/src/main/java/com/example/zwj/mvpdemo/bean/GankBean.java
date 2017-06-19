package com.example.zwj.mvpdemo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <b>创建时间</b> 17/5/27 <br>
 *
 * @author zhouwenjun
 */

public class GankBean implements Parcelable{

    public String _id;
    public String createdAt;
    public String desc;
    public String source;
    public String type;
    public String url;
    public boolean used;
    public String who;
    public int itemHeight;
    public int itemWidth;
    public String publishedAt;

    public GankBean() {
    }

    public GankBean(String _id, String createdAt, String desc, String source, String type, String url, boolean used, String who,int itemHeight) {
        this._id = _id;
        this.createdAt = createdAt;
        this.desc = desc;
        this.source = source;
        this.type = type;
        this.url = url;
        this.used = used;
        this.who = who;
        this.itemHeight = itemHeight;
    }

    protected GankBean(Parcel in) {
        _id = in.readString();
        createdAt = in.readString();
        desc = in.readString();
        source = in.readString();
        type = in.readString();
        url = in.readString();
        used = in.readByte() != 0;
        who = in.readString();
        itemHeight = in.readInt();
        itemWidth = in.readInt();
        publishedAt = in.readString();
    }

    public static final Creator<GankBean> CREATOR = new Creator<GankBean>() {
        @Override
        public GankBean createFromParcel(Parcel in) {
            return new GankBean(in);
        }

        @Override
        public GankBean[] newArray(int size) {
            return new GankBean[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(_id);
        dest.writeString(createdAt);
        dest.writeString(desc);
        dest.writeString(source);
        dest.writeString(type);
        dest.writeString(url);
        dest.writeByte((byte) (used ? 1 : 0));
        dest.writeString(who);
        dest.writeInt(itemHeight);
        dest.writeInt(itemWidth);
        dest.writeString(publishedAt);
    }
}
