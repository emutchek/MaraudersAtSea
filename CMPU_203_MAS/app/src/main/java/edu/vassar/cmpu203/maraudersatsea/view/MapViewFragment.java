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
        int x = this.listener.getGrid().islandsMet;
        switch (x) {
            case 0: {
                this.binding.mapImage.setImageResource(R.drawable.pre_islandmap);
                this.binding.mapImage.setTag(R.drawable.pre_islandmap);
                break;
            }
            case 1: {
                this.binding.mapImage.setImageResource(R.drawable.island0);
                this.binding.mapImage.setTag(R.drawable.island0);
                break;
            }
            case 2: {
                this.binding.mapImage.setImageResource(R.drawable.island1);
                this.binding.mapImage.setTag(R.drawable.island1);
                break;
            }
            case 3: {
                this.binding.mapImage.setImageResource(R.drawable.island2);
                this.binding.mapImage.setTag(R.drawable.island2);
                break;
            }
            case 4: {
                this.binding.mapImage.setImageResource(R.drawable.island3);
                this.binding.mapImage.setTag(R.drawable.island3);
                break;
            }
            case 5:{
                this.binding.mapImage.setImageResource(R.drawable.island4);
                this.binding.mapImage.setTag(R.drawable.island4);
                break;
            }
            case 6: {
                this.binding.mapImage.setImageResource(R.drawable.island5);
                this.binding.mapImage.setTag(R.drawable.island5);
                break;
            }
            case 7: {
                this.binding.mapImage.setImageResource(R.drawable.island6);
                this.binding.mapImage.setTag(R.drawable.island6);
                break;
            }
            case 8: {
                this.binding.mapImage.setImageResource(R.drawable.island7);
                this.binding.mapImage.setTag(R.drawable.island7);
                break;
            }
            case 9: {
                this.binding.mapImage.setImageResource(R.drawable.island8);
                this.binding.mapImage.setTag(R.drawable.island8);
                break;
            }
            case 10: {
                this.binding.mapImage.setImageResource(R.drawable.island9);
                this.binding.mapImage.setTag(R.drawable.island9);
                break;
            }
            case 11: {
                this.binding.mapImage.setImageResource(R.drawable.island10);
                this.binding.mapImage.setTag(R.drawable.island10);
                break;
            }
            case 12: {
                this.binding.mapImage.setImageResource(R.drawable.island11);
                this.binding.mapImage.setTag(R.drawable.island11);
                break;
            }
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
