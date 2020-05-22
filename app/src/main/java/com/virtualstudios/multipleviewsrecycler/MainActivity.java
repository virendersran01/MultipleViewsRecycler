package com.virtualstudios.multipleviewsrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.virtualstudios.multipleviewsrecycler.adapter.TripsAdapter;
import com.virtualstudios.multipleviewsrecycler.models.Ads;
import com.virtualstudios.multipleviewsrecycler.models.Item;
import com.virtualstudios.multipleviewsrecycler.models.News;
import com.virtualstudios.multipleviewsrecycler.models.Trip;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        List<Item> items = new ArrayList<>();

        Trip trip1 = new Trip(R.drawable.hacker1, "Hacker", "Hacking is power to bet");
        items.add(new Item(0, trip1));

        Ads ads1 = new Ads("Christmas Holiday", " 70% OFF on christmas sale");
        items.add(new Item(1, ads1));

        News news1 = new News("Bali, Indonesia", "You'll find beaches, konodo dragons and jungles sheltering elephants and tigers");
        items.add(new Item(3, news1));

        items.add(new Item(0, trip1));
        items.add(new Item(1, ads1));
        items.add(new Item(3, news1));


        recyclerView.setAdapter(new TripsAdapter(items));
    }
}
