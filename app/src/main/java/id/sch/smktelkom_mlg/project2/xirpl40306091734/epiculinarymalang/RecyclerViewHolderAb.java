package id.sch.smktelkom_mlg.project2.xirpl40306091734.epiculinarymalang;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Rehan on 12/2/2016.
 */

public class RecyclerViewHolderAb extends RecyclerView.ViewHolder {
    // ViewHolder akan mendeskripisikan item view yang ditempatkan di dalam RecyclerView.
    TextView tv1A, tv2A; //deklarasi textview
    ImageView imageViewA;  //deklarasi imageview

    public RecyclerViewHolderAb(View itemView) {
        super(itemView);
        tv1A = (TextView) itemView.findViewById(R.id.name);
        //menampilkan text dari widget CardView pada id daftar_judul
        tv2A = (TextView) itemView.findViewById(R.id.des);
        //menampilkan text deskripsi dari widget CardView pada id daftar_deskripsi
        imageViewA = (ImageView) itemView.findViewById(R.id.profile);
        //menampilkan gambar atau icon pada widget Cardview pada id daftar_icon
    }
}