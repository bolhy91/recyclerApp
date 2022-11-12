package com.bolhy91.recyclerapp.pages

import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bolhy91.recyclerapp.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

@Composable
fun SettingScreen(activity: Activity) {


    val GOOGLE_SIGN_IN = 100
    val context = LocalContext.current

//    var resultLauncher =
//        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//            if (result.resultCode == 100) {
//                // There are no request codes
//                val data: Intent? = result.data
//                Log.i("GOOGLE LOGIN: ", result.data.toString())
//            }
//        }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = 15.dp, top = 25.dp, end = 15.dp
            )
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Iniciar sesión",
                style = MaterialTheme.typography.h3,
                modifier = Modifier.clickable {
                    val googleConf =
                        GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                            .requestIdToken(activity.getString(R.string.default_web_client_id))
                            .requestEmail().build()
                    val googleClient = GoogleSignIn.getClient(context, googleConf)
                    activity.startActivityForResult(googleClient.signInIntent, GOOGLE_SIGN_IN)
                })
            Icon(painter = painterResource(id = R.drawable.ic_google), contentDescription = null)
        }
    }
}