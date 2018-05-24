package net.zlotin.remindme.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import net.zlotin.remindme.R;
import net.zlotin.remindme.fragment.AbstractTabFragment;
import net.zlotin.remindme.fragment.BirthdayFragment;
import net.zlotin.remindme.fragment.HistoryFragment;
import net.zlotin.remindme.fragment.IdeasFragment;
import net.zlotin.remindme.fragment.TodoFragment;

import java.util.HashMap;
import java.util.Map;

public class TabsFragmentAdapter extends FragmentPagerAdapter {

    private Map<Integer, AbstractTabFragment> tabs;
    private Context context;

    public TabsFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
        initTabsMap(context);
    }

    @Override
    public Fragment getItem(int position) {

        return tabs.get(position);

    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTitle();
    }

    private void initTabsMap(Context context) {
        tabs=new HashMap<>();
        tabs.put(0, HistoryFragment.getInstanse(context));
        tabs.put(1, IdeasFragment.getInstanse(context));
        tabs.put(2, TodoFragment.getInstanse(context));
        tabs.put(3, BirthdayFragment.getInstanse(context));
    }
}
