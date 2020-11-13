package com.example.a0306181262_dophannhatquang;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity
{
    String data = "";
    private RecyclerAdapter ReAdapter;
    private RecyclerView recyclerView;
    private final LinkedList<WordDict> listWord = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputStream inputStream = getApplicationContext().getResources().openRawResource(R.raw.dictionary);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String tempData = null;

        while(true)
        {
            try
            {
                if(!((tempData = bufferedReader.readLine()) != null))
                    break;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            stringBuilder.append(tempData);
            stringBuilder.append("\n");
        }

        data = stringBuilder.toString();

        try
        {
            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonArray = jsonObject.getJSONArray("ds");
            String word;
            String def;

            for(int i = 0; i < 10; i++)
            {
                word = jsonArray.getJSONObject(i).getString("word");
                def = jsonArray.getJSONObject(i).getString("definition");
                WordDict wD = new WordDict(word, def);

                listWord.addLast(wD);
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }


        final Intent intent = new Intent(this, AddWord.class);

//        if(intent.getStringExtra("word") != null && intent.getStringExtra("def") != null)
//        {
//            WordDict wd = new WordDict(intent.getStringExtra("word"), intent.getStringExtra("def"));
//            listWord.addFirst(wd);
//        }
        recyclerView = findViewById(R.id.recyclerView);
        ReAdapter = new RecyclerAdapter(this, listWord);
        recyclerView.setAdapter(ReAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void searchWord(View view)
    {
        EditText txtSearch = findViewById(R.id.searchWord);
        String word = txtSearch.getText().toString();
        LinkedList<WordDict> list = new LinkedList<>();

        for(int i = 0; i < listWord.size(); i++)
        {
            if(listWord.get(i).getWord().substring(0, word.length()).equalsIgnoreCase(word))
            {
                list.addLast(listWord.get(i));
            }
        }

        ReAdapter = new RecyclerAdapter(this, list);
        recyclerView.setAdapter(ReAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}