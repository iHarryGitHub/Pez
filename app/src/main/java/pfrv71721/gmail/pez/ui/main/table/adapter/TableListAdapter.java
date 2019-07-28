package pfrv71721.gmail.pez.ui.main.table.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import pfrv71721.gmail.pez.R;
import pfrv71721.gmail.pez.ui.main.table.SetOnTableListener;
import pfrv71721.gmail.pez.ui.main.table.data.Table;

public class TableListAdapter extends RecyclerView.Adapter<TableListAdapter.MyViewHolder> {

    private SetOnTableListener listener;


    ArrayList<Table> arrayList;


    public TableListAdapter(SetOnTableListener listener, ArrayList<Table> arrayList) {
        this.listener = listener;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_table, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Table table = arrayList.get(position);
        holder.setNumber(table.getId());
        holder.setState(table.getState());
        holder.bind(table);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_button_table)
        Button ButtonTable;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void setNumber(int id) {
            this.ButtonTable.setText(id+"");
        }


        public void setState(int state) {
            switch (state){
                case 0:
                    this.ButtonTable.setBackgroundColor(ButtonTable.getContext().getResources().getColor(R.color.md_green_500));
                    break;
                case 1:
                    this.ButtonTable.setBackgroundColor(ButtonTable.getContext().getResources().getColor(R.color.md_red_500));
                    break;
                case 2:
                    this.ButtonTable.setBackgroundColor(ButtonTable.getContext().getResources().getColor(R.color.md_blue_500));
                    break;
            }
        }

        public void bind(Table table) {
            this.ButtonTable.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClickTableListener(table);
                }
            });
        }
    }
}
