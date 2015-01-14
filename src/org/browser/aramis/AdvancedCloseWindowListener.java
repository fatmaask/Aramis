package org.browser.aramis;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.CloseWindowListener;
import org.eclipse.swt.browser.WindowEvent;

class AdvancedCloseWindowListener implements CloseWindowListener{
	public void close(WindowEvent event){
		((Browser) event.widget).getShell().close();
	}
}