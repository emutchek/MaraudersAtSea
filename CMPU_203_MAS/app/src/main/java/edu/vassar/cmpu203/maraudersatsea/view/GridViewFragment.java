package edu.vassar.cmpu203.maraudersatsea.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import edu.vassar.cmpu203.maraudersatsea.R;
import edu.vassar.cmpu203.maraudersatsea.databinding.FragmentGridViewBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GridViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GridViewFragment extends Fragment implements IGridView{

   private FragmentGridViewBinding binding;
   private Listener listener;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

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
            }
        }
        super.onCreate(savedInstanceState);

    }


}