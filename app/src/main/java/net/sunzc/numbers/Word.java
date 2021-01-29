package net.sunzc.numbers;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "word")
public class Word {
	@PrimaryKey(autoGenerate = true)
	public int id;
	public String word;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Word word1 = (Word) o;

		return word.equals(word1.word);
	}

	@Override
	public int hashCode() {
		return word.hashCode();
	}
}
