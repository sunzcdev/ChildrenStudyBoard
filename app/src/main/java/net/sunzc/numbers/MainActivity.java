package net.sunzc.numbers;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 播放数字，文字，图片等
 * 可以新增，删除，查看播放的文字和列表
 * 设置播放顺序，乱序，顺序
 * 可以缩小文字大小，重置文字大小
 */
public class MainActivity extends Activity implements View.OnClickListener {

	private TextView numberTv;
	private ArrayList<Integer> colors;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		numberTv = findViewById(R.id.number_tv);
		numberTv.setOnClickListener(this);
		colors = new ArrayList<Integer>() {
			{
				add(0xffCC0099);
				add(0xffCCCC00);
				add(0xff76D7C4);
				add(0xff5B2C6F);
				add(0xff34495E);
			}
		};
		bgcolors = new ArrayList<Integer>() {
			{
				add(0xff000066);
				add(0xffFF00FF);
				add(0xffFF3333);
				add(0xff000000);
				add(0xffFFFF33);
			}
		};
		onClick(numberTv);
	}

	private List<Integer> bgcolors;

	@Override
	public void onClick(View v) {
		int number;
		if (shuffleOrder) {
			number = new Random().nextInt(100);
		} else {
			number = Integer.parseInt(numberTv.getText().toString()) + 1;
		}
		numberTv.setText(number + "");
		int randomColor = new Random().nextInt(5);
		numberTv.setTextColor(colors.get(randomColor));
		numberTv.setBackgroundColor(bgcolors.get(randomColor));
	}

	private boolean shuffleOrder = true;

	public void playOrder(View view) {
		shuffleOrder = !shuffleOrder;
		((ImageView) view).setImageResource(shuffleOrder ? R.mipmap.shuffle_order_play : R.mipmap.cycle_order_play);
	}

}
