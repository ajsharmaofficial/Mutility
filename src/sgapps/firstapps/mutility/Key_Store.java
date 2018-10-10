package sgapps.firstapps.mutility;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import sgapps.firstapps.mutility.R;

public class Key_Store extends Activity implements OnClickListener {
	EditText nm,pass;
	ImageView sv,get,up;
	String site,pwd;
	TextView t;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_key__store);
		nm=(EditText)findViewById(R.id.editText1);
		nm.setTextColor(Color.RED);
		pass=(EditText)findViewById(R.id.editText2);
		pass.setTextColor(Color.RED);
		sv=(ImageView)findViewById(R.id.imageView1);
		get=(ImageView)findViewById(R.id.imageView2);
		up=(ImageView)findViewById(R.id.imageView3);
		t=(TextView)findViewById(R.id.textView4);
		t.setTextColor(Color.RED);
		sv.setOnClickListener(this);
		get.setOnClickListener(this);
		up.setOnClickListener(this);
		t.setText("");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.key__store, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.imageView1)
		{site=nm.getText().toString();
		pwd=pass.getText().toString();
		
			keydb obj1=new keydb(this);
			try
			{
				if(site.equals("")||pwd.equals(""))
				{
					Toast.makeText(this,"Either field can't be empty", Toast.LENGTH_SHORT).show();
				}
				else
				{

					obj1.open();
				obj1.add(site,pwd);
				Toast.makeText(Key_Store.this,"Succesfully Stored your password", Toast.LENGTH_SHORT).show();
				obj1.close();
				}
			
			}
			catch(Exception e)
			{e.printStackTrace();}
		}
		
		if(v.getId()==R.id.imageView2)
		{	site=nm.getText().toString();
			keydb obj2=new keydb(this);
			try
			{if(site.equals(""))
			{
				Toast.makeText(this,"Please enter the site name", Toast.LENGTH_SHORT).show();
			}else
			{
				obj2.open();
				String getpwd=obj2.get(site);
				Toast.makeText(Key_Store.this,getpwd, Toast.LENGTH_SHORT).show();
				t.setText("Password for "+site+" is "+getpwd);
				obj2.close();
			}
			}
			catch(Exception e)
			{e.printStackTrace();}
			
		}
		if(v.getId()==R.id.imageView3)
		{	site=nm.getText().toString();
			pwd=pass.getText().toString();
			keydb obj3=new keydb(this);
			try
			{if(site.equals("")||pwd.equals(""))
			{
				Toast.makeText(this,"Either Field can't be empty", Toast.LENGTH_SHORT).show();	
			}else
			{
				obj3.open();
				obj3.update(site,pwd);
				Toast.makeText(Key_Store.this,"Password Updated", Toast.LENGTH_SHORT).show();
				obj3.close();
			}
			}
			catch(Exception e)
			{e.printStackTrace();}
			
		}
	}

	

}
