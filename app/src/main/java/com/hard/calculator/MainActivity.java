package com.hard.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Delegate delegate = new Delegate();

    private TextView textView;
    private Button buttonClear;
    private Button buttonBackspace;
    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button buttonSum;
    private Button buttonDif;
    private Button buttonMult;
    private Button buttonDiv;
    private Button buttonEq;

    private int cache;
    private String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListeners();
    }

    private class Delegate {
        public void actionClear() {
            String buffer = textView.getText().toString();

            if (!buffer.equals("0")) {
                textView.setText("0");
                cache = 0;
                operation = "";
            }
        }

        public void actionBackspace() {
            String buffer = textView.getText().toString();

            if (!buffer.equals("0"))
                textView.setText(buffer.substring(0, buffer.length() - 1));

            if (buffer.length() <= 1)
                textView.setText("0");
        }

        public void action0() {
            String buffer = textView.getText().toString();

            if (buffer.equals("0"))
                textView.setText("0");
            else
                textView.setText(buffer + "0");
        }

        public void action1() {
            String buffer = textView.getText().toString();

            if (buffer.equals("0"))
                textView.setText("1");
            else
                textView.setText(buffer + "1");
        }

        public void action2() {
            String buffer = textView.getText().toString();

            if (buffer.equals("0"))
                textView.setText("2");
            else
                textView.setText(buffer + "2");
        }

        public void action3() {
            String buffer = textView.getText().toString();

            if (buffer.equals("0"))
                textView.setText("3");
            else
                textView.setText(buffer + "3");
        }

        public void action4() {
            String buffer = textView.getText().toString();

            if (buffer.equals("0"))
                textView.setText("4");
            else
                textView.setText(buffer + "4");
        }

        public void action5() {
            String buffer = textView.getText().toString();

            if (buffer.equals("0"))
                textView.setText("5");
            else
                textView.setText(buffer + "5");
        }

        public void action6() {
            String buffer = textView.getText().toString();

            if (buffer.equals("0"))
                textView.setText("6");
            else
                textView.setText(buffer + "6");
        }

        public void action7() {
            String buffer = textView.getText().toString();

            if (buffer.equals("0"))
                textView.setText("7");
            else
                textView.setText(buffer + "7");
        }

        public void action8() {
            String buffer = textView.getText().toString();

            if (buffer.equals("0"))
                textView.setText("8");
            else
                textView.setText(buffer + "8");
        }

        public void action9() {
            String buffer = textView.getText().toString();

            if (buffer.equals("0"))
                textView.setText("9");
            else
                textView.setText(buffer + "9");
        }

        public void actionSum() {
            cache = Integer.valueOf(textView.getText().toString());
            operation = "sum";

            textView.setText("0");
        }

        public void actionDif() {
            cache = Integer.valueOf(textView.getText().toString());
            operation = "dif";

            textView.setText("0");
        }

        public void actionMult() {
            cache = Integer.valueOf(textView.getText().toString());
            operation = "mult";

            textView.setText("0");
        }

        public void actionDiv() {
            cache = Integer.valueOf(textView.getText().toString());
            operation = "div";

            textView.setText("0");
        }

        public void actionEq() {
            int buffer = Integer.valueOf(textView.getText().toString());

            int result = 0;

            switch (operation) {
                case "sum":
                    result = cache + buffer;
                    break;
                case "dif":
                    result = cache - buffer;
                    break;
                case "mult":
                    result = cache * buffer;
                    break;
                case "div":
                    result = cache / buffer;
                    break;
            }

            textView.setText(String.valueOf(result));
        }
    }

    public void addListeners() {
        textView = (TextView) findViewById(R.id.textView1);

        buttonClear = (Button) findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.actionClear();
            }
        });

        buttonBackspace = (Button) findViewById(R.id.buttonBackspace);
        buttonBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.actionBackspace();
            }
        });

        button0 = (Button) findViewById(R.id.button0);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.action0();
            }
        });

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.action1();
            }
        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.action2();
            }
        });

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.action3();
            }
        });

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.action4();
            }
        });

        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.action5();
            }
        });

        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.action6();
            }
        });

        button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.action7();
            }
        });

        button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.action8();
            }
        });

        button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.action9();
            }
        });

        buttonSum = (Button) findViewById(R.id.buttonSum);
        buttonSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.actionSum();
            }
        });

        buttonDif = (Button) findViewById(R.id.buttonDif);
        buttonDif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.actionDif();
            }
        });

        buttonMult = (Button) findViewById(R.id.buttonMult);
        buttonMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.actionMult();
            }
        });

        buttonDiv = (Button) findViewById(R.id.buttonDiv);
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.actionDiv();
            }
        });

        buttonEq = (Button) findViewById(R.id.buttonEq);
        buttonEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.actionEq();
            }
        });
    }
}