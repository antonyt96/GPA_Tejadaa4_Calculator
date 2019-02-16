package com.example.gpa_tejadaa4_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText ch1,ch2,ch3,ch4,ch5;
    private EditText g1,g2,g3,g4,g5;
    private Button gpa_calc;
    private TextView result;
    Double final =0;
    /*
    private int credit_sum = 0;
    private int grade_sum = 0;
    */

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
        //Result
        result = (TextView)findViewById(R.id.result);

        gpa_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calculateGPA();
            }
        });
    }

    public void calculateGPA() {

        double quality_points = 0;
        double credit_sum = 0;
        double gpa=0;
        double chour1 = Double.valueOf(ch1.getText().toString());
        double chour2 = Double.valueOf(ch2.getText().toString());
        double chour3 = Double.valueOf(ch3.getText().toString());
        double chour4 = Double.valueOf(ch4.getText().toString());
        double chour5 = Double.valueOf(ch5.getText().toString());

        String l1 = String.valueOf(g1.getText());
        String l2 = String.valueOf(g2.getText());
        String l3 = String.valueOf(g3.getText());
        String l4 = String.valueOf(g4.getText());
        String l5 = String.valueOf(g5.getText());

        double[] creditArray = new double[]{chour1, chour2, chour3, chour4, chour5};
        String[] gradeArray = new String[]{l1,l2,l3,l4,l5};
        credit_sum = chour1+chour2+chour3+chour4+chour5;

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
        String str = Double.toString(gpa);
        result.setText(str);
    }
}
