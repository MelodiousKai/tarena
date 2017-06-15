package day01.core4_groupon.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import day01.core4_groupon.R;
import day01.core4_groupon.activity.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class Guide4Fragment extends baseFragment {

    @BindView(R.id.guide_button_4)
    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guide4, container, false);
        // Inflate the layout for this fragment
        ButterKnife.bind(this,view);
        setSkip(button);
        return view;
    }
}
