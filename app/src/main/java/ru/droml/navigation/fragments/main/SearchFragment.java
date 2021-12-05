package ru.droml.navigation.fragments.main;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import ru.droml.MainActivity;
import ru.droml.R;
import ru.droml.databinding.FragmentSearchBinding;
import ru.droml.utlis.StatusBarUtil;


public class SearchFragment extends Fragment {

    private FragmentSearchBinding binding;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSearchBinding.inflate(inflater, container,false);

        return binding.getRoot();
    }
}