package com.example.universalcinema;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.graphics.drawable.Drawable;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.print.PrintJob;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;
import me.relex.circleindicator.CircleIndicator2;
import me.relex.circleindicator.CircleIndicator3;

import static com.example.universalcinema.R.id.recyclerView;
import static com.example.universalcinema.R.layout.activity_main;

public class MainActivity extends AppCompatActivity
{
    private ViewPager viewPager;
    private ViewPager transPage;
    private CircleIndicator circleIndicator;
    private ImageAdapter adapter;
    private List<Photo> listImg;
    private Timer timer;
    private BottomNavigationView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        menu = findViewById(R.id.bottom_menu);
        transPage = findViewById(R.id.viewPager2);
        
        setUpViewPager();
        
        menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                switch (item.getItemId())
                {
                    case R.id.home:
                        transPage.setCurrentItem(0);
                        break;
                    case R.id.theater:
                        transPage.setCurrentItem(1);
                        break;
                    case R.id.search:
                        transPage.setCurrentItem(2);
                        break;
                    case R.id.account:
                        transPage.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });

        viewPager = findViewById(R.id.viewPager);
        circleIndicator = findViewById(R.id.circle);

        listImg = getListImg();

        adapter = new ImageAdapter(this, listImg);
        viewPager.setAdapter(adapter);
        circleIndicator.setViewPager(viewPager);

        adapter.registerDataSetObserver(circleIndicator.getDataSetObserver());

        AutoSlideImg();
    }

    private void setUpViewPager()
    {
        MenuAdapter adapter = new MenuAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        transPage.setAdapter(adapter);

        transPage.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {

            }

            @Override
            public void onPageSelected(int position)
            {
                switch (position)
                {
                    case 0:
                    menu.getMenu().findItem(R.id.home).setChecked(true);
                        break;
                    case 1:
                        menu.getMenu().findItem(R.id.theater).setChecked(true);
                        break;
                    case 2:
                        menu.getMenu().findItem(R.id.search).setChecked(true);
                        break;
                    case 3:
                        menu.getMenu().findItem(R.id.account).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state)
            {

            }
        });
    }

    private List<Photo> getListImg()
    {
        List<Photo> list = new ArrayList<>();
        list.add(new Photo(R.drawable.slide1));
        list.add(new Photo(R.drawable.slide2));
        list.add(new Photo(R.drawable.slide3));
        list.add(new Photo(R.drawable.slide4));
        list.add(new Photo(R.drawable.slide5));
        return list;
    }

    private void AutoSlideImg()
    {
        if(listImg == null || listImg.isEmpty() || viewPager == null)
            return;
        if(timer == null)
            timer = new Timer();
        timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                new Handler(Looper.getMainLooper()).post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        int currentIndex = viewPager.getCurrentItem();
                        int totalIndex = listImg.size() - 1;

                        if(currentIndex < totalIndex)
                        {
                            currentIndex++;
                            viewPager.setCurrentItem(currentIndex);
                        }
                        else
                            viewPager.setCurrentItem(0);
                    }
                });
            }
        },500, 3000);
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        if(timer != null)
        {
            timer.cancel();
            timer = null;
        }
    }
}