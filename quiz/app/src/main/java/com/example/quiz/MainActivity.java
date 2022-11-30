package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView total_questions;
    TextView question;
    RadioGroup group;
    RadioButton ans1;
    RadioButton ans2;
    RadioButton ans3;
    RadioButton ans4;
    Button submit;

    List<Question> questionList = new ArrayList<>();
    int index = 0;
    int totalQuestions = 0;
    int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        total_questions=findViewById(R.id.total_questions);
        question=findViewById(R.id.questions);
        group=findViewById(R.id.group);
        ans1=findViewById(R.id.ans1);
        ans2=findViewById(R.id.ans2);
        ans3=findViewById(R.id.ans3);
        ans4=findViewById(R.id.ans4);
        submit=findViewById(R.id.submit);

        addQuestion();
        loadQuestion();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPressSubmit();
            }
        });
    }

    private void onPressSubmit() {
        int id = group.getCheckedRadioButtonId();
        if(id == -1) {
            Toast.makeText(this,"Please select a answer",Toast.LENGTH_SHORT).show();
            return;
        }
        RadioButton selectedButton = findViewById(id);
        Question currentQuestion = questionList.get(index);

        if(selectedButton.getText().toString().equals(currentQuestion.getAnswer())) {
            score++;
        }

        if(index <=totalQuestions)
            index++;
        group.clearCheck();
        loadQuestion();
    }

    private void loadQuestion() {
        if(index >= totalQuestions) {
            showResult();
            return;
        }
        Question currentQuestion = questionList.get(index);
        question.setText(String.format("%d. %s", index + 1, currentQuestion.getQuestion()));
        ans1.setText(currentQuestion.getAns1());
        ans2.setText(currentQuestion.getAns2());
        ans3.setText(currentQuestion.getAns3());
        ans4.setText(currentQuestion.getAns4());
    }

    private void showResult() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setMessage("Your score is "+score+"/"+questionList.size());
        score=0 ;
        index=0;
        loadQuestion();
        builder.setTitle("Score !");
        builder.setCancelable(false);
        builder.setPositiveButton("Ok", (DialogInterface.OnClickListener) (dialog, which) -> {

        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void addQuestion() {
        questionList.add(new Question(
                "What is the capital of india?",
                "Delhi",
                "Mumbai",
                "Kolkota",
                "Hyderabad",
                "Delhi"
        ));
        questionList.add(new Question(
                "What is the capital of telangana?",
                "Delhi",
                "Mumbai",
                "Kolkota",
                "Hyderabad",
                "Hyderabad"
        ));
        questionList.add(new Question(
                "What is the capital of Andhra Pradesh?",
                "Vishakhapatnam",
                "Kadapa",
                "Ananthapur",
                "None of the above",
                "None of the above"
        ));



        totalQuestions = questionList.size();
        total_questions.setText("Total questions =  "+totalQuestions);

    }
}