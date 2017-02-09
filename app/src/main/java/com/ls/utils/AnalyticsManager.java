package com.ls.utils;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import com.ls.drupalcon.R;
import com.ls.drupalcon.app.App;

import android.app.Activity;

public class AnalyticsManager {


    public static void drawerFragmentTracker(Activity activity, String category, int actionId) {
        Tracker t = ((App) activity.getApplication()).getTracker();
        // Build and send an Event.
        t.setScreenName(category);
        t.send(new HitBuilders.ScreenViewBuilder().build());
    }

    public static void detailsScreenTracker(Activity activity, int categoryId, int actionId, String title) {
        Tracker t = ((App) activity.getApplication()).getTracker();
        // Build and send an Event.
        L.e("Screen" + activity.getString(categoryId) + " Details" + ": " + title);
        t.setScreenName(activity.getString(categoryId) + " Details" + ": " + title);
        t.send(new HitBuilders.ScreenViewBuilder().build());
    }

    public static void sendEvent(Activity activity, String name) {

        Tracker t = ((App) activity.getApplication()).getTracker();
        // Build and send an Event.
        t.send(new HitBuilders.EventBuilder()
                .setCategory(activity.getString(R.string.sponsor_banner))
                .setAction(name)
                .build());

        t.setScreenName(activity.getString(R.string.sponsor_banner) + ": " + name);
        t.send(new HitBuilders.ScreenViewBuilder().build());
    }
}
