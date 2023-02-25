package com.example.quanlybanlaptop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quanlybanlaptop.R;
import com.example.quanlybanlaptop.model.LoaiSP;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LoaiSPAdapter extends BaseAdapter {
    ArrayList<LoaiSP> arraylistloaisp;
    Context context;//giúp ta xem đang ở màn hình nào

    public LoaiSPAdapter(ArrayList<LoaiSP> arraylistloaisp, Context context) {
        this.arraylistloaisp = arraylistloaisp;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arraylistloaisp.size();
    }

    @Override
    public Object getItem(int i) {
        return arraylistloaisp.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    //tạo class giúp load dữ liệu , render lần đầu gán trực tiếp những giá trị nào thành công
    public class ViewHolder{
        TextView txtTenLoaiSP;
        ImageView imgLoaiSP;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_listview_loaisp,null);
            viewHolder.txtTenLoaiSP = view.findViewById(R.id.textviewloaisp);
            viewHolder.imgLoaiSP = (ImageView) view.findViewById(R.id.imageviewloaisp);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
            LoaiSP loaiSP = (LoaiSP) getItem(i);
            viewHolder.txtTenLoaiSP.setText(loaiSP.getTenloaisp());
            Picasso.get().load(loaiSP.getHinhanhloaisp())
                    .placeholder(R.drawable.noimage)
                    .error(R.drawable.error)
                    .into(viewHolder.imgLoaiSP);
        }
        return view;
    }
}
