package reversed.text;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    char[] input = {'I', ' ', 'l', 'o', 'v', 'e', ' ', 'V', 'i', 'r', 'c', 'a'};
    TextView tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvOutput = (TextView)findViewById(R.id.tv);

        char[] output = reverseWords(input);
        //Log.wtf("Reversed result ", String.valueOf(output));
        tvOutput.setText(String.valueOf(output));
    }

    public char[] reverseWords(char[] input) {
        List<String> list = new ArrayList<>();
        char[] temp = new char[input.length];
        Integer j = 0;

        char[] reversed = new char[input.length+1];
        for (int i = 0; i < input.length; i++) {
            if (input[i] == ' ') {
                list.add(String.valueOf(temp));
                temp = new char[input.length];
                j = 0;
            }
            temp[j] = input[i];
            j += 1;
        }
        list.add(String.valueOf(temp));


        //reverse the words
        j = 0;
        for (String item : list) {
            Log.wtf("word", item);
            if (j >0) j += 1;
            reversed[j] = ' ';

            char[] array = item.trim().toCharArray();
            for (int i = array.length - 1; i >= 0; i--) {
                j += 1;
                reversed[j] = array[i];
            }
        }

        return reversed;
    }

}
