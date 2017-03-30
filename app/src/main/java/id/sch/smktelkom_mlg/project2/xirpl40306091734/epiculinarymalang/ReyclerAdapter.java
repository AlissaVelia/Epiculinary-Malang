package id.sch.smktelkom_mlg.project2.xirpl40306091734.epiculinarymalang;

/**
 * Created by USER on 11/02/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    //deklarasi variable context

    private final Context context;

    String[] name = {"1", "2", "3", "4",
            "5"};
    String[] desc = {".", ".", ".", ".", "."};
    int[] img = {R.drawable.apetizer, R.drawable.main, R.drawable.dessert, R.drawable.malang, R.drawable.street};
    // menampilkan list item dalam bentuk text dengan tipe data string dengan variable name

    LayoutInflater inflater;
    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //member aksi saat cardview diklik berdasarkan posisi tertentu
            RecyclerViewHolder vholder = (RecyclerViewHolder) v.getTag();
            int position = vholder.getPosition();
            if (position == 0 && position < getItemCount()) {
                Intent intent = new Intent(context, food1Activity.class);
                context.startActivity(intent);
            }
            if (position == 1 && position < getItemCount()) {
                Intent intent = new Intent(context, food2Activity.class);
                context.startActivity(intent);
            }
            if (position == 2 && position < getItemCount()) {
                Intent intent = new Intent(context, food3Activity.class);
                context.startActivity(intent);
            }
            if (position == 3 && position < getItemCount()) {
                Intent intent = new Intent(context, food4Activity.class);
                context.startActivity(intent);
            }
            if (position == 4 && position < getItemCount()) {
                Intent intent = new Intent(context, food5Activity.class);
                context.startActivity(intent);
            }
        }
    };

    public RecyclerAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_list, parent, false);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.tv1.setText(name[position]);
        holder.tv1.setOnClickListener(clickListener);
        holder.tv1.setTag(holder);
        holder.tv2.setText(desc[position]);
        holder.imageView.setOnClickListener(clickListener);
        holder.imageView.setTag(holder);
        holder.imageView.setImageResource(img[position]);
    }

    @Override
    public int getItemCount() {
        return name.length;
    }
}
