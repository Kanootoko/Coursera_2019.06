package space.kanootoko.courseraWeek4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class BaseFragment extends Fragment {

    public BaseFragment() {
        // Required empty public constructor
    }

    public static BaseFragment newInstance() {
        BaseFragment fragment = new BaseFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first_layout, container, false);
    }
}