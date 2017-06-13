package com.xin.bob.fragmentbestpractice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class ContentActivity extends AppCompatActivity {

    private static final String ARG_KEY_TITLE = "ARG_KEY_TITLE";
    private static final String ARG_KEY_CONTENT = "ARG_KEY_CONTENT";

    private TextView tvTitle;
    private TextView tvContent;

    public static void actionStart(Context context, String title, String content) {
        Intent i = new Intent(context, ContentActivity.class);
        i.putExtra(ARG_KEY_TITLE, title);
        i.putExtra(ARG_KEY_CONTENT, content);
        context.startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        Intent intent = getIntent();
        if (intent != null) {
            String strTitle = intent.getStringExtra(ARG_KEY_TITLE);
            String strContent = intent.getStringExtra(ARG_KEY_CONTENT);
            initViews(strTitle, strContent);

        } else {
            Toast.makeText(this, "null", Toast.LENGTH_SHORT).show();
        }
    }

    private void initViews(String title, String content) {
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvContent = (TextView) findViewById(R.id.tv_content);
        tvTitle.setText(title);
        tvContent.setText(content);
    }


}
