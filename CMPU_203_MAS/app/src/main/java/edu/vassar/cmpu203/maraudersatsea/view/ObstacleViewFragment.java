package edu.vassar.cmpu203.maraudersatsea.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


import edu.vassar.cmpu203.maraudersatsea.databinding.FragmentObstacleViewBinding;
import edu.vassar.cmpu203.maraudersatsea.model.Obstacle;


public class ObstacleViewFragment extends Fragment implements IObstacleView {

    public FragmentObstacleViewBinding binding;
    private Listener listener;

    private Obstacle obs;


    public ObstacleViewFragment(Obstacle obs, Listener listener) {
        this.listener = listener;
        this.obs = obs;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentObstacleViewBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    public void optionButtons(Boolean flip) {
        this.binding.storyOptionA.setEnabled(flip);
        this.binding.storyOptionB.setEnabled(flip);
        if (flip) {
            this.binding.storyOptionA.setVisibility(View.VISIBLE);
            this.binding.storyOptionB.setVisibility(View.VISIBLE);
        } else {
            this.binding.storyOptionA.setVisibility(View.INVISIBLE);
            this.binding.storyOptionB.setVisibility(View.INVISIBLE);
        }
    }

    public void flipButton(ImageButton b, Boolean flip) {
        if (flip) {
            b.setVisibility(View.VISIBLE);
        } else {
            b.setVisibility(View.INVISIBLE);
        }
        b.setEnabled(flip);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        this.binding.sceneText.setText(obs.getText());
        flipButton(this.binding.exitButton, false);

        this.binding.storyOptionA.setText(obs.getOptions()[0]);
        this.binding.storyOptionB.setText(obs.getOptions()[1]);

        this.binding.storyOptionA.setOnClickListener(new View.OnClickListener() {
            /**
             * Listener method to be called when the option a button is clicked.
             *
             * @param view the view that was clicked on
             */
            @Override
            public void onClick(View view) {
                ObstacleViewFragment.this.binding.sceneText.setText(obs.returnObsEnding('A'));
                optionButtons(false);
                flipButton(ObstacleViewFragment.this.binding.exitButton, true);
                ObstacleViewFragment.this.listener.performSolutionA(obs.code);
            }
        });
        this.binding.storyOptionB.setOnClickListener(new View.OnClickListener() {
            /**
             * Listener method to be called when the option b button is clicked.
             *
             * @param view the view that was clicked on
             */
            @Override
            public void onClick(View view) {
                ObstacleViewFragment.this.binding.sceneText.setText(obs.returnObsEnding('B'));
                optionButtons(false);
                flipButton(ObstacleViewFragment.this.binding.exitButton, true);
                ObstacleViewFragment.this.listener.performSolutionB(obs.code);
            }
        });
        this.binding.exitButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Listener method to be called when the exit button is clicked.
             *
             * @param view the view that was clicked on
             */
            @Override
            public void onClick(View view) {

                ObstacleViewFragment.this.listener.onSceneDone();
            }
        });
        super.onCreate(savedInstanceState);

    }
}



