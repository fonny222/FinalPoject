package christopher_fontana.finalpoject;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ExerciseList extends ListActivity {

    List<String> choseExercise = new ArrayList<String>();

    String[] exercises = {"Bench Press", "Dumbbell Curl", "Incline Bench Press", "Barbell Curl", "Close Grip Pulldown",
            "Wide Grip Pulldown", "Dumbbell Walking Lunge", "Machine Leg Press", "Machine Lying Leg Curl", "Dumbbell Front Raises",
            "Dumbbell Lateral Raises", "Preacher Curl", "Skull Crusher", "Triceps Extension"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent nameBackFromMain = getIntent();
        ArrayList<String> choseExercise = nameBackFromMain.getStringArrayListExtra("nameBack");

        if(choseExercise != null && !choseExercise.isEmpty()){
            System.out.println(choseExercise.get(0));
        }

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,exercises));
    }

    protected void onListItemClick(ListView l, View v, int position, long id){

        // this gets the data at the position clicked on the table
        String selection = exercises[position];

        choseExercise.add(selection);

        Intent toMainExList = new Intent (ExerciseList.this, MainActivity.class);
        toMainExList.putStringArrayListExtra("toMain",(ArrayList<String>) choseExercise);
        startActivity(toMainExList);

        //System.out.println(selection);



        /*// this is the intent used to store the data to send to another class
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("Exercise",selection);
        startActivity(intent);
    */
    }
}
