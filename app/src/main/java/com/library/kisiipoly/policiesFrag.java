package com.library.kisiipoly;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class policiesFrag extends Fragment {
    private ListView listView;
    String policyList[]={"Policy number1","Policy number2","Policy number3","Policy number4","Policy number5","Policy number6"};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.frag_policies, container, false);
        View v=inflater.inflate(R.layout.frag_policies, container, false);

        return v;
    }

}
