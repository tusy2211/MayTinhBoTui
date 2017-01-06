package helloworld.cse.khanh.maytinhbotui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtNumber;
    private TextView txtResult;
    private Button btnNumber1;
    private Button btnNumber2;
    private Button btnNumber3;
    private Button btnNumber4;
    private Button btnNumber5;
    private Button btnNumber6;
    private Button btnNumber7;
    private Button btnNumber8;
    private Button btnNumber9;
    private Button btnNumber0;
    private Button btnCong;
    private Button btnTru;
    private Button btnNhan;
    private Button btnChia;
    private Button btnPoint;
    private Button btnResult;
    private Button btnClear;
    private Button btnClearAll;
    private final String TAG = getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        setEventClickViews();
    }

    public void initWidget(){
        edtNumber = (EditText) findViewById(R.id.edt_input);
        txtResult = (TextView) findViewById(R.id.txt_result);
        btnNumber0 = (Button) findViewById(R.id.btnNumber0);
        btnNumber1 = (Button) findViewById(R.id.btnNumber1);
        btnNumber2 = (Button) findViewById(R.id.btnNumber2);
        btnNumber3 = (Button) findViewById(R.id.btnNumber3);
        btnNumber4 = (Button) findViewById(R.id.btnNumber4);
        btnNumber5 = (Button) findViewById(R.id.btnNumber5);
        btnNumber6 = (Button) findViewById(R.id.btnNumber6);
        btnNumber7 = (Button) findViewById(R.id.btnNumber7);
        btnNumber8 = (Button) findViewById(R.id.btnNumber8);
        btnNumber9 = (Button) findViewById(R.id.btnNumber9);
        btnCong = (Button) findViewById(R.id.btnCong);
        btnTru = (Button) findViewById(R.id.btnTru);
        btnNhan = (Button) findViewById(R.id.btnNhan);
        btnChia = (Button) findViewById(R.id.btnChia);
        btnPoint = (Button) findViewById(R.id.btnPoint);
        btnResult = (Button) findViewById(R.id.btnResult);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnClearAll = (Button) findViewById(R.id.btnClearAll);
    }

    public void setEventClickViews(){
        btnNumber0.setOnClickListener(this);
        btnNumber1.setOnClickListener(this);
        btnNumber2.setOnClickListener(this);
        btnNumber3.setOnClickListener(this);
        btnNumber4.setOnClickListener(this);
        btnNumber5.setOnClickListener(this);
        btnNumber6.setOnClickListener(this);
        btnNumber7.setOnClickListener(this);
        btnNumber8.setOnClickListener(this);
        btnNumber9.setOnClickListener(this);

        btnCong.setOnClickListener(this);
        btnTru.setOnClickListener(this);
        btnNhan.setOnClickListener(this);
        btnChia.setOnClickListener(this);
        btnPoint.setOnClickListener(this);
        btnResult.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnClearAll.setOnClickListener(this);

    }

    // Mang chua cac phep tinh
    public ArrayList<String> arrOperation;
    // Mang chua cac so
    public ArrayList<Double> arrNumber;

    // lay tat ca cac phep tinh luu vao mang addOperation
    public int addOperation(String input){
        arrOperation = new ArrayList<>();
        char[] cArrays = input.toCharArray();
        for (int i = 0; i < cArrays.length; i++){
            switch (cArrays[i]){
                case '+':
                    arrOperation.add(cArrays[i] + "");
                    break;
                case '-':
                    arrOperation.add(cArrays[i] + "");
                    break;
                case '*':
                    arrOperation.add(cArrays[i] + "");
                    break;
                case '/':
                    arrOperation.add(cArrays[i] + "");
                    break;
                default:
                    break;
            }
        }
        return 0;
    }

    //Lay tat ca cac so luu vao mang arrNumber
    public void addNumber(String stringInput){
        arrNumber = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(stringInput);
        while (matcher.find()){
            arrNumber.add(Double.parseDouble(matcher.group(1)));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnNumber0:
                //Todo
                edtNumber.append("0");
                break;
            case R.id.btnNumber1:
                //Todo
                edtNumber.append("1");
                break;
            case R.id.btnNumber2:
                //Todo
                edtNumber.append("2");
                break;
            case R.id.btnNumber3:
                //Todo
                edtNumber.append("3");
                break;
            case R.id.btnNumber4:
                //Todo
                edtNumber.append("4");
                break;
            case R.id.btnNumber5:
                //Todo
                edtNumber.append("5");
                break;
            case R.id.btnNumber6:
                //Todo
                edtNumber.append("6");
                break;
            case R.id.btnNumber7:
                //Todo
                edtNumber.append("7");
                break;
            case R.id.btnNumber8:
                //Todo
                edtNumber.append("8");
                break;
            case R.id.btnNumber9:
                //Todo
                edtNumber.append("9");
                break;
            case R.id.btnCong:
                //Todo
                edtNumber.append("+");
                break;
            case R.id.btnTru:
                //Todo
                edtNumber.append("-");
                break;
            case R.id.btnNhan:
                //Todo
                edtNumber.append("*");
                break;
            case R.id.btnChia:
                //Todo
                edtNumber.append("/");
                break;
            case R.id.btnPoint:
                //Todo
                edtNumber.append(".");
                break;
            case R.id.btnClear:
                //Todo
//                String numberAferRemove = deleteNumber(edtNumber.getText().toString());
//                edtNumber.setText(numberAferRemove);
                BaseInputConnection textFieldInputConnection = new BaseInputConnection(edtNumber, true);
                textFieldInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                break;
            case R.id.btnClearAll:
                //Todo
                edtNumber.setText("");
                break;
            case R.id.btnResult:
                //Todo
                DecimalFormat df = new DecimalFormat("###.########");
                double result = 0;
                addOperation(edtNumber.getText().toString());
                addNumber(edtNumber.getText().toString());
                // Thuat toan tinh toan bieu thuc
                if(arrOperation.size() >= arrNumber.size()){
                    txtResult.setText("Wrong Format");
                }else{
                    for (int i = 0; i < (arrNumber.size() - 1); i++){
                        switch (arrOperation.get(i)){
                            case "+":
                                if(i == 0){
                                    result = arrNumber.get(i) + arrNumber.get(i+1);
                                }else{
                                    result = result + arrNumber.get(i+1);
                                }
                                break;
                            case "-":
                                if(i == 0){
                                    result = arrNumber.get(i) - arrNumber.get(i+1);
                                }else{
                                    result = result - arrNumber.get(i+1);
                                }
                                break;
                            case "*":
                                if(i == 0){
                                    result = arrNumber.get(i) * arrNumber.get(i+1);
                                }else{
                                    result = result * arrNumber.get(i+1);
                                }
                                break;
                            case "/":
                                if(i == 0){
                                    result = arrNumber.get(i) / arrNumber.get(i+1);
                                }else{
                                    result = result / arrNumber.get(i+1);
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    txtResult.setText(df.format(result) + "");
                    Log.d(TAG, "onClick: " + result);
                }

        }
    }
        // xu ly String delete
//    public String deleteNumber(String number){
//        int length = number.length();
//        String temp = number.substring(0,length - 1);
//        return temp;
//    }
}
