package org.browser.aramis;

import org.eclipse.swt.browser.LocationEvent;
import org.eclipse.swt.browser.LocationListener;
import org.eclipse.swt.widgets.Text;

class AdvancedLocationListener implements LocationListener{
	private Text location;
	
	public AdvancedLocationListener(Text text){
		location=text;
	}
	
	public void changing(LocationEvent event){
		location.setText("Loading " + event.location + "...");
	}
	
	public void changed(LocationEvent event){
	      location.setText(event.location);

	}
}