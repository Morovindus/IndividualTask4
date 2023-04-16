package com.example.individualtask4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.individualtask4.databinding.ActivityMainBinding;
import com.example.individualtask4.databinding.FooterBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Product> products = new ArrayList<Product>();
    static final String LOG_TAG = "myLogs";
    BoxAdapter boxAdapter;
    View header, footer;
    ListView lvMain;

    BoxAdapter boxadapter;
    static View v2;
    private ActivityMainBinding binding;
    private static FooterBinding binding_footer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        binding_footer = FooterBinding.inflate(getLayoutInflater());
        v2 = getLayoutInflater().inflate(R.layout.footer, null);
        //binding_footer.getRoot();
        View view = binding.getRoot();
        setContentView(view);


        header = createHeader("Магазин М.Х.Э.");
        footer = createFooter("Количество выбранных товаров:");
        boxAdapter = new BoxAdapter(this, products);

        fillData();
        lvMain = binding.lvMain;
        lvMain.addHeaderView(header);
        lvMain.addFooterView(footer);
        lvMain.setAdapter(boxAdapter);
        binding_footer.tvText1.setText("МАЯК");

        View view2 = binding_footer.getRoot();
        setContentView(view2);

    }

    public static void Change(Integer count){
        //((TextView)v2.findViewById(R.id.tvText1)).setText(count.toString());
        binding_footer.tvText1.setText("Товаров в корзине: " + count.toString());
        Log.d(LOG_TAG, count.toString());
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
        //Toast.makeText(this, count.toString(), Toast.LENGTH_LONG).show();
    }
    View createHeader(String text){
        View v = getLayoutInflater().inflate(R.layout.header, null);
        ((TextView)v.findViewById(R.id.tvText)).setText(text);
        return v;
    }

    View createFooter(String text){
        View v = getLayoutInflater().inflate(R.layout.footer, null);
        ((TextView)v.findViewById(R.id.tvText1)).setText(text);
        return v;
    }
}