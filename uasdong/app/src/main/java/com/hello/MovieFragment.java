package com.hello;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.hello.R;

public class MovieFragment extends Fragment {

    private static final String TAG = "RomanceFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_movie, container, false);

        // Find the button by its ID
        Button ayatayatcinta2Button = view.findViewById(R.id.ayatayatcinta2);
        Button ilyfrom38000ftButton = view.findViewById(R.id.tigaidiot);
        Button ketikaberhentidisniButton = view.findViewById(R.id.tdl);

        // Set click listener for each button
        ayatayatcinta2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Ayat ayat cinta 2 button clicked");
                playVideo(R.raw.ayatayatcinta2);
            }
        });

        ilyfrom38000ftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "tiga idiot button clicked");
                playVideo(R.raw.tigaidiot);
            }
        });

        ketikaberhentidisniButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "tdl button clicked");
                playVideo(R.raw.tdl);
            }
        });

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_tab, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.tab_romance) {
            Toast.makeText(getActivity(), "Clicked on " + item.getTitle(), Toast.LENGTH_SHORT)
                    .show();
        }
        return true;
    }

    private void playVideo(int videoResource) {
        String videoPath = "android.resource://" + getActivity().getPackageName() + "/" + videoResource;
        Intent intent = new Intent(getActivity(), VideoPlayerActivity.class);
        intent.putExtra("VIDEO_PATH", videoPath);
        startActivity(intent);
    }
}