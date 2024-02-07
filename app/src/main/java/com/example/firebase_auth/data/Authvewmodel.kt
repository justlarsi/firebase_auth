package com.example.firebase_auth.data

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.firebase_auth.navigation.ROUTE_REGISTER
import com.google.firebase.auth.FirebaseAuth

class Authvewmodel(var navController: NavHostController,var context:Context){
    var mAuth:FirebaseAuth

    init {
        mAuth=FirebaseAuth.getInstance()
    }
    fun signup(email:String,pass:String,confpass:String){
        if (email.isEmpty() || pass.isBlank() || confpass.isBlank()){
            Toast.makeText(context,"Please fill in the blanks",Toast.LENGTH_LONG).show()
        }
        else if (pass != confpass){
            Toast.makeText(context,"password is not match",Toast.LENGTH_SHORT).show()
            return
        }
        else {
            mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener {
                if (it.isSuccessful){
                    Toast.makeText(context,"Regesterd succesfully",Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
                }
            }
        }
    }
    fun login(email: String,pass: String){
        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener {
            if (it.isSuccessful){
                Toast.makeText(context,"login succesful",Toast.LENGTH_LONG).show()
//                navController.navigate(ROUTE_REGISTER)
            }
            else{
                Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
            }
        }
    }
    fun logout(){
        mAuth.signOut()
        navController.navigate(com.example.firebase_auth.navigation.ROUTE_LOGIN)
    }
    fun loggedin():Boolean{
        return mAuth.currentUser !=null
    }
}
