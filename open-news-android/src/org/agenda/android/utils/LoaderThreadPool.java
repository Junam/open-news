package org.agenda.android.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoaderThreadPool 
{

	public static ExecutorService executorService = Executors.newSingleThreadExecutor();
}
