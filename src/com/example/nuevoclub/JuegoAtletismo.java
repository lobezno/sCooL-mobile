package com.example.nuevoclub;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class JuegoAtletismo extends Activity {

	Canvas canvas;
	LinearLayout la;
	Bitmap bm,bm2;
	Dibuja lienzo;
	Button b1,b2;
	int x,y=0,x2=200,y2=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_juego_atletismo);
		la = (LinearLayout)findViewById(R.id.layoutjuegoatletismo);
		lienzo = new Dibuja(this);
		la.addView(lienzo);
		MediaPlayer mp = MediaPlayer.create(this, R.raw.chariotsoffire);
		mp.start();
		b1 = (Button)findViewById(R.id.button1);
		b2 = (Button)findViewById(R.id.button2);
		x=50;
		y=0;
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				y+=(int)Math.round(Math.random()*100);
				lienzo.invalidate();
			}
		});
		
		b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				y2+=(int)Math.round(Math.random()*100);
				lienzo.invalidate();
			}
		});
		
	}

	public class Dibuja extends View{

		public Dibuja(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
			bm=BitmapFactory.decodeResource(context.getResources(), R.drawable.corredor1);
			bm2=BitmapFactory.decodeResource(context.getResources(), R.drawable.corredor1);
		}
		
		public void onDraw(Canvas canvas){
			Paint pincel1 = new Paint();
			pincel1.setStrokeWidth(30);
			pincel1.setARGB(255, 255, 0, 0);
		    canvas.drawBitmap(bm, x,y,pincel1);
		    
		    Paint pincel2 = new Paint();
			pincel2.setStrokeWidth(30);
			pincel2.setARGB(255, 255, 0, 0);
		    canvas.drawBitmap(bm, x2,y2,pincel2);
		}
		
		
	}

}
