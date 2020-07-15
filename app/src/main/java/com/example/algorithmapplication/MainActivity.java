package com.example.algorithmapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.algorithmapplication.algorithm.Find;
import com.example.algorithmapplication.algorithm.ReplaceSpace;
import com.example.algorithmapplication.algorithm.TwoSum;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ReplaceSpace.testReplaceSpace();
    }
}