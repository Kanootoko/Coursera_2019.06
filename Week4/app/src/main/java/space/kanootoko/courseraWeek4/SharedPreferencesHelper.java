package space.kanootoko.courseraWeek4;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesHelper {
    public static String FILENAME = "SHARED_PREFERENCES";

    private static String SEARCH_SYSTEM_KEY = "SEACH_SYSTEM_KEY";

    private SharedPreferences mPrefs;

    public SharedPreferencesHelper(Context context) {
        mPrefs = context.getSharedPreferences(FILENAME, Context.MODE_PRIVATE);
    }

    public SearchSystem getSearchSystem() {
        return new SearchSystem(mPrefs.getString(SEARCH_SYSTEM_KEY, "google"));
    }

    public void setSearchSystem(SearchSystem mSSystem) {
        mPrefs.edit().putString(SEARCH_SYSTEM_KEY, mSSystem.toString()).apply();
    }
}
