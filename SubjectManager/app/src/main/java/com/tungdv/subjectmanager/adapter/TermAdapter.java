package com.tungdv.subjectmanager.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tungdv.subjectmanager.IIClickShow;
import com.tungdv.subjectmanager.R;
import com.tungdv.subjectmanager.model.Subjects;
import com.tungdv.subjectmanager.model.Term;

import java.util.List;

public class TermAdapter extends BaseAdapter {
    private List<Term> listTerm;
    private LayoutInflater layoutInflater;
    private Context context;
    private IIClickShow iiClickShow;

    public void setListTerm(List<Term> listTerm) {
        this.listTerm = listTerm;
    }

    public TermAdapter(Context aContext, List<Term> listTerm) {
        this.context = aContext;
        this.listTerm = listTerm;
        layoutInflater = LayoutInflater.from(aContext);
    }

    public void setIiClickShow(IIClickShow iiClickShow) {
        this.iiClickShow = iiClickShow;
    }

    @Override
    public int getCount() {
        return listTerm.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TermAdapter.ViewHolder holder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_term, null);
            holder = new TermAdapter.ViewHolder();
            holder.textViewTenHocPhan = (TextView) view.findViewById(R.id.txt_tenHocPhan);
            holder.textViewHocKy = (TextView) view.findViewById(R.id.txt_hoc_ky);
            holder.textViewNamHoc = (TextView) view.findViewById(R.id.txt_nam_hoc);
            holder.textViewViewDetail = (TextView) view.findViewById(R.id.tv_View_detail);
            holder.imageViewEdit = (ImageView) view.findViewById(R.id.imv_edit);
            holder.imageViewDelete = (ImageView) view.findViewById(R.id.imv_delete);
            view.setTag(holder);
        } else {
            holder = (TermAdapter.ViewHolder) view.getTag();
        }
        Term term = this.listTerm.get(i);

        holder.textViewTenHocPhan.setText("T??n h???c ph???n: " + term.getTenHocPhan());
        holder.textViewHocKy.setText("H???c k???: " + term.getHocKy());
        holder.textViewNamHoc.setText("N??m h???c: " + term.getNamHoc());

        holder.textViewViewDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TungDV", " textViewViewDetail onClick");
                iiClickShow.showDetail(i);

            }
        });
        holder.imageViewEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TungDV", " imageViewEdit onClick");
                iiClickShow.showEdit(i);
            }
        });
        holder.imageViewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TungDV", " imageViewDelete onClick");
                iiClickShow.showDelete(i);
            }
        });

        return view;
    }

    static class ViewHolder {
        TextView textViewTenHocPhan, textViewHocKy, textViewNamHoc, textViewViewDetail;
        ImageView imageViewEdit, imageViewDelete;
    }
}
