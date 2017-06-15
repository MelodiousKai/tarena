package day01.core4_groupon.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;

import day01.core4_groupon.activity.MainActivity;

/**
 * Created by tarena on 2017/6/15.
 */

public class baseFragment extends Fragment {

    public void setSkip(View view){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MainActivity.class));
                getActivity().finish();
            }
        });
    }
}
