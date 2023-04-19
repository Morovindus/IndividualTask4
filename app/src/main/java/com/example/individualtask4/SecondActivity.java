package com.example.individualtask4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.individualtask4.databinding.ActivityMainBinding;
import com.example.individualtask4.databinding.ActivitySecondBinding;
import com.example.individualtask4.databinding.FooterBinding;
import com.example.individualtask4.databinding.HeaderBinding;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    BoxAdapter boxAdapter;
    ListView lvMain;
    private static ActivitySecondBinding binding_second_activity;
    private static FooterBinding binding_footer;
    private static HeaderBinding binding_header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding_second_activity = ActivitySecondBinding.inflate(getLayoutInflater());
        binding_header = HeaderBinding.inflate(getLayoutInflater());
        binding_footer = FooterBinding.inflate(getLayoutInflater());
        View view = binding_second_activity.getRoot();
        setContentView(view);

        createHeader("Корзина");
        createFooter("Сумма выбранных товаров:");

        ArrayList<Product> products = (ArrayList<Product>) getIntent().getSerializableExtra("ARRAYLIST");
        boxAdapter = new BoxAdapter(this, products);

        binding_footer.tvText1.setText("Сумма выбранных товаров: " + getSum(products));
        binding_footer.button.setText("Back");

        lvMain = binding_second_activity.lvMain;
        lvMain.addHeaderView(binding_header.getRoot());
        lvMain.addFooterView(binding_footer.getRoot());
        lvMain.setAdapter(boxAdapter);
    }
    public Integer getSum(ArrayList<Product> products){
        Integer sum = 0;
        for (Product p : products) {
            sum += p.price;
        }
        return sum;
    }
    public void showResult(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    void createHeader(String text){
        binding_header.tvText.setText(text);
    }
    void createFooter(String text){
        binding_footer.tvText1.setText(text);
    }
}