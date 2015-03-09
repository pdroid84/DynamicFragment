package com.example.dynamicfragment;

import android.support.v7.app.ActionBarActivity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
	FragmentManager mgr=null;
	FragmentTransaction trn=null;
	Fragment frg=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mgr = getFragmentManager();
        trn = mgr.beginTransaction();
        frg = new Fagment_1();
        trn.add(R.id.linearLayout1, frg);
        trn.commit();
        Log.d("DEB","This lise is added to test git version control");
    }

    public void takeAction(View v) {
	// TODO Auto-generated method stub
    	int btnnum;
    	btnnum = v.getId();
    	Log.d("DEB", "Button "+btnnum+" is clicked");
    	if (v.getId()==R.id.button_addB)
    	{
    		mgr = getFragmentManager();
            trn = mgr.beginTransaction();
            frg = new FragmentB();
            trn.add(R.id.linearLayout2, frg,"fragbtag");
            trn.commit();
    	}
    	if (v.getId()==R.id.button_addC)
    	{
    		mgr = getFragmentManager();
            trn = mgr.beginTransaction();
            frg = new FragmentC();
            trn.add(R.id.linearLayout2, frg,"fragctag");
            trn.commit();
    	}
    	if (v.getId()==R.id.button_repl_B_by_C)
    	{
    		mgr = getFragmentManager();
            trn = mgr.beginTransaction();
            frg = new FragmentC();
            trn.replace(R.id.linearLayout2, frg);
            trn.commit();
    	}
    	if (v.getId()==R.id.button_repl_C_by_B)
    	{
    		mgr = getFragmentManager();
            trn = mgr.beginTransaction();
            frg = new FragmentB();
            trn.replace(R.id.linearLayout3, frg);
            trn.commit();
    	}
    	if (v.getId()==R.id.button_remB)
    	{
    		mgr = getFragmentManager();
            trn = mgr.beginTransaction();
            frg = (FragmentB)mgr.findFragmentByTag("fragbtag");
            trn.remove(frg);
            trn.commit();
    	}
    	if (v.getId()==R.id.button_remC)
    	{
    		mgr = getFragmentManager();
            trn = mgr.beginTransaction();
            frg = (FragmentC)mgr.findFragmentByTag("fragctag");
            trn.remove(frg);
            trn.commit();
    	}
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
