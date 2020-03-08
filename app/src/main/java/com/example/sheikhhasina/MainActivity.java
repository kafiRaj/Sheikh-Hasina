package com.example.sheikhhasina;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ExpandableListView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    private ExpandListAddapter expandListAddapter;
    private ExpandableListView expandableListView;

    List<MenuModel> menuModelList = new ArrayList<>();
    HashMap<MenuModel, List<MenuModel>> chidlist = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.toolbarId);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Home");
        mToolbar.setTitleTextColor(Color.WHITE);


        drawerLayout = findViewById(R.id.drawerLayId);
        navigationView = findViewById(R.id.navViewId);
        expandableListView = findViewById(R.id.expaneded_menuId);


        prePareMenu();
        populateExpandableList();


        ActionBarDrawerToggle actionBarDrawerToggle =
                new ActionBarDrawerToggle(this, drawerLayout, mToolbar, R.string.navigation_open, R.string.navigation_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(Color.WHITE);
        actionBarDrawerToggle.syncState();





    }



    private void prePareMenu() {

        MenuModel menuModel1 = new MenuModel("জীবন বৃত্তান্ত", true,true);
        MenuModel menuModel2 = new MenuModel("উদ্যোগ", true,true);
        MenuModel menuModel3 = new MenuModel("অর্জন", true,true);
        MenuModel menuModel4 = new MenuModel("ডিজিটাল সেবা", true,true);
        MenuModel menuModel5 = new MenuModel("হ্যালো PM", true,true);
        MenuModel menuModel6 = new MenuModel("মতামত অভিযোগ", true,true);


        menuModelList.add(menuModel1);
        menuModelList.add(menuModel2);
        menuModelList.add(menuModel3);
        menuModelList.add(menuModel4);
        menuModelList.add(menuModel5);
        menuModelList.add(menuModel6);

        // set child list

        List<MenuModel> childModelList1 = new ArrayList<>();
        List<MenuModel> childModelList2 = new ArrayList<>();
        List<MenuModel> childModelList3 = new ArrayList<>();
        List<MenuModel> childModelList4 = new ArrayList<>();
        List<MenuModel> childModelList5 = new ArrayList<>();
        List<MenuModel> childModelList6 = new ArrayList<>();

        //child for menu1

        MenuModel childItem1 = new MenuModel("ব্যক্তিগত জীবন",false,false);
        childModelList1.add(childItem1);

        childItem1 = new MenuModel("শিক্ষা জীবন",false,false);
        childModelList1.add(childItem1);

        childItem1 = new MenuModel("রাজনৈতিক জীবন",false,false);
        childModelList1.add(childItem1);

        if (menuModel1.hasChild){

            chidlist.put(menuModel1, childModelList1);
        }


        //child for menu2
        MenuModel childItem2 = new MenuModel("ব্যক্তিগত জীবন",false,false);
        childModelList2.add(childItem2);

        childItem2 = new MenuModel("শিক্ষা জীবন",false,false);
        childModelList2.add(childItem2);

        if (menuModel2.hasChild){

            chidlist.put(menuModel2, childModelList2);
        }

        //child for menu3
        MenuModel childItem3 = new MenuModel("ব্যক্তিগত জীবন",false,false);
        childModelList3.add(childItem3);

        childItem3 = new MenuModel("ব্যক্তিগত জীবন",false,false);
        childModelList3.add(childItem3);

        if (menuModel3.hasChild){

            chidlist.put(menuModel3, childModelList3);
        }

        //child for menu4

        MenuModel childItem4 = new MenuModel("ব্যক্তিগত জীবন",false,false);
        childModelList4.add(childItem4);

        childItem4 = new MenuModel("ব্যক্তিগত জীবন",false,false);
        childModelList4.add(childItem4);

        if (menuModel4.hasChild){

            chidlist.put(menuModel4, childModelList4);
        }



        //child for menu5

        MenuModel childItem5 = new MenuModel("ব্যক্তিগত জীবন",false,false);
        childModelList5.add(childItem5);

        childItem5 = new MenuModel("ব্যক্তিগত জীবন",false,false);
        childModelList5.add(childItem5);

        if (menuModel5.hasChild){

            chidlist.put(menuModel5, childModelList5);
        }

        //child for menu6


        MenuModel childItem6 = new MenuModel("ব্যক্তিগত জীবন",false,false);
        childModelList6.add(childItem6);

        childItem6 = new MenuModel("ব্যক্তিগত জীবন",false,false);
        childModelList6.add(childItem6);

        if (menuModel6.hasChild){

            chidlist.put(menuModel6, childModelList6);
        }





    }



    private void populateExpandableList() {

        expandListAddapter = new ExpandListAddapter(this, menuModelList, chidlist);
        expandableListView.setAdapter(expandListAddapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {

                if (menuModelList.get(i).isGroup){

                    if (!menuModelList.get(i).hasChild){


                    }
                }
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.appbar_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }
}
