package com.ranqingguo.postwhatyousee;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @Created by ranqingguo on 19/7/15.
 */
public class FontAdapter extends RecyclerView.Adapter<FontAdapter.ViewHolder> {
    String[] mFontStrs;

    public FontAdapter(String[] mFontStrs) {
        this.mFontStrs = mFontStrs;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_font, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.fontText.setText(mFontStrs[position]);
    }

    @Override
    public int getItemCount() {
        return mFontStrs.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.font_text)
        TextView fontText;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
