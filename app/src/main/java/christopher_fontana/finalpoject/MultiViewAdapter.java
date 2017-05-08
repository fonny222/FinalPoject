package christopher_fontana.finalpoject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ChrisF on 4/30/2017.
 */

public class MultiViewAdapter extends ArrayAdapter<ThreeStrings> {

    private int layoutResource;

    public MultiViewAdapter(Context context, int layoutResource, List<ThreeStrings> threeStringsList) {
        super(context, layoutResource, threeStringsList);
        this.layoutResource = layoutResource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if (view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            view = layoutInflater.inflate(layoutResource, null);
        }

        ThreeStrings threeStrings = getItem(position);

        if (threeStrings != null) {
            TextView leftTextView = (TextView) view.findViewById(R.id.leftTextView);
            TextView rightTextView = (TextView) view.findViewById(R.id.rightTextView);
            TextView centreTextView = (TextView) view.findViewById(R.id.centreTextView);

            if (leftTextView != null) {
                leftTextView.setText(threeStrings.getLeft());
            }

            if (rightTextView != null) {
                rightTextView.setText(threeStrings.getRight());
            }

           /*if (centreTextView != null) {
                centreTextView.setText(threeStrings.getRight());
            }
            */
        }

        return view;
    }

}
