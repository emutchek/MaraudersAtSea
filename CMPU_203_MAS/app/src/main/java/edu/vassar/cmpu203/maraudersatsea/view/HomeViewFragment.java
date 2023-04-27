package edu.vassar.cmpu203.maraudersatsea.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


import edu.vassar.cmpu203.maraudersatsea.R;
import edu.vassar.cmpu203.maraudersatsea.databinding.FragmentHomeViewBinding;
import edu.vassar.cmpu203.maraudersatsea.databinding.FragmentStoryViewBinding;
import edu.vassar.cmpu203.maraudersatsea.model.StoryScene;


public class HomeViewFragment extends Fragment implements IHomeView{

    public FragmentHomeViewBinding binding;
    private Listener listener;


    public HomeViewFragment(Listener listener) {
        this.listener = listener;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentHomeViewBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        String gameStatus = HomeViewFragment.this.listener.gameOver();
        endGame(gameStatus);

        this.binding.playButton.setOnClickListener(new View.OnClickListener(){
            /**
             * Listener method to be called when the option a button is clicked.
             *
             * @param view the view that was clicked on
             */
            @Override
            public void onClick(View view) {
                HomeViewFragment.this.listener.onSceneDone();
            }
        });


    }

    public void endGame(String message){
        if (message.equals("died")){
            this.binding.EndText.setVisibility(View.VISIBLE);
            this.binding.welcomeMessage.setVisibility(View.INVISIBLE);
        }
        else{
            this.binding.EndText.setVisibility(View.INVISIBLE);
            this.binding.welcomeMessage.setVisibility(View.VISIBLE);
        }
    }
}