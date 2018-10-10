package sgapps.firstapps.mutility;


import android.R.color;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import sgapps.firstapps.mutility.R;


public class TicTacToe_s extends Activity implements OnClickListener {
	Button b1,b2,b3,b4,b5,b6,b7,b8,b9,reload,exit;
	int value[]=new int[9];
	char c[]=new char[9];
	int win=-1,flg=0,count=0;
	//TextView t;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tic_tac_toe_s);
		 b1=(Button)findViewById(R.id.button1);
	        b2=(Button)findViewById(R.id.button2);
	        b3=(Button)findViewById(R.id.button3);
	        b4=(Button)findViewById(R.id.button4);
	        b5=(Button)findViewById(R.id.button5);
	        b6=(Button)findViewById(R.id.button6);
	        b7=(Button)findViewById(R.id.button7);
	        b8=(Button)findViewById(R.id.button8);
	        b9=(Button)findViewById(R.id.button9);
	        b1.setTextColor(Color.RED);
	        b2.setTextColor(Color.RED);
	        b3.setTextColor(Color.RED);
	        b4.setTextColor(Color.RED);
	        b5.setTextColor(Color.RED);
	        b6.setTextColor(Color.RED);
	        b7.setTextColor(Color.RED);
	        b8.setTextColor(Color.RED);
	        b9.setTextColor(Color.RED);
	        reload=(Button)findViewById(R.id.button10);
	        exit=(Button)findViewById(R.id.button11);
	       // t=(TextView)findViewById(R.id.textView1);
	        b1.setOnClickListener(this);
	        b2.setOnClickListener(this);
	        b3.setOnClickListener(this);
	        b4.setOnClickListener(this);
	        b5.setOnClickListener(this);
	        b6.setOnClickListener(this);
	        b7.setOnClickListener(this);
	        b8.setOnClickListener(this);
	        b9.setOnClickListener(this);
	        reload.setOnClickListener(this);
	        exit.setOnClickListener(this);
	        //t.setText("");
	        init();
	}
	
	void init()
    {
    for(int j=0;j<9;j++)
    {
    	value[j]=2;
    }
    }
    //********************************
    boolean isEmpty(int t)
    {
    switch(t)
    {
    case 0:if(b1.getText().toString().equals("")==true)
    {
    	return true;
    }break;
    case 1:if(b2.getText().toString().equals("")==true)
    {
    	return true;
    }break;
    case 2:if(b3.getText().toString().equals("")==true)
    {
    	return true;
    }break;
    case 3:if(b4.getText().toString().equals("")==true)
    {
    	return true;
    }break;
    case 4:if(b5.getText().toString().equals("")==true)
    {
    	return true;
    }break;
    case 5:if(b6.getText().toString().equals("")==true)
    {
    	return true;
    }break;
    case 6:if(b7.getText().toString().equals("")==true)
    {
    	return true;
    }break;
    case 7:if(b8.getText().toString().equals("")==true)
    {
    	return true;
    }break;
    case 8:if(b9.getText().toString().equals("")==true)
    {
    	return true;
    }break;
    default:return false;
    }
	return false;
    }
    //***********************
    int rand()
    {
    	int m=(int) (9*Math.random());
    	return m;
    }
    //****************************
    int takeCenter()
    {	int ctr=20;
    	if(b5.getText().toString().equals(""))
    	{
    		return 4;
    	}
    	else 
    	{
    		while(ctr>0)
    			{int a=rand();
    			//if(a%2!=0)
    			//{
    				if(isEmpty(a))
    				{
    					return a;
    				}
    			//}
    			
    			ctr--;	
    			}
    		
    	}
    	return -1;
    }
    //****************************
    int nextWin()
    {
    	if(value[0]*value[1]*value[2]==50)
    	{
    		if(value[0]==2)
    			return 0;
    		if(value[1]==2)
    			return 1;
    		if(value[2]==2)
    			return 2;	
    	}
    	if(value[0]*value[3]*value[6]==50)
    	{
    		if(value[0]==2)
    			return 0;
    		if(value[3]==2)
    			return 3;
    		if(value[6]==2)
    			return 6;
    	}
    	if(value[0]*value[4]*value[8]==50)
    	{
    		if(value[0]==2)
    			return 0;
    		if(value[4]==2)
    			return 4;
    		if(value[8]==2)
    			return 8;
    	}
    	if(value[1]*value[4]*value[7]==50)
    	{
    		if(value[1]==2)
    			return 1;
    		if(value[4]==2)
    			return 4;
    		if(value[7]==2)
    			return 7;
    	}
    	if(value[2]*value[5]*value[8]==50)
    	{
    		if(value[2]==2)
    			return 2;
    		if(value[5]==2)
    			return 5;
    		if(value[8]==2)
    			return 8;
    	}
    	if(value[3]*value[4]*value[5]==50)
    	{
    		if(value[3]==2)
    			return 3;
    		if(value[4]==2)
    			return 4;
    		if(value[5]==2)
    			return 5;
    	}
    	if(value[6]*value[7]*value[8]==50)
    	{
    		if(value[6]==2)
    			return 6;
    		if(value[7]==2)
    			return 7;
    		if(value[8]==2)
    			return 8;
    	}
    	if(value[2]*value[4]*value[6]==50)
    	{
    		if(value[2]==2)
    			return 2;
    		if(value[4]==2)
    			return 4;
    		if(value[6]==2)
    			return 6;
    	}
    	
    return -1;	
    }
    //****************
    int notLoose()
    {
    	if(value[0]*value[1]*value[2]==18)
    	{
    		if(value[0]==2)
    			return 0;
    		if(value[1]==2)
    			return 1;
    		if(value[2]==2)
    			return 2;	
    	}
    	if(value[0]*value[3]*value[6]==18)
    	{
    		if(value[0]==2)
    			return 0;
    		if(value[3]==2)
    			return 3;
    		if(value[6]==2)
    			return 6;
    	}
    	if(value[0]*value[4]*value[8]==18)
    	{
    		if(value[0]==2)
    			return 0;
    		if(value[4]==2)
    			return 4;
    		if(value[8]==2)
    			return 8;
    	}
    	if(value[1]*value[4]*value[7]==18)
    	{
    		if(value[1]==2)
    			return 1;
    		if(value[4]==2)
    			return 4;
    		if(value[7]==2)
    			return 7;
    	}
    	if(value[2]*value[5]*value[8]==18)
    	{
    		if(value[2]==2)
    			return 2;
    		if(value[5]==2)
    			return 5;
    		if(value[8]==2)
    			return 8;
    	}
    	if(value[3]*value[4]*value[5]==18)
    	{
    		if(value[3]==2)
    			return 3;
    		if(value[4]==2)
    			return 4;
    		if(value[5]==2)
    			return 5;
    	}
    	if(value[6]*value[7]*value[8]==18)
    	{
    		if(value[6]==2)
    			return 6;
    		if(value[7]==2)
    			return 7;
    		if(value[8]==2)
    			return 8;
    	}
    	if(value[2]*value[4]*value[6]==18)
    	{
    		if(value[2]==2)
    			return 2;
    		if(value[4]==2)
    			return 4;
    		if(value[6]==2)
    			return 6;
    	}
    	
    return -1;
    }
    void compTurn()
    {
    	int r;
    	r=nextWin();
    	if(r==-1)
    		r=notLoose();
    	if(r==-1)
    		r=takeCenter();
    		
	switch(r)
	{
	case 0:	b1.setText("O");c[0]='O';value[0]=5;break;
	case 1:b2.setText("O");c[1]='O';value[1]=5;break;
	case 2:b3.setText("O");c[2]='O';value[2]=5;break;
	case 3:b4.setText("O");c[3]='O';value[3]=5;break;
	case 4:b5.setText("O");c[4]='O';value[4]=5;break;
	case 5:b6.setText("O");c[5]='O';value[5]=5;break;
	case 6:b7.setText("O");c[6]='O';value[6]=5;break;
	case 7:b8.setText("O");c[7]='O';value[7]=5;break;
	case 8:b9.setText("O");c[8]='O';value[8]=5;break;
	}
    }
    //****************************
    
    
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tic_tac_toe_s, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.button1)
		{
			if (b1.getText().toString().equals(""))
					{
					b1.setText("X");
					c[0]='X';
					value[0]=3;
					flg=1;
					count++;
					}
			
		}
		if(v.getId()==R.id.button2)
		{
			if (b2.getText().toString().equals(""))
					{
				
					b2.setText("X");
					c[1]='X';
					value[1]=3;
					flg=1;
					count++;
					}
			
		}
		
		if(v.getId()==R.id.button3)
		{
			if (b3.getText().toString().equals(""))
					{
				
					b3.setText("X");
					c[2]='X';
					value[2]=3;
					flg=1;
					count++;
					}
			
		}
		
		if(v.getId()==R.id.button4)
		{
			if (b4.getText().toString().equals(""))
					{
					b4.setText("X");
					c[3]='X';
					value[3]=3;
					flg=1;
					count++;
					}
			
		}
		
		if(v.getId()==R.id.button5)
		{
			if (b5.getText().toString().equals(""))
					{
					b5.setText("X");
					c[4]='X';
					value[4]=3;
					flg=1;
					count++;
					}
			
		}
		
		if(v.getId()==R.id.button6)
		{
			if (b6.getText().toString().equals(""))
					{
					b6.setText("X");
					c[5]='X';
					value[5]=3;
					flg=1;
					count++;
					}
		}
		
		if(v.getId()==R.id.button7)
		{
			if (b7.getText().toString().equals(""))
					{
					b7.setText("X");
					c[6]='X';
					value[6]=3;
					flg=1;
					count++;
					}
			
		}
		
		if(v.getId()==R.id.button8)
		{
			if (b8.getText().toString().equals(""))
					{
					b8.setText("X");
					c[7]='X';
					value[7]=3;
					flg=1;
					count++;
					}
			
		}
		
		if(v.getId()==R.id.button9)
		{
			if (b9.getText().toString().equals(""))
					{
					b9.setText("X");
					c[8]='X';
					value[8]=3;
					flg=1;
					count++;
					}
			
		}
		if(flg==1&&count<9)
		{	//t.setText("");
			compTurn();
			flg=(flg+1)%2;
			count++;
		}
		if(v.getId()==R.id.button10)
		{
			b1.setText("");
			b2.setText("");
			b3.setText("");
			b4.setText("");
			b5.setText("");
			b6.setText("");
			b7.setText("");
			b8.setText("");
			b9.setText("");
			flg=0;win=-1;count=0;
			for(int i=0;i<9;i++)
				c[i]='\0';
			init();
			b1.setEnabled(true);
			b2.setEnabled(true);
			b3.setEnabled(true);
			b4.setEnabled(true);
			b5.setEnabled(true);
			b6.setEnabled(true);
			b7.setEnabled(true);
			b8.setEnabled(true);
			b9.setEnabled(true);
			
		}
		if(v.getId()==R.id.button11)
		{
			finish();
			System.exit(0);
			
		}
		
		
		if(c[0]==c[1]&&c[0]==c[2]&&c[0]=='X'
		 ||c[0]==c[3]&&c[0]==c[6]&&c[0]=='X'
		 ||c[0]==c[4]&&c[0]==c[8]&&c[0]=='X'
		 ||c[1]==c[4]&&c[1]==c[7]&&c[1]=='X'
		 ||c[2]==c[5]&&c[2]==c[8]&&c[2]=='X'
		 ||c[2]==c[4]&&c[2]==c[6]&&c[2]=='X'
		 ||c[3]==c[4]&&c[3]==c[5]&&c[3]=='X'
		 ||c[6]==c[7]&&c[6]==c[8]&&c[6]=='X'
		 )
		{
			win=1;
			
		}
		else if(c[0]==c[1]&&c[0]==c[2]&&c[0]=='O'
			  ||c[0]==c[3]&&c[0]==c[6]&&c[0]=='O'
			  ||c[0]==c[4]&&c[0]==c[8]&&c[0]=='O'
			  ||c[1]==c[4]&&c[1]==c[7]&&c[1]=='O'
			  ||c[2]==c[5]&&c[2]==c[8]&&c[2]=='O'
			  ||c[2]==c[4]&&c[2]==c[6]&&c[2]=='O'
			  ||c[3]==c[4]&&c[3]==c[5]&&c[3]=='O'
			  ||c[6]==c[7]&&c[6]==c[8]&&c[6]=='O'
				 )
				{
					win=0;
				}
		 if (win==1)
		 {
		        Toast.makeText(TicTacToe_s.this,"X wins",Toast.LENGTH_SHORT).show();
		       // t.setText("X is a winner");
		 }
		        else if (win==0)
		        {
		        	Toast.makeText(TicTacToe_s.this,"O wins",Toast.LENGTH_SHORT).show();
		        	//t.setText("O is a winner");
		        }
		 if(win==1||win==0)
		 {
			 b1.setEnabled(false);
			b2.setEnabled(false);
			b3.setEnabled(false);
			b4.setEnabled(false);
			b5.setEnabled(false);
			b6.setEnabled(false);
			b7.setEnabled(false);
			b8.setEnabled(false);
			b9.setEnabled(false);
			reload.setFocusable(true);
		 }
		 if(count==9&&win==-1)
			 Toast.makeText(TicTacToe_s.this,"Its a Draw restart the game.",Toast.LENGTH_SHORT).show();
		 
		 
		
	}

}
