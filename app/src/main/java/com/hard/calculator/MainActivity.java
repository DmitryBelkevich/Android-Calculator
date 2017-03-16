package com.hard.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findElements();
        addListeners();

        // Hello World
    }

    public void findElements() {
        textView = (TextView) findViewById(R.id.textView1);
        buttonClear = (Button) findViewById(R.id.buttonClear);
        buttonBackspace = (Button) findViewById(R.id.buttonBackspace);
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonSum = (Button) findViewById(R.id.buttonSum);
        buttonDif = (Button) findViewById(R.id.buttonDif);
        buttonMult = (Button) findViewById(R.id.buttonMult);
        buttonDiv = (Button) findViewById(R.id.buttonDiv);
        buttonEq = (Button) findViewById(R.id.buttonEq);
    }

    public void addListeners() {
        Receiver receiver = new Receiver();

        buttonClear.setOnClickListener(new ActionClearCommand(receiver));
        buttonBackspace.setOnClickListener(new ActionBackspaceCommand(receiver));
        button0.setOnClickListener(new Action0Command(receiver));
        button1.setOnClickListener(new Action1Command(receiver));
        button2.setOnClickListener(new Action2Command(receiver));
        button3.setOnClickListener(new Action3Command(receiver));
        button4.setOnClickListener(new Action4Command(receiver));
        button5.setOnClickListener(new Action5Command(receiver));
        button6.setOnClickListener(new Action6Command(receiver));
        button7.setOnClickListener(new Action7Command(receiver));
        button8.setOnClickListener(new Action8Command(receiver));
        button9.setOnClickListener(new Action9Command(receiver));
        buttonSum.setOnClickListener(new ActionSumCommand(receiver));
        buttonDif.setOnClickListener(new ActionDifCommand(receiver));
        buttonMult.setOnClickListener(new ActionMultCommand(receiver));
        buttonDiv.setOnClickListener(new ActionDivCommand(receiver));
        buttonEq.setOnClickListener(new ActionEqCommand(receiver));
    }

    /*
    Design pattern - Command
     */
    private class Receiver {
        private double cache;
        private Operation operation;

        public void actionClear() {
            String buffer = textView.getText().toString();

            if (!buffer.equals("0")) {
                textView.setText("0");
                cache = 0;
                operation = null;
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
            cache = Double.valueOf(textView.getText().toString());
            operation = Operation.SUM;

            textView.setText("0");
        }

        public void actionDif() {
            cache = Double.valueOf(textView.getText().toString());
            operation = Operation.DIF;

            textView.setText("0");
        }

        public void actionMult() {
            cache = Double.valueOf(textView.getText().toString());
            operation = Operation.MULT;

            textView.setText("0");
        }

        public void actionDiv() {
            cache = Double.valueOf(textView.getText().toString());
            operation = Operation.DIV;

            textView.setText("0");
        }

        public void actionEq() {
            double buffer = Double.valueOf(textView.getText().toString());

            double result = 0;

            if (operation != null) {
                switch (operation) {
                    case SUM:
                        result = cache + buffer;
                        break;
                    case DIF:
                        result = cache - buffer;
                        break;
                    case MULT:
                        result = cache * buffer;
                        break;
                    case DIV:
                        try {
                            result = cache / buffer;
                        } catch (Exception e) {
                            e.printStackTrace();
                            result = 9999;
                            Toast.makeText(MainActivity.this, "divide by zero", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
            }

            // отбросить ноль

            //cache = buffer;

            textView.setText(String.valueOf(result));
        }
    }

    private class ActionClearCommand implements View.OnClickListener {
        private Receiver receiver;

        private ActionClearCommand(Receiver receiver) {
            this.receiver = receiver;
        }

        @Override
        public void onClick(View v) {
            receiver.actionClear();
        }
    }

    private class ActionBackspaceCommand implements View.OnClickListener {
        private Receiver receiver;

        private ActionBackspaceCommand(Receiver receiver) {
            this.receiver = receiver;
        }

        @Override
        public void onClick(View v) {
            receiver.actionBackspace();
        }
    }

    private class Action0Command implements View.OnClickListener {
        private Receiver receiver;

        private Action0Command(Receiver receiver) {
            this.receiver = receiver;
        }

        @Override
        public void onClick(View v) {
            receiver.action0();
        }
    }

    private class Action1Command implements View.OnClickListener {
        private Receiver receiver;

        private Action1Command(Receiver receiver) {
            this.receiver = receiver;
        }

        @Override
        public void onClick(View v) {
            receiver.action1();
        }
    }

    private class Action2Command implements View.OnClickListener {
        private Receiver receiver;

        private Action2Command(Receiver receiver) {
            this.receiver = receiver;
        }

        @Override
        public void onClick(View v) {
            receiver.action2();
        }
    }

    private class Action3Command implements View.OnClickListener {
        private Receiver receiver;

        private Action3Command(Receiver receiver) {
            this.receiver = receiver;
        }

        @Override
        public void onClick(View v) {
            receiver.action3();
        }
    }

    private class Action4Command implements View.OnClickListener {
        private Receiver receiver;

        private Action4Command(Receiver receiver) {
            this.receiver = receiver;
        }

        @Override
        public void onClick(View v) {
            receiver.action4();
        }
    }

    private class Action5Command implements View.OnClickListener {
        private Receiver receiver;

        private Action5Command(Receiver receiver) {
            this.receiver = receiver;
        }

        @Override
        public void onClick(View v) {
            receiver.action5();
        }
    }

    private class Action6Command implements View.OnClickListener {
        private Receiver receiver;

        private Action6Command(Receiver receiver) {
            this.receiver = receiver;
        }

        @Override
        public void onClick(View v) {
            receiver.action6();
        }
    }

    private class Action7Command implements View.OnClickListener {
        private Receiver receiver;

        private Action7Command(Receiver receiver) {
            this.receiver = receiver;
        }

        @Override
        public void onClick(View v) {
            receiver.action7();
        }
    }

    private class Action8Command implements View.OnClickListener {
        private Receiver receiver;

        private Action8Command(Receiver receiver) {
            this.receiver = receiver;
        }

        @Override
        public void onClick(View v) {
            receiver.action8();
        }
    }

    private class Action9Command implements View.OnClickListener {
        private Receiver receiver;

        private Action9Command(Receiver receiver) {
            this.receiver = receiver;
        }

        @Override
        public void onClick(View v) {
            receiver.action9();
        }
    }

    private class ActionSumCommand implements View.OnClickListener {
        private Receiver receiver;

        private ActionSumCommand(Receiver receiver) {
            this.receiver = receiver;
        }

        @Override
        public void onClick(View v) {
            receiver.actionSum();
        }
    }

    private class ActionDifCommand implements View.OnClickListener {
        private Receiver receiver;

        private ActionDifCommand(Receiver receiver) {
            this.receiver = receiver;
        }

        @Override
        public void onClick(View v) {
            receiver.actionDif();
        }
    }

    private class ActionMultCommand implements View.OnClickListener {
        private Receiver receiver;

        private ActionMultCommand(Receiver receiver) {
            this.receiver = receiver;
        }

        @Override
        public void onClick(View v) {
            receiver.actionMult();
        }
    }

    private class ActionDivCommand implements View.OnClickListener {
        private Receiver receiver;

        private ActionDivCommand(Receiver receiver) {
            this.receiver = receiver;
        }

        @Override
        public void onClick(View v) {
            receiver.actionDiv();
        }
    }

    private class ActionEqCommand implements View.OnClickListener {
        private Receiver receiver;

        private ActionEqCommand(Receiver receiver) {
            this.receiver = receiver;
        }

        @Override
        public void onClick(View v) {
            receiver.actionEq();
        }
    }
}