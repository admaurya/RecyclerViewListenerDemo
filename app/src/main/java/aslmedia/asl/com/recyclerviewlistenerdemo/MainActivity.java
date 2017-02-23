package aslmedia.asl.com.recyclerviewlistenerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import adapter.RecyclerAdapter;
import model.StudentRecord;


/**
 * Implements CustomClickListener for handle onClick events
 */
public class MainActivity extends AppCompatActivity  implements RecyclerAdapter.CustomClickListener{

    private ArrayList<StudentRecord> arrayRecords;
    private RecyclerAdapter recyclerAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SET RECORD in the list before passing it to the adapter.
        setData();

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerAdapter=new RecyclerAdapter(arrayRecords, MainActivity.this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerAdapter);

        //bind listener with RecyclerView
        recyclerAdapter.setClickListener(this);

    }

    /**
     *
     * @param view      It represents the selected view form the Adapter
     * @param position  It represents data item within an Adapter List
     */
    @Override
    public void onClick(View view, int position) {
        StudentRecord record=arrayRecords.get(position);
        Toast.makeText(getApplicationContext(), "Name : "+record.getName()+"\nAge : "+record.getAge()+"\nSex : "+record.getSex()+"\nAddress : "+record.getAddress(), Toast.LENGTH_SHORT).show();
    }


    private void setData()
    {
        arrayRecords=new ArrayList<>();
        StudentRecord record=new StudentRecord("Amardeep", "Male", "Delhi", 26);
        arrayRecords.add(record);

        record=new StudentRecord("Dev Kumar", "Male", "Lucknow", 12);
        arrayRecords.add(record);

        record=new StudentRecord("Anjali", "Female", "Allahabad", 22);
        arrayRecords.add(record);

        record=new StudentRecord("Alok", "Male", "Agra", 20);
        arrayRecords.add(record);

        record=new StudentRecord("Surya", "Male", "Chennai", 21);
        arrayRecords.add(record);

        record=new StudentRecord("Pooja", "Female", "Kolkata", 18);
        arrayRecords.add(record);

        record=new StudentRecord("Pavan", "Male", "Mumbai", 19);
        arrayRecords.add(record);

        record=new StudentRecord("Ravi", "Male", "Guwahati", 20);
        arrayRecords.add(record);

        record=new StudentRecord("Anju", "Female", "Banglore", 20);
        arrayRecords.add(record);

        record=new StudentRecord("Gaurav", "Male", "Patna", 15);
        arrayRecords.add(record);

        record=new StudentRecord("Deepak", "Male", "Chandigarh", 24);
        arrayRecords.add(record);
    }

}
