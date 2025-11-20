package com.magiccodeinc.porcsmartbeta;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.magiccodeinc.porcsmartbeta.fragment.TabFragment1;
import com.magiccodeinc.porcsmartbeta.fragment.TabFragment2;
import com.magiccodeinc.porcsmartbeta.fragment.TabFragment3;

/** @noinspection ALL*/
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final android.content.Context context;

    public ViewPagerAdapter(android.content.Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        // Retorna el fragmento correspondiente a la posición
        switch (position) {
            case 0:
                return new TabFragment1();
            case 1:
                return new TabFragment2();
            case 2:
                return new TabFragment3();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        // Número total de pestañas
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Títulos de las pestañas
        switch (position) {
            case 0:
                return "Simple";
            case 1:
                return context.getString(R.string.incremento);
            case 2:
                return context.getString(R.string.decremento);
            default:
                return null;
        }
    }
}
