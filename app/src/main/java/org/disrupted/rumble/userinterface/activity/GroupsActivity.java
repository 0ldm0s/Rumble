/*
 * Copyright (C) 2014 Disrupted Systems
 * This file is part of Rumble.
 * Rumble is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Rumble is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with Rumble.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.disrupted.rumble.userinterface.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.disrupted.rumble.R;
import org.disrupted.rumble.app.RumbleApplication;
import org.disrupted.rumble.database.DatabaseFactory;
import org.disrupted.rumble.userinterface.adapter.IconTextItem;
import org.disrupted.rumble.userinterface.adapter.IconTextListAdapter;
import org.disrupted.rumble.userinterface.fragments.FragmentGroupList;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Marlinski
 */
public class GroupsActivity extends ActionBarActivity {

    private static final String TAG = "GroupsActivity";


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_activity);
        setTitle(R.string.navigation_drawer_group);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);

        Fragment fragmentGroupList = new FragmentGroupList();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragmentGroupList)
                .commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id==android.R.id.home) {
            finish();
            overridePendingTransition(R.anim.activity_close_enter, R.anim.activity_close_exit);
        }
        return false;
    }


    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.activity_close_enter, R.anim.activity_close_exit);
    }

}