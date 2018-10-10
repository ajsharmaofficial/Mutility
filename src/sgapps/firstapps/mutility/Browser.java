package sgapps.firstapps.mutility;




import android.os.Bundle;
import sgapps.firstapps.mutility.R;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;


public class Browser extends Activity implements OnClickListener {
	Button load;
	WebView vu;
	EditText t1;
	String url;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_PROGRESS);
		setContentView(R.layout.activity_browser);
		load=(Button)findViewById(R.id.button1);
        t1=(EditText)findViewById(R.id.editText1);
        vu=(WebView)findViewById(R.id.webView1);
        //vu.loadUrl("http://www.google.com");
        vu.setWebViewClient(new WebViewClient());
        vu.getSettings().setLoadWithOverviewMode(true);
        vu.getSettings().setJavaScriptEnabled(true);
        vu.getProgress();
        load.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.browser, menu);
		MenuInflater mi=getMenuInflater();
		mi.inflate(R.menu.menu, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if(item.getItemId()==R.id.forward){
			if(vu.canGoForward()){
				vu.goForward();
				
			}
			
		}
		if(item.getItemId()==R.id.back){
			if(vu.canGoBack())
				vu.goBack();
			
		}
		if(item.getItemId()==R.id.ref){
			vu.clearHistory();
			 
	
		}
		if(item.getItemId()==R.id.reload){
			vu.reload();
	
		}
		
		return super.onOptionsItemSelected(item);
	}
	@Override
	public void onClick(View v) {
		final Activity act=this;
		url=t1.getText().toString();
		//getWindow().requestFeature(Window.FEATURE_PROGRESS);
		vu.setWebChromeClient(new WebChromeClient()
		{
			public void onProgressChanged(WebView view,int progress)
			{
				act.setTitle("Loading");
				act.setProgress(progress*100);
				if(progress==100)
					act.setTitle("Loaded");
			}
		});
		if(v.getId()==R.id.button1){
			/*vu.loadUrl("file:///android_asset/newb/tr.html");*/
			vu.loadUrl("http://www."+url);
			
		}
		
	}


}

