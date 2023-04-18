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
import edu.vassar.cmpu203.maraudersatsea.databinding.FragmentGridViewBinding;
import edu.vassar.cmpu203.maraudersatsea.databinding.FragmentStoryViewBinding;
import edu.vassar.cmpu203.maraudersatsea.model.StoryScene;


public class StoryViewFragment extends Fragment implements IStoryView{

    public FragmentStoryViewBinding binding;
    private Listener listener;

    private StoryScene scene;

    private int curScene = 1;
    //private final static String SCENE_LOC = "sceneLocation";

    public StoryViewFragment(StoryScene scene, Listener listener) {
        this.listener = listener;
        this.scene = scene;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentStoryViewBinding.inflate(inflater);
        return this.binding.getRoot();
    }

/*

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(this.SCENE_LOC, this.curScene);
    }
    @Override
    public void onViewStateRestored(@Nullable Bundle saveInstanceState){
        super.onViewStateRestored(saveInstanceState);

        if (saveInstanceState != null) this.curScene = saveInstanceState.getInt(SCENE_LOC, curScene);

    }
    public static Bundle makeArgsBundle(int location) {
        Bundle args = new Bundle();
        args.putInt(SCENE_LOC, curScene);
        return args;
    }
*/

    public void optionButtons(Boolean flip) {
        this.binding.storyOptionA.setEnabled(flip);
        this.binding.storyOptionB.setEnabled(flip);
        if(flip) {
            this.binding.storyOptionA.setVisibility(View.VISIBLE);
            this.binding.storyOptionB.setVisibility(View.VISIBLE);
        }
        else{
            this.binding.storyOptionA.setVisibility(View.INVISIBLE);
            this.binding.storyOptionB.setVisibility(View.INVISIBLE);
        }
    }

    public void flipButton(ImageButton b, Boolean flip) {
        if(flip){
            b.setVisibility(View.VISIBLE);
        }
        else {
            b.setVisibility(View.INVISIBLE);
        }
        b.setEnabled(flip);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        this.binding.sceneText.setText(scene.getText1());
        flipButton(this.binding.exitButton, false);

        this.binding.storyOptionA.setText(scene.options[0]);
        this.binding.storyOptionB.setText(scene.options[1]);
        optionButtons(false);

        this.binding.nextButton.setOnClickListener(new View.OnClickListener(){
            /**
             * Listener method to be called when the next button is clicked.
             *
             * @param view the view that was clicked on
             */
            @Override
            public void onClick(View view) {
                if(curScene == 1) {
                    StoryViewFragment.this.binding.sceneText.setText(scene.getText2());
                    if(scene.getQuestion().equals("N/A")){
                        flipButton(StoryViewFragment.this.binding.nextButton, false);
                        flipButton(StoryViewFragment.this.binding.exitButton, true);
                    }
                    curScene++;
                }
                //if both scenes have been shown
                else if(curScene == 2) {
                    if(scene.getQuestion().equals("N/A")){
                        flipButton(StoryViewFragment.this.binding.nextButton, false);
                        flipButton(StoryViewFragment.this.binding.exitButton, true);
                    }
                    else {
                        StoryViewFragment.this.binding.sceneText.setText(scene.getQuestion());
                        //remove next button when options appear
                        flipButton(StoryViewFragment.this.binding.nextButton, false);
                        //enable and appear options
                        optionButtons(true);
                    }
                }
            }
        });
        this.binding.storyOptionA.setOnClickListener(new View.OnClickListener(){
            /**
             * Listener method to be called when the option a button is clicked.
             *
             * @param view the view that was clicked on
             */
            @Override
            public void onClick(View view) {
                StoryViewFragment.this.binding.sceneText.setText(scene.endings[0]);
                optionButtons(false);
                flipButton(StoryViewFragment.this.binding.exitButton, true);
            }
        });
        this.binding.storyOptionB.setOnClickListener(new View.OnClickListener(){
            /**
             * Listener method to be called when the option b button is clicked.
             *
             * @param view the view that was clicked on
             */
            @Override
            public void onClick(View view) {
                StoryViewFragment.this.binding.sceneText.setText(scene.endings[1]);
                optionButtons(false);
                flipButton(StoryViewFragment.this.binding.exitButton, true);
            }
        });
        this.binding.exitButton.setOnClickListener(new View.OnClickListener(){
            /**
             * Listener method to be called when the exit button is clicked.
             *
             * @param view the view that was clicked on
             */
            @Override
            public void onClick(View view) {
                StoryViewFragment.this.listener.onSceneDone();
            }
        });
        super.onCreate(savedInstanceState);

    }



}