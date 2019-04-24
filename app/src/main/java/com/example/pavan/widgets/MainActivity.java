package com.example.pavan.widgets;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private TextView Phone,Apptextnight,Apptextcheck,Apptextradio,Apptextspinner,Apptextseekbar;
    private QuickContactBadge PhonePic;
    private ToggleButton tToggle;
    private  Animation animation;
    private CheckBox AppcheckBox;
    private Spinner Appspinner;
    private RadioButton Appmale,Appfemale;
    private SeekBar AppseekBar;
    private Switch Appswitch1;
    private RatingBar AppratingBar2;
    private RadioGroup radioGroup;
    private RadioButton radioButton;


    private String[] plants = new String[]{
            "Spinner Item A",
            "Spinner Item B",
            "Spinner Item C",
            "Spinner Item D",
            "Spinner Item E"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets);

        Apptextnight = (TextView)findViewById(R.id.textnight);
        Apptextcheck= (TextView)findViewById(R.id.textcheck);
        Apptextradio = (TextView)findViewById(R.id.textradio);
        Apptextspinner = (TextView)findViewById(R.id.textspinner);
        Apptextseekbar= (TextView)findViewById(R.id.textseekbar);
        // run();

        AppcheckBox=(CheckBox) findViewById(R.id.checkBox);
        Appspinner=(Spinner) findViewById(R.id.spinner);
        AppseekBar=(SeekBar) findViewById(R.id.seekBar);
        Appswitch1=(Switch) findViewById(R.id.switch1);
        AppratingBar2 = (RatingBar) findViewById(R.id.ratingBar2);
        Appmale=(RadioButton) findViewById(R.id.radioMale);
        Appfemale=(RadioButton) findViewById(R.id.radioFemale);


        PhonePic = (QuickContactBadge)findViewById(R.id.quickContactBadge2);
        tToggle=(ToggleButton) findViewById(R.id.toggle);

        radioGroup = (RadioGroup) findViewById(R.id.radio);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                // get selected radio button from radioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);


                String a= (String) radioButton.getText();

                Apptextradio.setText(a);
            }


        });

        tToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    RelativeLayout currentLayout = (RelativeLayout) findViewById(R.id.background);
                    currentLayout.setBackground( getResources().getDrawable(R.drawable.backnew));
                    LayerDrawable stars = (LayerDrawable) AppratingBar2.getProgressDrawable();
                    stars.getDrawable(2).setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
                }
                else
                {
                    RelativeLayout currentLayout = (RelativeLayout) findViewById(R.id.background);
                    currentLayout.setBackground( getResources().getDrawable(R.drawable.back));
                    LayerDrawable stars = (LayerDrawable) AppratingBar2.getProgressDrawable();
                    stars.getDrawable(2).setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_ATOP);

                }

            }

        });



        AppcheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean a) {
                if(a)
                {
                    Apptextcheck.setText("Check Box selected");

                }
                else
                {
                    Apptextcheck.setText("Check Box Not selected");

                }

            }

        });


        PhonePic.assignContactFromPhone("+911234567890", true);
        PhonePic.setMode(ContactsContract.QuickContact.MODE_MEDIUM);

        final List<String> plantsList = new ArrayList<>(Arrays.asList(plants));

        // Initializing an ArrayAdapter
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this,R.layout.support_simple_spinner_dropdown_item,plantsList){
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                View v = Appspinner.getSelectedView();
                ((TextView)v).setTextColor(Color.parseColor("#760e34"));
                if(position%2 == 1) {


                }
                else {

                }
                return view;
            }
        };


        spinnerArrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        Appspinner.setAdapter(spinnerArrayAdapter);

        Appspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // Notify the selected item text

                Apptextspinner.setText(selectedItemText);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




//Seekbar Font Size Changing..
        //setOmSeekbarchangeListner will be called when u drag seekbar

        AppseekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int p=0;

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
                if(p<30)
                {
                    p=30;
                    AppseekBar.setProgress(p);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                // TODO Auto-generated method stub
                p=progress;
                Apptextseekbar.setTextSize(p);
            }
        });

        Appswitch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    ImageView animationTarget = (ImageView) findViewById(R.id.testImage);
                    animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);
                    animationTarget.startAnimation(animation);
                }

                else
                {
                   /* ImageView animationTarget = (ImageView) findViewById(R.id.testImage);
                    animation = AnimationUtils.loadAnimation(widgets.this, R.anim.rotate);
                    animationTarget.cancel(animation);*/


                }

            }
        });

    }

}
