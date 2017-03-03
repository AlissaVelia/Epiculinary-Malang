package id.sch.smktelkom_mlg.project2.xirpl40306091734.epiculinarymalang.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project2.xirpl40306091734.epiculinarymalang.R;
import id.sch.smktelkom_mlg.project2.xirpl40306091734.epiculinarymalang.model.food2;

public class food2adapter extends RecyclerView.Adapter<food2adapter.ViewHolder> {
    ArrayList<food2> hotelList;

    IHotelAdapter mIHotelAdapter;

    public food2adapter(Context context, ArrayList<food2> hotelList) {
        this.hotelList = hotelList;
        mIHotelAdapter = (IHotelAdapter) context;
    }

    @Override
    public food2adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_food5, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(food2adapter.ViewHolder holder, int position) {
        food2 Food2 = hotelList.get(position);
        holder.tvJudul.setText(Food2.judul);
        holder.tvDeskripsi.setText(Food2.deskripsi);
        holder.ivFoto.setImageURI(Uri.parse(Food2.foto));


    }

    @Override
    public int getItemCount() {
        if (hotelList != null)
            return hotelList.size();
        return 0;
    }

    public interface IHotelAdapter {
        void doClick(int pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvJudul;
        TextView tvDeskripsi;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.imageView);
            tvJudul = (TextView) itemView.findViewById(R.id.textViewJudul);
            tvDeskripsi = (TextView) itemView.findViewById(R.id.textViewDeskripsi);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mIHotelAdapter.doClick(getAdapterPosition());
                }
            });
        }
    }
}