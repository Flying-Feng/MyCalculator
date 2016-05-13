package example.lingnan.com.mycalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
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
     private Button buttonPoint;
     private Button buttonPlus;
     private Button buttonReduce;
     private Button buttonMulti;
     private Button buttonDivide;
     private Button buttonDel;
     private Button buttonClr;
     private Button buttonEqual;
     private Button buttonLast;
     private TextView txtResult;
     private TextView txtLastResult;

     private String result;
     private String num1;
     private String num2;


    boolean isClick=false;
    boolean isPlusClick=false;
    boolean isReduceClick=false;
    boolean isMultiClick=false;
    boolean isDivideClick=false;
    boolean isPointClick=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
        ButtonClick();


    }

    public void Init()
    {
        button0=(Button)findViewById(R.id.btn0);
        button1=(Button)findViewById(R.id.btn1);
        button2=(Button)findViewById(R.id.btn2);
        button3=(Button)findViewById(R.id.btn3);
        button4=(Button)findViewById(R.id.btn4);
        button5=(Button)findViewById(R.id.btn5);
        button6=(Button)findViewById(R.id.btn6);
        button7=(Button)findViewById(R.id.btn7);
        button8=(Button)findViewById(R.id.btn8);
        button9=(Button)findViewById(R.id.btn9);
        buttonPlus=(Button)findViewById(R.id.btnPlus);
        buttonReduce=(Button)findViewById(R.id.btnReduce);
        buttonMulti=(Button)findViewById(R.id.btnMulti);
        buttonDivide=(Button)findViewById(R.id.btnDiv);
        buttonPoint=(Button)findViewById(R.id.btnPoint);
        buttonClr=(Button)findViewById(R.id.btnCLR);
        buttonDel=(Button)findViewById(R.id.btnDEL);
        buttonEqual=(Button)findViewById(R.id.btnEquil);
        buttonLast=(Button)findViewById(R.id.btnLast);
        txtResult=(TextView)findViewById(R.id.txtResult);
        txtLastResult=(TextView)findViewById(R.id.txtLast);
    }

    public void ButtonClick()
    {
        button0.setOnClickListener(new MyButtonOnClickListener());
        button1.setOnClickListener(new MyButtonOnClickListener());
        button2.setOnClickListener(new MyButtonOnClickListener());
        button3.setOnClickListener(new MyButtonOnClickListener());
        button4.setOnClickListener(new MyButtonOnClickListener());
        button5.setOnClickListener(new MyButtonOnClickListener());
        button6.setOnClickListener(new MyButtonOnClickListener());
        button7.setOnClickListener(new MyButtonOnClickListener());
        button8.setOnClickListener(new MyButtonOnClickListener());
        button9.setOnClickListener(new MyButtonOnClickListener());
        buttonPoint.setOnClickListener(new MyButtonOnClickListener());
        buttonPlus.setOnClickListener(new MyButtonOnClickListener());
        buttonReduce.setOnClickListener(new MyButtonOnClickListener());
        buttonMulti.setOnClickListener(new MyButtonOnClickListener());
        buttonDivide.setOnClickListener(new MyButtonOnClickListener());
        buttonDel.setOnClickListener(new MyButtonOnClickListener());
        buttonClr.setOnClickListener(new MyButtonOnClickListener());

    }

    class MyButtonOnClickListener implements View.OnClickListener
    {

        public void onClick(View v) {


            char tempChar=' ';
            Button button=(Button)v;
            result=txtResult.getText().toString();

            switch (button.getId())
            {
                case R.id.btn0:
                case R.id.btn1:
                case R.id.btn2:
                case R.id.btn3:
                case R.id.btn4:
                case R.id.btn5:
                case R.id.btn6:
                case R.id.btn7:
                case R.id.btn8:
                case R.id.btn9:
                    result=result+button.getText().toString();
                    txtResult.setText(result);
                    isClick=false;
                    isPointClick=false;
                    break;
                case R.id.btnDEL:
                   if(result.length()==0)
                       break;
                    else
                    {
                        result=result.substring(0,result.length()-1);
                        txtResult.setText(result);
                        break;
                    }
                case R.id.btnCLR:
                    result="";
                    txtResult.setText(result);
                    break;
                case R.id.btnPlus:
                case R.id.btnReduce:
                case R.id.btnMulti:
                case R.id.btnDiv:
                case R.id.btnPoint:

                    if(!isClick)
                    {
                        result=result+button.getText().toString();
                        txtResult.setText(result);
                        isClick=true;
                        break;
                    }
                    else
                    {
                        tempChar=result.charAt(result.length()-1);
                        if(tempChar=='+'||tempChar=='-'||tempChar=='×'||tempChar=='÷'||tempChar=='.')
                        {
                            result=result.substring(0,result.length()-1)+button.getText().toString();
                            txtResult.setText(result);
                            isClick=true;
                            break;
                        }
                        else
                            break;
                    }



            }

        }
    }
}

