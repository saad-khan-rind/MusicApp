package com.saadullahkhan.i190474;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ChattingActivity extends AppCompatActivity {
    RecyclerView contactsRecycler;
    ChatListAdapter chatListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);
        contactsRecycler = findViewById(R.id.contactsRecycler);
        contactsRecycler.setLayoutManager(new LinearLayoutManager(ChattingActivity.this));
        chatListAdapter = new ChatListAdapter(loadContacts(), ChattingActivity.this);
        contactsRecycler.setAdapter(chatListAdapter);
    }

    private ArrayList<User> loadContacts() {
        Cursor cursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,null,null,null,ContactsContract.CommonDataKinds.Phone.NUMBER);
        ArrayList<User> arrayList = new ArrayList<>();
        if(cursor.getCount()>0) {
            while (cursor.moveToNext()) {
                int idIndex = cursor.getColumnIndex(ContactsContract.Contacts._ID);
                String id = cursor.getString(idIndex);
                int numberIndex = cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER);
                String number = cursor.getString(numberIndex);
                if(number.length()>0){
                    Cursor phoneCursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID+"=?",new String[] {id},null);
                    if(phoneCursor.getCount()>0){
                        while (phoneCursor.moveToNext()){
                            int phoneNumberIndex = phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                            String phoneNumber = phoneCursor.getString(phoneNumberIndex);
                            FirebaseDatabase.getInstance().getReference("Users").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    for(DataSnapshot one:snapshot.getChildren()){
                                        if(phoneNumber.equals(one.child("number").toString())){
                                            arrayList.add(new User(one.child("name").toString(),one.child("number").toString(),one.child("password").toString()));
                                        }
                                    }
                                }
                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });
                        }
                    }
                    phoneCursor.close();
                }
            }
        }
        cursor.close();
        return arrayList;

    }
}