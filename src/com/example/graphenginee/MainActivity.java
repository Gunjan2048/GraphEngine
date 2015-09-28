package com.example.graphenginee;

import java.util.ArrayList;

 

 

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
 
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;


public class MainActivity extends ActionBarActivity implements OnItemClickListener {
DrawerLayout dLayout;

 ActionBarDrawerToggle actionBarDrawerToggle;
 ListView navList;
 ListView plotList;
 Spinner spinner;
 FragmentManager fragmentManager;
 FragmentTransaction fragmentTransaction;
 ActionBar actionBar;
 FragmentManager fragmentManagerSide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   dLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
   navList=(ListView)findViewById(R.id.navList);
   ArrayList<String> navElement =new ArrayList<String>();
   navElement.add("Home");
   navElement.add("Linear plot");
   navElement.add("PiePlot");
   navElement.add("Barplot");
   navElement.add("Scatter plot");
   navElement.add("next plot");
   navElement.add("next plot");
   navElement.add("next plot");
   navList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
   
   
   ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1, navElement);
   navList.setAdapter(adapter);
   navList.setOnItemClickListener(this);
  
   actionBar=getSupportActionBar();
    actionBar.setDisplayShowHomeEnabled(true);
    actionBar.setDisplayHomeAsUpEnabled(true);
    actionBarDrawerToggle=new ActionBarDrawerToggle(this, dLayout, R.string.OpenDrawer, R.string.closeDrawer);
   fragmentManager=getSupportFragmentManager();
  loadselection(0);
 

    }

    
   


	private void loadselection(int i) {
		// TODO Auto-generated method stub
		navList.setItemChecked(i, true);
		 
    	switch (i) {
		case 0:
	       		
			break;
        case 1:
			Linearplot load1 =new Linearplot();
			  fragmentTransaction =fragmentManager.beginTransaction();
			fragmentTransaction.replace(R.id.container, load1).commit();
			break;
        case 2:
        	Pieplot load2=new Pieplot();
        	fragmentTransaction=fragmentManager.beginTransaction();
        	fragmentTransaction.replace(R.id.container, load2).commit();
			
			break;
        case 3:
			Barplot load3 =new Barplot();
			fragmentTransaction=fragmentManager.beginTransaction();
			fragmentTransaction.replace(R.id.container,load3).commit();
			
			break;
        case 4:
        	Scatterplot load4=new Scatterplot();
			fragmentTransaction=fragmentManager.beginTransaction();
			fragmentTransaction.replace(R.id.container,load4).commit();
			
			
			break;
        case 5:
			
			break;
        default:
			break;
		}
	}


	@Override
    	protected void onPostCreate(@Nullable Bundle savedInstanceState) {
    		// TODO Auto-generated method stub
    		super.onPostCreate(savedInstanceState);
    		actionBarDrawerToggle.syncState();
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
        }else if(id== android.R.id.home){
        	if(dLayout.isDrawerOpen(navList)){
        		dLayout.closeDrawer(navList);
        	}else {
        		dLayout.closeDrawer(navList);
        	}
        }
        return super.onOptionsItemSelected(item);
    }


	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
			loadselection(position);	
			dLayout.closeDrawer(navList);

	}	
}
