package com.example.opticaapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;

import androidx.annotation.NonNull;

import java.util.Locale;

public class Settings extends PreferenceActivity {

    ListPreference preference;
    SharedPreferences sp;
    String l;

    protected void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);

        preference = (ListPreference) findPreference("language");
        sp = PreferenceManager.getDefaultSharedPreferences(Settings.this);
        l = sp.getString("language","es");
        setLocale(l);

    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Settings.this, Home.class);
        startActivity(intent);
        finish();
        //onBackPressed();
    }

    private void setLocale(String language) {

        Resources r = getResources();
        DisplayMetrics dm = r.getDisplayMetrics();
        Configuration c = r.getConfiguration();
        c.locale = new Locale(language);
        r.updateConfiguration(c,dm);
        onConfigurationChanged(c);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        finish();
        startActivity(getIntent());
    }
}
