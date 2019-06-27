package space.kanootoko.courseraWeek4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SearchFragment extends Fragment {

    EditText mSearchText;
    Button mSearchButton;

    SharedPreferencesHelper mHelper;

    public SearchFragment() {
        // Required empty public constructor
    }

    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
        return fragment;
    }

    private View.OnClickListener mSearchOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mHelper.getSearchSystem().search(mSearchText.getText().toString())));
            startActivity(browserIntent);
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search, container, false);
        mSearchText = v.findViewById(R.id.search_text);
        mSearchButton = v.findViewById(R.id.search_button);

        mHelper = new SharedPreferencesHelper(getActivity());
        mSearchButton.setOnClickListener(mSearchOnClickListener);
        return v;
    }

}
