package com.ventas.android;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.UUID;

/**
 * Created by guanmy on 2017/2/2.
 */

public class AlbumCoverFragment extends Fragment {

    private static final String ARG_ALBUM_ID = "album_id";

    private ImageView mAlbumCoverImage;
    private TextView mAlbumDescription;
    private TextView mAlbumCreateTimeText;
    private Album mAlbum;

    public static AlbumCoverFragment newInstance(UUID albumId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_ALBUM_ID, albumId);

        AlbumCoverFragment fragment = new AlbumCoverFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UUID albumId = (UUID)getArguments().getSerializable(ARG_ALBUM_ID);
        mAlbum = AlbumLab.get(getActivity()).getAlbum(albumId);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_album_cover, container, false);

        mAlbumCoverImage = (ImageView)view.findViewById(R.id.album_cover);
        Glide.with(getActivity()).load(mAlbum.getCoverPhotoId()).into(mAlbumCoverImage);

        mAlbumDescription = (TextView)view.findViewById(R.id.album_description);
        mAlbumDescription.setText(mAlbum.getDescription());

        mAlbumCreateTimeText = (TextView)view.findViewById(R.id.album_create_time);
        mAlbumCreateTimeText.setText("TRAVELS " + mAlbum.getCreateTime().toString());

        return view;
    }
}
