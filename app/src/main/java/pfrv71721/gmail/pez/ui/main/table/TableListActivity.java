package pfrv71721.gmail.pez.ui.main.table;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import pfrv71721.gmail.pez.ui.main.table.grid.GridAutofitLayoutManager;
import pfrv71721.gmail.pez.R;
import pfrv71721.gmail.pez.ui.main.table.adapter.TableListAdapter;
import pfrv71721.gmail.pez.ui.main.table.data.Table;


public class TableListActivity extends AppCompatActivity implements SetOnTableListener {

    @BindView(R.id.labelTableListRv)
    RecyclerView labelTableListRv;

    private ArrayList<Table> arrayList =new ArrayList<>();
    private TableListAdapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_list);
        ButterKnife.bind(this);
        getSupportActionBar().hide();
        adapter=new TableListAdapter(this,arrayList);


        GridAutofitLayoutManager layoutManager = new GridAutofitLayoutManager(this, 160);

        labelTableListRv.setLayoutManager(layoutManager);
        labelTableListRv.setAdapter(adapter);


        for (int i=1;i<3;i++){
            Table table = new Table(i,0);
            arrayList.add(table);
        }

        for (int i=3;i<5;i++){
            Table table = new Table(i,2);
            arrayList.add(table);
        }

        for (int i=5;i<10;i++){
            Table table = new Table(i,1);
            arrayList.add(table);
        }

        adapter.notifyDataSetChanged();

    }

    @Override
    public void onClickTableListener(Table table) {
        Toast.makeText(this, table.getId()+" "+table.getState(), Toast.LENGTH_SHORT).show();

    }
}
