package com.example.individualtask4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.individualtask4.databinding.ActivityMainBinding;
import com.example.individualtask4.databinding.FooterBinding;
import com.example.individualtask4.databinding.HeaderBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Product> products = new ArrayList<Product>();
    static final String LOG_TAG = "myLogs";
    BoxAdapter boxAdapter;
    View header, footer;
    ListView lvMain;
    private static ActivityMainBinding binding_main;
    private static FooterBinding binding_footer;
    private static HeaderBinding binding_header;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding_main = ActivityMainBinding.inflate(getLayoutInflater());
        binding_header = HeaderBinding.inflate(getLayoutInflater());
        binding_footer = FooterBinding.inflate(getLayoutInflater());
        View view = binding_main.getRoot();
        setContentView(view);

        createHeader("Каталог");
        createFooter("Товаров в корзине: ");
        boxAdapter = new BoxAdapter(this, products);

        fillData();
        lvMain = binding_main.lvMain;
        lvMain.addHeaderView(binding_header.getRoot());
        lvMain.addFooterView(binding_footer.getRoot());
        lvMain.setAdapter(boxAdapter);

    }

    public static void Change(Integer count){
        binding_footer.tvText1.setText("Товаров в корзине: " + count.toString());
        Log.d(LOG_TAG, count.toString());
    }
    void fillData(){
        products.add(new Product("#123456", "Батарейка ААА", 99,
                R.drawable.picture_1_foreground, false));
        products.add(new Product("#678713","Зонтик", 1499,
                R.drawable.picture_2_foreground, false));
        products.add(new Product("#856683","Кровать", 13999,
                R.drawable.picture_3_foreground, false));
        products.add(new Product("#962136","Торт", 879,
                R.drawable.picture_4_foreground, false));
        products.add(new Product("#862137","Фонарь", 1260,
                R.drawable.picture_5_foreground, false));
        products.add(new Product("#816398","Наушники", 7980,
                R.drawable.picture_6_foreground, false));
    }

    void createHeader(String text){
        binding_header.tvText.setText(text);
    }

    void createFooter(String text){
        binding_footer.tvText1.setText(text);
    }
}