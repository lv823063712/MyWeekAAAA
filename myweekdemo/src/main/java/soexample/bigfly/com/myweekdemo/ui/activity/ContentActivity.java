package soexample.bigfly.com.myweekdemo.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import soexample.bigfly.com.myweekdemo.R;
import soexample.bigfly.com.myweekdemo.base.MyBaseActivity;
import soexample.bigfly.com.myweekdemo.ui.activity.fragment.HomeFragment;
import soexample.bigfly.com.myweekdemo.ui.activity.fragment.ShoppingFragment;

public class ContentActivity extends MyBaseActivity  {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.Test)
    DrawerLayout Test;
    @BindView(R.id.homePage)
    TextView homePage;
    @BindView(R.id.MyFragment)
    FrameLayout MyFragment;
    private TextView text_home;
    private TextView text_shopping;
    private FragmentManager manager;
    private HomeFragment homeFragment;
    private ShoppingFragment shoppingFragment;
    @Override
    protected int getLayout() {
        return R.layout.activity_content;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        manager = getSupportFragmentManager();
        homeFragment = new HomeFragment();
        shoppingFragment = new ShoppingFragment();
        ContentActivity.this.manager.beginTransaction().replace(R.id.MyFragment, homeFragment).commit();
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.dh);
        }
        navView.setCheckedItem(R.id.nav_home);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Test.openDrawer(GravityCompat.START);
                int itemId = menuItem.getItemId();
                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        ContentActivity.this.manager.beginTransaction().replace(R.id.MyFragment, homeFragment).commit();

                        break;
                    case R.id.nav_shop:
                        ContentActivity.this.manager.beginTransaction().replace(R.id.MyFragment, shoppingFragment).commit();

                        break;
                }
                return true;
            }
        });
    }

    @Override
    protected void setOnClick() {

    }


    @Override
    protected void preLogic() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                Test.openDrawer(GravityCompat.START);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

}
