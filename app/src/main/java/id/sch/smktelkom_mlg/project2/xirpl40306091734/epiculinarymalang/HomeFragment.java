package id.sch.smktelkom_mlg.project2.xirpl40306091734.epiculinarymalang;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {
    RecyclerView recyclerView1;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView1 = (RecyclerView) getView().findViewById(R.id.recycler_view1);
        //menampilkan reyclerview yang ada pada file layout dengan id reycler view
        RecyclerAdapterHome adapter = new RecyclerAdapterHome(getActivity());
        //membuat adapter baru untuk reyclerview
        recyclerView1.setAdapter(adapter);
        //menset nilai dari adapter
        recyclerView1.setHasFixedSize(true);
        //menset setukuran

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView1.setLayoutManager(layoutManager);
        //menset layoutmanager dan menampilkan daftar/list
        //dalam bentuk linearlayoutmanager pada class saat ini
    }
}
