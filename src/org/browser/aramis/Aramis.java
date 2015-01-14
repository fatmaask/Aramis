package org.browser.aramis;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.events.*;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.GridLayout;




public class Aramis {

	protected Shell shell;
	private Shell shlAramis_1;
	private int insertMark = -1;
	public static Browser browser2;
	public static Text text;
	private Display display;
	private Shell shell1;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public void open(String location) {
		display = new Display();
	    shlAramis_1 = new Shell(display);
	    shell1= new Shell(shlAramis_1, SWT.DIALOG_TRIM | SWT.MIN);
	    shell1.setSize(622,359);
	    shlAramis_1.setSize(1000, 600);
	    Image small = new Image(display, "C:\\Users\\Fatma\\Desktop\\workspace\\Aramis\\src\\img\\browser2.png");
	    shlAramis_1.setImage(small);
	    shlAramis_1.setText("Aramis");
	    createContents(shlAramis_1, location);
	    

	    
	    shlAramis_1.open();
	    while (!shlAramis_1.isDisposed()) {
	      if (!display.readAndDispatch()) {
	        display.sleep();
	      }
	    }
	    display.dispose();
	    
	}
	
	/**
	 * Create contents of the window.
	 */
	public void createContents(Shell shlAramis, String location) {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		shlAramis_1.setLayout(new BorderLayout(0, 0));
		
	
		CTabFolder tabFolder = new CTabFolder(shlAramis_1, SWT.BORDER);
		tabFolder.setBackground(SWTResourceManager.getColor(204, 204, 204));
	    tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
	    tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
	    tabFolder.setSimple(false);
	    tabFolder.setUnselectedImageVisible(false);
	    tabFolder.setUnselectedCloseVisible(false);
	
	    
	    tabFolder.setSelectionBackground(new Color[] {
		        display.getSystemColor(SWT.COLOR_WIDGET_BACKGROUND),
		        display.getSystemColor(SWT.COLOR_WIDGET_NORMAL_SHADOW),
		        display.getSystemColor(SWT.COLOR_WIDGET_LIGHT_SHADOW) }, new int[] { 50, 100 });
	    
	    CTabItem YeniSekme = new CTabItem(tabFolder, SWT.NONE);
	    YeniSekme.setText("New Tab");
	    
	    
	    ViewForm viewForm = new ViewForm(tabFolder, SWT.NONE);
	    YeniSekme.setControl(viewForm);
	    
	    Composite composite = new Composite(viewForm, SWT.NONE);
	    viewForm.setTopLeft(composite);
	    
	   
	    
	    Browser browser = new Browser(viewForm, SWT.NONE);
	    viewForm.setContent(browser);
	    
	 
	 	    // Add event handlers
	 	    browser.addCloseWindowListener(new AdvancedCloseWindowListener());
	 	    
	 	    // Go to the initial URL
	 	     
	 	    if(location != ""){
	 	    	browser.setUrl("www.google.com");
	 	    }
	 	   composite.setLayout(new GridLayout(4, false));
	 	    
	 	    
	 	    
	 	   ToolBar toolBar = new ToolBar(composite, SWT.FLAT | SWT.RIGHT);
		    
		    ToolItem toolItem = new ToolItem(toolBar, SWT.NONE);
		    toolItem.setImage(SWTResourceManager.getImage("C:\\Users\\Fatma\\Desktop\\workspace\\Aramis\\src\\img\\back.png"));
		    toolItem.addSelectionListener(new SelectionAdapter() {
		    	@Override
		    	public void widgetSelected(SelectionEvent e) {
		    		browser.back();
		    	}
		    });
		    
		    ToolItem toolItem_1 = new ToolItem(toolBar, SWT.NONE);
		    toolItem_1.setImage(SWTResourceManager.getImage("C:\\Users\\Fatma\\Desktop\\workspace\\Aramis\\src\\img\\forward.png"));
		    
		    toolItem_1.addSelectionListener(new SelectionAdapter() {
		    	@Override
		    	public void widgetSelected(SelectionEvent e) {
		    		browser.forward();
		    	}
		    });
		    
		    ToolItem toolItem_2 = new ToolItem(toolBar, SWT.NONE);
		    toolItem_2.addSelectionListener(new SelectionAdapter() {
		    	@Override
		    	public void widgetSelected(SelectionEvent e) {
		    		browser.refresh();
		    	}
		    });
		    toolItem_2.setImage(SWTResourceManager.getImage("C:\\Users\\Fatma\\Desktop\\workspace\\Aramis\\src\\img\\refresh.png"));
		    
		    
		    
		    text = new Text(composite, SWT.BORDER | SWT.SEARCH);
		    text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		    text.setFocus();
		    
		    Button btnNewButton = new Button(composite, SWT.NONE);
		    btnNewButton.setText("Go");
		    btnNewButton.addSelectionListener(new SelectionAdapter() {
		    	@Override
		    	public void widgetSelected(SelectionEvent e) {
		    		browser.setUrl(text.getText());
		    	}
		    });
		    
		    shlAramis_1.setDefaultButton(btnNewButton);
		    browser.addLocationListener(new AdvancedLocationListener(text));
		    new Label(composite, SWT.NONE);
		   
		    
		    
		    Menu menu = new Menu(shlAramis_1, SWT.BAR);
		    shlAramis_1.setMenuBar(menu);
		    
		    MenuItem mntmYeniSekme = new MenuItem(menu, SWT.CASCADE);
		    mntmYeniSekme.setText("File");
		    
		    Menu menu_1 = new Menu(mntmYeniSekme);
		    mntmYeniSekme.setMenu(menu_1);
		    
		    MenuItem mntmNewTab_1 = new MenuItem(menu_1, SWT.NONE);
		    mntmNewTab_1.setText("New Tab");
		    mntmNewTab_1.setImage(SWTResourceManager.getImage("C:\\Users\\Fatma\\Desktop\\workspace\\Aramis\\src\\img\\plus.png"));
		    
		    MenuItem mntmSave = new MenuItem(menu_1, SWT.NONE);
		    mntmSave.addSelectionListener(new SelectionAdapter() {
		    	@Override
		    	public void widgetSelected(SelectionEvent e) {
		    		FileDialog dialog = new FileDialog(shell, SWT.SAVE);
		    	    dialog
		    	        .setFilterNames(new String[] { "All Files (*.*)" });
		    	    dialog.setFilterExtensions(new String[] { "*.*" });                              
		    	    dialog.setFilterPath("c:\\"); 
		    	    dialog.open();
		    	}
		    });
		    mntmSave.setText("Save");
		    
		    new MenuItem(menu_1, SWT.SEPARATOR);
		    
		    MenuItem mntmExit = new MenuItem(menu_1, SWT.NONE);
		    mntmExit.addSelectionListener(new SelectionAdapter() {
		    	@Override
		    	public void widgetSelected(SelectionEvent e) {
		    		shlAramis_1.close();
		    	}
		    });
		    mntmExit.setText("Exit");
		    mntmNewTab_1.addSelectionListener(new SelectionAdapter(){
		    	@Override
		    	public void widgetSelected(SelectionEvent event) {
		            CTabItem tabItem = new CTabItem(tabFolder, SWT.CLOSE, insertMark + 1);
		            tabItem.setText("New Tab");
		            ViewForm viewForm2 = new ViewForm(tabFolder, SWT.NONE);
		    	    tabItem.setControl(viewForm2);
		    	    
		    	    Composite composite2 = new Composite(viewForm2, SWT.NONE);
		    	    viewForm2.setTopLeft(composite2);
		    	    
		    	    browser2 = new Browser(viewForm2, SWT.NONE);
		    	    viewForm2.setContent(browser2);
		    	    
		    	 // Add event handlers
			 	    browser2.addCloseWindowListener(new AdvancedCloseWindowListener());
			 	    
			 	    // Go to the initial URL
			 	    if (location != null) {
			 	      browser2.setUrl(location);
			 	    }
			 	    
			 	    if(location != "w+"){
			 	    	browser2.setUrl("www.google.com");
			 	    }
			 	    
		    	    
		    	    ToolBar toolBar2 = new ToolBar(composite2, SWT.FLAT | SWT.RIGHT);
		    	    toolBar2.setBounds(0, 0, 73, 23);
		    	    
		    	    ToolItem toolItem2 = new ToolItem(toolBar2, SWT.NONE);
		    	    toolItem2.addSelectionListener(new SelectionAdapter() {
				    	@Override
				    	public void widgetSelected(SelectionEvent e) {
				    		browser2.back();
				    	}
				    });
		    	    toolItem2.setImage(SWTResourceManager.getImage("C:\\Users\\Fatma\\Desktop\\workspace\\Aramis2\\src\\img\\back.png"));
		    	    
		    	    ToolItem toolItem_12 = new ToolItem(toolBar2, SWT.NONE);
		    	    toolItem_12.addSelectionListener(new SelectionAdapter() {
				    	@Override
				    	public void widgetSelected(SelectionEvent e) {
				    		browser2.forward();
				    	}
				    });
		    	    toolItem_12.setImage(SWTResourceManager.getImage("C:\\Users\\Fatma\\Desktop\\workspace\\Aramis2\\src\\img\\forward.png"));
		    	    
		    	    
		    	    ToolItem toolItem_22 = new ToolItem(toolBar2, SWT.NONE);
				    toolItem_22.addSelectionListener(new SelectionAdapter() {
				    	@Override
				    	public void widgetSelected(SelectionEvent e) {
				    		browser2.refresh();
				    	}
				    });
				    toolItem_22.setImage(SWTResourceManager.getImage("C:\\Users\\Fatma\\Desktop\\workspace\\Aramis2\\src\\img\\refresh.png"));
		    	    
		    	    text = new Text(composite2, SWT.BORDER);
		    	    text.setBounds(80, 0, 393, 21);
		    	    text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
				    text.setFocus();
				    
				    Button btn2 = new Button(composite2, SWT.NONE);
				    btn2.addSelectionListener(new SelectionAdapter() {
			    	@Override
			    	public void widgetSelected(SelectionEvent e) {
			    		browser2.setUrl(text.getText());
			    	}
				    });
				    btn2.setBounds(476, 0, 38, 23);
				    btn2.setText("Go");
				    
		    	    
				    shlAramis_1.setDefaultButton(btn2);
				    browser2.addLocationListener(new AdvancedLocationListener(text));
				    new Label(composite2, SWT.NONE);	 	    
		    	    
		          }
		    });
		    
		    MenuItem mntmAbout = new MenuItem(menu, SWT.CASCADE);
		    mntmAbout.setText("About");
		    
		    Menu menu_2 = new Menu(mntmAbout);
		    mntmAbout.setMenu(menu_2);
		    
		    MenuItem mntmNewItem = new MenuItem(menu_2, SWT.NONE);
		    mntmNewItem.setText("Fatma Aþýk");    
		    
		    new MenuItem(menu_2, SWT.SEPARATOR);
		    
		    MenuItem mntmAboutAramis = new MenuItem(menu_2, SWT.NONE);
		    mntmAboutAramis.addSelectionListener(new SelectionAdapter() {
		    	@Override
		    	public void widgetSelected(SelectionEvent e) {
		    		shell1.open();
		    	}
		    });
		    mntmAboutAramis.setText("About Aramis");
	    
	    
		    shell1.setLayout(new FillLayout(SWT.HORIZONTAL));
		    shell1.setText("About Aramis");
		    shell1.setImage(SWTResourceManager.getImage("C:\\Users\\Fatma\\Desktop\\workspace\\Aramis\\src\\img\\browser2.png"));
		    shell1.setMinimized(false);
			Composite composite1 = new Composite(shell1, SWT.NONE);
			
			Label lblAramis = new Label(composite1, SWT.NONE);
			lblAramis.setForeground(SWTResourceManager.getColor(105, 105, 105));
			lblAramis.setFont(SWTResourceManager.getFont("Rosewood Std Regular", 40, SWT.BOLD | SWT.ITALIC));
			lblAramis.setBounds(309, 28, 189, 72);
			lblAramis.setText("Aramis");
			
			Label lblNewLabel = new Label(composite1, SWT.NONE);
			lblNewLabel.setForeground(SWTResourceManager.getColor(51, 51, 51));
			lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
			lblNewLabel.setBounds(309, 117, 234, 28);
			lblNewLabel.setText("Aramis was designed by Fatma Aþýk.");
			
			Label lblNewLabel_1 = new Label(composite1, SWT.NONE);
			lblNewLabel_1.setBounds(470, 282, 80, 15);
			lblNewLabel_1.setText("January 2015");
			
			Label lblNewLabel_2 = new Label(composite1, SWT.NONE);
			lblNewLabel_2.setBounds(309, 163, 240, 15);
			lblNewLabel_2.setText("Instructor: Assoc. Prof. Dr. Bekir Taner Dinçer");
			
			Label lblNewLabel_4 = new Label(composite1, SWT.NONE);
			lblNewLabel_4.setBounds(380, 200, 240, 15);
			lblNewLabel_4.setText("Muðla Sýtký Koçman University");
			
			
			Label lblNewLabel_3 = new Label(composite1, SWT.NONE);
			lblNewLabel_3.setImage(SWTResourceManager.getImage("C:\\Users\\Fatma\\Desktop\\workspace\\Aramis\\src\\img\\browser2.png"));
			lblNewLabel_3.setBounds(10, 28, 256, 256);
		    
    
		
			
	}
	

	public static void main(String[] args) {
		new Aramis().open(args.length == 0 ? null : args[0]);
		
		
	}
}
