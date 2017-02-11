package id.sch.smktelkom_mlg.project2.xirpl40306091734.epiculinarymalang;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Rehan on 12/2/2016.
 */

public class RecyclerAdapterAb extends RecyclerView.Adapter<RecyclerViewHolderAb> {

    //deklarasi variable context

    private final Context context;

    String[] name = {"Alfan Cahyo Wicaksono", "Galbie Elinour", "Multazam Arroihan G", "Septy Nur Aulia D"};
    String[] desc = {"XIRPL5 | 3", "XIRPL5 | 12", "XIRPL5 | 21", "XIRPL5 | 30"};
    int[] img = {R.drawable.mch1, R.drawable.mch2, R.drawable.mch3, R.drawable.mch4};
    // menampilkan list item dalam bentuk text dengan tipe data string dengan variable name

    LayoutInflater inflater;
    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //memberi aksi saat cardview diklik berdasarkan posisi tertentu
            RecyclerViewHolderAb vholder = (RecyclerViewHolderAb) v.getTag();
            int position = vholder.getPosition();
            if (position == 0 && position < getItemCount()) {
                Toast.makeText(context, "Instagram : @alpanstopper", Toast.LENGTH_LONG).show();
            }
            if (position == 1 && position < getItemCount()) {
                Toast.makeText(context, "Instagram : @galbielinour", Toast.LENGTH_LONG).show();
            }
            if (position == 2 && position < getItemCount()) {
                Toast.makeText(context, "Instagram : @rehanarroihan", Toast.LENGTH_LONG).show();
            }
            if (position == 3 && position < getItemCount()) {
                Toast.makeText(context, "Instagram : @septydarmantya", Toast.LENGTH_LONG).show();
            }
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
        holder.tv2A.setText(desc[position]);
        holder.imageViewA.setOnClickListener(clickListener);
        holder.imageViewA.setTag(holder);
        holder.imageViewA.setImageResource(img[position]);
    }

    @Override
    public int getItemCount() {
        return name.length;
    }

}
