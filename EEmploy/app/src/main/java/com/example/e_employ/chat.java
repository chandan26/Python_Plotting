package com.example.e_employ;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.nio.channels.Channel;

public class chat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        MessageAdapter messageAdapter;
        EditText messageInput;
        Button sendButton;
        String username;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            username = this.getIntent().getExtras().getString("username");
            Toast.makeText(this, "Welcome, " + username + "!", Toast.LENGTH_LONG).show();

            messageInput = (EditText) findViewById(R.id.message_input);
            messageInput.setOnKeyListener(this);

            sendButton = (Button) findViewById(R.id.send_button);
            sendButton.setOnClickListener(this);

            messageAdapter = new MessageAdapter(this, new ArrayList<Message>());
            final ListView messagesView = (ListView) findViewById(R.id.messages_view);
            messagesView.setAdapter(messageAdapter);

            Pusher pusher = new Pusher("faa685e4bb3003eb825c");

            pusher.connect();

            Channel channel = pusher.subscribe("messages");

            channel.bind("new_message", new SubscriptionEventListener() {
                @Override
                public void onEvent(String channelName, String eventName, final String data) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Gson gson = new Gson();
                            Message message = gson.fromJson(data, Message.class);
                            messageAdapter.add(message);
                            messagesView.setSelection(messageAdapter.getCount() - 1);
                        }

                    });
                }

            });

        }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {

            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }



        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP){
                postMessage();
            }
            return true;
        }

        private void postMessage()  {
            String text = messageInput.getText().toString();

            if (text.equals("")) {
                return;
            }

            RequestParams params = new RequestParams();

            params.put("text", text);
            params.put("name", username);


            AsyncHttpClient client = new AsyncHttpClient();

            client.post(MESSAGES_ENDPOINT + "/messages", params, new JsonHttpResponseHandler(){

                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            messageInput.setText("");
                        }
                    });
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                    Toast.makeText(getApplicationContext(), "Network Issue :(", Toast.LENGTH_LONG).show();
                }
            });

        }

        @Override
        public void onClick(View v) {
            postMessage();
        }
    }
}