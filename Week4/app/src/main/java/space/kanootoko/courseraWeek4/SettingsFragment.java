package space.kanootoko.courseraWeek4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class SettingsFragment extends Fragment {

    private SharedPreferencesHelper mHelper;

    private RadioGroup mSearchingSystem;

    public SettingsFragment() {
    }

    public static SettingsFragment newInstance() {
        SettingsFragment fragment = new SettingsFragment();
        return fragment;
    }

    private RadioGroup.OnCheckedChangeListener searchingSystemSettings = new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int id) {
            RadioButton rb = radioGroup.findViewById(id);
            Toast.makeText(getContext(), rb.getText().toString(), Toast.LENGTH_SHORT).show();

            mHelper.setSearchSystem(new SearchSystem(rb.getText().toString()));
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_settings, container, false);
        mSearchingSystem = v.findViewById(R.id.settings_radio_group);
        mSearchingSystem.setOnCheckedChangeListener(searchingSystemSettings);

        mHelper = new SharedPreferencesHelper(getActivity());
        return v;
    }
}
