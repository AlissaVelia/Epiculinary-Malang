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
import id.sch.smktelkom_mlg.project2.xirpl40306091734.epiculinarymalang.model.food1;


public class food1adapter extends RecyclerView.Adapter<food1adapter.ViewHolder> {
    ArrayList<food1> hotelList;

    IHotelAdapter mIHotelAdapter;

    public food1adapter(Context context, ArrayList<food1> hotelList) {
        this.hotelList = hotelList;
        mIHotelAdapter = (IHotelAdapter) context;
    }

    @Override
    public food1adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_food5, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(food1adapter.ViewHolder holder, int position) {
        food1 Food1 = hotelList.get(position);
        holder.tvJudul.setText(Food1.judul);
        holder.tvDeskripsi.setText(Food1.deskripsi);
        holder.ivFoto.setImageURI(Uri.parse(Food1.foto));
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


