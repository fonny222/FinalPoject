package christopher_fontana.finalpoject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ExerciseInformation extends AppCompatActivity {

    ArrayList<String> populateView = new ArrayList<String>();

    String repsString;
    String weightString;
    String completeLine;

    String newLine = System.getProperty("Line.Separator");
    String everyLine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_information);

        //String[] test = {"One","Two","Three","Four","Five","Six","Seven"};

        //testAR.addAll(Arrays.asList(test));

        final ListView listInfo = (ListView) findViewById(R.id.listInformation);



        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> makeListViewWork = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, populateView);
        listInfo.setAdapter(makeListViewWork);


        // get reps and weight
        final EditText reps = (EditText) findViewById(R.id.txtReps);
        final EditText weight = (EditText) findViewById(R.id.txtWeight);

        // instantiate add button
        Button addToList = (Button) findViewById(R.id.btnAdd);

        addToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               repsString = (reps.getText().toString());
                weightString = (weight.getText().toString());
                completeLine = "Reps: " + repsString + " x " +weightString;

                populateView.add(completeLine);

                // this reloads the listview so it displays new data
                listInfo.invalidateViews();
            }
        });

        // instantiate confirmation button
        Button confirmation = (Button) findViewById(R.id.btnConfirm);

        final StringBuilder builder = new StringBuilder();

        confirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(String s : populateView){

                    builder.append(s+"\n");
                }

                everyLine = builder.toString();

                System.out.println();
                System.out.println(everyLine);
                System.out.println();

                Intent intent = new Intent(ExerciseInformation.this,MainActivity.class);
                intent.putExtra("ExerciseInfo",everyLine);
                startActivity(intent);

            }
        });
    }
}
