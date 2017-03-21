package com.codespurt.calendarviewexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.alamkanak.weekview.MonthLoader;
import com.alamkanak.weekview.WeekView;
import com.alamkanak.weekview.WeekViewEvent;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private WeekView mWeekView;
    private MonthLoader.MonthChangeListener mMonthChangeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWeekView = (WeekView) findViewById(R.id.weekView);

        mMonthChangeListener = new MonthLoader.MonthChangeListener() {

            @Override
            public List<WeekViewEvent> onMonthChange(int newYear, int newMonth) {
                List<WeekViewEvent> events = getEvents(2017, 3, 21, 21);
                return events;
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        mWeekView.setMonthChangeListener(mMonthChangeListener);
    }

    private List<WeekViewEvent> getEvents(int year, int month, int startDate, int endDate) {
        List<WeekViewEvent> matchedEvents = new ArrayList<>();
        // morning
        WeekViewEvent event1 = new WeekViewEvent(1, "", year, month, startDate, 9, 0, year, month, endDate, 12, 60);
        event1.setColor(getResources().getColor(R.color.colorPrimary));
        matchedEvents.add(event1);

        // lunch
        WeekViewEvent event2 = new WeekViewEvent(2, "", year, month, startDate, 13, 0, year, month, endDate, 13, 60);
        event2.setColor(getResources().getColor(R.color.red));
        matchedEvents.add(event2);

        // evening
        WeekViewEvent event3 = new WeekViewEvent(3, "", year, month, startDate, 14, 0, year, month, endDate, 16, 60);
        event3.setColor(getResources().getColor(R.color.colorPrimary));
        matchedEvents.add(event3);
        return matchedEvents;
    }
}
