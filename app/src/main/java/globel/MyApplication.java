package globel;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.util.Printer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Created by acer on 2017/8/9.
 */

public class MyApplication extends Application {

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            private PrintWriter printWriter;

            @Override
            public void uncaughtException(Thread thread, Throwable throwable) {

                try {
                    String s = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "myerror.log";
                    File file = new File(s);
                    printWriter = new PrintWriter(file);
                    throwable.printStackTrace(printWriter);

                    //上传到服务器

                    //关闭软件
                    System.exit(0);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    printWriter.close();
                }
            }
        });
    }

    public static Context getContext() {
        return mContext;
    }
}
