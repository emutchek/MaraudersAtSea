package edu.vassar.cmpu203.maraudersatsea.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
   private static int LOCATION = 0;
   private final static String LOCATION_STR = "location";

    public GridViewFragment(Listener listener) {
        this.listener = listener;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(this.LOCATION_STR, this.LOCATION);
    }
    @Override
    public void onViewStateRestored(@Nullable Bundle saveInstanceState){
        super.onViewStateRestored(saveInstanceState);

        if (saveInstanceState != null) this.LOCATION = saveInstanceState.getInt(LOCATION_STR, LOCATION);

    }
    public static Bundle makeArgsBundle(int location) {
        Bundle args = new Bundle();
        args.putInt(LOCATION_STR, LOCATION);
        return args;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentGridViewBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
      Grid grid = GridViewFragment.this.listener.getGrid();
      //GridViewFragment curGame = this.listener.curGame;
      this.updateGridView(grid);
        this.binding.moveButton.setOnClickListener(new View.OnClickListener(){
            /**
             * Listener method to be called when the move button is clicked.
             *
             * @param view the view that was clicked on
             */
            @Override
            public void onClick(View view) {
                Grid grid = GridViewFragment.this.listener.onMove();
                GridViewFragment.this.updateGridView(grid);
                GridViewFragment.this.listener.addressAdjacent();
            }
        });
        super.onCreate(savedInstanceState);
    }


    public void updateGridView(Grid grid){
        ASurrounding[][] arr = grid.grid;
        int loc = grid.getShipLocation();

        //set image and tag for s4L and s4R
        int idDrawable = arr[loc+4][0].getSymbol();
        binding.s4L.setImageResource(idDrawable);
        binding.s4L.setTag(idDrawable);
        idDrawable = arr[loc+4][1].getSymbol();
        binding.s4R.setImageResource(idDrawable);
        binding.s4R.setTag(idDrawable);

        //set image and tag for s3L and s3R
        idDrawable = arr[loc+3][0].getSymbol();
        binding.s3L.setImageResource(idDrawable);
        binding.s3L.setTag(idDrawable);
        idDrawable = arr[loc+3][1].getSymbol();
        binding.s3R.setImageResource(idDrawable);
        binding.s3R.setTag(idDrawable);

        //set image and tag for s2L and s2R
        idDrawable = arr[loc+2][0].getSymbol();
        binding.s2L.setImageResource(idDrawable);
        binding.s2L.setTag(idDrawable);
        idDrawable = arr[loc+2][1].getSymbol();
        binding.s2R.setImageResource(idDrawable);
        binding.s2R.setTag(idDrawable);

        //set image and tag for s1L and s1R
        idDrawable = arr[loc+1][0].getSymbol();
        binding.s1L.setImageResource(idDrawable);
        binding.s1L.setTag(idDrawable);
        idDrawable = arr[loc+1][1].getSymbol();
        binding.s1R.setImageResource(idDrawable);
        binding.s1R.setTag(idDrawable);

        //set image and tag for s0L and s0R
        idDrawable = arr[loc][0].getSymbol();
        binding.s0L.setImageResource(idDrawable);
        binding.s0L.setTag(idDrawable);
        idDrawable = arr[loc][1].getSymbol();
        binding.s0R.setImageResource(idDrawable);
        binding.s0R.setTag(idDrawable);
    }
}