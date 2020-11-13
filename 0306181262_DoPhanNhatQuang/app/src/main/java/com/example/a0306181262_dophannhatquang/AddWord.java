package com.example.a0306181262_dophannhatquang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddWord extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);
    }

    public void backButton (View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void addWord (View view)
    {
        EditText txtWord = findViewById(R.id.addWord);
        EditText txtDef = findViewById(R.id.addDef);

        if(!txtWord.getText().toString().isEmpty())
        {
            for(int i = 0; i < txtWord.getText().toString().length(); i++)
            {
                if(Character.isSpaceChar(txtWord.getText().toString().charAt(i)))
                {
                    Toast.makeText(this, "Có chứa ký tự khoảng trắng", Toast.LENGTH_SHORT).show();
                }
                else
                {
//                    Intent intent = new Intent(this, MainActivity.class);
//                    intent.putExtra("word", txtWord.getText().toString());
//                    intent.putExtra("def", txtDef.getText().toString());
                    Toast.makeText(this, "Thêm thành công", Toast.LENGTH_LONG).show();
                }
            }
        }
        else
            {
                Toast.makeText(this, "Nhập từ cần thêm vào", Toast.LENGTH_LONG).show();
            if (!txtDef.getText().toString().isEmpty()) {
                Toast.makeText(this, "Phần định nghĩa không được bỏ trống", Toast.LENGTH_LONG).show();
            }
        }
    }
}