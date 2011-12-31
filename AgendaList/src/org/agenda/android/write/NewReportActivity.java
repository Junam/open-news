package org.agenda.android.write;

import org.agenda.android.AgendaActivity;
import org.agenda.android.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NewReportActivity extends AgendaActivity
{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_report);
		updateNavBar();
	}
	
	private void updateNavBar() {
		
		LinearLayout layout =  (LinearLayout) findViewById(R.id.journal_list_nav);
		
		layout.addView(createNavElement("Home"));
		layout.addView(createNavElement(">"));
		layout.addView(createNavElement("New Report"));
		
		
		/*
		TextView rootNav = (TextView) findViewById(R.id.nav_bar_el_1);
		rootNav.setVisibility(View.VISIBLE);
		rootNav.setText("Home");
		
		TextView delimiter1 = (TextView) findViewById(R.id.nav_bar_del_1);
		delimiter1.setVisibility(View.VISIBLE);
		
		TextView currentNav = (TextView) findViewById(R.id.nav_bar_el_2);
		currentNav.setVisibility(View.VISIBLE);
		currentNav.setText("New Report");
		
		TextView delimiter2 = (TextView) findViewById(R.id.nav_bar_del_2);
		delimiter2.setVisibility(View.INVISIBLE);
		
		TextView third = (TextView) findViewById(R.id.nav_bar_el_3);
		third.setVisibility(View.INVISIBLE);
		*/
		
	}

	
}
