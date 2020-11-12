package com.example.dicionary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity
{
    private final LinkedList<String> listWord = new LinkedList<>();
    private RecyclerAdapter ReAdapter;
    private RecyclerView recyclerView;
    String Data = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputStream is = getApplicationContext().getResources().openRawResource(R.raw.dictionary);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String tempData = null;
        while(true)
        {
            try
            {
                if(!((tempData = br.readLine()) != null))
                {
                    break;
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            sb.append(tempData);
        }

        Data = sb.toString();

        try
        {
            JSONObject jsonObject = new JSONObject(Data);
            JSONArray arrayWord = jsonObject.getJSONArray("word");

            for(int i = 0; i < arrayWord.length(); i++)
            {
                listWord.addLast(arrayWord.getString(i));
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

        recyclerView = findViewById(R.id.recyclerView);
        ReAdapter = new RecyclerAdapter(this, listWord);
        recyclerView.setAdapter(ReAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void addWord (View view)
    {
        EditText editText = findViewById(R.id.addWord);
        if(editText.getText().toString() != null)
        {
            listWord.addLast(editText.getText().toString());
            ReAdapter = new RecyclerAdapter(this, listWord);
            recyclerView.setAdapter(ReAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
        else
            Toast.makeText(this, "Nhập từ cần thêm vào !!!", Toast.LENGTH_SHORT);
    }

    public void searchWord (View view)
    {
        EditText editText = findViewById(R.id.addWord);
        LinkedList<String> list = new LinkedList<>();

        if(editText.getText().toString() != null)
        {
            for(int i = 0; i < listWord.size(); i++)
                if(editText.getText().toString().equalsIgnoreCase(listWord.get(i).toString()))
                    list.addLast(listWord.get(i).toString());

            ReAdapter = new RecyclerAdapter(this, list);
            recyclerView.setAdapter(ReAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
        else
            Toast.makeText(this, "Nhập từ cần tìm vào !!!", Toast.LENGTH_SHORT);
    }
}