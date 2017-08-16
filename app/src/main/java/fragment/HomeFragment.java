package fragment;

import android.content.DialogInterface;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import com.example.acer.starlangauage.R;
import com.example.acer.starlangauage.activity.HomeActivity;

import static com.example.acer.starlangauage.R.id.rg_luban;


/**
 * Created by acer on 2017/8/12.
 */

public class HomeFragment extends BaseFragment {


    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_home, null);
        TextView tv_title = view.findViewById(R.id.tv_home_title);
        Button btn_hide = view.findViewById(R.id.btn_hide);
        RadioGroup rg_group = view.findViewById(R.id.radiogroup);
        final RadioButton rg_luban = view.findViewById(R.id.rg_luban);

        btn_hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
                builder.setTitle("恭喜過關");
                builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        rg_luban.setClickable(true);
                    }
                });

            }
        });
        rg_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i) {
                    case R.id.rg_myue:


                        break;
                    case R.id.rg_kai:

initData();
                        break;
                    case R.id.rg_luban:

                        break;
                    case R.id.rg_zzhou:

                        break;
                }
            }
        });
        return view;
    }

    @Override
    public void initData() {

    }
}
