package com.ventas.android;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mAlbumViewPager;
    private TabLayout mAlbumInfoTabLayout;
    private ViewPager mAlbumInfoViewPager;
    private RoundNavigationIndicator mPointIndicator;
    private List<Album> mAlbumList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAlbumList = AlbumLab.get(this).getAlbumList();

        mPointIndicator = (RoundNavigationIndicator)findViewById(R.id.point_indicator);
        mPointIndicator.setLength(mAlbumList.size());

        mAlbumViewPager = (ViewPager)findViewById(R.id.album_view_pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        mAlbumViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Album album = mAlbumList.get(position % mAlbumList.size());
                AlbumCoverFragment fragment = AlbumCoverFragment.newInstance(album.getId());
                return fragment;
            }

            @Override
            public int getCount() {
                //return mAlbumList.size();
                return Integer.MAX_VALUE;
            }
        });
        // TODO: 可能要调用removeOnPageChangeListener()取消注册
        mAlbumViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                mPointIndicator.setSelected(position % mAlbumList.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
        });


        mAlbumInfoViewPager = (ViewPager)findViewById(R.id.album_info_view_pager);
        mAlbumInfoViewPager.setAdapter(new FragmentPagerAdapter(fragmentManager) {

            private String[] titles = new String[] {
                    "GUIDES",
                    "JOURNAL",
                    "PHOTO"
            };

            @Override
            public Fragment getItem(int position) {
                return JournalFragment.newInstance();
            }

            @Override
            public int getCount() {
                return titles.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });

        mAlbumInfoTabLayout = (TabLayout)findViewById(R.id.album_info_tab_layout);
        mAlbumInfoTabLayout.setupWithViewPager(mAlbumInfoViewPager);
    }
}
