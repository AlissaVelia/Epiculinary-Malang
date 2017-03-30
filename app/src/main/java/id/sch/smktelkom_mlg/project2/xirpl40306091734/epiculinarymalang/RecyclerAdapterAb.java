package id.sch.smktelkom_mlg.project2.xirpl40306091734.epiculinarymalang;

/**
 * Created by USER on 11/02/2017.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class RecyclerAdapterAb extends RecyclerView.Adapter<RecyclerViewHolderAb> {

    //deklarasi variable context

    private final Context context;

    String[] name = {"ve", "ve", "ve", "ve"};
    int[] img = {R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1};

    LayoutInflater inflater;
    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //memberi aksi saat cardview diklik berdasarkan posisi tertentu
            RecyclerViewHolderAb vholder = (RecyclerViewHolderAb) v.getTag();
//
        }
    };

    public RecyclerAdapterAb(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewHolderAb onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_list_food2, parent, false);
        RecyclerViewHolderAb viewHolderAb = new RecyclerViewHolderAb(v);
        return viewHolderAb;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolderAb holder, int position) {
        holder.tv1A.setText(name[position]);
        holder.tv1A.setOnClickListener(clickListener);
        holder.tv1A.setTag(holder);
        holder.imageViewA.setOnClickListener(clickListener);
        holder.imageViewA.setTag(holder);
        holder.imageViewA.setImageResource(img[position]);
    }

    @Override
    public int getItemCount() {
        return name.length;
    }

}
