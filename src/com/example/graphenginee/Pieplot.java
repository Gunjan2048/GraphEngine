package com.example.graphenginee;

import java.util.ArrayList;

import org.achartengine.ChartFactory;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

import android.app.Activity;
import android.content.Context;
 
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
 
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
 
import android.widget.ListView;
 

public class Pieplot extends Fragment {
	
	View getview;
	LinearLayout layout;
	public  String[] months =new String[]{
			"jan","feb","march","april",
			"may","june","july","aug","sept","oct",
			"nov","dec"
			
	};	
	 ArrayAdapter<String> adapter;
Context context;
 float [] destribution=new float[10];
private EditText edittext;
private Button buttonpie;
ListView listview;
protected String str;
int check=0;
@Override
public void onAttach(Activity activity) {
	// TODO Auto-generated method stub
	
	context =this.getActivity().getBaseContext();
	super.onAttach(activity);
}
	
@Override
@Nullable
public View onCreateView(LayoutInflater inflater,
		@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
	// TODO Auto-generated method stub
View pieplot =inflater.inflate(R.layout.pieplot, container,false);
listview=(ListView)pieplot.findViewById(R.id.listView1);
edittext =(EditText)pieplot.findViewById(R.id.editTextpie);
buttonpie=(Button)pieplot.findViewById(R.id.buttonpie);
final ArrayList<String> pieplotData =new ArrayList<String>();
pieplotData.add("element");

buttonpie.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	  str =edittext.getText().toString();
		  pieplotData.add(str);
	edittext.setText("");
    
	destribution[check]= Float.parseFloat(str);
    check=check+1;
     
    
	adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1,pieplotData);
	listview.setAdapter(adapter);
	}
});

return pieplot;
 




}

private View OpenChart() {
	// TODO Auto-generated method stub
	String [] subjects={
			"math","stats","physics","chemistry","english","economy","advance"
			
	};
	 
	
	int[] colors ={Color.BLUE,Color.YELLOW,Color.MAGENTA,Color.GREEN,Color.BLACK,Color.RED,Color.WHITE};
	CategorySeries catagory =new CategorySeries("pie chart");
	for(int i =0;i<destribution.length;i++){
		catagory.add(subjects[i], destribution[i]);
	
	}
	DefaultRenderer drend1 =new DefaultRenderer();
	for (int i =0;i<destribution.length;i++){
		SimpleSeriesRenderer drend =new SimpleSeriesRenderer();
		drend.setColor(colors[i]);
		drend.setDisplayChartValues(true);
		drend1.addSeriesRenderer(drend);
	}
	drend1.setChartTitle("pie chart");
	drend1.setChartTitleTextSize(25);
	drend1.setZoomButtonsVisible(true);
	View mview =ChartFactory.getPieChartView(context, catagory, drend1);
	
	//Intent in =ChartFactory.getPieChartIntent(getBaseContext(), catagory,drend1, "pieChartDemo");
	
		return mview;
	
	
}
	@Override
		public void onDetach() {
			// TODO Auto-generated method stub
			super.onDetach();
		}
	
	@Override
		public void onDestroy() {
			// TODO Auto-generated method stub
			super.onDestroy();
		}

	
}
