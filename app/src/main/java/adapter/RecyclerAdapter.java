package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import aslmedia.asl.com.recyclerviewlistenerdemo.R;
import model.StudentRecord;

/**
 * Created by Amardeep on 2/13/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyHolder>{

    private ArrayList<StudentRecord> studentRecords;
    private Context context;
    private CustomClickListener listener;

    public RecyclerAdapter(ArrayList<StudentRecord> studentRecord, Context context)
    {
        this.studentRecords=studentRecord;
        this.context=context;
    }

    //TODO Create ViewHolder class i.e. MyHolder
    public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView name, age, sex, address;
        public MyHolder(View view)
        {
            super(view);
            name=(TextView)view.findViewById(R.id.txtName);
            age=(TextView)view.findViewById(R.id.txtAge);
            sex=(TextView)view.findViewById(R.id.txtSex);
            address=(TextView)view.findViewById(R.id.txtAddress);

            //bind the listener
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //Check listener should not be null to avoid the exception
            if(listener!=null)
            listener.onClick(v, getAdapterPosition());
        }
    }

    //TODO define custom interface i.e. CustomClickListener
    public interface CustomClickListener {
        void onClick(View view, int position);
    }

    //TODO Create this custom function for bind Adapter(RecyclerAdapter) from activity class
    public void setClickListener(CustomClickListener itemClickListener) {
        this.listener = itemClickListener;
    }

    @Override
    public int getItemCount() {
        return studentRecords.size();
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        StudentRecord record=studentRecords.get(position);
        holder.name.setText(record.getName());
        holder.sex.setText(record.getSex());
        holder.age.setText(""+record.getAge());
        holder.address.setText(record.getAddress());
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_card_view_record, parent, false);
        //Return view to the Holder View class i.e. MyHolder
        return new MyHolder(view);
    }

}
