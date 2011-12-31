package org.agenda.android.read;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import org.agenda.android.AgendaActivity;
import org.agenda.android.R;
import org.agenda.android.model.Item;
import org.agenda.android.model.JournalRepository;
import org.agenda.android.utils.NetUtils;

import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewAnimator;

public class PaperReadActivity  extends AgendaActivity implements OnClickListener 
{

	private GestureDetector gestureDetector;
	private OnTouchListener onTouchListener;
	private Animation rightOutRotateAnimation;
	private Animation rightInRotateAnimation;
	private Animation leftOutRotateAnimation;
	private Animation leftInRotateAnimation;
	private ProgressDialog dialog;
	
//	private ProgressDialog dialog;
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_items_layout);
		final ViewAnimator animator = (ViewAnimator) findViewById(R.id.viewAnimator1);
		animator.setAnimateFirstView(true);
		
		createAnimations();
		
			
		SimpleOnGestureListener gestureListener = new SimpleOnGestureListener(){
		
			@Override
			public boolean onFling(MotionEvent e1, MotionEvent e2,
					float velocityX, float velocityY) {
				Log.d("AGENDA","Fling: " + velocityX + " : " + velocityY);
				if (velocityX < -180)
				{
					ViewAnimator animator = (ViewAnimator) findViewById(R.id.viewAnimator1);
					animator.setOutAnimation(leftOutRotateAnimation);
					animator.setInAnimation(leftInRotateAnimation);
					animator.showNext();
					return true;
				}
				if (velocityX > 180)
				{
					ViewAnimator animator = (ViewAnimator) findViewById(R.id.viewAnimator1);
					animator.setOutAnimation(rightOutRotateAnimation);
					animator.setInAnimation(rightInRotateAnimation);
					animator.showPrevious();
					return true;
				}
				return super.onFling(e1, e2, velocityX, velocityY);
			}
			
		
		};
		
		gestureDetector = new GestureDetector(this, gestureListener);
		onTouchListener = new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				return gestureDetector.onTouchEvent(event);
				
			}
			
			
		};
		
		View parent = findViewById(R.id.parent_slide_panel);
		parent.setOnClickListener(this);
		parent.setOnTouchListener(onTouchListener);

		String journalName = getIntent().getExtras().getString("journalName");
		updateNavBar(journalName);
		
		dialog = ProgressDialog.show(PaperReadActivity.this, "", 
                "Loading. Please wait...", true);
		dialog.show();
		loadResources(JournalRepository.getJournals().get(0).getItems()[0]);
		
		
		
		
	}
	
	
	
	
	@Override
	protected void onStart() {
		super.onStart();
		
		
	}


	private void createAnimations() {
		int width = getWindowManager().getDefaultDisplay().getWidth();
		AccelerateDecelerateInterpolator leftaccelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
		rightOutRotateAnimation = new TranslateAnimation(0f, width, 0f, 0f);
		rightInRotateAnimation = new TranslateAnimation(-width, 0f, 0f, 0f);
		rightInRotateAnimation.setDuration(200L);
		rightInRotateAnimation.setInterpolator(leftaccelerateDecelerateInterpolator);
		rightOutRotateAnimation.setDuration(200L);
		rightOutRotateAnimation.setInterpolator(leftaccelerateDecelerateInterpolator);
		
		leftOutRotateAnimation = new TranslateAnimation(0f, -width, 0f, 0f);
		leftInRotateAnimation = new TranslateAnimation(width, 0f, 0f, 0f);
		leftInRotateAnimation.setDuration(200l);
		leftInRotateAnimation.setInterpolator(leftaccelerateDecelerateInterpolator);
		leftOutRotateAnimation.setDuration(200L);
		leftOutRotateAnimation.setInterpolator(leftaccelerateDecelerateInterpolator);
	}
	
	
	
	private void updateNavBar(String journalName) {
		LinearLayout layout =  (LinearLayout) findViewById(R.id.journal_list_nav);
		
		layout.addView(createNavElement("Home"));
		layout.addView(createNavElement(">"));
		layout.addView(createNavElement("Read"));
		layout.addView(createNavElement(">"));
		layout.addView(createNavElement(journalName));
		
	}
	
	private void loadResources(Item item)
	{
		AsyncTask<Item, Void , Item> asyncTask = new AsyncTask<Item, Void, Item>() {
			
			
			@Override
			protected void onPostExecute(Item item) {
				ViewAnimator animator = (ViewAnimator) findViewById(R.id.viewAnimator1);
				ImageView imageView = (ImageView) animator.getCurrentView().findViewById(R.id.item_main_img);
				Log.d("AGENDA", "imageView: " + imageView);
				imageView.setImageDrawable(item.getImage());
				TextView titleView = (TextView) animator.getCurrentView().findViewById(R.id.title_text_view);
				Log.d("AGENDA", "titleView: " + titleView);
				titleView.setText(item.getTitle());
				TextView contentView = (TextView) animator.getCurrentView().findViewById(R.id.content_text_view);
				Log.d("AGENDA", "contentView: " + contentView);
				contentView.setText(item.getContent());
				dialog.hide();
				dialog.dismiss();
				
			}
			@Override
			protected Item doInBackground(Item... items) {
				InputStream is;
				try {
					Log.d("AGENDA", "items[0].getImageUrl(): " + items[0].getImageUrl());
					is = (InputStream) NetUtils.fetch(items[0].getImageUrl());
					items[0].setImage(Drawable.createFromStream(is, "src"));
					

					is.close();
					Log.d("AGENDA", "items[0].getContentAndTitleUrl(): " + items[0].getContentAndTitleUrl());
					is = (InputStream) NetUtils.fetch(items[0].getContentAndTitleUrl());

					String toString = NetUtils.isToString(is);
					items[0].setContent(toString.split("\n")[1]);
					items[0].setTitle(toString.split("\n")[0]);

					is.close();
					
					

				} catch (MalformedURLException e) {
					Log.d("AGENDA", "MalformedURLException: " + e.getMessage());
					e.printStackTrace();
				} catch (IOException e) {
					Log.d("AGENDA", "IOException: " + e.getMessage());
					e.printStackTrace();
				} catch (Exception e) {
					Log.d("AGENDA", "Exception: " + e.getMessage());
					e.printStackTrace();
				}
				return items[0];
			}
		};
		
		asyncTask.execute(item);
				

	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
