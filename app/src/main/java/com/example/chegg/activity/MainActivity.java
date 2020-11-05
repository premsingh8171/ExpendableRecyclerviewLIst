package com.example.chegg.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chegg.R;
import com.example.chegg.adapter.MainAdapter;
import com.example.chegg.modelactivity.ChapterModel;
import com.example.chegg.modelactivity.ChapterSubModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MainAdapter adapter;
    private RecyclerView main_rv;
    private ArrayList<ChapterModel> list_p = new ArrayList<>();
    private ArrayList<ChapterSubModel> list_c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_rv = findViewById(R.id.main_rv);
        list();
    }
    private void list() {
        for (int i = 0; i < 4; i++) {
            ChapterModel model = new ChapterModel();
            if (i == 0) {
                model.setChapter("Chapter1");
                list_c = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    ChapterSubModel model1_c = new ChapterSubModel();
                    if (j == 0) {
                        model1_c.setSub_chapter("Data_1");
                    } else if (j == 1) {
                        model1_c.setSub_chapter("Data_2");
                    } else {
                        model1_c.setSub_chapter("Data_3");
                    }
                    list_c.add(model1_c);
                }
                model.setChildList(list_c);
            } else if (i == 1) {
                model.setChapter("Chapter2");
                list_c = new ArrayList<>();
                for (int j = 0; j < 4; j++) {
                    ChapterSubModel model1_c = new ChapterSubModel();
                    if (j == 0) {
                        model1_c.setSub_chapter("Data_21");
                    } else if (j == 1) {
                        model1_c.setSub_chapter("Data_22");
                    } else if (j == 2) {
                        model1_c.setSub_chapter("Data_23");
                    } else {
                        model1_c.setSub_chapter("Data_24");
                    }
                    list_c.add(model1_c);
                }
                model.setChildList(list_c);
            } else if (i == 2) {
                model.setChapter("Chapter3");
                list_c = new ArrayList<>();
                for (int j = 0; j < 4; j++) {
                    ChapterSubModel model1_c = new ChapterSubModel();
                    if (j == 0) {
                        model1_c.setSub_chapter("Data_31");
                    } else if (j == 1) {
                        model1_c.setSub_chapter("Data_32");
                    } else if (j == 2) {
                        model1_c.setSub_chapter("Data_33");
                    } else {
                        model1_c.setSub_chapter("Data_34");
                    }
                    list_c.add(model1_c);
                }
                model.setChildList(list_c);
            } else if (i == 3) {
                model.setChapter("Chapter4");
                list_c = new ArrayList<>();
                for (int j = 0; j < 4; j++) {
                    ChapterSubModel model1_c = new ChapterSubModel();
                    if (j == 0) {
                        model1_c.setSub_chapter("Data_41");
                    } else if (j == 1) {
                        model1_c.setSub_chapter("Data_42");
                    } else if (j == 2) {
                        model1_c.setSub_chapter("Data_43");
                    } else {
                        model1_c.setSub_chapter("Data_44");
                    }
                    list_c.add(model1_c);

                }
                model.setChildList(list_c);
            }
            list_p.add(model);
        }
        rv_list(list_p);
        Log.d("list__p_", String.valueOf(list_p.size()));
    }

    private void rv_list(ArrayList<ChapterModel> list_p_) {
        adapter = new MainAdapter(this, list_p_, new MainAdapter.OnClickItem() {
            @Override
            public void onClickItem(ChapterModel model) {

            }
        });
        main_rv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}