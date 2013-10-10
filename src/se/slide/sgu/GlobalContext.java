package se.slide.sgu;

import android.content.Context;

import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.MapBuilder;
import com.google.analytics.tracking.android.StandardExceptionParser;

import java.text.DateFormat;
import java.util.Date;

public enum GlobalContext {
    INSTANCE;
    
    private Context context;
    
    public void init(Context context) {
        context = context.getApplicationContext();
    }

    public void sendExceptionToGoogleAnalytics(String threadName, Throwable t, boolean fatal) {
        // https://developers.google.com/analytics/devguides/collection/android/v3/exceptions
        EasyTracker easyTracker = EasyTracker.getInstance(context);
        easyTracker.send(MapBuilder.createException(new StandardExceptionParser(context, null).getDescription(threadName, t), fatal).build());
    }
    
    public String formatDate(Date date) {
        DateFormat dateFormat = android.text.format.DateFormat.getLongDateFormat(context);
        return dateFormat.format(date);
    }
}