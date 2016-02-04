package com.syalife.diary.object;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/2/3.
 */
public class ContentItem implements Serializable {
    public enum ContentType {
        _PICTURE(0, "Picture and Text"),
        _VEDIO(1, "Video and Text"),
        _DIARY(2, "Only Text");

        int mTypeId;
        String mTypeDesc;

        ContentType(int id, String desc) {
            mTypeId = id;
            mTypeDesc = desc;
        }

        public int getTypeId() {
            return mTypeId;
        }

        public String getTypeDesc() {
            return mTypeDesc;
        }
    }

    private int mId = 0;
    private ContentType mType = ContentType._DIARY;
    private String mImageSource = "ImageSource";
    private String mTitle = "Title";
    private String mSubTitle = "SubTitle";
    private String mDescription = "Description";
    private Date mDate = new Date();

    public ContentItem(int id, String title, String imageUrl) {
        mId = id;
        mTitle = title;
        mImageSource = imageUrl;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setSubTitle(String subTitle) {
        mSubTitle = subTitle;
    }

    public String getSubTitle() {
        return mSubTitle;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setType(ContentType type) {
        mType = type;
    }

    public ContentType getType() {
        return mType;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public Date getDate() {
        return mDate;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[id]");
        builder.append(String.valueOf(mId));
        builder.append("; [Type]").append(mType.getTypeDesc());
        builder.append("; [ImageSource]").append(mImageSource);
        builder.append("; [Title]").append(mTitle);
        builder.append("; [SubTitle]").append(mSubTitle);
        builder.append("; [Description]").append(mDescription);
        builder.append("; [Date]").append(mDate.toString());
        return super.toString();
    }
}
