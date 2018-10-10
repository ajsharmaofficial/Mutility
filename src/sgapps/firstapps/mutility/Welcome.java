package sgapps.firstapps.mutility;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

import android.view.animation.AnimationUtils;

import android.widget.ImageView;
import android.widget.RelativeLayout;



public class Welcome extends Activity implements AnimationListener {
	
	Animation anim,anim1;
	ImageView b2;
	RelativeLayout b1;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		b1=(RelativeLayout)findViewById(R.id.layout);
		b2=(ImageView)findViewById(R.id.imageView2);
		anim=AnimationUtils.loadAnimation(this,R.anim.am);
		anim1=AnimationUtils.loadAnimation(this,R.anim.tm);
		anim.setAnimationListener(this);
		anim1.setAnimationListener(this);
		b1.setAnimation(anim);
		
		b1.startAnimation(anim);
        
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public void onAnimationEnd(Animation animation) {
		// TODO Auto-generated method stub
		
		if(animation==anim1)
		{
			b2.clearAnimation();
			Intent i=new Intent(Welcome.this,MainActivity.class);
			startActivity(i);
			finish();
		}
		else {
		b2.setBackgroundResource(R.drawable.apps);
		b2.setAnimation(anim1);
		b2.startAnimation(anim1);
		}
		
	}
	@Override
	public void onAnimationRepeat(Animation animation) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onAnimationStart(Animation animation) {
		// TODO Auto-generated method stub
		
	}
	

}
