package com.example.owner.takeandgo.controller;
//TODO add Asynig task
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.owner.takeandgo.R;
import com.example.owner.takeandgo.model.backEnd.DBManagerFactory;
import com.example.owner.takeandgo.model.entities.Car;

import java.util.List;

public class ShowCarListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_car_list);
    }

    void initItemByListView()
    {
        ListView listView = new ListView(this);
        final List<Car> myItemList = DBManagerFactory.getManager().getCars();
        ArrayAdapter<Car> adapter = new ArrayAdapter<Car>(this, R.layout.activity_show_car_list, myItemList )
        {
            @Override
            public View getView(int position, View convertView, ViewGroup parent)
            {
                if (convertView == null) {
                    convertView = View.inflate(ShowCarListActivity.this, R.layout.activity_show_car_list, null);
                }
                TextView productNumberTextView = (TextView) convertView.findViewById(R.id.numberTextView);
                TextView productBranchNumberTextView = (TextView) convertView.findViewById(R.id.branchNumberTextView);
                TextView productionModelTypeTextView = (TextView) convertView.findViewById(R.id.modelTypeTextView);
                TextView productionMileageTextView = (TextView) convertView.findViewById(R.id.mileageTextView);
                productNumberTextView.setText((myItemList.get(position).getNumber()));
                productBranchNumberTextView.setText(( myItemList.get(position).getBranchNumber()));
                productionModelTypeTextView.setText((myItemList.get(position).getModelType()));
                productionMileageTextView.setText((myItemList.get(position).getMileage()));
                return convertView;
            }
        };
        listView.setAdapter(adapter);
        this.setContentView(listView);
    }
}
