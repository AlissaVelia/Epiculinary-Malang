package id.sch.smktelkom_mlg.project2.xirpl40306091734.epiculinarymalang;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Rehan on 12/1/2016.
 */

public class RecyclerViewHolderHome extends RecyclerView.ViewHolder {
    // ViewHolder akan mendeskripisikan item view yang ditempatkan di dalam RecyclerView.
    TextView tv1F, tv2F; //deklarasi textview
    ImageView imageViewF;  //deklarasi imageview

    public RecyclerViewHolderHome(View itemView) {
        super(itemView);
        tv1F = (TextView) itemView.findViewById(R.id.title);
        //menampilkan text dari widget CardView pada id daftar_judul
        tv2F = (TextView) itemView.findViewById(R.id.description);
        //menampilkan text deskripsi dari widget CardView pada id daftar_deskripsi
        imageViewF = (ImageView) itemView.findViewById(R.id.icon);
        //menampilkan gambar atau icon pada widget Cardview pada id daftar_icon
    }
}
