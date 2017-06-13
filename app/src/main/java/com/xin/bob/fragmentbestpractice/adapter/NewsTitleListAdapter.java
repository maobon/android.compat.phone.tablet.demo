package com.xin.bob.fragmentbestpractice.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xin.bob.fragmentbestpractice.ContentActivity;
import com.xin.bob.fragmentbestpractice.MainActivity;
import com.xin.bob.fragmentbestpractice.R;
import com.xin.bob.fragmentbestpractice.entity.News;
import com.xin.bob.fragmentbestpractice.fragment.ContentFragment;

import java.util.List;

/**
 * Created by bob on 2017/6/12.
 * News listview use with RecyclerView
 */

public class NewsTitleListAdapter extends RecyclerView.Adapter<NewsTitleListAdapter.ViewHolder> {

    private Context context;
    private List<News> data;
    private LayoutInflater inflater;

    public NewsTitleListAdapter(Context context, List<News> data) {
        this.context = context;
        this.data = data;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.layout_item_title, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final News news = data.get(position);

        holder.bindData(news);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isWorkingOnPhone = ((MainActivity) context).isWorkingOnPhone;
                if (isWorkingOnPhone) {
                    ContentActivity.actionStart(context, news.getTitle(), news.getContent());
                } else {
                    ContentFragment fragment = (ContentFragment) ((MainActivity) context)
                            .getSupportFragmentManager().findFragmentById(R.id.fragment_content);
                    fragment.refreshData(news.getTitle(), news.getContent());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;
        private View itemView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tvTitle = itemView.findViewById(R.id.tv_title);
        }

        public void bindData(News news) {
            tvTitle.setText(news.getTitle());
        }

    }
}
