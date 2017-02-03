package com.ventas.android;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * Created by guanmy on 2017/2/2.
 */

public class Album {

    private UUID mId;
    private Date mCreateTime;
    private String mName;
    private String mDescription;
    private int mCoverPhotoId;

    public Album() {
        this(UUID.randomUUID());
    }

    public Album(UUID id) {
        mId = id;
        mCreateTime = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public Date getCreateTime() {
        return mCreateTime;
    }

    public void setCreateTime(Date createTime) {
        mCreateTime = createTime;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public int getCoverPhotoId() {
        return mCoverPhotoId;
    }

    public void setCoverPhotoId(int coverPhotoId) {
        mCoverPhotoId = coverPhotoId;
    }
}
