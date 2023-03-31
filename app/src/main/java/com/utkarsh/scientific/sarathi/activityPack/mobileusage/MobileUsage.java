package com.utkarsh.scientific.sarathi.activityPack.mobileusage;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AppOpsManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.utkarsh.scientific.sarathi.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MobileUsage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_usage);

        AppOpsManager appOps = (AppOpsManager) getSystemService(Context.APP_OPS_SERVICE);
        int mode = appOps.checkOpNoThrow(AppOpsManager.OPSTR_GET_USAGE_STATS, android.os.Process.myUid(), getPackageName());
        if (mode != AppOpsManager.MODE_ALLOWED) {
            // Request permission to access app usage data
            Intent intent = new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS);
            startActivity(intent);
        }

        ListView listView = (ListView) findViewById(R.id.listview);


        // Get the UsageStatsManager
        UsageStatsManager usageStatsManager = (UsageStatsManager) getSystemService(Context.USAGE_STATS_SERVICE);

        // Set the range of time for which you want to get app usage data
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_WEEK, -2);
        long startTime = calendar.getTimeInMillis();
        long endTime = System.currentTimeMillis();

        // Get the app usage data for the specified time range
        List<UsageStats> usageStatsList = usageStatsManager.queryUsageStats(UsageStatsManager.INTERVAL_DAILY, startTime, endTime);
        Log.i("si", String.valueOf(usageStatsList));
        // Create a list of app names and their usage times
        List<UsageStats> sortedUsageStatsList = sortUsageStats(getUsageStatistics(usageStatsManager));
        List<String> appUsageList = new ArrayList<>();
        for (UsageStats usageStats : sortedUsageStatsList) {
            Log.d("si", "Package name: " + usageStats.getPackageName());
            String appName = getAppNameFromPackageName(usageStats.getPackageName());
            long usageTime = usageStats.getTotalTimeInForeground();
            String appUsage = appName + " - " + formatUsageTime(usageTime);
            appUsageList.add(appUsage);
        }


        // Display the app usage data in the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, appUsageList);

        listView.setAdapter(adapter);




    }


    // Helper method to get the app name from the package name
    private String getAppNameFromPackageName(String packageName) {
        try {
            return getPackageManager().getApplicationLabel(getPackageManager().getApplicationInfo(packageName, 0)).toString();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return packageName;
    }

    private String formatUsageTime(long usageTime) {
        if (usageTime >= 60 * 60 * 1000) {
            // If usage time is more than or equal to 1 hour, display in hours and minutes
            long hours = usageTime / (60 * 60 * 1000);
            long minutes = (usageTime % (60 * 60 * 1000)) / (60 * 1000);
            return String.format("%d hour%s, %d minute%s", hours, hours == 1 ? "" : "s", minutes, minutes == 1 ? "" : "s");
        } else if (usageTime >= 60 * 1000) {
            // If usage time is more than or equal to 1 minute, display in minutes and seconds
            long minutes = usageTime / (60 * 1000);
            long seconds = (usageTime % (60 * 1000)) / 1000;
            return String.format("%d minute%s, %d second%s", minutes, minutes == 1 ? "" : "s", seconds, seconds == 1 ? "" : "s");
        } else {
            // If usage time is less than 1 minute, display in seconds
            long seconds = usageTime / 1000;
            return String.format("%d second%s", seconds, seconds == 1 ? "" : "s");
        }
    }

    private List<UsageStats> sortUsageStats(Map<String, UsageStats> usageStatsMap) {
        List<UsageStats> usageStatsList = new ArrayList<>(usageStatsMap.values());
        // Sort the list in descending order of usage time
        Collections.sort(usageStatsList, new Comparator<UsageStats>() {
            @Override
            public int compare(UsageStats u1, UsageStats u2) {
                return Long.compare(u2.getTotalTimeInForeground(), u1.getTotalTimeInForeground());
            }
        });
        return usageStatsList;
    }

    private Map<String, UsageStats> getUsageStatistics(UsageStatsManager usageStatsManager) {
        // Get the current time in milliseconds
        long currentTimeMillis = System.currentTimeMillis();

        // Set the start time to one hour ago
        long startTimeMillis = currentTimeMillis - (60 * 60 * 1000);

        // Query the app usage stats for the time range
        List<UsageStats> usageStatsList = usageStatsManager.queryUsageStats(UsageStatsManager.INTERVAL_DAILY, startTimeMillis, currentTimeMillis);

        // Create a map of package names to usage stats
        Map<String, UsageStats> usageStatsMap = new HashMap<>();
        for (UsageStats usageStats : usageStatsList) {
            usageStatsMap.put(usageStats.getPackageName(), usageStats);
        }
        return usageStatsMap;
    }





}