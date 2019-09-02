package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import deploy.android.lozanofit.es.lozanofitroutinemixer.R;
import deploy.android.lozanofit.es.lozanofitroutinemixer.classes.Activity2AlertDialog;

public class Activity5 extends AppCompatActivity {

    public int counter = 0;
    public String timestring = "";
    public String levelstring = "";
    public String bodystring = "";
    public String objectivestring = "";
    public ArrayList<String> musclesSelected = new ArrayList<String>();
    public String muscleNow = "";
    public boolean fromAct2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        objectivestring = getIntent().getStringExtra("selectedObjective");
        levelstring = getIntent().getStringExtra("selectedLevel");
        timestring = getIntent().getStringExtra("selectedTime");
        bodystring = getIntent().getStringExtra("selectedBodyPart");
        musclesSelected = getIntent().getStringArrayListExtra("musclesSelected");


        //mark muscles selected
        int idx0 = 0;
        while(idx0<musclesSelected.size()){
            switch(musclesSelected.get(idx0)){
                case "biceps":
                    CheckBox checkb2 = (CheckBox) findViewById(R.id.checkBox2);
                    checkb2.setChecked(true);
                    break;
                case "chest":
                    CheckBox checkb3 = (CheckBox) findViewById(R.id.checkBox3);
                    checkb3.setChecked(true);
                    break;
                case "mid-back":
                    CheckBox checkb4 = (CheckBox) findViewById(R.id.checkBox4);
                    checkb4.setChecked(true);
                    break;
                case "deltoid":
                    CheckBox checkb5 = (CheckBox) findViewById(R.id.checkBox5);
                    checkb5.setChecked(true);
                    break;
                case "upper-back":
                    CheckBox checkb6 = (CheckBox) findViewById(R.id.checkBox6);
                    checkb6.setChecked(true);
                    break;
                case "triceps":
                    CheckBox checkb7 = (CheckBox) findViewById(R.id.checkBox7);
                    checkb7.setChecked(true);
                    break;
                case "forearm":
                    CheckBox checkb8 = (CheckBox) findViewById(R.id.checkBox8);
                    checkb8.setChecked(true);
                    break;
                case "lumbar":
                    CheckBox checkb9 = (CheckBox) findViewById(R.id.checkBox9);
                    checkb9.setChecked(true);
                    break;
                case "abs":
                    CheckBox checkb10 = (CheckBox) findViewById(R.id.checkBox10);
                    checkb10.setChecked(true);
                    break;
                case "glute":
                    CheckBox checkb11 = (CheckBox) findViewById(R.id.checkBox11);
                    checkb11.setChecked(true);
                    break;
                case "thigh":
                    CheckBox checkb12 = (CheckBox) findViewById(R.id.checkBox12);
                    checkb12.setChecked(true);
                    break;
                case "calf":
                    CheckBox checkb13 = (CheckBox) findViewById(R.id.checkBox13);
                    checkb13.setChecked(true);
                    break;

            }
            idx0++;
        }


        //BICEPS clickable
        final TextView bicepsClicked = findViewById(R.id.textView18);
        //link to activity6
        bicepsClicked.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), Activity6.class);

                intent.putExtra("selectedLevel", levelstring);
                intent.putExtra("selectedObjective", objectivestring);

                //new
                intent.putExtra("selectedBodyPart", bodystring);
                intent.putExtra("selectedTime", timestring);

                musclesSelected.clear();
                //add selected muscles
                CheckBox checkb2 = (CheckBox) findViewById(R.id.checkBox2);
                if (checkb2.isChecked()) {
                    musclesSelected.add("biceps");
                }
                CheckBox checkb3 = (CheckBox) findViewById(R.id.checkBox3);
                if (checkb3.isChecked()) {
                    musclesSelected.add("chest");
                }
                CheckBox checkb4 = (CheckBox) findViewById(R.id.checkBox4);
                if (checkb4.isChecked()) {
                    musclesSelected.add("mid-back");
                }
                CheckBox checkb5 = (CheckBox) findViewById(R.id.checkBox5);
                if (checkb5.isChecked()) {
                    musclesSelected.add("deltoid");
                }
                CheckBox checkb6 = (CheckBox) findViewById(R.id.checkBox6);
                if (checkb6.isChecked()) {
                    musclesSelected.add("upper-back");
                }
                CheckBox checkb7 = (CheckBox) findViewById(R.id.checkBox7);
                if (checkb7.isChecked()) {
                    musclesSelected.add("triceps");
                }
                CheckBox checkb8 = (CheckBox) findViewById(R.id.checkBox8);
                if (checkb8.isChecked()) {
                    musclesSelected.add("forearm");
                }
                CheckBox checkb9 = (CheckBox) findViewById(R.id.checkBox9);
                if (checkb9.isChecked()) {
                    musclesSelected.add("lumbar");
                }
                CheckBox checkb10 = (CheckBox) findViewById(R.id.checkBox10);
                if (checkb10.isChecked()) {
                    musclesSelected.add("abs");
                }
                CheckBox checkb11 = (CheckBox) findViewById(R.id.checkBox11);
                if (checkb11.isChecked()) {
                    musclesSelected.add("glute");
                }
                CheckBox checkb12 = (CheckBox) findViewById(R.id.checkBox12);
                if (checkb12.isChecked()) {
                    musclesSelected.add("thigh");
                }
                CheckBox checkb13 = (CheckBox) findViewById(R.id.checkBox13);
                if (checkb13.isChecked()) {
                    musclesSelected.add("calf");
                }

                intent.putExtra("musclesSelected", musclesSelected);


                muscleNow = bicepsClicked.getText().toString();
                intent.putExtra("muscleNow", muscleNow);
                intent.putExtra("fromAct2", fromAct2);


                startActivity(intent);
            }
        });

        //PECHO clickable
        final TextView chestClicked = findViewById(R.id.textView19);
        //link to activity6
        chestClicked.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), Activity6.class);

                intent.putExtra("selectedLevel", levelstring);
                intent.putExtra("selectedObjective", objectivestring);

                //new
                intent.putExtra("selectedBodyPart", bodystring);
                intent.putExtra("selectedTime", timestring);

                musclesSelected.clear();
                //add selected muscles
                CheckBox checkb2 = (CheckBox) findViewById(R.id.checkBox2);
                if (checkb2.isChecked()) {
                    musclesSelected.add("biceps");
                }
                CheckBox checkb3 = (CheckBox) findViewById(R.id.checkBox3);
                if (checkb3.isChecked()) {
                    musclesSelected.add("chest");
                }
                CheckBox checkb4 = (CheckBox) findViewById(R.id.checkBox4);
                if (checkb4.isChecked()) {
                    musclesSelected.add("mid-back");
                }
                CheckBox checkb5 = (CheckBox) findViewById(R.id.checkBox5);
                if (checkb5.isChecked()) {
                    musclesSelected.add("deltoid");
                }
                CheckBox checkb6 = (CheckBox) findViewById(R.id.checkBox6);
                if (checkb6.isChecked()) {
                    musclesSelected.add("upper-back");
                }
                CheckBox checkb7 = (CheckBox) findViewById(R.id.checkBox7);
                if (checkb7.isChecked()) {
                    musclesSelected.add("triceps");
                }
                CheckBox checkb8 = (CheckBox) findViewById(R.id.checkBox8);
                if (checkb8.isChecked()) {
                    musclesSelected.add("forearm");
                }
                CheckBox checkb9 = (CheckBox) findViewById(R.id.checkBox9);
                if (checkb9.isChecked()) {
                    musclesSelected.add("lumbar");
                }
                CheckBox checkb10 = (CheckBox) findViewById(R.id.checkBox10);
                if (checkb10.isChecked()) {
                    musclesSelected.add("abs");
                }
                CheckBox checkb11 = (CheckBox) findViewById(R.id.checkBox11);
                if (checkb11.isChecked()) {
                    musclesSelected.add("glute");
                }
                CheckBox checkb12 = (CheckBox) findViewById(R.id.checkBox12);
                if (checkb12.isChecked()) {
                    musclesSelected.add("thigh");
                }
                CheckBox checkb13 = (CheckBox) findViewById(R.id.checkBox13);
                if (checkb13.isChecked()) {
                    musclesSelected.add("calf");
                }

                intent.putExtra("musclesSelected", musclesSelected);


                muscleNow = chestClicked.getText().toString();
                intent.putExtra("muscleNow", muscleNow);
                intent.putExtra("fromAct2", fromAct2);


                startActivity(intent);
            }
        });

        //MID-BACK clickable
        final TextView midBackClicked = findViewById(R.id.textView20);
        //link to activity6
        midBackClicked.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), Activity6.class);

                intent.putExtra("selectedLevel", levelstring);
                intent.putExtra("selectedObjective", objectivestring);

                //new
                intent.putExtra("selectedBodyPart", bodystring);
                intent.putExtra("selectedTime", timestring);

                musclesSelected.clear();
                //add selected muscles
                CheckBox checkb2 = (CheckBox) findViewById(R.id.checkBox2);
                if (checkb2.isChecked()) {
                    musclesSelected.add("biceps");
                }
                CheckBox checkb3 = (CheckBox) findViewById(R.id.checkBox3);
                if (checkb3.isChecked()) {
                    musclesSelected.add("chest");
                }
                CheckBox checkb4 = (CheckBox) findViewById(R.id.checkBox4);
                if (checkb4.isChecked()) {
                    musclesSelected.add("mid-back");
                }
                CheckBox checkb5 = (CheckBox) findViewById(R.id.checkBox5);
                if (checkb5.isChecked()) {
                    musclesSelected.add("deltoid");
                }
                CheckBox checkb6 = (CheckBox) findViewById(R.id.checkBox6);
                if (checkb6.isChecked()) {
                    musclesSelected.add("upper-back");
                }
                CheckBox checkb7 = (CheckBox) findViewById(R.id.checkBox7);
                if (checkb7.isChecked()) {
                    musclesSelected.add("triceps");
                }
                CheckBox checkb8 = (CheckBox) findViewById(R.id.checkBox8);
                if (checkb8.isChecked()) {
                    musclesSelected.add("forearm");
                }
                CheckBox checkb9 = (CheckBox) findViewById(R.id.checkBox9);
                if (checkb9.isChecked()) {
                    musclesSelected.add("lumbar");
                }
                CheckBox checkb10 = (CheckBox) findViewById(R.id.checkBox10);
                if (checkb10.isChecked()) {
                    musclesSelected.add("abs");
                }
                CheckBox checkb11 = (CheckBox) findViewById(R.id.checkBox11);
                if (checkb11.isChecked()) {
                    musclesSelected.add("glute");
                }
                CheckBox checkb12 = (CheckBox) findViewById(R.id.checkBox12);
                if (checkb12.isChecked()) {
                    musclesSelected.add("thigh");
                }
                CheckBox checkb13 = (CheckBox) findViewById(R.id.checkBox13);
                if (checkb13.isChecked()) {
                    musclesSelected.add("calf");
                }

                intent.putExtra("musclesSelected", musclesSelected);


                muscleNow = midBackClicked.getText().toString();
                intent.putExtra("muscleNow", muscleNow);
                intent.putExtra("fromAct2", fromAct2);


                startActivity(intent);
            }
        });

        //DELTOID clickable
        final TextView deltoidClicked = findViewById(R.id.textView21);
        //link to activity6
        deltoidClicked.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), Activity6.class);

                intent.putExtra("selectedLevel", levelstring);
                intent.putExtra("selectedObjective", objectivestring);

                //new
                intent.putExtra("selectedBodyPart", bodystring);
                intent.putExtra("selectedTime", timestring);

                musclesSelected.clear();
                //add selected muscles
                CheckBox checkb2 = (CheckBox) findViewById(R.id.checkBox2);
                if (checkb2.isChecked()) {
                    musclesSelected.add("biceps");
                }
                CheckBox checkb3 = (CheckBox) findViewById(R.id.checkBox3);
                if (checkb3.isChecked()) {
                    musclesSelected.add("chest");
                }
                CheckBox checkb4 = (CheckBox) findViewById(R.id.checkBox4);
                if (checkb4.isChecked()) {
                    musclesSelected.add("mid-back");
                }
                CheckBox checkb5 = (CheckBox) findViewById(R.id.checkBox5);
                if (checkb5.isChecked()) {
                    musclesSelected.add("deltoid");
                }
                CheckBox checkb6 = (CheckBox) findViewById(R.id.checkBox6);
                if (checkb6.isChecked()) {
                    musclesSelected.add("upper-back");
                }
                CheckBox checkb7 = (CheckBox) findViewById(R.id.checkBox7);
                if (checkb7.isChecked()) {
                    musclesSelected.add("triceps");
                }
                CheckBox checkb8 = (CheckBox) findViewById(R.id.checkBox8);
                if (checkb8.isChecked()) {
                    musclesSelected.add("forearm");
                }
                CheckBox checkb9 = (CheckBox) findViewById(R.id.checkBox9);
                if (checkb9.isChecked()) {
                    musclesSelected.add("lumbar");
                }
                CheckBox checkb10 = (CheckBox) findViewById(R.id.checkBox10);
                if (checkb10.isChecked()) {
                    musclesSelected.add("abs");
                }
                CheckBox checkb11 = (CheckBox) findViewById(R.id.checkBox11);
                if (checkb11.isChecked()) {
                    musclesSelected.add("glute");
                }
                CheckBox checkb12 = (CheckBox) findViewById(R.id.checkBox12);
                if (checkb12.isChecked()) {
                    musclesSelected.add("thigh");
                }
                CheckBox checkb13 = (CheckBox) findViewById(R.id.checkBox13);
                if (checkb13.isChecked()) {
                    musclesSelected.add("calf");
                }

                intent.putExtra("musclesSelected", musclesSelected);


                muscleNow = deltoidClicked.getText().toString();
                intent.putExtra("muscleNow", muscleNow);
                intent.putExtra("fromAct2", fromAct2);


                startActivity(intent);
            }
        });

        //UPPER-BACK clickable
        final TextView upperBackClicked = findViewById(R.id.textView22);
        //link to activity6
        upperBackClicked.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), Activity6.class);

                intent.putExtra("selectedLevel", levelstring);
                intent.putExtra("selectedObjective", objectivestring);

                //new
                intent.putExtra("selectedBodyPart", bodystring);
                intent.putExtra("selectedTime", timestring);

                musclesSelected.clear();
                //add selected muscles
                CheckBox checkb2 = (CheckBox) findViewById(R.id.checkBox2);
                if (checkb2.isChecked()) {
                    musclesSelected.add("biceps");
                }
                CheckBox checkb3 = (CheckBox) findViewById(R.id.checkBox3);
                if (checkb3.isChecked()) {
                    musclesSelected.add("chest");
                }
                CheckBox checkb4 = (CheckBox) findViewById(R.id.checkBox4);
                if (checkb4.isChecked()) {
                    musclesSelected.add("mid-back");
                }
                CheckBox checkb5 = (CheckBox) findViewById(R.id.checkBox5);
                if (checkb5.isChecked()) {
                    musclesSelected.add("deltoid");
                }
                CheckBox checkb6 = (CheckBox) findViewById(R.id.checkBox6);
                if (checkb6.isChecked()) {
                    musclesSelected.add("upper-back");
                }
                CheckBox checkb7 = (CheckBox) findViewById(R.id.checkBox7);
                if (checkb7.isChecked()) {
                    musclesSelected.add("triceps");
                }
                CheckBox checkb8 = (CheckBox) findViewById(R.id.checkBox8);
                if (checkb8.isChecked()) {
                    musclesSelected.add("forearm");
                }
                CheckBox checkb9 = (CheckBox) findViewById(R.id.checkBox9);
                if (checkb9.isChecked()) {
                    musclesSelected.add("lumbar");
                }
                CheckBox checkb10 = (CheckBox) findViewById(R.id.checkBox10);
                if (checkb10.isChecked()) {
                    musclesSelected.add("abs");
                }
                CheckBox checkb11 = (CheckBox) findViewById(R.id.checkBox11);
                if (checkb11.isChecked()) {
                    musclesSelected.add("glute");
                }
                CheckBox checkb12 = (CheckBox) findViewById(R.id.checkBox12);
                if (checkb12.isChecked()) {
                    musclesSelected.add("thigh");
                }
                CheckBox checkb13 = (CheckBox) findViewById(R.id.checkBox13);
                if (checkb13.isChecked()) {
                    musclesSelected.add("calf");
                }

                intent.putExtra("musclesSelected", musclesSelected);


                muscleNow = upperBackClicked.getText().toString();
                intent.putExtra("muscleNow", muscleNow);
                intent.putExtra("fromAct2", fromAct2);


                startActivity(intent);
            }
        });

        //TRICEPS clickable
        final TextView tricepsClicked = findViewById(R.id.textView23);
        //link to activity6
        tricepsClicked.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), Activity6.class);

                intent.putExtra("selectedLevel", levelstring);
                intent.putExtra("selectedObjective", objectivestring);

                //new
                intent.putExtra("selectedBodyPart", bodystring);
                intent.putExtra("selectedTime", timestring);

                musclesSelected.clear();
                //add selected muscles
                CheckBox checkb2 = (CheckBox) findViewById(R.id.checkBox2);
                if (checkb2.isChecked()) {
                    musclesSelected.add("biceps");
                }
                CheckBox checkb3 = (CheckBox) findViewById(R.id.checkBox3);
                if (checkb3.isChecked()) {
                    musclesSelected.add("chest");
                }
                CheckBox checkb4 = (CheckBox) findViewById(R.id.checkBox4);
                if (checkb4.isChecked()) {
                    musclesSelected.add("mid-back");
                }
                CheckBox checkb5 = (CheckBox) findViewById(R.id.checkBox5);
                if (checkb5.isChecked()) {
                    musclesSelected.add("deltoid");
                }
                CheckBox checkb6 = (CheckBox) findViewById(R.id.checkBox6);
                if (checkb6.isChecked()) {
                    musclesSelected.add("upper-back");
                }
                CheckBox checkb7 = (CheckBox) findViewById(R.id.checkBox7);
                if (checkb7.isChecked()) {
                    musclesSelected.add("triceps");
                }
                CheckBox checkb8 = (CheckBox) findViewById(R.id.checkBox8);
                if (checkb8.isChecked()) {
                    musclesSelected.add("forearm");
                }
                CheckBox checkb9 = (CheckBox) findViewById(R.id.checkBox9);
                if (checkb9.isChecked()) {
                    musclesSelected.add("lumbar");
                }
                CheckBox checkb10 = (CheckBox) findViewById(R.id.checkBox10);
                if (checkb10.isChecked()) {
                    musclesSelected.add("abs");
                }
                CheckBox checkb11 = (CheckBox) findViewById(R.id.checkBox11);
                if (checkb11.isChecked()) {
                    musclesSelected.add("glute");
                }
                CheckBox checkb12 = (CheckBox) findViewById(R.id.checkBox12);
                if (checkb12.isChecked()) {
                    musclesSelected.add("thigh");
                }
                CheckBox checkb13 = (CheckBox) findViewById(R.id.checkBox13);
                if (checkb13.isChecked()) {
                    musclesSelected.add("calf");
                }

                intent.putExtra("musclesSelected", musclesSelected);


                muscleNow = tricepsClicked.getText().toString();
                intent.putExtra("muscleNow", muscleNow);
                intent.putExtra("fromAct2", fromAct2);


                startActivity(intent);
            }
        });

        //FOREARM clickable
        final TextView forearmClicked = findViewById(R.id.textView24);
        //link to activity6
        forearmClicked.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), Activity6.class);

                intent.putExtra("selectedLevel", levelstring);
                intent.putExtra("selectedObjective", objectivestring);

                //new
                intent.putExtra("selectedBodyPart", bodystring);
                intent.putExtra("selectedTime", timestring);

                musclesSelected.clear();
                //add selected muscles
                CheckBox checkb2 = (CheckBox) findViewById(R.id.checkBox2);
                if (checkb2.isChecked()) {
                    musclesSelected.add("biceps");
                }
                CheckBox checkb3 = (CheckBox) findViewById(R.id.checkBox3);
                if (checkb3.isChecked()) {
                    musclesSelected.add("chest");
                }
                CheckBox checkb4 = (CheckBox) findViewById(R.id.checkBox4);
                if (checkb4.isChecked()) {
                    musclesSelected.add("mid-back");
                }
                CheckBox checkb5 = (CheckBox) findViewById(R.id.checkBox5);
                if (checkb5.isChecked()) {
                    musclesSelected.add("deltoid");
                }
                CheckBox checkb6 = (CheckBox) findViewById(R.id.checkBox6);
                if (checkb6.isChecked()) {
                    musclesSelected.add("upper-back");
                }
                CheckBox checkb7 = (CheckBox) findViewById(R.id.checkBox7);
                if (checkb7.isChecked()) {
                    musclesSelected.add("triceps");
                }
                CheckBox checkb8 = (CheckBox) findViewById(R.id.checkBox8);
                if (checkb8.isChecked()) {
                    musclesSelected.add("forearm");
                }
                CheckBox checkb9 = (CheckBox) findViewById(R.id.checkBox9);
                if (checkb9.isChecked()) {
                    musclesSelected.add("lumbar");
                }
                CheckBox checkb10 = (CheckBox) findViewById(R.id.checkBox10);
                if (checkb10.isChecked()) {
                    musclesSelected.add("abs");
                }
                CheckBox checkb11 = (CheckBox) findViewById(R.id.checkBox11);
                if (checkb11.isChecked()) {
                    musclesSelected.add("glute");
                }
                CheckBox checkb12 = (CheckBox) findViewById(R.id.checkBox12);
                if (checkb12.isChecked()) {
                    musclesSelected.add("thigh");
                }
                CheckBox checkb13 = (CheckBox) findViewById(R.id.checkBox13);
                if (checkb13.isChecked()) {
                    musclesSelected.add("calf");
                }

                intent.putExtra("musclesSelected", musclesSelected);


                muscleNow = forearmClicked.getText().toString();
                intent.putExtra("muscleNow", muscleNow);
                intent.putExtra("fromAct2", fromAct2);


                startActivity(intent);
            }
        });

        //LUMBAR clickable
        final TextView lumbarClicked = findViewById(R.id.textView25);
        //link to activity6
        lumbarClicked.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), Activity6.class);

                intent.putExtra("selectedLevel", levelstring);
                intent.putExtra("selectedObjective", objectivestring);

                //new
                intent.putExtra("selectedBodyPart", bodystring);
                intent.putExtra("selectedTime", timestring);

                musclesSelected.clear();
                //add selected muscles
                CheckBox checkb2 = (CheckBox) findViewById(R.id.checkBox2);
                if (checkb2.isChecked()) {
                    musclesSelected.add("biceps");
                }
                CheckBox checkb3 = (CheckBox) findViewById(R.id.checkBox3);
                if (checkb3.isChecked()) {
                    musclesSelected.add("chest");
                }
                CheckBox checkb4 = (CheckBox) findViewById(R.id.checkBox4);
                if (checkb4.isChecked()) {
                    musclesSelected.add("mid-back");
                }
                CheckBox checkb5 = (CheckBox) findViewById(R.id.checkBox5);
                if (checkb5.isChecked()) {
                    musclesSelected.add("deltoid");
                }
                CheckBox checkb6 = (CheckBox) findViewById(R.id.checkBox6);
                if (checkb6.isChecked()) {
                    musclesSelected.add("upper-back");
                }
                CheckBox checkb7 = (CheckBox) findViewById(R.id.checkBox7);
                if (checkb7.isChecked()) {
                    musclesSelected.add("triceps");
                }
                CheckBox checkb8 = (CheckBox) findViewById(R.id.checkBox8);
                if (checkb8.isChecked()) {
                    musclesSelected.add("forearm");
                }
                CheckBox checkb9 = (CheckBox) findViewById(R.id.checkBox9);
                if (checkb9.isChecked()) {
                    musclesSelected.add("lumbar");
                }
                CheckBox checkb10 = (CheckBox) findViewById(R.id.checkBox10);
                if (checkb10.isChecked()) {
                    musclesSelected.add("abs");
                }
                CheckBox checkb11 = (CheckBox) findViewById(R.id.checkBox11);
                if (checkb11.isChecked()) {
                    musclesSelected.add("glute");
                }
                CheckBox checkb12 = (CheckBox) findViewById(R.id.checkBox12);
                if (checkb12.isChecked()) {
                    musclesSelected.add("thigh");
                }
                CheckBox checkb13 = (CheckBox) findViewById(R.id.checkBox13);
                if (checkb13.isChecked()) {
                    musclesSelected.add("calf");
                }

                intent.putExtra("musclesSelected", musclesSelected);


                muscleNow = lumbarClicked.getText().toString();
                intent.putExtra("muscleNow", muscleNow);
                intent.putExtra("fromAct2", fromAct2);


                startActivity(intent);
            }
        });

        //ABS clickable
        final TextView absClicked = findViewById(R.id.textView26);
        //link to activity6
        absClicked.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), Activity6.class);

                intent.putExtra("selectedLevel", levelstring);
                intent.putExtra("selectedObjective", objectivestring);

                //new
                intent.putExtra("selectedBodyPart", bodystring);
                intent.putExtra("selectedTime", timestring);

                musclesSelected.clear();
                //add selected muscles
                CheckBox checkb2 = (CheckBox) findViewById(R.id.checkBox2);
                if (checkb2.isChecked()) {
                    musclesSelected.add("biceps");
                }
                CheckBox checkb3 = (CheckBox) findViewById(R.id.checkBox3);
                if (checkb3.isChecked()) {
                    musclesSelected.add("chest");
                }
                CheckBox checkb4 = (CheckBox) findViewById(R.id.checkBox4);
                if (checkb4.isChecked()) {
                    musclesSelected.add("mid-back");
                }
                CheckBox checkb5 = (CheckBox) findViewById(R.id.checkBox5);
                if (checkb5.isChecked()) {
                    musclesSelected.add("deltoid");
                }
                CheckBox checkb6 = (CheckBox) findViewById(R.id.checkBox6);
                if (checkb6.isChecked()) {
                    musclesSelected.add("upper-back");
                }
                CheckBox checkb7 = (CheckBox) findViewById(R.id.checkBox7);
                if (checkb7.isChecked()) {
                    musclesSelected.add("triceps");
                }
                CheckBox checkb8 = (CheckBox) findViewById(R.id.checkBox8);
                if (checkb8.isChecked()) {
                    musclesSelected.add("forearm");
                }
                CheckBox checkb9 = (CheckBox) findViewById(R.id.checkBox9);
                if (checkb9.isChecked()) {
                    musclesSelected.add("lumbar");
                }
                CheckBox checkb10 = (CheckBox) findViewById(R.id.checkBox10);
                if (checkb10.isChecked()) {
                    musclesSelected.add("abs");
                }
                CheckBox checkb11 = (CheckBox) findViewById(R.id.checkBox11);
                if (checkb11.isChecked()) {
                    musclesSelected.add("glute");
                }
                CheckBox checkb12 = (CheckBox) findViewById(R.id.checkBox12);
                if (checkb12.isChecked()) {
                    musclesSelected.add("thigh");
                }
                CheckBox checkb13 = (CheckBox) findViewById(R.id.checkBox13);
                if (checkb13.isChecked()) {
                    musclesSelected.add("calf");
                }

                intent.putExtra("musclesSelected", musclesSelected);


                muscleNow = absClicked.getText().toString();
                intent.putExtra("muscleNow", muscleNow);
                intent.putExtra("fromAct2", fromAct2);


                startActivity(intent);
            }
        });

        //GLUTE clickable
        final TextView gluteClicked = findViewById(R.id.textView27);
        //link to activity6
        gluteClicked.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), Activity6.class);

                intent.putExtra("selectedLevel", levelstring);
                intent.putExtra("selectedObjective", objectivestring);

                //new
                intent.putExtra("selectedBodyPart", bodystring);
                intent.putExtra("selectedTime", timestring);

                musclesSelected.clear();
                //add selected muscles
                CheckBox checkb2 = (CheckBox) findViewById(R.id.checkBox2);
                if (checkb2.isChecked()) {
                    musclesSelected.add("biceps");
                }
                CheckBox checkb3 = (CheckBox) findViewById(R.id.checkBox3);
                if (checkb3.isChecked()) {
                    musclesSelected.add("chest");
                }
                CheckBox checkb4 = (CheckBox) findViewById(R.id.checkBox4);
                if (checkb4.isChecked()) {
                    musclesSelected.add("mid-back");
                }
                CheckBox checkb5 = (CheckBox) findViewById(R.id.checkBox5);
                if (checkb5.isChecked()) {
                    musclesSelected.add("deltoid");
                }
                CheckBox checkb6 = (CheckBox) findViewById(R.id.checkBox6);
                if (checkb6.isChecked()) {
                    musclesSelected.add("upper-back");
                }
                CheckBox checkb7 = (CheckBox) findViewById(R.id.checkBox7);
                if (checkb7.isChecked()) {
                    musclesSelected.add("triceps");
                }
                CheckBox checkb8 = (CheckBox) findViewById(R.id.checkBox8);
                if (checkb8.isChecked()) {
                    musclesSelected.add("forearm");
                }
                CheckBox checkb9 = (CheckBox) findViewById(R.id.checkBox9);
                if (checkb9.isChecked()) {
                    musclesSelected.add("lumbar");
                }
                CheckBox checkb10 = (CheckBox) findViewById(R.id.checkBox10);
                if (checkb10.isChecked()) {
                    musclesSelected.add("abs");
                }
                CheckBox checkb11 = (CheckBox) findViewById(R.id.checkBox11);
                if (checkb11.isChecked()) {
                    musclesSelected.add("glute");
                }
                CheckBox checkb12 = (CheckBox) findViewById(R.id.checkBox12);
                if (checkb12.isChecked()) {
                    musclesSelected.add("thigh");
                }
                CheckBox checkb13 = (CheckBox) findViewById(R.id.checkBox13);
                if (checkb13.isChecked()) {
                    musclesSelected.add("calf");
                }

                intent.putExtra("musclesSelected", musclesSelected);


                muscleNow = gluteClicked.getText().toString();
                intent.putExtra("muscleNow", muscleNow);
                intent.putExtra("fromAct2", fromAct2);


                startActivity(intent);
            }
        });

        //THIGH clickable
        final TextView thighClicked = findViewById(R.id.textView28);
        //link to activity6
        thighClicked.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), Activity6.class);

                intent.putExtra("selectedLevel", levelstring);
                intent.putExtra("selectedObjective", objectivestring);

                //new
                intent.putExtra("selectedBodyPart", bodystring);
                intent.putExtra("selectedTime", timestring);

                musclesSelected.clear();
                //add selected muscles
                CheckBox checkb2 = (CheckBox) findViewById(R.id.checkBox2);
                if (checkb2.isChecked()) {
                    musclesSelected.add("biceps");
                }
                CheckBox checkb3 = (CheckBox) findViewById(R.id.checkBox3);
                if (checkb3.isChecked()) {
                    musclesSelected.add("chest");
                }
                CheckBox checkb4 = (CheckBox) findViewById(R.id.checkBox4);
                if (checkb4.isChecked()) {
                    musclesSelected.add("mid-back");
                }
                CheckBox checkb5 = (CheckBox) findViewById(R.id.checkBox5);
                if (checkb5.isChecked()) {
                    musclesSelected.add("deltoid");
                }
                CheckBox checkb6 = (CheckBox) findViewById(R.id.checkBox6);
                if (checkb6.isChecked()) {
                    musclesSelected.add("upper-back");
                }
                CheckBox checkb7 = (CheckBox) findViewById(R.id.checkBox7);
                if (checkb7.isChecked()) {
                    musclesSelected.add("triceps");
                }
                CheckBox checkb8 = (CheckBox) findViewById(R.id.checkBox8);
                if (checkb8.isChecked()) {
                    musclesSelected.add("forearm");
                }
                CheckBox checkb9 = (CheckBox) findViewById(R.id.checkBox9);
                if (checkb9.isChecked()) {
                    musclesSelected.add("lumbar");
                }
                CheckBox checkb10 = (CheckBox) findViewById(R.id.checkBox10);
                if (checkb10.isChecked()) {
                    musclesSelected.add("abs");
                }
                CheckBox checkb11 = (CheckBox) findViewById(R.id.checkBox11);
                if (checkb11.isChecked()) {
                    musclesSelected.add("glute");
                }
                CheckBox checkb12 = (CheckBox) findViewById(R.id.checkBox12);
                if (checkb12.isChecked()) {
                    musclesSelected.add("thigh");
                }
                CheckBox checkb13 = (CheckBox) findViewById(R.id.checkBox13);
                if (checkb13.isChecked()) {
                    musclesSelected.add("calf");
                }

                intent.putExtra("musclesSelected", musclesSelected);


                muscleNow = thighClicked.getText().toString();
                intent.putExtra("muscleNow", muscleNow);
                intent.putExtra("fromAct2", fromAct2);


                startActivity(intent);
            }
        });

        //CALF clickable
        final TextView calfClicked = findViewById(R.id.textView29);
        //link to activity6
        calfClicked.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), Activity6.class);

                intent.putExtra("selectedLevel", levelstring);
                intent.putExtra("selectedObjective", objectivestring);

                //new
                intent.putExtra("selectedBodyPart", bodystring);
                intent.putExtra("selectedTime", timestring);

                musclesSelected.clear();
                //add selected muscles
                CheckBox checkb2 = (CheckBox) findViewById(R.id.checkBox2);
                if (checkb2.isChecked()) {
                    musclesSelected.add("biceps");
                }
                CheckBox checkb3 = (CheckBox) findViewById(R.id.checkBox3);
                if (checkb3.isChecked()) {
                    musclesSelected.add("chest");
                }
                CheckBox checkb4 = (CheckBox) findViewById(R.id.checkBox4);
                if (checkb4.isChecked()) {
                    musclesSelected.add("mid-back");
                }
                CheckBox checkb5 = (CheckBox) findViewById(R.id.checkBox5);
                if (checkb5.isChecked()) {
                    musclesSelected.add("deltoid");
                }
                CheckBox checkb6 = (CheckBox) findViewById(R.id.checkBox6);
                if (checkb6.isChecked()) {
                    musclesSelected.add("upper-back");
                }
                CheckBox checkb7 = (CheckBox) findViewById(R.id.checkBox7);
                if (checkb7.isChecked()) {
                    musclesSelected.add("triceps");
                }
                CheckBox checkb8 = (CheckBox) findViewById(R.id.checkBox8);
                if (checkb8.isChecked()) {
                    musclesSelected.add("forearm");
                }
                CheckBox checkb9 = (CheckBox) findViewById(R.id.checkBox9);
                if (checkb9.isChecked()) {
                    musclesSelected.add("lumbar");
                }
                CheckBox checkb10 = (CheckBox) findViewById(R.id.checkBox10);
                if (checkb10.isChecked()) {
                    musclesSelected.add("abs");
                }
                CheckBox checkb11 = (CheckBox) findViewById(R.id.checkBox11);
                if (checkb11.isChecked()) {
                    musclesSelected.add("glute");
                }
                CheckBox checkb12 = (CheckBox) findViewById(R.id.checkBox12);
                if (checkb12.isChecked()) {
                    musclesSelected.add("thigh");
                }
                CheckBox checkb13 = (CheckBox) findViewById(R.id.checkBox13);
                if (checkb13.isChecked()) {
                    musclesSelected.add("calf");
                }

                intent.putExtra("musclesSelected", musclesSelected);


                muscleNow = calfClicked.getText().toString();
                intent.putExtra("muscleNow", muscleNow);
                intent.putExtra("fromAct2", fromAct2);


                startActivity(intent);
            }
        });

    }


    public void goToActivity2(View view) {

        musclesSelected.clear();
        //add selected muscles
        CheckBox checkb2 = (CheckBox) findViewById(R.id.checkBox2);
        if (checkb2.isChecked()) {
            musclesSelected.add("biceps");
        }
        CheckBox checkb3 = (CheckBox) findViewById(R.id.checkBox3);
        if (checkb3.isChecked()) {
            musclesSelected.add("chest");
        }
        CheckBox checkb4 = (CheckBox) findViewById(R.id.checkBox4);
        if (checkb4.isChecked()) {
            musclesSelected.add("mid-back");
        }
        CheckBox checkb5 = (CheckBox) findViewById(R.id.checkBox5);
        if (checkb5.isChecked()) {
            musclesSelected.add("deltoid");
        }
        CheckBox checkb6 = (CheckBox) findViewById(R.id.checkBox6);
        if (checkb6.isChecked()) {
            musclesSelected.add("upper-back");
        }
        CheckBox checkb7 = (CheckBox) findViewById(R.id.checkBox7);
        if (checkb7.isChecked()) {
            musclesSelected.add("triceps");
        }
        CheckBox checkb8 = (CheckBox) findViewById(R.id.checkBox8);
        if (checkb8.isChecked()) {
            musclesSelected.add("forearm");
        }
        CheckBox checkb9 = (CheckBox) findViewById(R.id.checkBox9);
        if (checkb9.isChecked()) {
            musclesSelected.add("lumbar");
        }
        CheckBox checkb10 = (CheckBox) findViewById(R.id.checkBox10);
        if (checkb10.isChecked()) {
            musclesSelected.add("abs");
        }
        CheckBox checkb11 = (CheckBox) findViewById(R.id.checkBox11);
        if (checkb11.isChecked()) {
            musclesSelected.add("glute");
        }
        CheckBox checkb12 = (CheckBox) findViewById(R.id.checkBox12);
        if (checkb12.isChecked()) {
            musclesSelected.add("thigh");
        }
        CheckBox checkb13 = (CheckBox) findViewById(R.id.checkBox13);
        if (checkb13.isChecked()) {
            musclesSelected.add("calf");
        }


        //warning, select at least 1 muscle (toast?)
        if (musclesSelected.size() == 0) {
            Toast toast1 = Toast.makeText(getApplicationContext(),
                    "Mínimo 1 músculo", Toast.LENGTH_LONG);
            toast1.show();

        } else {
            //NOT WORKING go to activity 2 directly, then go to activity1 first
            Intent intent = new Intent(this, Activity2.class);
            intent.putExtra("exerciseCounter", counter);
            intent.putExtra("selectedTime", timestring);
            intent.putExtra("selectedLevel", levelstring);
            intent.putExtra("selectedBodyPart", bodystring);
            intent.putExtra("selectedObjective", objectivestring);
            intent.putExtra("listCreated", false);
            intent.putExtra("musclesSelected", musclesSelected);
            startActivity(intent);
        }


    }


    public void goToMain(View view) {


        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("exerciseCounter", counter);
        intent.putExtra("selectedTime", timestring);
        intent.putExtra("selectedLevel", levelstring);
        intent.putExtra("selectedBodyPart", bodystring);
        intent.putExtra("selectedObjective", objectivestring);
        intent.putExtra("listCreated", false);
        startActivity(intent);

    }


    public void goToActivity6(View view){

        //on click checkbox problems, get view clicked here problems
        //final TextView simpleChrono = findViewById(R.id.);

        Intent intent = new Intent(this, Activity6.class);
        intent.putExtra("selectedTime", timestring);
        intent.putExtra("selectedLevel", levelstring);
        intent.putExtra("selectedBodyPart", bodystring);
        intent.putExtra("selectedObjective", objectivestring);
        intent.putExtra("listCreated", false);
        //intent.putExtra("muscle", );
        startActivity(intent);

    }


}




