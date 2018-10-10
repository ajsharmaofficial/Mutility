package sgapps.firstapps.mutility;

import java.sql.SQLException;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class keydb {
	static String DBNAME="db";
	static String TBNAME="passwords";
	static String SITE="sid";
	static String PASS="pwd";
	static int VER=5;
	
	Context c;
	SQLiteDatabase dbms;
	indb handleob;
	class indb extends SQLiteOpenHelper
	{

		public indb(Context context) {
			super(context, DBNAME, null, VER);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase dbo) {
			dbo.execSQL("create table "+TBNAME+" ("+SITE+" text not null, "+PASS+" text not null);");
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase dbo, int arg1, int arg2) {
			dbo.execSQL("drop table if exists "+TBNAME);
			onCreate(dbo);
			
		}
		
	}
	keydb(Context con)
	{
		c=con;
	}
	public keydb open() throws SQLException{
		handleob=new indb(c);
		dbms=handleob.getWritableDatabase();
		return this;
		
	}
	public void close() {
		handleob.close();
		
	}
	public void add(String site2, String pwd) {
		ContentValues cv=new ContentValues();
		cv.put(SITE, site2);
		cv.put(PASS, pwd);
		dbms.insert(TBNAME, null, cv);
		
	}
	public String get(String s) {
		Cursor cr;
		String t1=null,t2=null;
		String cols[]={SITE,PASS};
		cr=dbms.query(TBNAME, cols,null, null, null, null, null);
		int i=cr.getColumnIndex(SITE);
		int p=cr.getColumnIndex(PASS);
		for(cr.moveToFirst();!cr.isAfterLast();cr.moveToNext())
		{
			t1=cr.getString(i);
			t2=cr.getString(p);
			if(t1.equals(s))
				return t2;
		}
		return "NOT FOUND";
	}
	public void  update(String site2, String pwd) {
		ContentValues cv=new ContentValues();
		cv.put(PASS, pwd);
		String s= SITE+" = '"+site2+"'";
		dbms.update(TBNAME, cv, s, null);
		
	}
	
	

}
