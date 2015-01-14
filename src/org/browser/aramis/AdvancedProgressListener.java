package org.browser.aramis;

import org.eclipse.swt.browser.ProgressEvent;
import org.eclipse.swt.browser.ProgressListener;
import org.eclipse.swt.widgets.Label;

class AdvancedProgressListener implements ProgressListener{
	private Label progress;
	private static final String AT_REST = "Ready";
	public AdvancedProgressListener(Label label){
		progress=label;
	}
	
	public void changed(ProgressEvent event){
		if(event.total != 0){
			int percent = (int) (event.current / event.total);
			progress.setText(percent + "%");
		}else{
			progress.setText("");
		}
	}
	
	public void completed(ProgressEvent event){
		progress.setText(AT_REST);
	}
	
}