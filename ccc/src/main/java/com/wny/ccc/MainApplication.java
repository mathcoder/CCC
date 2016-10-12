package com.wny.ccc;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;

/**
 * name mathcoder23 pwd:mathcoder23pwd
 * name huarun pwd:huarun111
 */
public class MainApplication extends Application {

	public static Context context;
	@Override
	public void onCreate() {
		super.onCreate();
		context = this;
	}

}
