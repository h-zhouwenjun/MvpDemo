package com.example.zwj.mvpdemo.bean;

import java.util.List;

/**
 * <b>创建时间</b> 17/6/16 <br>
 *
 * @author zhouwenjun
 */

public class DynamicBean extends BaseBean{


    public final static String TYPE_URL = "1";
    public final static String TYPE_IMG = "2";
    public final static String TYPE_VIDEO = "3";
    /**
     *
     */
    public static final long serialVersionUID = 1L;
    public String id;
    public String content;
    public String createTime;
    public String head;
    public String name;
    public String type;//1:链接  2:图片 3:视频
    public String linkImg;
    public String linkTitle;
    public String videoUrl;
    public String videoImgUrl;
    public List<String> imgUrls;
    public int praiseCount;
    public boolean isExpand;

}
