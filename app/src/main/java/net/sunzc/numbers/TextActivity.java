package net.sunzc.numbers;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TextActivity extends Activity implements View.OnClickListener {

	private TextView numberTv;
	private ArrayList<Integer> colors;
	private List<Word> texts;
	private Word word;
	private WordDao wordDao;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_text);
		numberTv = findViewById(R.id.number_tv);
		numberTv.setOnClickListener(this);
		wordDao = WordDb.buildDb(this).getWordDao();
		texts = wordDao.getAll();
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

	List<Integer> bgcolors;

	@Override
	public void onClick(View v) {
		if (texts.isEmpty()){
			return;
		}
		int number;
		if (shuffleOrder) {
			number = new Random().nextInt(texts.size());
		} else {
			number = (texts.indexOf(word) + 1) % texts.size();
		}
		showWord(texts.get(number));
	}

	private void showWord(Word word) {
		this.word = word;
		String text = word.word;
		numberTv.setText(text);
		int randomColor = new Random().nextInt(5);
		numberTv.setTextColor(colors.get(randomColor));
		numberTv.setBackgroundColor(bgcolors.get(randomColor));
	}

	private boolean shuffleOrder = true;

	public void playOrder(View view) {
		shuffleOrder = !shuffleOrder;
		((ImageView) view).setImageResource(shuffleOrder ? R.mipmap.shuffle_order_play : R.mipmap.cycle_order_play);
	}

	public void add(View view) {
		final EditText inputText = new EditText(this);
		inputText.setInputType(InputType.TYPE_CLASS_TEXT);
		new AlertDialog.Builder(this).setView(inputText).setPositiveButton("添加", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Word word = new Word();
				word.word = inputText.getText().toString();
				showWord(word);
				texts.add(word);
				wordDao.insert(word);
			}
		}).setNegativeButton("取消", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {

			}
		}).show();
	}

	public void delete(final View view) {
		new AlertDialog.Builder(this).setTitle("确定要删除吗？").setPositiveButton("删除", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				TextActivity.this.onClick(view);
				texts.remove(word);
				wordDao.delete(word);
			}
		}).setNegativeButton("取消", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {

			}
		}).show();
	}
}
