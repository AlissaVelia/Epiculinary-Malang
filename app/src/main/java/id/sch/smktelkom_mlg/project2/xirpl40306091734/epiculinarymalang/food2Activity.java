package id.sch.smktelkom_mlg.project2.xirpl40306091734.epiculinarymalang;

/**
 * Created by USER on 11/02/2017.
 */

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project2.xirpl40306091734.epiculinarymalang.adapter.food2adapter;
import id.sch.smktelkom_mlg.project2.xirpl40306091734.epiculinarymalang.model.food1;
import id.sch.smktelkom_mlg.project2.xirpl40306091734.epiculinarymalang.model.food2;

public class food2Activity extends AppCompatActivity implements food2adapter.IHotelAdapter {
    public static final String HOTEL = "hotel";
    ArrayList<food2> mList = new ArrayList<>();
    food2adapter mAdapter;

    ArrayList<food2> mListAll = new ArrayList<>();
    boolean isFiltered;
    ArrayList<Integer> mListMapFilter = new ArrayList<>();
    String mQuery;
    RecyclerView rvfood2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Main Course");

        rvfood2 = (RecyclerView) findViewById(R.id.recycler_view_food2);
        LinearLayoutManager layoutManager = new GridLayoutManager(this,2);
         rvfood2.setLayoutManager(layoutManager);
        mAdapter = new food2adapter(this, mList);
        rvfood2.setAdapter(mAdapter);

        filData();
    }

    private void filData() {
        Resources resources = getResources();
        String[] arJudul = resources.getStringArray(R.array.placesfood2);
        String[] arDeskripsi = resources.getStringArray(R.array.place_descfood2);
        String[] arDetail = resources.getStringArray(R.array.place_detailsfood2);
        String[] arLokasi = resources.getStringArray(R.array.place_locationsfood2);
        TypedArray a = resources.obtainTypedArray(R.array.places_picturefood2);
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
            mList.add(new food2(arJudul[i], arDeskripsi[i], arDetail[i],
                    arLokasi[i], arFoto[i]));
        }
        mAdapter.notifyDataSetChanged();
    }

    private void doFilter(String query) {
        if (!isFiltered) {
            mListAll.clear();
            mListAll.addAll(mList);
            isFiltered = true;
        }
        mList.clear();
        if (query == null || query.isEmpty()) {
            mList.addAll(mListAll);
            isFiltered = false;
        } else {
            mListMapFilter.clear();
            for (int i = 0; i < mListAll.size(); i++) {
                food2 food = mListAll.get(i);
                if (food.judul.toLowerCase().contains(query) ||
                        food.deskripsi.toLowerCase().contains(query) ||
                        food.lokasi.toLowerCase().contains(query)) {
                    mList.add(food);
                    mListMapFilter.add(i);
                }
            }
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mQuery = newText.toLowerCase();
                doFilter(mQuery);
                return true;
            }
        });
        return true;
    }
    @Override
    public void doClick(int pos) {
        Intent intent = new Intent(this, DetailActivity2.class);
        intent.putExtra(HOTEL, mList.get(pos));
        startActivity(intent);
    }
}
