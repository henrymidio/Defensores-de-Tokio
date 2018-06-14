package br.com.henrique.det;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import br.com.henrique.det.R;
import br.com.henrique.det.br.com.henrique.det.tabs.FragmentTab1;
import br.com.henrique.det.br.com.henrique.det.tabs.FragmentTab2;
import br.com.henrique.det.br.com.henrique.det.tabs.FragmentTab3;
import br.com.henrique.det.br.com.henrique.det.tabs.FragmentTab4;

public class Tabs extends ActionBarActivity {

    Ficha character = new Ficha();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);

        final ActionBar actionBar = getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0d6ca0")));
        actionBar.setTitle("Ficha de Personagem");
        actionBar.setDisplayHomeAsUpEnabled(true);
        // Specify that tabs should be displayed in the action bar.
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

       character = (Ficha)getIntent().getExtras().getSerializable("personagem");


        setupTabs();


    }

    public void setupTabs() {

        final ActionBar actionBar = getActionBar();
        // Specify that tabs should be displayed in the action bar.
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab tab1 = actionBar.newTab();
        tab1.setText("Características");
        tab1.setTabListener(new MyTabListener(new FragmentTab1(character)));
        actionBar.addTab(tab1);

        ActionBar.Tab tab2 = actionBar.newTab();
        tab2.setText("Vantagens");
        tab2.setTabListener(new MyTabListener(new FragmentTab2(character)));
        actionBar.addTab(tab2);

        ActionBar.Tab tab3 = actionBar.newTab();
        tab3.setText("Tipos de Dano");
        tab3.setTabListener(new MyTabListener(new FragmentTab3(character)));
        actionBar.addTab(tab3);

        ActionBar.Tab tab4 = actionBar.newTab();
        tab4.setText("Dinheiro e Itens");
        tab4.setTabListener(new MyTabListener(new FragmentTab4(character)));
        actionBar.addTab(tab4);

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            Intent i = new Intent(this, CriarPersonagem.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    private class MyTabListener implements ActionBar.TabListener {

        private Fragment fragment;

        public MyTabListener(Fragment frag){

            this.fragment = frag;

        }


        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

            ft.replace(R.id.scroll, fragment);


        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

            ft.remove(fragment);

        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

        }
    }
}
