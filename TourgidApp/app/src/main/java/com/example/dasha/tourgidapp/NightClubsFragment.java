package com.example.dasha.tourgidapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NightClubsFragment extends Fragment {


    public NightClubsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.institution_list, container, false);

        ArrayList<Institution> institutions = new ArrayList<Institution>();
        institutions.add(new Institution("Grodno", "20.00-6.00"));
        institutions.add(new Institution("Grodno", "20.00-6.00"));
        institutions.add(new Institution("Grodno", "20.00-6.00"));
        institutions.add(new Institution("Grodno", "20.00-6.00"));
        institutions.add(new Institution("Grodno", "20.00-6.00"));
        institutions.add(new Institution("Grodno", "20.00-6.00"));
        institutions.add(new Institution("Grodno", "20.00-6.00"));
        institutions.add(new Institution("Grodno", "20.00-6.00"));
        institutions.add(new Institution("Grodno", "20.00-6.00"));
        institutions.add(new Institution("Grodno", "20.00-6.00"));
        institutions.add(new Institution("Grodno", "20.00-6.00"));
        institutions.add(new Institution("Grodno", "20.00-6.00"));
        institutions.add(new Institution("Grodno", "20.00-6.00"));

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        InstitutionAdapter adapter = new InstitutionAdapter(getActivity(), institutions, R.drawable.night_club);

        listView.setAdapter(adapter);

        return rootView;
    }

}
