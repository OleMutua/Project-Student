package com.example.project;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnnouncementsFragment extends Fragment {

    /**
     * Receiver for listening for new notifications
     */
    BroadcastReceiver receiver;

    /**
     * Where to display the new notification
     */
    TextView tvNotification;


    public AnnouncementsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_announcements, container, false);
        tvNotification = (TextView) view.findViewById(R.id.tvNotification);

        //Initialize the broadcast receiver to listen for intents
        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String notification = intent.getStringExtra("notification");
                tvNotification.setText(notification);
            }
        };

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        //Register receiver to only listen for new notifications for the specified action
        final IntentFilter filter = new IntentFilter();
        filter.addAction(MyFirebaseMessagingService.BROADCAST_ACTION_NEW_NOTIFICATION);
        getActivity().registerReceiver(receiver, filter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        //Don't listen for new notifications when the activity is destroyed
        if (receiver != null)
            getActivity().unregisterReceiver(receiver);
    }
}
