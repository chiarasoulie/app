package com.example.firstapplicationchiara

import android.content.Context
import android.graphics.fonts.FontStyle
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.window.core.layout.WindowHeightSizeClass
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import com.example.firstapplicationchiara.ui.theme.FirstApplicationChiaraTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
            FirstApplicationChiaraTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding),
                        windowSizeClass
                    )
                }
            }

        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier ,classes: WindowSizeClass) {
    val classeLargeur = classes.windowWidthSizeClass
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        when (classeLargeur) {
            WindowWidthSizeClass.COMPACT -> {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    ProfileSection()
                    InformationSection()
                    ContactSection()
                    Spacer(Modifier.height(100.dp))
                    StartButton()
                }

            }/* largeur faible */
                else -> {
                    Row(){
                        Column(horizontalAlignment = AbsoluteAlignment.Left) {
                            ProfileSection()
                            InformationSection()
                        }
                        Spacer(Modifier.height(300.dp))
                        Column (horizontalAlignment = Alignment.CenterHorizontally){
                            ContactSection()
                            Spacer(Modifier.height(50.dp))
                            StartButton()
                        }
                    }


                }


        }
    }
}

@Composable
fun ProfileSection() {
    Image(
        painter = painterResource(R.drawable.th_1795365130),
        contentDescription = "Profile",
        modifier = Modifier
            .size(100.dp) // Taille de l'image
            .clip(CircleShape)
    )

    Text(
        text = "Chiara Soulié",
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
    )
}

@Composable
fun InformationSection() {
    Text(text = "Étudiante en e-santé")
    Text(
        text = "École d'ingénieur ISIS",
        fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
    )
    Spacer(Modifier.height(60.dp))
}

@Composable
fun ContactSection() {
    Contactligne(
        iconRes = R.drawable.th_349871517,
        contactText = "souliechiara@gmail.com"
    )
    Contactligne(
        iconRes = R.drawable.th_3906094816,
        contactText = "www.linkedin.com/in/chiarasoulié"
    )
}

@Composable
fun Contactligne(iconRes: Int, contactText: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(iconRes),
            contentDescription = null,
            modifier = Modifier
                .size(30.dp)
                .padding(end = 8.dp)
        )
        Text(text = contactText)
    }
}

@Composable
fun StartButton() {
    Button(onClick = { /* Add your action */ }) {
        Text("Démarrer")
    }
}






@Composable
fun MyScreen(showTopAppBar: Boolean) {

}