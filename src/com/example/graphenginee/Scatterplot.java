package com.example.graphenginee;

import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

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
import android.widget.Button;
import android.widget.LinearLayout;

public class Scatterplot extends Fragment {
Context context;
LinearLayout layout;
View chartview;
Button button;
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
         View scatterplot =inflater.inflate(R.layout.scatterplot,container,false);
         layout =(LinearLayout)scatterplot.findViewById(R.id.linearlayout44);
         
         button =(Button)scatterplot.findViewById(R.id.buttonscatterplot);
         button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			chartview=getChart();	
			layout.addView(chartview);
			}
		});
         
         return scatterplot;
}
public View getChart(){
	int x[]={1,2,3,4,5,6,7,8,9};
	int value[]={12,23,45,34,67,89,78,15,24};
	XYSeries series=new XYSeries("series1");
	for(int i=0;i<x.length;i++){
		series.add(x[i],value[i]);
	}
	XYMultipleSeriesDataset dataset =new XYMultipleSeriesDataset();
	dataset.addSeries(series);
	XYSeriesRenderer seriesRenderer =new XYSeriesRenderer();
	seriesRenderer.setColor(Color.BLUE);
	seriesRenderer.setPointStyle(PointStyle.DIAMOND);
	seriesRenderer.setLineWidth(6);
	XYMultipleSeriesRenderer mrenderer =new XYMultipleSeriesRenderer();
	mrenderer.addSeriesRenderer(seriesRenderer);
	View viewgraph =ChartFactory.getScatterChartView(context, dataset, mrenderer);
	return viewgraph;
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
