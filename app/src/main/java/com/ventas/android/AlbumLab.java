package com.ventas.android;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by guanmy on 2017/2/2.
 */

public class AlbumLab {

    private static AlbumLab sAlbumLab;

    private Context mContext;
    private List<Album> mAlbumList;

    public static AlbumLab get(Context context) {
        if (sAlbumLab == null) {
            sAlbumLab = new AlbumLab(context);
        }

        return sAlbumLab;
    }

    private AlbumLab(Context context) {
        mContext = context.getApplicationContext();

        mAlbumList = new ArrayList<>();
        addAlbum("album1", "album1 description", R.drawable.album_cover_1);
        addAlbum("album2", "album2 description", R.drawable.album_cover_2);
        addAlbum("album3", "album3 description", R.drawable.album_cover_3);
        addAlbum("album4", "album4 description", R.drawable.album_cover_4);
    }

    public List<Album> getAlbumList() {
        return mAlbumList;
    }

    public Album getAlbum(UUID id) {
        for (Album album: mAlbumList) {
            if (album.getId().equals(id)) {
                return album;
            }
        }
        return null;
    }

    private void addAlbum(String name, String description, int coverPhotoId) {
        Album album = new Album();
        album.setName(name);
        album.setDescription(description);
        album.setCoverPhotoId(coverPhotoId);
        mAlbumList.add(album);
    }
}
