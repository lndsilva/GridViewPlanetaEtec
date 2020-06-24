package br.com.local.gridviewplanetaetec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    GridView gridView;

    String[] namePlanets = {"Jupiter", "Lua", "Marte", "Plutão", "Saturno", "Sol", "Terra", "Venus"};
    int[] imagePlanets = {R.drawable.jupiter, R.drawable.lua, R.drawable.marte,
            R.drawable.plutao, R.drawable.saturno, R.drawable.sol,
            R.drawable.terra, R.drawable.venus,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);

        //instanciar o meu adapter
        CustomAdapter customAdaper = new CustomAdapter();
        //gridview receber por parâmetro o adapter
        gridView.setAdapter(customAdaper);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), RecebePlaneta_Activity.class);

                intent.putExtra("name", namePlanets[position]);
                intent.putExtra("image", imagePlanets[position]);

                startActivity(intent);
            }
        });
    }

    public class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return imagePlanets.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view1 = getLayoutInflater().inflate(R.layout.modelo_layout, null);

            TextView name = view1.findViewById(R.id.txtPlanetas);
            ImageView image = view1.findViewById(R.id.images);

            name.setText(namePlanets[position]);
            image.setImageResource(imagePlanets[position]);

            return view1;
        }
    }
}