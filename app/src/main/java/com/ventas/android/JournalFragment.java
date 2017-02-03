package com.ventas.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by guanmy on 2017/2/3.
 */

public class JournalFragment extends Fragment {

    private Button mReadMoreButton;

    public static JournalFragment newInstance() {
        return new JournalFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_journal, container, false);

        mReadMoreButton = (Button)view.findViewById(R.id.journal_read_more);
        mReadMoreButton.setText("READ MORE");
        mReadMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = JournalActivity.newIntent(getActivity());
                startActivity(intent);
            }
        });

        return view;
    }
}
