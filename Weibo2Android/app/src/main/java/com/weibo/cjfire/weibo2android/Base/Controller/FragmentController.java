package com.weibo.cjfire.weibo2android.Base.Controller;

//import android.support.v4.app.FragmentActivity;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentTransaction;
//import android.support.v4.app.Fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;

import com.weibo.cjfire.weibo2android.Discover.View.DiscoverFragment;
import com.weibo.cjfire.weibo2android.Home.View.HomeFragment;
import com.weibo.cjfire.weibo2android.Me.View.MeFragment;
import com.weibo.cjfire.weibo2android.Message.View.MessageFragment;

import java.util.ArrayList;

/**
 * Created by cjfire on 16/7/10.
 */
public class FragmentController {

    private int containerId;
    private FragmentManager fm;
    private ArrayList<Fragment> fragments;

    private Fragment currentFragment;

    private void setCurrentFragment(Fragment currentFragment) {

        FragmentTransaction ft = fm.beginTransaction();

        if (this.currentFragment != null) {
            ft.hide(this.currentFragment);
            this.currentFragment = currentFragment;
            ft.show(this.currentFragment);
        }

        ft.commit();
    }

    public FragmentController(FragmentActivity activity, int containerId) {
        this.containerId = containerId;

        fm = activity.getFragmentManager();

        initFragment();

        setCurrentFragment(fragments.get(0));
    }

    private void initFragment() {

        fragments = new ArrayList<Fragment>();
        fragments.add(new HomeFragment());
        fragments.add(new MessageFragment());
        fragments.add(new DiscoverFragment());
        fragments.add(new MeFragment());

        FragmentTransaction ft = fm.beginTransaction();

        for(Fragment fragment : fragments) {
            ft.add(containerId, fragment);
            ft.hide(fragment);
        }

        ft.commit();
    }

    public void showFragment(int position) {
        setCurrentFragment(fragments.get(position));
    }

    public Fragment getFragment(int position) {
        return fragments.get(position);
    }
}
