package org.agenda.android.read;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.agenda.android.R;
import org.agenda.android.model.Journal;
import org.agenda.android.utils.LoaderThreadPool;
import org.agenda.android.utils.NetUtils;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView.FixedViewInfo;
import android.widget.TextView;

public class JournalListAdapter extends ArrayAdapter<Journal>{

	private Activity activity;
	
	public JournalListAdapter(Context context, int textViewResourceId, int itemname, Activity activity) {
		super(context, textViewResourceId, itemname);
		this.activity = activity;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = activity.getLayoutInflater();
		View row=inflater.inflate(R.layout.journal_item_layout, parent, false);
		
		final ImageView image =(ImageView)row.findViewById(R.id.journalImageView);
		TextView textView = (TextView) row.findViewById(R.id.journal_list_item);
		
		Journal journal = getItem(position);
		textView.setText(journal.getName());
		
		AsyncTask<Journal, Void, Journal> asyncTask = new AsyncTask<Journal, Void, Journal>() 
		{
			
			@Override
			protected Journal doInBackground(Journal... params) {
				try {
					InputStream is = (InputStream) NetUtils.fetch("https://sites.google.com/a/idpuzzle.com/file-hoster/mobile/paper.png");
					Drawable d = Drawable.createFromStream(is, "src");
					params[0].setListImage(d);
					
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return params[0];
			}
			
			@Override
			protected void onPostExecute(Journal result) {
				image.setImageDrawable(result.getListImage());
				image.refreshDrawableState();
				super.onPostExecute(result);
			}
		};
		
		asyncTask.execute(getItem(position));		
		
//		LoaderThreadPool.executorService.submit(new Runnable() {
//			
//			@Override
//			public void run() {
//				
//				try {
//					is = (InputStream) NetUtils.fetch("https://sites.google.com/a/idpuzzle.com/file-hoster/mobile/paper.png");
//					Drawable d = Drawable.createFromStream(is, "src");
//					image.setImageDrawable(d);
//					image.refreshDrawableState();
//				} catch (MalformedURLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//			}
//		});
		
		
		
		return row;
	}
	
	
}
