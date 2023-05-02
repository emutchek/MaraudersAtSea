package edu.vassar.cmpu203.maraudersatsea.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


import edu.vassar.cmpu203.maraudersatsea.R;
import edu.vassar.cmpu203.maraudersatsea.databinding.FragmentMapViewBinding;
import edu.vassar.cmpu203.maraudersatsea.databinding.FragmentObstacleViewBinding;
import edu.vassar.cmpu203.maraudersatsea.model.Map;


public class MapViewFragment extends Fragment implements IMapView {

    public FragmentMapViewBinding binding;
    private Listener listener;
    private Map map;


    public MapViewFragment(Map map, Listener listener) {
        this.listener = listener;
        this.map = map;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentMapViewBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    public void displayMap() {
        switch (this.listener.getGrid().islandsMet) {
            case 0: this.binding.mapImage.setImageResource(R.drawable.eastern_islands__mas_);
            case 1: this.binding.mapImage.setImageResource(R.drawable.eastern_islands__mas_);
            case 2: this.binding.mapImage.setImageResource(R.drawable.eastern_islands__mas_);
            case 3: this.binding.mapImage.setImageResource(R.drawable.eastern_islands__mas_);
            case 4: this.binding.mapImage.setImageResource(R.drawable.eastern_islands__mas_);
            case 5: this.binding.mapImage.setImageResource(R.drawable.eastern_islands__mas_);
            case 6: this.binding.mapImage.setImageResource(R.drawable.eastern_islands__mas_);
            case 7: this.binding.mapImage.setImageResource(R.drawable.eastern_islands__mas_);
            case 8: this.binding.mapImage.setImageResource(R.drawable.eastern_islands__mas_);
            case 9: this.binding.mapImage.setImageResource(R.drawable.eastern_islands__mas_);
            case 10: this.binding.mapImage.setImageResource(R.drawable.eastern_islands__mas_);
            case 11: this.binding.mapImage.setImageResource(R.drawable.eastern_islands__mas_);
            case 12: this.binding.mapImage.setImageResource(R.drawable.eastern_islands__mas_);
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        displayMap();

        this.binding.exitButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Listener method to be called when the exit button is clicked.
             *
             * @param view the view that was clicked on
             */
            @Override
            public void onClick(View view) {
                MapViewFragment.this.listener.onSceneDone();
            }
        });
        super.onCreate(savedInstanceState);

    }
}
