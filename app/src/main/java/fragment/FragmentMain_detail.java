package fragment;

import static com.jrs.myapplication.R.*;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.jrs.myapplication.R;

import Tools.TimeUtils;
import view.SwitchButtonView;


public class FragmentMain_detail extends BaseFragment {

    private TextView frg1TextYear;
    private TextView frg1TextMonth;
    private TextView frg1TextSalary;
    private TextView frg1TextProportion;
    private SwitchButtonView frg1BtSwitchbutton;
    private TextView frg1TextNumuser;
    private TextView frg1TextConsume;
    private TextView frg1TextTime;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(layout.fragment_1,container,false);
        initUI(view);
        setListener();
        initData();
        return view;
    }

    private void initData() {
        String year = TimeUtils.getYear();
        frg1TextYear.setText(year);
    }

    private void setListener() {

    }

    private void initUI(View view) {
        frg1TextYear = view.findViewById(R.id.frg1_text_year);
        frg1TextMonth = view.findViewById(R.id.frg1_text_month);
        frg1TextSalary = view.findViewById(R.id.frg1_text_salary);
        frg1TextProportion = view.findViewById(R.id.frg1_text_proportion);
        frg1BtSwitchbutton = view.findViewById(R.id.frg1_bt_switchbutton);
        frg1TextNumuser = view.findViewById(R.id.frg1_text_numuser);
        frg1TextConsume = view.findViewById(R.id.frg1_text_consume);
        frg1TextTime = view.findViewById(R.id.frg1_text_time);
    }
}
