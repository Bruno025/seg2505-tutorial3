package com.example.tutoriel3;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {

    private DatabaseReference mDatabase;
    

        public String username;
        public String email;

        public User() {
            // Default constructor required for calls to DataSnapshot.getValue(User.class)
        }

        public User(DatabaseReference mDatabase, String username, String email) {
            this.mDatabase = mDatabase;
            this.username = username;
            this.email = email;
        }

    public void writeNewUser(String userId, String name, String email) {
        User user = new User(mDatabase, name, email);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("users").child(userId).setValue(user);
    }


}