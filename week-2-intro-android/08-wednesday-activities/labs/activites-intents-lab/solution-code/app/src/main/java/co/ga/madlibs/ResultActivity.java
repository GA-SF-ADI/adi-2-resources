package co.ga.madlibs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by james on 12/7/15.
 */
public class ResultActivity extends AppCompatActivity {
    public static final String ADJECTIVE1 = "adj1";
    public static final String ADJECTIVE2 = "adj2";
    public static final String NOUN1 = "noun1";
    public static final String NOUN2 = "noun";
    public static final String ANIMALS = "animals";
    public static final String GAME = "game";

    TextView resultTextView;
    Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultTextView = (TextView) findViewById(R.id.result_textview);
        backButton = (Button) findViewById(R.id.back_button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        setResults();
    }

    private void setResults() {
        String[] words = new String[6];
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            words[0] = extras.getString(ADJECTIVE1, "???");
            words[1] = extras.getString(ADJECTIVE2, "???");
            words[2] = extras.getString(NOUN1, "???");
            words[3] = extras.getString(NOUN2, "???");
            words[4] = extras.getString(ANIMALS, "???");
            words[5] = extras.getString(GAME, "???");

            String resultString = getString(R.string.madlib_result, words);

            resultString = addIndefiniteArticles(resultString, words[2], words[3]);

            resultTextView.setText( Html.fromHtml(resultString) );
        } else {
            Toast.makeText(ResultActivity.this, "Did you set the words as extra data in the Intent?", Toast.LENGTH_SHORT).show();
        }
    }

    private String addIndefiniteArticles(String sentence, String... nouns){
        String result = sentence;
        for (String noun : nouns){
            if (!TextUtils.isEmpty(noun)){
                String article = isVowel(noun.charAt(0))? "an" : "a";
                result = result.replaceFirst("a/an <b>" + noun + "</b>", article + " <b>" + noun + "</b>");
            }
        }

        return result;
    }

    private static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }
}
