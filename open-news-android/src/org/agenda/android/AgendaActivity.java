package org.agenda.android;

import android.app.Activity;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AgendaActivity extends Activity{

	protected TextView createNavElement(String name) {
		TextView textView = new TextView(getApplicationContext());
		textView.setText(name);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(5, 0, 5, 0);
		textView.setLayoutParams(layoutParams);
		return textView;
	}
}
