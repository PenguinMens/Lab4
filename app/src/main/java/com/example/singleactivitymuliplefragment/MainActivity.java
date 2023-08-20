package com.example.singleactivitymuliplefragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    AuFragment auFragment = new AuFragment();
    EuFragment euFragment = new EuFragment();

    MenuFragment menuFragment = new MenuFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadMenuFragment(1);
        MainActivityData mainActivityDataViewModel = new ViewModelProvider(this)
                .get(MainActivityData.class);
        mainActivityDataViewModel.clickedValue.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if(mainActivityDataViewModel.getClickedValue()==1){
                    loadAuFragment(1);
                }
                if(mainActivityDataViewModel.getClickedValue()==2){
                    loadEuFragment();
                }
                System.out.println(mainActivityDataViewModel.getClickedValue());
            }
        });
        NoteViewModel noteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);
        noteViewModel.clickedValue.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if(noteViewModel.getClickedValue() == 2)
                {
                    loadMenuFragment(-1);
                }
            }
        });
        /*
        Button auButton = menuFragment.getAuButton();
        Button euButton = menuFragment.getEuButton();
        auButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadAuFragment();
            }
        });
        euButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadEuFragment();
            }
        });*/
    }

    private void loadMenuFragment(int meta){
        FragmentManager fm = getSupportFragmentManager();
        Fragment frag = fm.findFragmentById(R.id.menu_container);
        if(meta == -1)
        {
            fm.beginTransaction().replace(R.id.menu_container,menuFragment).commit();
        }
        if(frag==null){
            fm.beginTransaction().add(R.id.menu_container,menuFragment).commit();
        }

    }


    private void loadAuFragment(int meta ){
        FragmentManager fm = getSupportFragmentManager();
        Fragment frag = fm.findFragmentById(R.id.menu_container);
        if(meta == -1)
        {
            if(frag==null){
                fm.beginTransaction().add(R.id.menu_container,auFragment).commit();
            }
            else{
                fm.beginTransaction().replace(R.id.menu_container,auFragment).commit();
            }
        }
        else
        {


            fm.beginTransaction().replace(R.id.menu_container,auFragment).commit();

        }

    }
    private void loadEuFragment(){
        FragmentManager fm = getSupportFragmentManager();
        Fragment frag = fm.findFragmentById(R.id.menu_container);
        if(frag==null){
            fm.beginTransaction().add(R.id.menu_container,euFragment).commit();
        }
        else{
            fm.beginTransaction().replace(R.id.menu_container,euFragment).commit();
        }
    }
}