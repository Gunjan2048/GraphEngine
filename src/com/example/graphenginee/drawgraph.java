package com.example.graphenginee;

 

import org.achartengine.ChartFactory;
import org.achartengine.model.XYSeries;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
 
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
  
 
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
 

//import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
 
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

 

 
 
 
import java.lang.Math;
 
 
public class drawgraph  extends Fragment{
	
	 // private String Evaluate;
	 XYSeries series;
	  int [] x=new int[100];
	
	  float[] correspond1 =new float[100];
//	private EditText edit3;
	//private EditText edit5;
	Context context;
 

LinearLayout layout;
private XYMultipleSeriesRenderer multirend;
private XYSeriesRenderer renderer;
private XYMultipleSeriesDataset dataset;
private Button btn;
private View mc;
private EditText edit65;
float [][] m  =new float[100][100];
String[] operation;
int[] functionTrack =new int[100];
private Intent context1;
private Spinner s;	 
 
@Override
public void onAttach(Activity activity) {
	// TODO Auto-generated method stub
	super.onAttach(activity);
	 context =this.getActivity().getBaseContext();
 
}
 @Override
public void onCreate(@Nullable Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
}

@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View graphview= inflater.inflate(R.layout.drawgraph, container, false);
		edit65=(EditText)graphview.findViewById(R.id.editText1); 
		layout=(LinearLayout)graphview.findViewById(R.id.linearLayout);
		//edit5 =(EditText)graphview.findViewById(R.id.editText5);
	   for(int i=0;i<100;i++){
		   x[i]=i;
	   }
	   for (int i =-50;i<50;i++){
		   correspond1[i+50]=(float) Math.sin(3.14*i/180);
	   }
        btn =(Button)graphview.findViewById(R.id.button1);
	    btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
	           
		//	mc=	OPenChart(context);
		//layout.addView(mc);
		 
			}
		});
	    

		 return graphview;
	}

 private View OPenChart(Context c){
	 
	 
		series =new XYSeries("plot 1");
		for (int i=0;i<100;i++){
			series.add(x[i], correspond1[i]);
		}
		  dataset =new XYMultipleSeriesDataset();
		dataset.addSeries(series);
		  renderer =new XYSeriesRenderer();
		renderer.setColor(Color.BLUE);
		renderer.setPointStyle(PointStyle.TRIANGLE);
		renderer.setFillPoints(true);
		renderer.setLineWidth(4);
		renderer.setDisplayChartValues(true);
		 multirend = new XYMultipleSeriesRenderer();
		multirend.setXLabels(0);
		multirend.setChartTitle("your graphs are here ");
		multirend.setXTitle("X axis");
		multirend.setYTitle("Y axis ");
		multirend.setZoomButtonsVisible(true);
		 for(int i=0;i<x.length;i++){
	          multirend.addXTextLabel(i+1, "h");
	      }
		multirend.addSeriesRenderer(renderer);
		 View mchart = ChartFactory.getLineChartView(c, dataset,multirend);
	 return mchart;
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
