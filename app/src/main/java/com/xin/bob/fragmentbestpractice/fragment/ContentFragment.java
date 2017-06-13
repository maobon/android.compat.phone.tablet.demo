package com.xin.bob.fragmentbestpractice.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xin.bob.fragmentbestpractice.R;


public class ContentFragment extends Fragment {

    private View rootView;
    private TextView tvTitle;
    private TextView tvContent;

    public ContentFragment() {
        // Required empty public constructor
    }

    public static ContentFragment newInstance(String param1, String param2) {
        ContentFragment fragment = new ContentFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_content, container, false);
        tvTitle = rootView.findViewById(R.id.tv_title);
        tvContent = rootView.findViewById(R.id.tv_content);
        return rootView;
    }

    /**
     * refresh data
     * @param title String
     * @param content String
     */
    public void refreshData(String title, String content){
        tvTitle.setText(title);
        tvContent.setText(content);
    }

}
