package com.profe.menulistas;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.profe.menulistas.fragments.ListCamisasFragment;
import com.profe.menulistas.fragments.ListPantalonesFragment;
import com.profe.menulistas.fragments.ZapatosFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView navView;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = (DrawerLayout) findViewById(R.id.drawer);
        navView = (NavigationView) findViewById(R.id.navView);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navView.setNavigationItemSelectedListener(this);

        fm = getSupportFragmentManager();
        fm.popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawer.openDrawer(GravityCompat.START);
                break;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_camisas:
                ListCamisasFragment listCamisasFragment = ListCamisasFragment.newInstance();
                fm.beginTransaction().replace(R.id.container,listCamisasFragment).commit();
                break;
            case R.id.item_pantalones:
                ListPantalonesFragment listPantalonesFragment = ListPantalonesFragment.newInstance();
                fm.beginTransaction().replace(R.id.container,listPantalonesFragment).commit();
                break;
            case R.id.item_zapatos:
                ZapatosFragment zapatosFragment = ZapatosFragment.newInstance();
                fm.beginTransaction().replace(R.id.container,zapatosFragment).commit();
                break;
        }
        item.setChecked(true);
        getSupportActionBar().setTitle(item.getTitle());
        drawer.closeDrawers();

        return true;
    }
}
