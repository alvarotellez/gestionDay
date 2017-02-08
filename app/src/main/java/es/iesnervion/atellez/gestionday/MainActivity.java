package es.iesnervion.atellez.gestionday;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import es.iesnervion.atellez.gestionday.Fragments.AboutUsFragment;
import es.iesnervion.atellez.gestionday.Fragments.AgregarFragment;
import es.iesnervion.atellez.gestionday.Fragments.GraficoFragment;
import es.iesnervion.atellez.gestionday.Fragments.InicioFragment;
import es.iesnervion.atellez.gestionday.Fragments.ResumenFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //Esto es para poner una ventana por defecto
        InicioFragment inicio = new InicioFragment();
        FragmentTransaction transactionInicio = getFragmentManager().beginTransaction();
        transactionInicio.add(R.id.content_main,inicio);

        transactionInicio.addToBackStack(null);


        transactionInicio.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_home){
            InicioFragment home = new InicioFragment();
            FragmentTransaction transactionInicio = getFragmentManager().beginTransaction();
            transactionInicio.replace(R.id.content_main,home);
            transactionInicio.addToBackStack(null);

            transactionInicio.commit();
        }else if (id == R.id.nav_add) {
              AgregarFragment add = new AgregarFragment();
              FragmentTransaction transactionAgregar = getFragmentManager().beginTransaction();
              transactionAgregar.replace(R.id.content_main,add);
              transactionAgregar.addToBackStack(null);

              transactionAgregar.commit();

            } else if (id == R.id.nav_resume) {
                ResumenFragment resume = new ResumenFragment();
                FragmentTransaction transactionResumen = getFragmentManager().beginTransaction();
                transactionResumen.replace(R.id.content_main,resume);
                transactionResumen.addToBackStack(null);

                transactionResumen.commit();
            } else if (id == R.id.nav_graphic) {
                GraficoFragment graphic = new GraficoFragment();
                FragmentTransaction transactionGrafico = getFragmentManager().beginTransaction();
                transactionGrafico.replace(R.id.content_main,graphic);
                transactionGrafico.addToBackStack(null);

                transactionGrafico.commit();
            } else if (id == R.id.nav_about) {

             AboutUsFragment about = new AboutUsFragment();
             FragmentTransaction transactionAbout = getFragmentManager().beginTransaction();
             transactionAbout.replace(R.id.content_main,about);
             transactionAbout.addToBackStack(null);

            transactionAbout.commit();
            }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
