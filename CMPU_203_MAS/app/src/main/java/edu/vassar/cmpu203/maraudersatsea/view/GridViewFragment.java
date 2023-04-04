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

   private FragmentGridViewBinding binding;
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
        this.binding.moveButton.setOnClickListener(new View.OnClickListener(){
            /**
             * Listener method to be called when the move button is clicked.
             *
             * @param view the view that was clicked on
             */
            @Override
            public void onClick(View view) {
                //  GridView.this.binding.s4L.setImageResource(getImage(1));
                //updateGridView(GridView.this.listener.onMoveView());
                //String surroundingText = GridView.this.listener.onMoveDisplayCards();
                //Snackbar.make(view, surroundingText, Snackbar.LENGTH_LONG).show();
                Grid grid = GridViewFragment.this.listener.onMove();
                updateGridView(grid);
            }
        });
        super.onCreate(savedInstanceState);

    }
    public void updateGridView(Grid grid){
        ASurrounding[][] arr = grid.grid;
        int loc = grid.getShipLocation();
        this.binding.s4L.setImageResource(arr[loc+4][0].getSymbol());
        this.binding.s4R.setImageResource(arr[loc+4][1].getSymbol());
        this.binding.s3L.setImageResource(arr[loc+3][0].getSymbol());
        this.binding.s3R.setImageResource(arr[loc+3][1].getSymbol());
        this.binding.s2L.setImageResource(arr[loc+2][0].getSymbol());
        this.binding.s2R.setImageResource(arr[loc+2][1].getSymbol());
        this.binding.s1L.setImageResource(arr[loc+1][0].getSymbol());
        this.binding.s1R.setImageResource(arr[loc+1][1].getSymbol());
        this.binding.s0L.setImageResource(arr[loc][0].getSymbol());
        this.binding.s0R.setImageResource(arr[loc][1].getSymbol());
    }

}