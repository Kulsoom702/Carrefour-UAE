package com.example.grocery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.example.grocery.adapter.CategoryAdapter;
import com.example.grocery.adapter.DiscountedProductAdapter;
import com.example.grocery.adapter.RecentlyViewedAdapter;
import com.example.grocery.model.Category;
import com.example.grocery.model.DiscountedProducts;
import com.example.grocery.model.RecentlyViewed;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView discountedRecyclerView, categoryRecyclerView , recentlyViewedRecycler;
    DiscountedProductAdapter discountedProductAdapter;
    RecentlyViewedAdapter recentlyViewedAdapter;
    List<DiscountedProducts> discountedProductsList;
    List<RecentlyViewed> recentlyViewedList;
    CategoryAdapter categoryAdapter;
    List<Category> categoryList;
    ImageView allCategoryImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        discountedRecyclerView=findViewById(R.id.discountedRecycler);
        //adding data to model
        discountedProductsList =new ArrayList<>();
        discountedProductsList.add(new DiscountedProducts(1,R.drawable.discountberry));
        discountedProductsList.add(new DiscountedProducts(2,R.drawable.discountbrocoli));
        discountedProductsList.add(new DiscountedProducts(3,R.drawable.discountmeat));
        discountedProductsList.add(new DiscountedProducts(4,R.drawable.discountberry));
        discountedProductsList.add(new DiscountedProducts(5,R.drawable.discountbrocoli));
        discountedProductsList.add(new DiscountedProducts(6,R.drawable.discountmeat));
        setDiscountedRecycler(discountedProductsList);

        categoryRecyclerView =findViewById(R.id.catagoryRecycler);
        //adding data to model
        categoryList =new ArrayList<>();
        categoryList.add(new Category(1,R.drawable.ic_veggies));
        categoryList.add(new Category(2,R.drawable.ic_fruits));
        categoryList.add(new Category(3,R.drawable.ic_juce));
        categoryList.add(new Category(4,R.drawable.ic_dairy));
        categoryList.add(new Category(5,R.drawable.ic_meat));
        categoryList.add(new Category(6,R.drawable.ic_fish));
        categoryList.add(new Category(7,R.drawable.ic_egg));
        categoryList.add(new Category(8,R.drawable.ic_drink));
        categoryList.add(new Category(9,R.drawable.ic_desert));
        categoryList.add(new Category(10,R.drawable.ic_salad));
        categoryList.add(new Category(11,R.drawable.ic_cookies));
        categoryList.add(new Category(12,R.drawable.ic_spices));
        setCategoryRecycler();

        allCategoryImageView =findViewById(R.id.allCategoryImage);
        allCategoryImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AllCategory.class);
                startActivity(intent);
            }
        });

        recentlyViewedRecycler =findViewById(R.id.recently_items);
        //adding data to model
        recentlyViewedList =new ArrayList<>();
        recentlyViewedList.add(new RecentlyViewed("Nutella","","Rs. 399","1","Piece",R.drawable.card4,R.drawable.b4));
        recentlyViewedList.add(new RecentlyViewed("KokoKrunch","","Rs. 299","1","Piece",R.drawable.card3,R.drawable.b3));
        recentlyViewedList.add(new RecentlyViewed("Laptop","","Rs.40,000","1","",R.drawable.card2,R.drawable.b2));
        recentlyViewedList.add(new RecentlyViewed("Kitkat","","Rs.20","1","Pcs",R.drawable.card1,R.drawable.b1));
        setRecentlyRecycler();
    }

    private void setRecentlyRecycler() {
        RecyclerView.LayoutManager  layoutManager=new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recentlyViewedRecycler.setLayoutManager(layoutManager);
        recentlyViewedAdapter = new RecentlyViewedAdapter(this,recentlyViewedList);
        recentlyViewedRecycler.setAdapter(recentlyViewedAdapter);
    }

    private void setCategoryRecycler() {
        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this,categoryList);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }

    private void setDiscountedRecycler(List<DiscountedProducts> dataList) {
        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        discountedRecyclerView.setLayoutManager(layoutManager);
        discountedProductAdapter =new DiscountedProductAdapter(this,dataList);
        discountedRecyclerView.setAdapter(discountedProductAdapter);
    }

}