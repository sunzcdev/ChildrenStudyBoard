package net.sunzc.numbers;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface WordDao {
	@Query("select * from word")
	List<Word> getAll();

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	void insert(Word word);

	@Delete
	void delete(Word word);
}
