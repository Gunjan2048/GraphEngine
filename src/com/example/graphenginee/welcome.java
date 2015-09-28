package com.example.graphenginee;


import android.app.Activity;
import android.content.Context;

import android.os.Bundle;
import   android.support.v4.app.*;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup; 
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class welcome extends Fragment implements OnItemClickListener {
 Button btnRemove ;
 Spinner spinner;


 Spinner spinner2;
 
 int count;
 int[] Operation22=new int [100];
 int[] functiontrack=new int [100] ;
 Context context=null; 
 String content1[]={"","sin(","cos(","tan(","Cosec(","Sec(","cot("};
 String operation1[]={"","+","-","*","/","x)" };
 private EditText edit;
 Button btnerase;
 public String function_string;

int check3=0;
int check4=0;
int[] x=new int[100];


private float[][] m=new float[100][100];
 
public  float [] correspond =new float[100];

@Override
	public void onAttach(Activity activity) {	
	super.onAttach(activity);
	context =this.getActivity().getApplicationContext();
}
@Override
	public void onCreate( Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		 
	}
	@Override
 
		public View onCreateView(LayoutInflater inflater,
				  ViewGroup container,   Bundle savedInstanceState) {
			// TODO Auto-generated method stub
		 View InputFragmentview =inflater.inflate(R.layout.detail,container, false);
		 for(int i=-50;i<50;i++){
			 x[i]=i;
		 }
		 for(int i=0;i<100;i++){
	    	functiontrack[i]=101;
	    	Operation22[i]=101;
	    }
		   for(int i=0;i<6;i++){
			   for(int j=0;j<100;j++){
				  if (i==0){
					  m[i][j]=(float) Math.sin(3.14/180*j);
				  }else if(i==1){
					  m[i][j]=(float) Math.cos(3.14/180*j);
				  }else if(i==2){
					  m[i][j]=(float) Math.tan(3.14/180*j);
				  }else if(i==3){
					  m[i][j]=(float) ((float)1/( Math.sin(3.14/180*j)));
				  }else if(i==4){
					  m[i][j]=(float) ((float)1/( Math.cos(3.14/180*j)));
				  }else if(i==5){
					  m[i][j]=(float) ((float)1/( Math.tan(3.14/180*j)));
				  }
			   }
		   }
		   spinner =(Spinner)InputFragmentview.findViewById(R.id.spinner2);
		   edit=(EditText)InputFragmentview.findViewById(R.id.editText1);
	     ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(context,R.array.spinner_content, android.R.layout.simple_spinner_item);
		 adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		 spinner.setPromptId(R.string.prompt);
		 spinner.setAdapter(adapter);
		 spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
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
		 
		 spinner2 =(Spinner)InputFragmentview.findViewById(R.id.spinner1); 
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
		 
		//Button erase 
	
		 return InputFragmentview;
	} 
	public void evaluate(int[] Operation,int[] functiontrack){
		int check1 =6;
		int a,b;
if (functiontrack[1]==101){
		for (int i=0;i<correspond.length;i++){
			correspond[i]=m[functiontrack[0]][i];
}
		
}else{
		for (int q=0;q<Operation.length;q++){
		    if(Operation[q]==3){
				a=functiontrack[q];
				b=functiontrack[q+1];
				for(int p=0;p<100;p++){
					m[check1][p]=m[a][p]*m[b][p];
					}
				revert(check1,q,q,Operation,functiontrack);
				check1=check1+1;
			}
		}
		
		for (int q=0;q<Operation.length;q++){
			if(Operation[q]==4){
				a=functiontrack[q];
				b=functiontrack[q+1];
				for(int p=0;p<100;p++){
					 
					m[check1][p]=m[a][p]/m[b][p];
					 
					}
				revert(check1,q,q,Operation,functiontrack);
				check1=check1+1;
			}
		}
		
		for(int p=0;p<Operation.length;p++){
			if (Operation[p]==1){
				int c,d;
				c=functiontrack[p];
				d=functiontrack[p+1];
				for(int i=0;i<100;i++){
					m[check1][i]=m[c][i]+m[d][i];
					
				}
				revert(check1,p,p,Operation,functiontrack);
				check1=check1+1;
			}
		}
		for(int p=0;p<Operation.length;p++){
			if (Operation[p]==2){
				int c,d;
				c=functiontrack[p];
				d=functiontrack[p+1];
				for(int i=0;i<100;i++){
					m[check1][i]=m[c][i]-m[d][i];
					
				}
				revert(check1,p,p,Operation,functiontrack);
				check1=check1+1;
			}
		}
	for (int g=0;g<100;g++){
		correspond[g]=m[check1-1][g];
	}
}
}
private void revert(int check,int pos,int pos2,int [] Operation, int [] functiontrack) {//check is the new row in m,pos is the position to be replaced in functiontrack,pos2 is that of Operation
		
		for(int i=pos;i<functiontrack.length;i++){
			if (i==pos){
				functiontrack[pos]=check;
				
			}else{
				functiontrack[i]=functiontrack[i+1];
			}
		}
		for(int i=pos2;i<Operation.length;i++){
			  Operation[i]=Operation[i+1];
		 
		}
	}

@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		super.onDetach();
	}
@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
@Override
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	// TODO Auto-generated method stub
	
}

 
 
}



 


 
 



 