package net.sunzc.numbers;

import android.content.Context;

import java.io.File;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordDb extends RoomDatabase {

	public static WordDb buildDb(Context context) {
		return Room.databaseBuilder(context.getApplicationContext(), WordDb.class, new File(context.getExternalFilesDir("db"), "file_browser.db").getAbsolutePath())
				.allowMainThreadQueries()
				.build();
	}

	public abstract WordDao getWordDao();
}
