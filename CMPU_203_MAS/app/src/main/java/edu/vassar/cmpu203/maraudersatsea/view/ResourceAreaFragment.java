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
import edu.vassar.cmpu203.maraudersatsea.databinding.FragmentRaViewBinding;
import edu.vassar.cmpu203.maraudersatsea.model.ResourceArea;
import edu.vassar.cmpu203.maraudersatsea.model.Inventory;




public class ResourceAreaFragment extends Fragment implements IResourceArea {

    public FragmentRaViewBinding binding;
    private Listener listener;

    private ResourceArea RA;


    public ResourceAreaFragment(ResourceArea RA, Listener listener) {
        this.listener = listener;
        this.RA = RA;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentRaViewBinding.inflate(inflater);
        return this.binding.getRoot();

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

    public void throwResource(char c){
        ResourceAreaFragment.this.binding.RAfound.setText("You successfully picked it up!");
        ResourceAreaFragment.this.binding.rope.setVisibility(View.INVISIBLE);
        ResourceAreaFragment.this.binding.wood.setVisibility(View.INVISIBLE);
        ResourceAreaFragment.this.binding.medicine.setVisibility(View.INVISIBLE);
        listener.getInv().removeInventory(c);
        listener.getInv().addToInventory(RA);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        this.binding.RAfound.setText(RA.displayCards());
        int idDrawable = RA.getResourceSymbol();
        this.binding.imageView.setImageResource(idDrawable);

        this.binding.grabRA.setOnClickListener(new View.OnClickListener(){
            /**
             * Listener method to be called when the grab/pickup button is clicked.
             *
             * @param view the view that was clicked on
             */
            @Override
            public void onClick(View view) {
                ResourceAreaFragment.this.binding.grabRA.setVisibility(View.INVISIBLE);
                if (listener.getInv().isFull()){
                    ResourceAreaFragment.this.binding.RAfound.setText("Oh no! Your inventory is full. Do you want to throw something overboard to make room?");
                    ResourceAreaFragment.this.binding.rope.setVisibility(View.VISIBLE);
                    ResourceAreaFragment.this.binding.wood.setVisibility(View.VISIBLE);
                    ResourceAreaFragment.this.binding.medicine.setVisibility(View.VISIBLE);
                    //call update inventory screen
                }
                else{
                    ResourceAreaFragment.this.binding.RAfound.setText("You successfully picked it up!");
                    listener.getInv().addToInventory(RA);
                    //call update inventory screen
                }
            }
        });


        this.binding.rope.setOnClickListener(new View.OnClickListener(){
            /**
             * Listener method to be called when the rope button is clicked.
             *
             * @param view the view that was clicked on
             */
            @Override
            public void onClick(View view) {
                throwResource('R');
            }
        });

        this.binding.wood.setOnClickListener(new View.OnClickListener(){
            /**
             * Listener method to be called when the rope button is clicked.
             *
             * @param view the view that was clicked on
             */
            @Override
            public void onClick(View view) {
                throwResource('W');
            }
        });

        this.binding.medicine.setOnClickListener(new View.OnClickListener(){
            /**
             * Listener method to be called when the rope button is clicked.
             *
             * @param view the view that was clicked on
             */
            @Override
            public void onClick(View view) {
                throwResource('M');
            }
        });

        this.binding.exitRA.setOnClickListener(new View.OnClickListener(){
            /**
             * Listener method to be called when the exit button is clicked.
             *
             * @param view the view that was clicked on
             */
            @Override
            public void onClick(View view) {
                ResourceAreaFragment.this.listener.onSceneDone();
            }
        });
        super.onCreate(savedInstanceState);

    }



}
