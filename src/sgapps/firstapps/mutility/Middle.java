package sgapps.firstapps.mutility;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import sgapps.firstapps.mutility.R;

public class Middle extends Activity implements OnClickListener {
	TextView t[]=new TextView[51];
	Button b;
	int r,i,save;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_middle);
		t[1]=(TextView)findViewById(R.id.TextView42);
		t[2]=(TextView)findViewById(R.id.TextView01);
		t[3]=(TextView)findViewById(R.id.TextView49);
		t[4]=(TextView)findViewById(R.id.TextView24);
		t[5]=(TextView)findViewById(R.id.TextView18);
		t[6]=(TextView)findViewById(R.id.TextView12);
		t[7]=(TextView)findViewById(R.id.TextView06);
		t[8]=(TextView)findViewById(R.id.TextView04);
		t[9]=(TextView)findViewById(R.id.TextView38);
		t[10]=(TextView)findViewById(R.id.TextView64);
		t[11]=(TextView)findViewById(R.id.TextView60);
		t[12]=(TextView)findViewById(R.id.TextView53);
		t[13]=(TextView)findViewById(R.id.TextView77);
		t[14]=(TextView)findViewById(R.id.TextView81);
		t[15]=(TextView)findViewById(R.id.TextView100);
		t[16]=(TextView)findViewById(R.id.TextView93);
		t[17]=(TextView)findViewById(R.id.TextView102);
		t[18]=(TextView)findViewById(R.id.TextView27);
		t[19]=(TextView)findViewById(R.id.TextView03);
		t[20]=(TextView)findViewById(R.id.TextView45);
		t[21]=(TextView)findViewById(R.id.TextView22);
		t[22]=(TextView)findViewById(R.id.TextView16);
		t[23]=(TextView)findViewById(R.id.TextView10);
		t[24]=(TextView)findViewById(R.id.TextView40);
		t[25]=(TextView)findViewById(R.id.TextView69);
		t[26]=(TextView)findViewById(R.id.TextView63);
		t[27]=(TextView)findViewById(R.id.TextView36);
		t[28]=(TextView)findViewById(R.id.TextView58);
		t[29]=(TextView)findViewById(R.id.TextView71);
		t[30]=(TextView)findViewById(R.id.TextView75);
		t[31]=(TextView)findViewById(R.id.TextView83);
		t[32]=(TextView)findViewById(R.id.TextView97);
		t[33]=(TextView)findViewById(R.id.TextView91);
		t[34]=(TextView)findViewById(R.id.TextView104);
		t[35]=(TextView)findViewById(R.id.TextView26);
		t[36]=(TextView)findViewById(R.id.TextView47);
		t[37]=(TextView)findViewById(R.id.TextView43);
		t[38]=(TextView)findViewById(R.id.TextView20);
		t[39]=(TextView)findViewById(R.id.TextView14);
		t[40]=(TextView)findViewById(R.id.TextView08);
		t[41]=(TextView)findViewById(R.id.TextView51);
		t[42]=(TextView)findViewById(R.id.TextView67);
		t[43]=(TextView)findViewById(R.id.TextView61);
		t[44]=(TextView)findViewById(R.id.TextView34);
		t[45]=(TextView)findViewById(R.id.TextView55);
		t[46]=(TextView)findViewById(R.id.TextView73);
		t[47]=(TextView)findViewById(R.id.TextView79);
		t[48]=(TextView)findViewById(R.id.TextView87);
		t[49]=(TextView)findViewById(R.id.TextView95);
		t[50]=(TextView)findViewById(R.id.TextView89);
		
		b=(Button)findViewById(R.id.button1);
		b.setOnClickListener(this);
		r=(int) (Math.random()*10);
		save=r;
		set(r,9);
		set(r,18);
		set(r,27);
		set(r,36);
		set(r,45);
		for(i=1;i<=50;i++)
		{
			if(i==9||i==18||i==27||i==36||i==45)
				continue;
		r=(int) (10*Math.random());
		set(r,i);
		}
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	void set(int ran,int j )
	{
		switch (ran) {
		case 0:	t[j].setText("");t[j].setBackgroundDrawable(getResources().getDrawable(R.drawable.aa));break;
		case 1:	t[j].setText("");t[j].setBackgroundDrawable(getResources().getDrawable(R.drawable.bb));break;
		case 2:	t[j].setText("");t[j].setBackgroundDrawable(getResources().getDrawable(R.drawable.cc));break;
		case 3: t[j].setText("");t[j].setBackgroundDrawable(getResources().getDrawable(R.drawable.dd));break;
		case 4:	t[j].setText("");t[j].setBackgroundDrawable(getResources().getDrawable(R.drawable.ee));break;
		case 5:	t[j].setText("");t[j].setBackgroundDrawable(getResources().getDrawable(R.drawable.ff));break;
		case 6:	t[j].setText("");t[j].setBackgroundDrawable(getResources().getDrawable(R.drawable.gg));break;
		case 7:	t[j].setText("");t[j].setBackgroundDrawable(getResources().getDrawable(R.drawable.hh));break;
		case 8:	t[j].setText("");t[j].setBackgroundDrawable(getResources().getDrawable(R.drawable.ii));break;
		case 9:	t[j].setText("");t[j].setBackgroundDrawable(getResources().getDrawable(R.drawable.jj));break;
		default:
			break;
		}
	}
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.button1)
		{
			Intent i =new Intent(Middle.this,Result.class);
			i.putExtra("nm",save);
			startActivity(i);
			/*t.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_launcher));
			t3.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_launcher));
			
			b.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_launcher));*/
		}
		// TODO Auto-generated method stub
		
	}

}