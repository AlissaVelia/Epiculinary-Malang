package id.sch.smktelkom_mlg.project2.xirpl40306091734.epiculinarymalang;

/**
 * Created by USER on 11/02/2017.
 */

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project2.xirpl40306091734.epiculinarymalang.adapter.food4adapter;
import id.sch.smktelkom_mlg.project2.xirpl40306091734.epiculinarymalang.model.food4;

public class food4Activity extends AppCompatActivity implements food4adapter.IHotelAdapter {
    public static final String HOTEL = "hotel";
    ArrayList<food4> mList = new ArrayList<>();
    food4adapter mAdapter;
    RecyclerView rvfood4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food4);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Malang Food");

        rvfood4 = (RecyclerView) findViewById(R.id.recycler_view_food4);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvfood4.setLayoutManager(layoutManager);
        mAdapter = new food4adapter(this, mList);
        rvfood4.setAdapter(mAdapter);

        filData();
    }

    private void filData() {
        Resources resources = getResources();
        String[] arJudul = resources.getStringArray(R.array.placesfood4);
        String[] arDeskripsi = resources.getStringArray(R.array.place_descfood4);
        String[] arDetail = resources.getStringArray(R.array.place_detailsfood4);
        String[] arLokasi = resources.getStringArray(R.array.place_locationsfood4);
        TypedArray a = resources.obtainTypedArray(R.array.places_picturefood4);
        String[] arFoto = new String[a.length()];
        for (int i = 0; i < arFoto.length; i++) {
            int id = a.getResourceId(i, 0);
            arFoto[i] = ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                    + resources.getResourcePackageName(id) + '/'
                    + resources.getResourceTypeName(id) + '/'
                    + resources.getResourceEntryName(id);
        }
        a.recycle();

        for (int i = 0; i < arJudul.length; i++) {
            mList.add(new food4(arJudul[i], arDeskripsi[i], arDetail[i],
                    arLokasi[i], arFoto[i]));
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void doClick(int pos) {
        Intent intent = new Intent(this, DetailActivity4.class);
        intent.putExtra(HOTEL, mList.get(pos));
        startActivity(intent);
    }
}
