package com.subin.morseit;


import android.content.ClipData;
import android.content.ClipboardManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    private ClipboardManager myClipboard;
    private ClipData myClip;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_translate = findViewById(R.id.button);
        final EditText input_field = findViewById(R.id.editText);
        t1 = (TextView) findViewById(R.id.textView);

        button_translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input_field_text = input_field.getText().toString();
                TextView output_field = findViewById(R.id.textView);

                String morse_code = translateToMorse(input_field_text);
                output_field.setText(morse_code);
            }
        });

        Button button_copy = findViewById(R.id.button1);
        myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        button_copy.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String text;
                text = t1.getText().toString();

                myClip = ClipData.newPlainText("text", text);
                myClipboard.setPrimaryClip(myClip);

                Toast.makeText(getApplicationContext(), "Text Copied",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public String translateToMorse(String input_field_text) {
        Map<Character, String> map = new HashMap<>();
        StringBuilder morse_code = new StringBuilder();

        map.put('A', ".-");
        map.put('B', "-...");
        map.put('C', "-.-.");
        map.put('D', "-..");
        map.put('E', ".");
        map.put('F', "..-.");
        map.put('G', "--.");
        map.put('H', "....");
        map.put('I', "..");
        map.put('J', ".---");
        map.put('K', "-.-");
        map.put('L', ".-..");
        map.put('M', "--");
        map.put('N', "-.");
        map.put('O', "---");
        map.put('P', ".--.");
        map.put('Q', "--.-");
        map.put('R', ".-.");
        map.put('S', "...");
        map.put('T', "-");
        map.put('U', "..-");
        map.put('V', "...-");
        map.put('W', ".--");
        map.put('X', "-..-");
        map.put('Y', "-.--");
        map.put('Z', "--..");
        map.put('a', ".-");
        map.put('b', "-...");
        map.put('c', "-.-.");
        map.put('d', "-..");
        map.put('e', ".");
        map.put('f', "..-.");
        map.put('g', "--.");
        map.put('h', "....");
        map.put('i', "..");
        map.put('j', ".---");
        map.put('k', "-.-");
        map.put('l', ".-..");
        map.put('m', "--");
        map.put('n', "-.");
        map.put('o', "---");
        map.put('p', ".--.");
        map.put('q', "--.-");
        map.put('r', ".-.");
        map.put('s', "...");
        map.put('t', "-");
        map.put('u', "..-");
        map.put('v', "...-");
        map.put('w', ".--");
        map.put('x', "-..-");
        map.put('y', "-.--");
        map.put('z', "--..");
        map.put('0',	"-----");
        map.put('1',".----");
        map.put( '2',"..---");
        map.put('3',"...--");
        map.put('4',"....-");
        map.put('5',".....");
        map.put('6',"-....");
        map.put('7',"--...");
        map.put('8',"---..");
        map.put('9',"----.");
        map.put('.',".-.-.-");
        map.put(',',"--..--");
        map.put('?',"..--..");
        map.put('=',"-...-");

        for (int i = 0; i < input_field_text.length(); i++) {
            char upperChar = (char) (input_field_text.charAt(i));
            String fetchedChar = map.get(upperChar);
            if (fetchedChar != null) {
                morse_code.append(map.get(upperChar));
            } else {
                morse_code.append(input_field_text.charAt(i));
            }
            morse_code.append(' ');
        }
        return morse_code.toString();
    }
}