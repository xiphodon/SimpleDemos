package com.example.x36_fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment03 extends Fragment {

	private TextView tv_formain;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.fragment03, null);
		tv_formain = (TextView)v.findViewById(R.id.tv_formain);
		
		return v;
	}
	
	public void setText(String text){
		tv_formain.setText(text);
	}
}
