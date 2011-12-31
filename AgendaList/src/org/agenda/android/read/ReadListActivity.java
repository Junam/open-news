package org.agenda.android.read;

import org.agenda.android.AgendaActivity;
import org.agenda.android.R;
import org.agenda.android.model.JournalRepository;

import android.R.color;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ReadListActivity extends AgendaActivity {

	private JournalListAdapter journalListAdapter;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.journal_list_view_layout);
		ListView listView = (ListView) findViewById(R.id.list_view_id);
		Log.d("AGENDA", listView.toString());
		
		journalListAdapter = new JournalListAdapter(this, R.layout.journal_item_layout, R.id.journal_list_item, this);
		for (int i = 0; i < JournalRepository.getJournals().size(); i++) {
			
			journalListAdapter.add(JournalRepository.getJournals().get(i));
		}
		
		
		
		listView.setAdapter(journalListAdapter);
		
		
		OnItemClickListener listener = new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> l, View v, int position, long id) {
				TextView textView = (TextView) v.findViewById(R.id.journal_list_item);
				textView.setShadowLayer(10, 10, 10, Color.RED);
				Intent intent = new Intent(ReadListActivity.this, PaperReadActivity.class);
				Bundle bundle = new Bundle();
		 		bundle.putString("journalName", journalListAdapter.getItem(position).toString());
		 		intent.putExtras(bundle);
				startActivity(intent);
				
			}
		};
		listView.setOnItemClickListener(listener );
		
		updateNavBar();
	}
	
	@Override
	protected void onStart() {
		ListView listView = (ListView) findViewById(R.id.list_view_id);
		for (int i = 0; i <listView.getCount(); i++) {
			if (listView.getChildAt(i) == null)
			{
				continue;
			}
			
			TextView textView = (TextView) listView.getChildAt(i).findViewById(R.id.journal_list_item);
			textView.setShadowLayer(0, 0, 0, Color.TRANSPARENT);
			
			
		}
		 super.onStart();
	}
	
	private void updateNavBar() {
		LinearLayout layout =  (LinearLayout) findViewById(R.id.journal_list_nav);
		
		layout.addView(createNavElement("Home"));
		layout.addView(createNavElement(">"));
		layout.addView(createNavElement("Read"));
		
	}
	
	
	
}
