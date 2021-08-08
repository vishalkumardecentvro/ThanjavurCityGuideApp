package com.myapp.thanajavurcityguide;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.isolpro.custom.Activity;
import com.myapp.thanajavurcityguide.databinding.ActivityHomeBinding;

public class HomeActivity extends Activity<com.myapp.thanajavurcityguide.databinding.ActivityHomeBinding> {

  private AppBarConfiguration mAppBarConfiguration;
  private DrawerLayout drawer;
  private NavigationView navigationView;
  private NavController navController;
  private Toolbar toolbar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    super.setContentBinding(ActivityHomeBinding.inflate(getLayoutInflater()));
    begin();
  }

  @Override
  public boolean onSupportNavigateUp() {
    NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home);
    return NavigationUI.navigateUp(navController, mAppBarConfiguration) || super.onSupportNavigateUp();
  }


  @Override
  protected void instantiate() {
    toolbar = findViewById(R.id.toolbar);
    drawer = findViewById(R.id.drawer_layout);
    navigationView = findViewById(R.id.nav_view);
    navController = Navigation.findNavController(activity, R.id.nav_host_fragment_content_home);

  }

  @Override
  protected void initialize() {
    setSupportActionBar(toolbar);

    mAppBarConfiguration = new AppBarConfiguration.Builder(
            R.id.destinationsFragment
    ).setOpenableLayout(drawer).build();

    NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
    NavigationUI.setupWithNavController(navigationView, navController);

    // + Removing color tint from nav icons
    navigationView.setItemIconTintList(null);

  }

  @Override
  protected void listen() {

  }

  @Override
  protected void load() {

  }

  public void navigateTo(int resourceLayout, Bundle bundle) {
    navController.navigate(resourceLayout, bundle);
  }

  public void navigateTo(int resourceLayout) {
    navController.navigate(resourceLayout, null);
  }

  public void setTitle(String string) {
    toolbar.setTitle(string);
  }

}