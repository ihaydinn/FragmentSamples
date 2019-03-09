package com.ismailhakkiaydin.fragmentsamples;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*FragmentA fragmentA = new FragmentA();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.activity_main, fragmentA, "FragmentA");

        fragmentTransaction.commit();*/

        fragmentManager = getFragmentManager();
        fragmentManager.addOnBackStackChangedListener(this);

    }

    public void addFragmentA(View view){
        FragmentA fragmentA = new FragmentA();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, fragmentA, "FragmentA");
        fragmentTransaction.addToBackStack("addFragmentA");
        fragmentTransaction.commit();
    }

    public void removeFragmentA(View view){
        FragmentA fragmentA = (FragmentA) fragmentManager.findFragmentByTag("FragmentA");
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (fragmentA != null){
            fragmentTransaction.remove(fragmentA);
            fragmentTransaction.addToBackStack("removeFragmentA");
            fragmentTransaction.commit();
        }else {
            Toast.makeText(this, "Fragment Bulunamadı", Toast.LENGTH_LONG).show();
        }

    }

    public void addFragmentB(View view){
        FragmentB fragmentB = new FragmentB();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, fragmentB, "FragmentB");
        fragmentTransaction.addToBackStack("addFragmentB");
        fragmentTransaction.commit();
    }

    public void removeFragmentB(View view){
        FragmentB fragmentB = (FragmentB) fragmentManager.findFragmentByTag("FragmentB");
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (fragmentB != null){
            fragmentTransaction.remove(fragmentB);
            fragmentTransaction.addToBackStack("removeFragmentB");
            fragmentTransaction.commit();
        }else {
            Toast.makeText(this, "Fragment Bulunamadı", Toast.LENGTH_LONG).show();
        }
    }

    public void replaceFragmentA(View view){
       FragmentA fragmentA = new FragmentA();
       FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
       fragmentTransaction.replace(R.id.container, fragmentA, "FragmentA");
        fragmentTransaction.addToBackStack("replaceFragmentA");
       fragmentTransaction.commit();
    }

    public void replaceFragmentB(View view){
        FragmentB fragmentB = new FragmentB();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragmentB, "FragmentB");
        fragmentTransaction.addToBackStack("replaceFragmentB");
        fragmentTransaction.commit();

    }

    public void attachFragmentA(View view){
        FragmentA fragmentA = (FragmentA) fragmentManager.findFragmentByTag("FragmentA");
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (fragmentA != null){
            fragmentTransaction.attach(fragmentA);
            fragmentTransaction.addToBackStack("attachFragmentA");
            fragmentTransaction.commit();
        }else {
            Toast.makeText(this, "Fragment Bulunamadı", Toast.LENGTH_LONG).show();
        }

    }

    public void detachFragmentA(View view){
        FragmentA fragmentA = (FragmentA) fragmentManager.findFragmentByTag("FragmentA");
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (fragmentA != null){
            fragmentTransaction.detach(fragmentA);
            fragmentTransaction.addToBackStack("detachFragmentA");
            fragmentTransaction.commit();
        }else {
            Toast.makeText(this, "Fragment Bulunamadı", Toast.LENGTH_LONG).show();
        }

    }

    public void showFragmentA(View view){
        FragmentA fragmentA = (FragmentA) fragmentManager.findFragmentByTag("FragmentA");
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (fragmentA != null){
            fragmentTransaction.show(fragmentA);
            fragmentTransaction.addToBackStack("showFragmentA");
            fragmentTransaction.commit();
        }else {
            Toast.makeText(this, "Fragment Bulunamadı", Toast.LENGTH_LONG).show();
        }

    }

    public void hideFragmentA(View view){
        FragmentA fragmentA = (FragmentA) fragmentManager.findFragmentByTag("FragmentA");
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (fragmentA != null){
            fragmentTransaction.hide(fragmentA);
            fragmentTransaction.addToBackStack("hideFragmentA");
            fragmentTransaction.commit();
        }else {
            Toast.makeText(this, "Fragment Bulunamadı", Toast.LENGTH_LONG).show();
        }

    }

    public void backButton(View view){
        fragmentManager.popBackStack();

    }
    public void popAddAInclusive(View view){
        fragmentManager.popBackStack("addFragmentA", FragmentManager.POP_BACK_STACK_INCLUSIVE);

    }
    public void popAddB(View view){
        fragmentManager.popBackStack("addFragmentB",0);

    }


    @Override
    public void onBackStackChanged() {
        int elemanSayisi = fragmentManager.getBackStackEntryCount();

        StringBuilder mesaj = new StringBuilder();

        for (int i = elemanSayisi-1; i>=0; i--){
            mesaj.append("Index ").append(i).append(" : ");
            mesaj.append(fragmentManager.getBackStackEntryAt(i).getName());
            mesaj.append("\n");
        }
       
    }
}
