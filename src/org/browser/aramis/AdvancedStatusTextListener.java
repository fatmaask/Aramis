package org.browser.aramis;

import org.eclipse.swt.browser.StatusTextEvent;
import org.eclipse.swt.browser.StatusTextListener;
import org.eclipse.swt.widgets.Label;

class AdvancedStatusTextListener implements StatusTextListener{
	private Label status;
	
	
	public AdvancedStatusTextListener(Label label){
		status=label;
	}
	
	public void changed(StatusTextEvent event){
		status.setText(event.text);
	}
}
