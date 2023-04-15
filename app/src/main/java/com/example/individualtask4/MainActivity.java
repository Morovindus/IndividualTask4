package com.example.individualtask4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.individualtask4.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Product> products = new ArrayList<Product>();
    BoxAdapter boxAdapter;
    View header, footer;

    Integer count = 0;
    ListView lvMain;

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        header = createHeader("Магазин М.Х.Э.");
        footer = createFooter("Количество выбранных товаров:");
        boxAdapter = new BoxAdapter(this, products);

        fillData();

        lvMain = (ListView) findViewById(R.id.lvMain);
        lvMain.addHeaderView(header);
        lvMain.addFooterView(footer);
        lvMain.setAdapter(boxAdapter);


        View inflatedView = getLayoutInflater().inflate(R.layout.item, null);
        CheckBox cbBuy = (CheckBox) inflatedView.findViewById(R.id.cbBox);

        cbBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count += 1;
                /*if(isChecked()){
                    count += 1;
                } else {
                    count -= 1;
                }*/
            }
        });
    }


    void fillData(){
        products.add(new Product("#123456", "Product" + 1, 1 * 1000,
                R.drawable.ic_launcher_foreground, false));
        products.add(new Product("#678713","Product" + 2, 2 * 1000,
                R.drawable.ic_launcher_foreground, false));
        products.add(new Product("#856683","Product" + 3, 3 * 1000,
                R.drawable.ic_launcher_foreground, false));
        products.add(new Product("#962136","Product" + 4, 4 * 1000,
                R.drawable.ic_launcher_foreground, false));
        products.add(new Product("#862137","Product" + 5, 5 * 1000,
                R.drawable.ic_launcher_foreground, false));
        products.add(new Product("#816398","Product" + 6, 6 * 1000,
                R.drawable.ic_launcher_foreground, false));
    }

    public void showResult(View v){
        Toast.makeText(this, count.toString(), Toast.LENGTH_LONG).show();
    }
    View createHeader(String text){
        View v = getLayoutInflater().inflate(R.layout.header, null);
        ((TextView)v.findViewById(R.id.tvText)).setText(text);
        return v;
    }

    View createFooter(String text){
        View v = getLayoutInflater().inflate(R.layout.footer, null);
        ((TextView)v.findViewById(R.id.tvText)).setText(text);
        return v;
    }
}