package edu.vassar.cmpu203.maraudersatsea.view;

import android.view.View;

import androidx.fragment.app.Fragment;

public interface IMainView {
    public View getRootView();
    public void displayFragment(Fragment fragment, boolean reversible, String name);

    public void refreshStats(String inv, String ship);
}
