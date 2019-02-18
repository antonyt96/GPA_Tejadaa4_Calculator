package com.example.gpa_tejadaa4_calculator;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText ch1,ch2,ch3,ch4,ch5;
    private EditText g1,g2,g3,g4,g5;
    private Button gpa_calc;
    private TextView result;
    private ConstraintLayout currentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Credit Hours
        ch1 = (EditText)findViewById(R.id.C_H1);
        ch2 = (EditText)findViewById(R.id.C_H2);
        ch3 = (EditText)findViewById(R.id.C_H3);
        ch4 = (EditText)findViewById(R.id.C_H4);
        ch5 = (EditText)findViewById(R.id.C_H5);

        //Grades
        g1= (EditText)findViewById(R.id.L_G1);
        g2= (EditText)findViewById(R.id.L_G2);
        g3= (EditText)findViewById(R.id.L_G3);
        g4= (EditText)findViewById(R.id.L_G4);
        g5= (EditText)findViewById(R.id.L_G5);


        //Button
        gpa_calc = (Button) findViewById(R.id.button);

        currentLayout = (ConstraintLayout)findViewById(R.id.main_layout);

        //Result
        result = (TextView)findViewById(R.id.gparesult);

        gpa_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //credits check
                if(TextUtils.isEmpty(ch1.getText())){
                    ch1.setError("No blank fields");
                    ch1.requestFocus();
                }
                else if(TextUtils.isEmpty(ch2.getText())){
                    ch2.setError("No blank fields");
                    ch2.requestFocus();
                }
                else if(TextUtils.isEmpty(ch3.getText())){
                    ch3.setError("No blank fields");
                    ch3.requestFocus();
                }
                else if(TextUtils.isEmpty(ch4.getText())){
                    ch4.setError("No blank fields");
                    ch4.requestFocus();
                }
                else if(TextUtils.isEmpty(ch5.getText())){
                    ch5.setError("No blank fields");
                    ch5.requestFocus();
                }
                //grade check
                else if(TextUtils.isEmpty(g1.getText())){
                    g1.setError("No blank fields");
                    g1.requestFocus();
                }
                else if(TextUtils.isEmpty(g2.getText())){
                    g2.setError("No blank fields");
                    g2.requestFocus();
                }
                else if(TextUtils.isEmpty(g3.getText())){
                    g3.setError("No blank fields");
                    g3.requestFocus();
                }
                else if(TextUtils.isEmpty(g4.getText())){
                    g4.setError("No blank fields");
                    g4.requestFocus();
                }
                else if(TextUtils.isEmpty(g5.getText())){
                    g5.setError("No blank fields");
                    g5.requestFocus();
                }
                else {
                    calculateGPA();
                }
            }
        });
    }

    public void calculateGPA() {

        gpa_calc.setTextColor(getResources().getColor(R.color.transparent));
        double quality_points = 0;
        double credit_sum = 0;
        double gpa=0;

        double chour1 = 0;
        double chour2 = 0;
        double chour3 = 0;
        double chour4 = 0;
        double chour5 = 0;

        String l1 = "";
        String l2 = "";
        String l3 = "";
        String l4 = "";
        String l5 = "";

        chour1 = Double.valueOf(ch1.getText().toString());
        chour2 = Double.valueOf(ch2.getText().toString());
        chour3 = Double.valueOf(ch3.getText().toString());
        chour4 = Double.valueOf(ch4.getText().toString());
        chour5 = Double.valueOf(ch5.getText().toString());


        l1 = String.valueOf(g1.getText().toString());
        l2 = String.valueOf(g2.getText().toString());
        l3 = String.valueOf(g3.getText().toString());
        l4 = String.valueOf(g4.getText().toString());
        l5 = String.valueOf(g5.getText().toString());

        double[] creditArray = new double[]{chour1, chour2, chour3, chour4, chour5};
        String[] gradeArray = new String[]{l1,l2,l3,l4,l5};

        credit_sum = chour1+chour2+chour3+chour4+chour5;
        //quality points calculation
        for(int i=0; i<gradeArray.length; i++){

            if (gradeArray[i].equals("A")){

                quality_points += (creditArray[i] * 4);
            }
            else if (gradeArray[i].equals("B")){

                quality_points += (creditArray[i] * 3);
            }
            else if (gradeArray[i].equals("C")){

                quality_points += (creditArray[i] * 2);
            }
            else if (gradeArray[i].equals("D")){

                quality_points += (creditArray[i] * 1);
            }
            else if (gradeArray[i].equals("F")){

                quality_points += (creditArray[i] * 0);
            }

        }

        gpa = (quality_points/credit_sum);
        DecimalFormat num = new DecimalFormat("#.##");
        num.format(gpa);

        if (gpa == 0.0){currentLayout.setBackgroundColor(getResources().getColor(R.color.bad));}
        else if (gpa > 0.0 && gpa <= 2.3){currentLayout.setBackgroundColor(getResources().getColor(R.color.good));}
        else if (gpa > 2.3 && gpa <= 4.0){currentLayout.setBackgroundColor(getResources().getColor(R.color.great));}

        String str = String.valueOf(gpa);
        result.setText(str);
    }
}
