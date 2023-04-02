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
            Intent intent = new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS);
            startActivity(intent);
        }

        ListView listView = (ListView) findViewById(R.id.listview);

        UsageStatsManager usageStatsManager = (UsageStatsManager) getSystemService(Context.USAGE_STATS_SERVICE);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_WEEK, -2);
        long startTime = calendar.getTimeInMillis();
        long endTime = System.currentTimeMillis();


        List<UsageStats> usageStatsList = usageStatsManager.queryUsageStats(UsageStatsManager.INTERVAL_DAILY, startTime, endTime);

        List<UsageStats> sortedUsageStatsList = sortUsageStats(getUsageStatistics(usageStatsManager));
        List<String> appUsageList = new ArrayList<>();
        for (UsageStats usageStats : sortedUsageStatsList) {
            String appName = getAppNameFromPackageName(usageStats.getPackageName());
            long usageTime = usageStats.getTotalTimeInForeground();
            String appUsage = appName + " - " + formatUsageTime(usageTime);
            appUsageList.add(appUsage);
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, appUsageList);

        listView.setAdapter(adapter);




    }


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
                       long hours = usageTime / (60 * 60 * 1000);
            long minutes = (usageTime % (60 * 60 * 1000)) / (60 * 1000);
            return String.format("%d hour%s, %d minute%s", hours, hours == 1 ? "" : "s", minutes, minutes == 1 ? "" : "s");
        } else if (usageTime >= 60 * 1000) {
            long minutes = usageTime / (60 * 1000);
            long seconds = (usageTime % (60 * 1000)) / 1000;
            return String.format("%d minute%s, %d second%s", minutes, minutes == 1 ? "" : "s", seconds, seconds == 1 ? "" : "s");
        } else {
                        long seconds = usageTime / 1000;
            return String.format("%d second%s", seconds, seconds == 1 ? "" : "s");
        }
    }

    private List<UsageStats> sortUsageStats(Map<String, UsageStats> usageStatsMap) {
        List<UsageStats> usageStatsList = new ArrayList<>(usageStatsMap.values());
               Collections.sort(usageStatsList, new Comparator<UsageStats>() {
            @Override
            public int compare(UsageStats u1, UsageStats u2) {
                return Long.compare(u2.getTotalTimeInForeground(), u1.getTotalTimeInForeground());
            }
        });
        return usageStatsList;
    }

    private Map<String, UsageStats> getUsageStatistics(UsageStatsManager usageStatsManager) {

        long currentTimeMillis = System.currentTimeMillis();

        long startTimeMillis = currentTimeMillis - (60 * 60 * 1000);

        List<UsageStats> usageStatsList = usageStatsManager.queryUsageStats(UsageStatsManager.INTERVAL_DAILY, startTimeMillis, currentTimeMillis);

        Map<String, UsageStats> usageStatsMap = new HashMap<>();
        for (UsageStats usageStats : usageStatsList) {
            usageStatsMap.put(usageStats.getPackageName(), usageStats);
        }
        return usageStatsMap;
    }





}