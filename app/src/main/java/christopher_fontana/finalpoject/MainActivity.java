package christopher_fontana.finalpoject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    String completeInfo;

    // List<String> nameFromExList = new ArrayList<String>();

    // array lists for both sections of the array
    ArrayList<String> todaysExercise;
    ArrayList<String> exerciseInformation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // test section can be deleted
        exerciseInformation = new ArrayList<String>();
        todaysExercise = new ArrayList<String>();

        exerciseInformation.add("Reps: 0 - 0 lbs");


        // instantiates new array list from the class Three Strings
        List<ThreeStrings> threeStringsList = new ArrayList<>();

        // intent is how to send info from one class to another
        // Bundle extras = getIntent().getExtras();

        // exercise name intent
        Intent fromExList = getIntent();

        // exerciseInfo intent
        Bundle extras = getIntent().getExtras();

        if(extras!= null) {
            completeInfo = extras.getString("ExerciseInfo");
        }
        ArrayList<String> nameFromExList = fromExList.getStringArrayListExtra("toMain");
        // if extras ( intent that stores data from other class) is not null


        // it will change the text, if it is null it will ignore it.
        if (nameFromExList != null && !nameFromExList.isEmpty()) {

            for (int i = 0; i < nameFromExList.size(); i++) {

                //System.out.println(nameFromExList.get(i));

                todaysExercise.add(nameFromExList.get(i));
                exerciseInformation.add(completeInfo);
            }
        }


        // gets the array length
        int arrayLength = todaysExercise.size();
        // populates the table
        for (int i = 0; i < arrayLength; i++) {

            // this is a test you can delete the following
            ThreeStrings threeStrings = new ThreeStrings(todaysExercise.get(i), exerciseInformation.get(0));


            // *******keep the following******
            // this adds the threeStrings info to the list that creates the custom cells
            threeStringsList.add(threeStrings);
        }

        ListView listView = (ListView) findViewById(R.id.listInformation);
        MultiViewAdapter threeHorizontalTextViewsAdapter = new MultiViewAdapter(this, R.layout.text3, threeStringsList);
        listView.setAdapter(threeHorizontalTextViewsAdapter);

        Button button = (Button) findViewById(R.id.addExercise);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent nameBackExList = new Intent(MainActivity.this, ExerciseList.class);

                nameBackExList.putStringArrayListExtra("nameBack", (ArrayList<String>) todaysExercise);
                startActivity(nameBackExList);
                //startActivity(new Intent(MainActivity.this, ExerciseList.class));
            }
        });

        // this lets you click a position in the list view and takes you to the exercise Information class
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selection = todaysExercise.get(position);

                startActivity(new Intent(MainActivity.this, ExerciseInformation.class));

            }
        });
    }
}