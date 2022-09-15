package com.example.seo.bluetoothtestapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Debugging
    private static final String TAG = "BluetoothChat";
    private static final boolean D = true;

    // Message types sent from the BluetoothChatService Handler
    public static final int MESSAGE_STATE_CHANGE = 1;
    public static final int MESSAGE_READ = 2;
    public static final int MESSAGE_WRITE = 3;
    public static final int MESSAGE_DEVICE_NAME = 4;
    public static final int MESSAGE_TOAST = 5;

    // Key names received from the BluetoothChatService Handler
    public static final String DEVICE_NAME = "device_name";
    public static final String TOAST = "toast";

    // Intent request codes
    private static final int REQUEST_CONNECT_DEVICE = 1;
    private static final int REQUEST_ENABLE_BT = 2;
    private static int mode = 1;

   //button flag
    private int btn1_flag=1;
    private int btn2_flag=1;
    private int btn3_flag=1;
    private int btn4_flag=1;
    private int btn5_flag=1;
    private int btn6_flag=1;
    private int btn7_flag=1;
    private int btn8_flag=1;
    private int btn9_flag=1;


    // Layout Views
    private TextView mTitle;
    private ListView mConversationView;
    private EditText mOutEditText;
    private Button mSendButton;
    private Button mode1Button;
    private Button mode2Button;
    private Button mode3Button;
    private Button Button1;
    private Button Button2;
    private Button Button3;
    private Button Button4;
    private Button Button5;
    private Button Button6;
    private Button Button7;
    private Button Button8;
    private Button Button9;

    // Name of the connected device
    private String mConnectedDeviceName = null;
    // Array adapter for the conversation thread
    private ArrayAdapter<String> mConversationArrayAdapter;
    // String buffer for outgoing messages
    private StringBuffer mOutStringBuffer;
    // Local Bluetooth adapter
    private BluetoothAdapter mBluetoothAdapter = null;
    // Member object for the chat services
    private BluetoothService mChatService = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (D) Log.e(TAG, "+++ ON CREATE +++");

        // Set up the window layout
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activity_main);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.custom_title);

        // Set up the custom title
        mTitle = (TextView) findViewById(R.id.title_left_text);
        mTitle.setText(R.string.app_name);
        mTitle = (TextView) findViewById(R.id.title_right_text);

        // Get local Bluetooth adapter
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        // If the adapter is null, then Bluetooth is not supported
        if (mBluetoothAdapter == null) {
            Toast.makeText(this, "Bluetooth is not available", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        mode1Button=(Button)findViewById(R.id.mode1btn);
        mode2Button=(Button)findViewById(R.id.mode2btn);
        mode3Button=(Button)findViewById(R.id.mode3btn);
        Button1=(Button)findViewById(R.id.btn1);
        Button2=(Button)findViewById(R.id.btn2);
        Button3=(Button)findViewById(R.id.btn3);
        Button4=(Button)findViewById(R.id.btn4);
        Button5=(Button)findViewById(R.id.btn5);
        Button6=(Button)findViewById(R.id.btn6);
        Button7=(Button)findViewById(R.id.btn7);
        Button8=(Button)findViewById(R.id.btn8);
        Button9=(Button)findViewById(R.id.btn9);



        mode1Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("모드1", ":  클릭");
                mode=1;
                setbackground();
                sendMessage("q");
                mode1Button.setBackgroundResource(R.color.colorPrimaryDark);
                mode2Button.setBackgroundResource(R.color.colorPrimary);
                mode3Button.setBackgroundResource(R.color.colorPrimary);

            }
        });
        mode2Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("모드2", ":  클릭");
                mode=2;
                setbackground();
                sendMessage("w");
                mode1Button.setBackgroundResource(R.color.colorPrimary);
                mode2Button.setBackgroundResource(R.color.colorPrimaryDark);
                mode3Button.setBackgroundResource(R.color.colorPrimary);
            }
        });
        mode3Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("모드3", ":  클릭");
                mode=3;
                setbackground();
                sendMessage("e");
                mode1Button.setBackgroundResource(R.color.colorPrimary);
                mode2Button.setBackgroundResource(R.color.colorPrimary);
                mode3Button.setBackgroundResource(R.color.colorPrimaryDark);
            }
        });

        Button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(btn1_flag==1){btn1_flag=0;sendMessage("1o");}else{btn1_flag=1;sendMessage("1f");} setbackground();
                //sendMessage("1");
            }
        });
        Button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(btn2_flag==1){btn2_flag=0;sendMessage("2o");}else{btn2_flag=1;sendMessage("2f");}  setbackground();
                //sendMessage("2");
            }
        });
        Button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(btn3_flag==1){btn3_flag=0;sendMessage("3o");}else{btn3_flag=1;sendMessage("3f");}  setbackground();
                //sendMessage("3");
            }
        });
        Button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(btn4_flag==1){btn4_flag=0;sendMessage("4o");}else{btn4_flag=1;sendMessage("4f");}    setbackground();
                //sendMessage("4");
            }
        });
        Button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(btn5_flag==1){btn5_flag=0;sendMessage("5o");}else{btn5_flag=1;sendMessage("5f");}    setbackground();
                //sendMessage("5");
            }
        });
        Button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(btn6_flag==1){btn6_flag=0;sendMessage("6o");}else{btn6_flag=1;sendMessage("6f");}    setbackground();
                //sendMessage("6");
            }
        });
        Button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(btn7_flag==1){btn7_flag=0;sendMessage("7o");}else{btn7_flag=1;sendMessage("7f");}    setbackground();
                //sendMessage("7");
            }
        });
        Button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(btn8_flag==1){btn8_flag=0;sendMessage("8o");}else{btn8_flag=1;sendMessage("8f");}    setbackground();
                //sendMessage("8");
            }
        });
        Button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(btn9_flag==1){btn9_flag=0;sendMessage("9o");}else{btn9_flag=1;sendMessage("9f");}    setbackground();
                //sendMessage("9");
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        if (D) Log.e(TAG, "++ ON START ++");

        // If BT is not on, request that it be enabled.
        // setupChat() will then be called during onActivityResult
        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableIntent, REQUEST_ENABLE_BT);
            // Otherwise, setup the chat session
        } else {
            if (mChatService == null) setupChat();
        }
    }

    @Override
    public synchronized void onResume() {
        super.onResume();
        if (D) Log.e(TAG, "+ ON RESUME +");

        // Performing this check in onResume() covers the case in which BT was
        // not enabled during onStart(), so we were paused to enable it...
        // onResume() will be called when ACTION_REQUEST_ENABLE activity returns.
        if (mChatService != null) {
            // Only if the state is STATE_NONE, do we know that we haven't started already
            if (mChatService.getState() == BluetoothService.STATE_NONE) {
                // Start the Bluetooth chat services
                mChatService.start();
            }
        }
    }

    private void setupChat() {
        Log.d(TAG, "setupChat()");

        // Initialize the array adapter for the conversation thread
        mConversationArrayAdapter = new ArrayAdapter<String>(this, R.layout.message);
        mConversationView = (ListView) findViewById(R.id.in);
        mConversationView.setAdapter(mConversationArrayAdapter);

        // Initialize the compose field with a listener for the return key
        mOutEditText = (EditText) findViewById(R.id.edit_text_out);
        mOutEditText.setOnEditorActionListener(mWriteListener);

        // Initialize the send button with a listener that for click events
        mSendButton = (Button) findViewById(R.id.button_send);
        mSendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Send a message using content of the edit text widget
                TextView view = (TextView) findViewById(R.id.edit_text_out);
                String message = view.getText().toString();
                sendMessage(message);
            }
        });

        // Initialize the BluetoothChatService to perform bluetooth connections
        mChatService = new BluetoothService(this, mHandler);

        // Initialize the buffer for outgoing messages
        mOutStringBuffer = new StringBuffer("");
    }

    @Override
    public synchronized void onPause() {
        super.onPause();
        if (D) Log.e(TAG, "- ON PAUSE -");
    }

    @Override
    public void onStop() {
        super.onStop();
        if (D) Log.e(TAG, "-- ON STOP --");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Stop the Bluetooth chat services
        if (mChatService != null) mChatService.stop();
        if (D) Log.e(TAG, "--- ON DESTROY ---");
    }

    private void ensureDiscoverable() {
        if (D) Log.d(TAG, "ensure discoverable");
        if (mBluetoothAdapter.getScanMode() !=
                BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE) {
            Intent discoverableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
            discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
            startActivity(discoverableIntent);
        }
    }

    /**
     * Sends a message.
     *
     * @param message A string of text to send.
     */
    private void sendMessage(String message) {
        // Check that we're actually connected before trying anything
        if (mChatService.getState() != BluetoothService.STATE_CONNECTED) {
            Toast.makeText(this, R.string.not_connected, Toast.LENGTH_SHORT).show();
            return;
        }

        // Check that there's actually something to send
        if (message.length() > 0) {
            // Get the message bytes and tell the BluetoothChatService to write
            byte[] send = message.getBytes();
            mChatService.write(send);

            // Reset out string buffer to zero and clear the edit text field
            mOutStringBuffer.setLength(0);
            mOutEditText.setText(mOutStringBuffer);
        }
    }

    // The action listener for the EditText widget, to listen for the return key
    private TextView.OnEditorActionListener mWriteListener =
            new TextView.OnEditorActionListener() {
                public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
                    // If the action is a key-up event on the return key, send the message
                    if (actionId == EditorInfo.IME_NULL && event.getAction() == KeyEvent.ACTION_UP) {
                        String message = view.getText().toString();
                        sendMessage(message);
                    }
                    if (D) Log.i(TAG, "END onEditorAction");
                    return true;
                }
            };

    // The Handler that gets information back from the BluetoothChatService
    @SuppressLint("HandlerLeak")
    private final Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MESSAGE_STATE_CHANGE:
                    if (D) Log.i(TAG, "MESSAGE_STATE_CHANGE: " + msg.arg1);
                    switch (msg.arg1) {
                        case BluetoothService.STATE_CONNECTED:
                            mTitle.setText(R.string.title_connected_to);
                            mTitle.append(mConnectedDeviceName);
                            mConversationArrayAdapter.clear();
                            break;
                        case BluetoothService.STATE_CONNECTING:
                            mTitle.setText(R.string.title_connecting);
                            break;
                        case BluetoothService.STATE_LISTEN:
                        case BluetoothService.STATE_NONE:
                            mTitle.setText(R.string.title_not_connected);
                            break;
                    }
                    break;
                case MESSAGE_WRITE:
                    byte[] writeBuf = (byte[]) msg.obj;
                    // construct a string from the buffer
                    String writeMessage = new String(writeBuf);
                    mConversationArrayAdapter.add("Me:  " + writeMessage);
                    break;
                case MESSAGE_READ:
                    byte[] readBuf = (byte[]) msg.obj;
                    // construct a string from the valid bytes in the buffer
                    String readMessage = new String(readBuf, 0, msg.arg1);
                    if(readMessage.equals("q")){
                        mConversationArrayAdapter.add("mode : 1");
                        mode=1;
                        setbackground();
                        mode1Button.setBackgroundResource(R.color.colorPrimaryDark);
                        mode2Button.setBackgroundResource(R.color.colorPrimary);
                        mode3Button.setBackgroundResource(R.color.colorPrimary);
                    }
                    if(readMessage.equals("w")){
                        mConversationArrayAdapter.add("mode : 2");
                        mode=2;
                        setbackground();
                        mode1Button.setBackgroundResource(R.color.colorPrimary);
                        mode2Button.setBackgroundResource(R.color.colorPrimaryDark);
                        mode3Button.setBackgroundResource(R.color.colorPrimary);
                    }
                    if(readMessage.equals("e")){
                        mConversationArrayAdapter.add("mode : 3");
                        mode=3;
                        setbackground();
                        mode1Button.setBackgroundResource(R.color.colorPrimary);
                        mode2Button.setBackgroundResource(R.color.colorPrimary);
                        mode3Button.setBackgroundResource(R.color.colorPrimaryDark);
                    }

                    if(readMessage.equals("1o")){
                        mConversationArrayAdapter.add("btn1 : on");
                        btn1_flag=0;
                        setbackground();
                    }
                    if(readMessage.equals("1f")){
                        mConversationArrayAdapter.add("btn1 : off");
                        btn1_flag=1;
                        setbackground();
                    }

                    if(readMessage.equals("2o")){
                        mConversationArrayAdapter.add("btn2 : on");
                        btn2_flag=0;
                        setbackground();
                    }
                    if(readMessage.equals("2f")){
                        mConversationArrayAdapter.add("btn2 : off");
                        btn2_flag=1;
                        setbackground();
                    }

                    if(readMessage.equals("3o")){
                        mConversationArrayAdapter.add("btn3 : on");
                        btn3_flag=0;
                        setbackground();
                    }
                    if(readMessage.equals("3f")){
                        mConversationArrayAdapter.add("btn3 : off");
                        btn3_flag=1;
                        setbackground();
                    }


                    if(readMessage.equals("4o")){
                        mConversationArrayAdapter.add("btn4 : on");
                        btn4_flag=0;
                        setbackground();
                    }
                    if(readMessage.equals("4f")){
                        mConversationArrayAdapter.add("btn4 : off");
                        btn4_flag=1;
                        setbackground();
                    }


                    if(readMessage.equals("5o")){
                        mConversationArrayAdapter.add("btn5 : on");
                        btn5_flag=0;
                        setbackground();
                    }
                    if(readMessage.equals("5f")){
                        mConversationArrayAdapter.add("btn5 : off");
                        btn5_flag=1;
                        setbackground();
                    }


                    if(readMessage.equals("6o")){
                        mConversationArrayAdapter.add("btn6 : on");
                        btn6_flag=0;
                        setbackground();
                    }
                    if(readMessage.equals("6f")){
                        mConversationArrayAdapter.add("btn6 : off");
                        btn6_flag=1;
                        setbackground();
                    }


                    if(readMessage.equals("7o")){
                        mConversationArrayAdapter.add("btn7 : on");
                        btn7_flag=0;
                        setbackground();
                    }

                    if(readMessage.equals("7f")){
                        mConversationArrayAdapter.add("btn7 : off");
                        btn7_flag=1;
                        setbackground();
                    }


                    if(readMessage.equals("8o")){
                        mConversationArrayAdapter.add("btn8 : on");
                        btn8_flag=0;
                        setbackground();
                    }
                    if(readMessage.equals("8f")){
                        mConversationArrayAdapter.add("btn8 : off");
                        btn8_flag=1;
                        setbackground();
                    }


                    if(readMessage.equals("9o")){
                        mConversationArrayAdapter.add("btn9 : on");
                        btn9_flag=0;
                        setbackground();
                    }
                    if(readMessage.equals("9f")){
                        mConversationArrayAdapter.add("btn9 : off");
                        btn9_flag=1;
                        setbackground();
                    }
                    //mConversationArrayAdapter.add(mConnectedDeviceName + ":  " + readMessage);
                    break;
                case MESSAGE_DEVICE_NAME:
                    // save the connected device's name
                    mConnectedDeviceName = msg.getData().getString(DEVICE_NAME);
                    Toast.makeText(getApplicationContext(), "Connected to "
                            + mConnectedDeviceName, Toast.LENGTH_SHORT).show();
                    break;
                case MESSAGE_TOAST:
                    Toast.makeText(getApplicationContext(), msg.getData().getString(TOAST),
                            Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (D) Log.d(TAG, "onActivityResult " + resultCode);
        switch (requestCode) {
            case REQUEST_CONNECT_DEVICE:
                // When DeviceListActivity returns with a device to connect
                if (resultCode == Activity.RESULT_OK) {
                    // Get the device MAC address
                    String address = data.getExtras()
                            .getString(DeviceListActivity.EXTRA_DEVICE_ADDRESS);
                    // Get the BLuetoothDevice object
                    BluetoothDevice device = mBluetoothAdapter.getRemoteDevice(address);
                    // Attempt to connect to the device
                    mChatService.connect(device);
                }
                break;
            case REQUEST_ENABLE_BT:
                // When the request to enable Bluetooth returns
                if (resultCode == Activity.RESULT_OK) {
                    // Bluetooth is now enabled, so set up a chat session
                    setupChat();
                } else {
                    // User did not enable Bluetooth or an error occured
                    Log.d(TAG, "BT not enabled");
                    Toast.makeText(this, R.string.bt_not_enabled_leaving, Toast.LENGTH_SHORT).show();
                    finish();
                }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.scan:
                // Launch the DeviceListActivity to see devices and do scan
                Intent serverIntent = new Intent(this, DeviceListActivity.class);
                startActivityForResult(serverIntent, REQUEST_CONNECT_DEVICE);
                return true;
            case R.id.discoverable:
                // Ensure this device is discoverable by others
                ensureDiscoverable();
                return true;
        }
        return false;
    }


    private void setbackground(){
        if(mode==1){
            if(btn1_flag==1){Button1.setBackgroundResource(R.color.color11);}
            else{Button1.setBackgroundResource(R.color.color12);}
            if(btn2_flag==1){Button2.setBackgroundResource(R.color.color11);}
            else{Button2.setBackgroundResource(R.color.color12);}
            if(btn3_flag==1){Button3.setBackgroundResource(R.color.color11);}
            else{Button3.setBackgroundResource(R.color.color12);}
            if(btn4_flag==1){Button4.setBackgroundResource(R.color.color11);}
            else{Button4.setBackgroundResource(R.color.color12);}
            if(btn5_flag==1){Button5.setBackgroundResource(R.color.color11);}
            else{Button5.setBackgroundResource(R.color.color12);}
            if(btn6_flag==1){Button6.setBackgroundResource(R.color.color11);}
            else{Button6.setBackgroundResource(R.color.color12);}
            if(btn7_flag==1){Button7.setBackgroundResource(R.color.color11);}
            else{Button7.setBackgroundResource(R.color.color12);}
            if(btn8_flag==1){Button8.setBackgroundResource(R.color.color11);}
            else{Button8.setBackgroundResource(R.color.color12);}
            if(btn9_flag==1){Button9.setBackgroundResource(R.color.color11);}
            else{Button9.setBackgroundResource(R.color.color12);}
        }
        if(mode==2){
            if(btn1_flag==1){Button1.setBackgroundResource(R.color.color21);}
            else{Button1.setBackgroundResource(R.color.color22);}
            if(btn2_flag==1){Button2.setBackgroundResource(R.color.color21);}
            else{Button2.setBackgroundResource(R.color.color22);}
            if(btn3_flag==1){Button3.setBackgroundResource(R.color.color21);}
            else{Button3.setBackgroundResource(R.color.color22);}
            if(btn4_flag==1){Button4.setBackgroundResource(R.color.color21);}
            else{Button4.setBackgroundResource(R.color.color22);}
            if(btn5_flag==1){Button5.setBackgroundResource(R.color.color21);}
            else{Button5.setBackgroundResource(R.color.color22);}
            if(btn6_flag==1){Button6.setBackgroundResource(R.color.color21);}
            else{Button6.setBackgroundResource(R.color.color22);}
            if(btn7_flag==1){Button7.setBackgroundResource(R.color.color21);}
            else{Button7.setBackgroundResource(R.color.color22);}
            if(btn8_flag==1){Button8.setBackgroundResource(R.color.color21);}
            else{Button8.setBackgroundResource(R.color.color22);}
            if(btn9_flag==1){Button9.setBackgroundResource(R.color.color21);}
            else{Button9.setBackgroundResource(R.color.color22);}
        }
        if(mode==3){
            if(btn1_flag==1){Button1.setBackgroundResource(R.color.color31);}
            else{Button1.setBackgroundResource(R.color.color32);}
            if(btn2_flag==1){Button2.setBackgroundResource(R.color.color31);}
            else{Button2.setBackgroundResource(R.color.color32);}
            if(btn3_flag==1){Button3.setBackgroundResource(R.color.color31);}
            else{Button3.setBackgroundResource(R.color.color32);}
            if(btn4_flag==1){Button4.setBackgroundResource(R.color.color31);}
            else{Button4.setBackgroundResource(R.color.color32);}
            if(btn5_flag==1){Button5.setBackgroundResource(R.color.color31);}
            else{Button5.setBackgroundResource(R.color.color32);}
            if(btn6_flag==1){Button6.setBackgroundResource(R.color.color31);}
            else{Button6.setBackgroundResource(R.color.color32);}
            if(btn7_flag==1){Button7.setBackgroundResource(R.color.color31);}
            else{Button7.setBackgroundResource(R.color.color32);}
            if(btn8_flag==1){Button8.setBackgroundResource(R.color.color31);}
            else{Button8.setBackgroundResource(R.color.color32);}
            if(btn9_flag==1){Button9.setBackgroundResource(R.color.color31);}
            else{Button9.setBackgroundResource(R.color.color32);}
        }
    }

}


