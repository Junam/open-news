package org.agenda.android;

import org.agenda.android.read.ReadListActivity;
import org.agenda.android.write.NewReportActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
       
        LinearLayout readButton = (LinearLayout) findViewById(R.id.read_button_id);
        OnClickListener l = new OnClickListener() {
			@Override
			public void onClick(View v) {
				TextView readView = (TextView) findViewById(R.id.readTextView);
				readView.setShadowLayer(15, 5, 5, Color.RED);
				readView.setTextColor(Color.BLACK);
				Intent gotoRead = new Intent(MainActivity.this, ReadListActivity.class);
				startActivity(gotoRead);
			}
			
		};
		readButton.setOnClickListener(l );
		
		LinearLayout writeButton = (LinearLayout) findViewById(R.id.write_button_id);
		OnClickListener wl = new OnClickListener() {
			@Override
			public void onClick(View v) {
				TextView writeView = (TextView) findViewById(R.id.writeTextView);
				writeView.setShadowLayer(15, 5, 5, Color.RED);
				writeView.setTextColor(Color.BLACK);
				Intent gotoNewReport = new Intent(MainActivity.this, NewReportActivity.class);
				startActivity(gotoNewReport);
			}
			
		};
		writeButton.setOnClickListener(wl );
    }
    
    

	@Override
    protected void onStart() {
    	TextView readView = (TextView) findViewById(R.id.readTextView);
		readView.setShadowLayer(0,0,0, Color.TRANSPARENT);
		readView.setTextColor(Color.WHITE);
		TextView writeView = (TextView) findViewById(R.id.writeTextView);
		writeView.setShadowLayer(0,0,0, Color.TRANSPARENT);
		writeView.setTextColor(Color.WHITE);
    	super.onStart();
    }
}