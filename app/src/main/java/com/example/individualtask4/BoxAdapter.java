package com.example.individualtask4;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.individualtask4.databinding.ItemBinding;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class BoxAdapter extends BaseAdapter {
    Context ctx;
    final String LOG_TAG = "myLogs";
    LayoutInflater lInflater;
    ArrayList<Product> objects;

    BoxAdapter(Context context, ArrayList<Product> products){
        ctx = context;
        objects = products;
        lInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount(){
        return objects.size();
    }

    @Override
    public Object getItem(int position){
        return objects.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemBinding binding = ItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        Product p = getProduct(position);
        binding.tvId.setText(p.Id);
        binding.tvDescr.setText(p.name);
        binding.tvPrice.setText(p.price + " рублей");
        binding.ivImage.setImageResource(p.image);

        CheckBox cbBuy = binding.cbBox;

        cbBuy.setOnCheckedChangeListener(myCheckChangeList);
        cbBuy.setTag(position);
        cbBuy.setChecked(p.box);
        return binding.getRoot();
    }

    Product getProduct(int position){
        return ((Product) getItem(position));
    }

    ArrayList<Product> getBox(){
        ArrayList<Product> box = new ArrayList<Product>();
        for (Product p : objects) {
            if (p.box)
                box.add(p);
        }
        return box;
    }
    Integer count = 0;
    CompoundButton.OnCheckedChangeListener myCheckChangeList = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged (CompoundButton buttonView, boolean isChecked){
            getProduct((Integer) buttonView.getTag()).box = isChecked;

            if (isChecked == true) {
                count += 1;
                MainActivity.Change(count);
            }
            else {
                count -= 1;
                MainActivity.Change(count);
            }
        }
    };

}
