package sgapps.firstapps.mutility;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import sgapps.firstapps.mutility.R;

public class Result extends Activity implements AnimationListener {
	Button b;
	Animation an;
	MediaPlayer p;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		int res=getIntent().getExtras().getInt("nm");
		b=(Button)findViewById(R.id.button1);
		b.setText("");
		an=AnimationUtils.loadAnimation(Result.this,R.anim.bounce);
		an.setAnimationListener(this);
		b.startAnimation(an);
		p=MediaPlayer.create(this,R.raw.d );
		p.start();
		switch (res) {
		case 0:	b.setBackgroundDrawable(getResources().getDrawable(R.drawable.a));break;
		case 1:	b.setBackgroundDrawable(getResources().getDrawable(R.drawable.b));break;
		case 2:	b.setBackgroundDrawable(getResources().getDrawable(R.drawable.c));break;
		case 3: b.setBackgroundDrawable(getResources().getDrawable(R.drawable.d));break;
		case 4:	b.setBackgroundDrawable(getResources().getDrawable(R.drawable.e));break;
		case 5:	b.setBackgroundDrawable(getResources().getDrawable(R.drawable.f));break;
		case 6:	b.setBackgroundDrawable(getResources().getDrawable(R.drawable.g));break;
		case 7:	b.setBackgroundDrawable(getResources().getDrawable(R.drawable.h));break;
		case 8:	b.setBackgroundDrawable(getResources().getDrawable(R.drawable.i));break;
		case 9:	b.setBackgroundDrawable(getResources().getDrawable(R.drawable.j));break;
		default:
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result, menu);
		return true;
	}

	@Override
	public void onAnimationEnd(Animation arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAnimationRepeat(Animation arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAnimationStart(Animation arg0) {
		// TODO Auto-generated method stub
		
	}

}