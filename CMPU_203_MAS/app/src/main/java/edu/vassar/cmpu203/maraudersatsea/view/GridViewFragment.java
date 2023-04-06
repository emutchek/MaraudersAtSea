package edu.vassar.cmpu203.maraudersatsea.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import edu.vassar.cmpu203.maraudersatsea.R;
import edu.vassar.cmpu203.maraudersatsea.databinding.FragmentGridViewBinding;
import edu.vassar.cmpu203.maraudersatsea.model.ASurrounding;
import edu.vassar.cmpu203.maraudersatsea.model.Grid;

public class GridViewFragment extends Fragment implements IGridView{

   public FragmentGridViewBinding binding;
   private Listener listener;

    public GridViewFragment(Listener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentGridViewBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
      this.listener.updateGridView();
        this.binding.moveButton.setOnClickListener(new View.OnClickListener(){
            /**
             * Listener method to be called when the move button is clicked.
             *
             * @param view the view that was clicked on
             */
            @Override
            public void onClick(View view) {
                Grid grid = GridViewFragment.this.listener.onMove();
                GridViewFragment.this.listener.updateGridView();
                GridViewFragment.this.listener.addressAdjacent();
            }
        });
        super.onCreate(savedInstanceState);
    }
}