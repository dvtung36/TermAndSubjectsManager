package com.tungdv.subjectmanager.adapter;

import android.content.Context;
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

import java.util.List;

public class SubjectsAdapter extends BaseAdapter {

    private List<Subjects> listSubject;
    private LayoutInflater layoutInflater;
    private Context context;
    private IIClickShow iiClickShow;

    public void setListSubject(List<Subjects> listSubject) {
        this.listSubject = listSubject;

    }

    public SubjectsAdapter(Context aContext, List<Subjects> listSubject) {
        this.context = aContext;
        this.listSubject = listSubject;
        layoutInflater = LayoutInflater.from(aContext);
    }

    public void setIiClickShow(IIClickShow iiClickShow) {
        this.iiClickShow = iiClickShow;
    }

    @Override
    public int getCount() {
        return listSubject.size();
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
        ViewHolder holder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_subjects, null);
            holder = new ViewHolder();
            holder.textViewTenMonHoc = (TextView) view.findViewById(R.id.txt_tenMH);
            holder.textViewSoTinChi = (TextView) view.findViewById(R.id.txt_so_tin_chi);
            holder.textViewSoTiet = (TextView) view.findViewById(R.id.txt_so_tiet);
            holder.textViewViewDetail = (TextView) view.findViewById(R.id.tv_View_detail);
            holder.imageViewEdit = (ImageView) view.findViewById(R.id.imv_edit);
            holder.imageViewDelete = (ImageView) view.findViewById(R.id.imv_delete);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Subjects subjects = this.listSubject.get(i);

        holder.textViewTenMonHoc.setText("T??n m??n h???c: " + subjects.getTenMonHoc());
        holder.textViewSoTinChi.setText("S??? t??n ch???: " + subjects.getSoTinChi());
        holder.textViewSoTiet.setText("S??? ti???t: " + subjects.getSoTiet());

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
        TextView textViewTenMonHoc, textViewSoTinChi, textViewSoTiet, textViewViewDetail;
        ImageView imageViewEdit, imageViewDelete;
    }
}
