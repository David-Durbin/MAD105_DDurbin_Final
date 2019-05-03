package com.example.ddurbin_temp_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;


public class Main2Activity extends AppCompatActivity {

    ImageView curView = null;
    private int pairCount = 0;
    final int[] drawable = new int[]{R.drawable.sample_1,R.drawable.sample_2,R.drawable.sample_3,
    R.drawable.sample_4,R.drawable.sample_5,R.drawable.sample_6,R.drawable.sample_7};

    int[] pos = {0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7};
    int currentPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        GridView gridView = (GridView) findViewById(R.id.idGridView);
        ImageAdapter imageAdapter = new ImageAdapter(this);
        gridView.setAdapter(imageAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(currentPosition < 0)
                {
                    currentPosition = position;
                    curView = (ImageView) view;
                    ((ImageView)view).setImageResource(drawable[pos[position]]);
                }
                else
                {
                    if(currentPosition == position)
                    {
                        ((ImageView)view).setImageResource(R.drawable.back);
                    }
                    else if(pos[currentPosition] != pos[position])
                    {
                        curView.setImageResource(R.drawable.back);
                        Toast.makeText(getApplicationContext(), "Not a match", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        ((ImageView)view).setImageResource(drawable[pos[position]]);
                        pairCount++;

                        if(pairCount == 0)
                        {
                            Toast.makeText(getApplicationContext(), "You Win!", Toast.LENGTH_LONG).show();
                        }

                        currentPosition = -1;
                    }
                }
            }
        });
    }
}
