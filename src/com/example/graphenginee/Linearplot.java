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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;

public class Linearplot extends Fragment implements OnClickListener{
	Context context ;
	private Spinner spinner;
	private EditText edit;
	private Spinner spinner2;
	 String content1[]={"","sin(","cos(","tan(","Cosec(","Sec(","cot("};
	 String operation1[]={"","+","-","*","/","x)" };
		private int check3=0;
		int [] x=new int [100];
		Button buttonOk;
		private int[] functiontrack=new int [100];
		 int[] Operation22=new int[100];
			private int check4=0;
			private float[][] m=new float[6][100];
		
			float [] correspond=new float[100];
			private XYMultipleSeriesDataset dataset;
			private XYSeriesRenderer renderer;
			private XYMultipleSeriesRenderer multirend;
			Context context1;
			private View cChart;
			LinearLayout linearlayout;
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		context =this.getActivity().getApplicationContext();
		context1=this.getActivity().getBaseContext();
	}
	
	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
	}
	
	@Override
 
	public View onCreateView(LayoutInflater inflater,
			  ViewGroup container,   Bundle savedInstanceState) {
		// TODO Auto-generated method stub
	View linearplot =inflater.inflate(R.layout.linearplot, container, false);

	functiontrack[0]=101;
	functiontrack[1]=101;
	Operation22[0]=101;
	Operation22[1]=101;
	for(int i=0;i<6;i++){
		   for(int j=0;j<100;j++){
			  if (i==0){
				  m[i][j]=(float) Math.sin(3.14/180*resource(j)*7);
			  }else if(i==1){
				  m[i][j]=(float) Math.cos(3.14/180*resource(j)*7);
			  }else if(i==2){
				  m[i][j]=(float) Math.tan(3.14/180*resource(j)*7);
			  }else if(i==3){
				  m[i][j]=(float) ((float)1/( Math.sin(3.14/180*(resource(j)+0.5)*7)));
			  }else if(i==4){
				  m[i][j]=(float) ((float)1/( Math.cos(3.14/180*resource(j)*7)));
			  }else if(i==5){
				  m[i][j]=(float) ((float)1/( Math.tan(3.14/180*(resource(j)+0.5)*7)));
			  }
		   }
	   }buttonOk =(Button)linearplot.findViewById(R.id.buttonOK);
linearlayout=(LinearLayout)linearplot.findViewById(R.id.linearlayout1)	;
 spinner =(Spinner)linearplot.findViewById(R.id.spinner1);
edit=(EditText)linearplot.findViewById(R.id.editText1);
ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(context, R.array.spinner_content, android.R.layout.simple_spinner_item);
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
spinner.setBackgroundColor(Color.MAGENTA);
spinner.setAdapter(adapter);
spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		int m =spinner.getSelectedItemPosition();
		if(m!=0){	
		String str55 =content1[m];
			edit.setText(edit.getText()+str55);
			functiontrack[check3]= m-1;
	         check3=check3+1;
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		edit.setText(edit.getText());
	}
});
spinner2 =(Spinner) linearplot.findViewById(R.id.spinner2); 
ArrayAdapter<CharSequence> adapter1 =ArrayAdapter.createFromResource(context,R.array.operations, android.R.layout.simple_spinner_item);
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
spinner2.setPromptId(R.string.prompt);
spinner2.setAdapter(adapter1);
spinner2.setOnItemSelectedListener(new OnItemSelectedListener() {

	@Override
	public void onItemSelected(AdapterView<?> parent, View view,
			int position, long id) {
	   int m1=spinner2.getSelectedItemPosition();
		if(m1!=0){	
		String str2 =operation1[m1];
			edit.setText(edit.getText()+str2);					
			}
	
	if(m1!=5 && m1!=0){ 
		Operation22[check4]= m1-1;
			check4=check4+1;				
	}else{
		
	}
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		
		edit.setText(edit.getText());
	}
});

//spinner2 =(Spinner)linearplot.findViewById(R.id.spinner2);
buttonOk.setOnClickListener(new OnClickListener() {
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		cChart=OPenChart(context1);
		linearlayout.addView(cChart);
		String sr="";
		for(int i=0;i<functiontrack.length;i++){
			sr=sr+functiontrack[i];
		}
		edit.setText(sr);
	}
});
	return linearplot;
	}
	 
	private double resource(int j) {
		// TODO Auto-generated method stub
		return j;
	}

	public void evaluate(){
		
if (functiontrack[0]!=101 && functiontrack[1]==101){
		for (int i=0;i<correspond.length;i++){
			correspond[i]=m[functiontrack[0]][i];
}
		
}else if(Operation22[0]!=101 && Operation22[1]!=101){
 int a,b,sign1=0,sign2=0;
 int signature;
	for (int i=0;i<100;i++){
	  correspond[i]=0;
  }
  
  for (int i =0;i<2;i++){
	  if (Operation22[i]==2 || Operation22[i]==3){
		  sign1 =sign1+1;
	  }else if (Operation22[i]==0 || Operation22[i]==1){
		  sign2 =sign2+1;
	  }
  }
  //E
  if (sign1==1 && sign2==1){
	  for(int i =0;i<2;i++){
		  signature=Operation22[i];
		  if (signature==2 ||  signature==3){
			  for(int j=0;j<100;j++){
				  if(signature==2){
					  correspond[j]=m[functiontrack[i]][j]* m[functiontrack[i+1]][j];
				  }else if (signature==3){
					  correspond[j]=m[functiontrack[i]][j]/ m[functiontrack[i+1]][j];
				  }
			  }
		  }
	  }
	  for (int i =0;i<2;i++){
		  signature=Operation22[i];
		  if(signature==0 || signature==1){
			  if (i==0){
			
					  if (signature==0){
						  for (int j=0;j<100;j++){
							correspond[j]=correspond[j]+m[functiontrack[0]][j];
							  
							  
						  }
						  }
					  }else if(signature==1){
						  for (int j=0;j<100;j++){
							  correspond[j]=correspond[j]-m[functiontrack[0]][j];
							  
						  }
					  }
				  
			  }else if (i==1){
				  if (signature==0){
					  for (int j=0;j<100;j++){
						correspond[j]=correspond[j]+m[functiontrack[1]][j];
						  
						  
					  }
					  }
				  }else if(signature==1){
					  for (int j=0;j<100;j++){
						  correspond[j]=correspond[j]-m[functiontrack[1]][j];
						  
					  }
				  }
	
			  }
			  
		  }
	  
 
  else if (sign1==2 && sign2 ==0){
	  if(Operation22[0]==2 || Operation22[0]==3){
		
			  if(Operation22[0]==2){
				  for(int j=0;j<100;j++){
					  
					  correspond[j]=m[functiontrack[0]][j]*m[functiontrack[1]][j];
					  
				  }
			  }else if (Operation22[0]==3){
for(int j=0;j<100;j++){
	correspond[j]=m[functiontrack[0]][j]*m[functiontrack[1]][j];
}
			  }
		  
	  }
	  if(Operation22[1]==2 || Operation22[1]==3){
			
		  if(Operation22[1]==2){
			  for(int j=0;j<100;j++){
				  
				  correspond[j]=correspond[j]*m[functiontrack[2]][j];
				  
			  }
		  }else if (Operation22[1]==3){
for(int j=0;j<100;j++){
	  correspond[j]=correspond[j]/m[functiontrack[2]][j];
}
		  }
	  
  }
  
	  
  }else if(sign1==0 && sign2==2){
	  
	  if(Operation22[0]==0 || Operation22[0]==1){
			
		  if(Operation22[0]==0){
			  for(int j=0;j<100;j++){
				  
				  correspond[j]=m[functiontrack[0]][j]+m[functiontrack[1]][j];
				  
			  }
		  }else if (Operation22[0]==1){
for(int j=0;j<100;j++){
correspond[j]=m[functiontrack[0]][j]-m[functiontrack[1]][j];
}
		  }
	  
  }
  if(Operation22[1]==0 || Operation22[1]==1){
		
	  if(Operation22[1]==0){
		  for(int j=0;j<100;j++){
			  
			  correspond[j]=correspond[j]+m[functiontrack[2]][j];
			  
		  }
	  }else if (Operation22[1]==1){
for(int j=0;j<100;j++){
  correspond[j]=correspond[j]-m[functiontrack[2]][j];
}
	  }
  
}

  
	
  }		
}else if (Operation22[0]!=101 & Operation22[1]==101){
   int	a=functiontrack[0];
   int 	b=functiontrack[1];
int	sign =Operation22[0];
	for(int i =0;i<100;i++){
		if(sign==0){
			correspond[i]=m[a][i]+m[b][i];
		}else if(sign ==1){
			correspond[i]=m[a][i]-m[b][i];
		}else if(sign==2){
			correspond[i]=m[a][i]*m[b][i];
		}else if(sign ==3){
			correspond[i]=m[a][i]/m[b][i];
		}
		
	}
	

	
}

}


private View OPenChart(Context c){
	 
	 for(int i=0;i<100;i++){
		 x[i]=i;
		 correspond[i]=i;
	 }
	 evaluate();
	XYSeries series = new XYSeries("plot 1");
	for (int i=0;i<100;i++){
		series.add(x[i], correspond[i]);
	}
	  dataset =new XYMultipleSeriesDataset();
	dataset.addSeries(series);
	  renderer =new XYSeriesRenderer();
	renderer.setColor(Color.RED);
	renderer.setPointStyle(PointStyle.TRIANGLE);
	renderer.setFillPoints(true);
	renderer.setLineWidth(4);
	renderer.setDisplayChartValues(true);
 
	 multirend = new XYMultipleSeriesRenderer();
	multirend.setXLabels(0);
	multirend.setChartTitle("your graphs are here ");
	multirend.setXTitle("X axis");
	multirend.setYTitle("Y axis ");
	multirend.setApplyBackgroundColor(true);
	multirend.setAxesColor(Color.WHITE);
	multirend.setShowAxes(true);
	multirend.setBackgroundColor(Color.BLACK);
	multirend.setZoomButtonsVisible(true);
	multirend.setShowGrid(true);
	multirend.setGridColor(Color.WHITE);
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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		}
	}


