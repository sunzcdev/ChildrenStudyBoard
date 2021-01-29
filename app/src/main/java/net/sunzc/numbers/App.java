package net.sunzc.numbers;

import android.app.Application;

import com.tencent.bugly.Bugly;
import com.tencent.bugly.BuglyStrategy;

public class App extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		BuglyStrategy strage = new BuglyStrategy();
		strage.setBuglyLogUpload(true);
		Bugly.init(this, "", Bugly.isDev(),strage);
	}
}
