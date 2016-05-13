package example.lingnan.com.mycalculator;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2016/5/12 0012.
 */
public class ReceiverActivity extends Activity {

    private final static String SMS_ACTION="android.provider.telphone.SMS_RECEIVED";
    Button btnAdd,btnUnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receiverlayout);
        btnAdd=(Button) findViewById(R.id.btnAddListener);
        btnUnAdd=(Button)findViewById(R.id.btnUnAddlistener);
        btnAdd.setOnClickListener(new AddRegister());

    }

    class AddRegister implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            ReceiverClass receiverClass=new ReceiverClass();
            IntentFilter filter=new IntentFilter();
            filter.addAction(SMS_ACTION);
            registerReceiver(receiverClass,filter);

        }
    }


}
