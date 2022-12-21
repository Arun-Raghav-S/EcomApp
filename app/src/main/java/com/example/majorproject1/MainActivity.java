package com.example.majorproject1;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.majorproject1.ui.account.AccountFragment;
import com.example.majorproject1.ui.home.HomeFragment;
import com.example.majorproject1.ui.cart.CartFragment;
import com.google.android.material.navigation.NavigationView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
public class MainActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;
    TextView Profname,Profemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SharedPreferences cartColor=getSharedPreferences("CartColor",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor1;
        editor1= cartColor.edit();
        editor1.putInt("Color",R.color.orange);
        editor1.putInt("Color bag",0);
        editor1.putInt("Color pc",0);
        editor1.putInt("Color phone",0);
        editor1.putInt("Color cycle",0);
        editor1.putInt("Color bottle",0);
        editor1.apply();
        SharedPreferences sharedPreferences= getSharedPreferences("CartList", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor;
        editor = sharedPreferences.edit();
        editor.putInt("bag",3);
        editor.putInt("pc",3);
        editor.putInt("phone",3);
        editor.putInt("cycle",3);
        editor.putInt("bottle",3);
        editor.apply();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView =navigationView.getHeaderView(0);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_account, R.id.nav_cart,R.id.nav_signout).setDrawerLayout(drawer).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        Profname=(TextView) headerView.findViewById(R.id.profname);
        Profemail=(TextView) headerView.findViewById(R.id.profemail);
        SharedPreferences sh=getSharedPreferences("Sharedpref",MODE_PRIVATE);
        String s1=sh.getString("name"," ha");
        String s2=sh.getString("email","ha");
        Profemail.setText(s2);
        Profname.setText(s1);
        FrameLayout fl=(FrameLayout)findViewById(R.id.nav_host_fragment_content_main);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        fl.removeAllViews();
                        toolbar.setTitle("Home");
                        toolbar.setNavigationIcon(R.drawable.ic_baseline_menu_24);
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main,new HomeFragment()).commit();
                    break;
                    case R.id.nav_cart:
                        fl.removeAllViews();
                        toolbar.setTitle("Cart");
                        toolbar.setNavigationIcon(R.drawable.ic_baseline_menu_24);
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main,new CartFragment()).commit();
                        break;

                    case R.id.nav_account:
                        fl.removeAllViews();
                        toolbar.setTitle("Account info");
                        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main,new AccountFragment()).commit();
                        break;
                    case R.id.nav_signout:{
                        SharedPreferences sharedPreferences1=getSharedPreferences("CartColor",Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor1;
                        editor1= sharedPreferences1.edit();
                        editor1.clear();
                        editor1.apply();
                        SharedPreferences sharedPreferences2=getSharedPreferences("CartList",Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor2;
                        editor2= sharedPreferences2.edit();
                        editor2.clear();
                        editor2.apply();
                        SharedPreferences sharedPreferences3=getSharedPreferences("Sharedpref",Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor3;
                        editor3= sharedPreferences2.edit();
                        editor3.clear();
                        editor3.apply();
                        Intent intent=new Intent(MainActivity.this, LOGIN.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        break;}
                }
                DrawerLayout drawerLayout=(DrawerLayout) findViewById(R.id.drawer_layout);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}