package com.example.evaluacion_final.view

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.widget.addTextChangedListener
import com.example.evaluacion_final.R
import com.example.evaluacion_final.databinding.ActivityLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.lang.Exception

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var googleLauncher: ActivityResultLauncher<Intent>
    private lateinit var sharedPreferences:SharedPreferences
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mostrarLogin()

        sharedPreferences = getSharedPreferences(SESSION_PREFERENCE, MODE_PRIVATE)
        firebaseAuth = Firebase.auth
        googleLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode === RESULT_OK){
                val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(it.data)
                try{
                    val account = task.getResult(ApiException::class.java)
                    signInFirebaseWithGoogle(account.idToken)
                } catch (e:Exception){

                }
            }
        }
    }

    private fun signInFirebaseWithGoogle(idToken: String?) {
        val authCredential = GoogleAuthProvider.getCredential(idToken, null)
        firebaseAuth.signInWithCredential(authCredential)
            .addOnCompleteListener(this){
                if(it.isSuccessful){
                    val user: FirebaseUser = firebaseAuth.currentUser!!
                    sharedPreferences.edit().apply {
                        putString(EMAIL, user.email)
                            .apply()
                    }
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    Toast.makeText(this, "Ocurrió un error", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun mostrarLogin(){
        binding.tilEmail.editText?.addTextChangedListener {text ->
            binding.btnLogin.isEnabled = validarEntrada(text.toString(), binding.tilPassword.editText?.text.toString())
        }
        binding.tilPassword.editText?.addTextChangedListener {text ->
            binding.btnLogin.isEnabled = validarEntrada(binding.tilEmail.editText?.text.toString(), text.toString())
        }
        binding.btnLogin.setOnClickListener{
//            val email = binding.tilEmail.editText?.text.toString()
//            val password = binding.tilPassword.editText?.text.toString()
//            if (validarDatos(email, password)) {
//                val intent = Intent(this, MainActivity::class.java)
//                startActivity(intent)
//                finish()
//            } else {
//                Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
//            }
            signInWithEmailPassword()
        }
        binding.btnGoogle.setOnClickListener {
            ingresarGoogle()
        }
        binding.btnSingUp.setOnClickListener{
            signUpWithEmailPassword()
        }
    }

    private fun signUpWithEmailPassword() {
        val email = binding.tilEmail.editText?.text.toString()
        val password = binding.tilPassword.editText?.text.toString()
        if(validarEntrada(email, password)){
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this){
                    if(it.isSuccessful){
                        Toast.makeText(this, "Usuario creado correctamente", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "El usuario no pudo ser creado", Toast.LENGTH_SHORT).show()
                    }
                }
        }else{
            Toast.makeText(this, "Credenciales no válidas", Toast.LENGTH_SHORT).show()
        }
    }

    private fun signInWithEmailPassword() {
        val email = binding.tilEmail.editText?.text.toString()
        val password = binding.tilPassword.editText?.text.toString()
        signInFirebaseWithEmail(email,password)
    }

    private fun signInFirebaseWithEmail(email: String, password: String) {
        if (validarEntrada(email, password)) {
            firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = firebaseAuth.currentUser!!
                        sharedPreferences.edit().apply {
                            putString(EMAIL, user.email)
                                .apply()
                        }
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this, "El usuario no se encontró", Toast.LENGTH_SHORT).show()
                    }
                }
        } else {
            Toast.makeText(this, "Ingresa correo electrónico y contraseña", Toast.LENGTH_SHORT).show()
        }
    }

    private fun ingresarGoogle(){
        val googleSignOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.web_client_id))
            .requestEmail().build()
        val client: GoogleSignInClient = GoogleSignIn.getClient(this, googleSignOptions)
        val intent = client.signInIntent
        googleLauncher.launch(intent)
    }

    private fun validarEntrada(email: String, password: String): Boolean{
        val isEmailOk = email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val isPasswordOk = password.length >= 6
        return isPasswordOk && isEmailOk
    }

    private fun validarDatos(email: String, password: String): Boolean{
        val isEmailOk = email == "ejemplo@idat.edu.pe"
        val isPasswordOk = password == "123456"
        return isPasswordOk && isEmailOk
    }
    companion object{
        const val SESSION_PREFERENCE: String = "SESSION_PREFERENCES"
        const val EMAIL: String = "EMAIL"
    }
}