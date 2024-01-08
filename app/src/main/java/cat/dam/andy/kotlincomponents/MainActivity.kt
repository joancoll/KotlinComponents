package cat.dam.andy.kotlincomponents

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cat.dam.andy.kotlincomponents.ui.theme.KotlinComponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinComponentsTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                ) {
                    //SimpleText()
                    //TextWithStyle()
                    //SelectableText()
                    //ClickText()
                    //SimpleClickableText()
                    //SimpleTextField()
                    //SpacerDividerExample()
                    //ButtonExample()
                    //MoreButtonExample()
                }

            }
        }
    }
}

@Composable
fun SimpleText() {
    // Text amb estil per defecte
    Text("Hello World")
    Text(text = "Hello World!")
    // Text des de un StringResource
    Text(stringResource(id = R.string.hello_world))
    Text(stringResource(R.string.hello_world))
}


@Composable
fun TextWithStyle() {
    Text("Red", color = Color.Red)
    Text("Size 30sp", fontSize = 30.sp)
    Text("Italic", fontStyle = FontStyle.Italic)
    Text("Bold", fontWeight = FontWeight.Bold)
    Text(
        modifier = Modifier
            .fillMaxWidth(),
        text = "Start", textAlign = TextAlign.Start,
    )
    Text(
        modifier = Modifier
            .fillMaxWidth(),
        text = "Center", textAlign = TextAlign.Center,
    )
    Text(
        modifier = Modifier
            .fillMaxWidth(),
        text = "End", textAlign = TextAlign.End,
    )
    Text("text amb limit 2 linies ".repeat(50), maxLines = 2)
    Text(
        "text amb limit 2 linies i el·lipsis ".repeat(50),
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
    )
    Text(
        text = "Aquest és un exemple amb estil personalitzat",
        modifier = Modifier.padding(top = 8.dp),
        color = Color.Blue,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Italic,
        letterSpacing = 0.5.sp,
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.LineThrough,
        maxLines = 1,
    )
    TextShadow()
    MultipleStylesInText()
    NewFont()
}

@Composable
fun TextShadow() {
    val offset = Offset(5.0f, 10.0f)
    Text(
        text = "Text amb ombra",
        style = TextStyle(
            fontSize = 24.sp,
            shadow = Shadow(
                color = Color.Green,
                offset = offset,
                blurRadius = 3f
            )
        )
    )
}

@Composable
fun MultipleStylesInText() {
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Magenta)) {
                append("Múlt")
            }
            append("iples ")

            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)) {
                append("Es")
            }
            append("tils")
        }
    )
}

@Composable
fun NewFont() {
    val dancingScriptFamily = FontFamily(
        Font(R.font.dancingscript_regular, FontWeight.Normal),
        Font(R.font.dancingscript_medium, FontWeight.Medium),
        Font(R.font.dancingscript_semibold, FontWeight.SemiBold),
        Font(R.font.dancingscript_bold, FontWeight.Bold)
    )
    Text("Font Serif", fontSize = 24.sp, fontFamily = FontFamily.Serif)
    Text("Font Sans-Serif", fontSize = 24.sp, fontFamily = FontFamily.SansSerif)
    Text(
        "NewFont Normal",
        fontSize = 24.sp,
        fontFamily = dancingScriptFamily,
        fontWeight = FontWeight.Normal
    )
    Text(
        "NewFont Bold",
        fontSize = 24.sp,
        fontFamily = dancingScriptFamily,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun SelectableText() {
    SelectionContainer {
        Column {
            Text("Aquest text es pot seleccionar")
            Text("Aquest també")
            Text("Aquest altre també")
            DisableSelection {
                Text("Però aquest no")
                Text("i aquest tampoc")
            }
            Text("Però ara ja pots seleccionar aquest")
            Text("I aquest també")
        }
    }
}

@Composable
fun ClickText() {
    var count by remember { mutableStateOf(0) }
    // Text que es clicable i incrementa el comptador al clicar
    Text(
        text = "Nombre de vegades que has clicat aquest text: $count",
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .clickable {
                count++
            }
    )
}

@Composable
fun SimpleClickableText() {
    ClickableText(
        text = AnnotatedString("Clica a qualsevol part del text per veure la seva posició al Logcat."),
        onClick = { offset ->
            Log.d("ClickableText", "Has clicat al caràcter número: $offset.")
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleTextField() {
    var name by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    TextField(
        value = name,
        onValueChange = { name = it },
        label = { Text("Escriu el teu nom") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
        ),
        singleLine = true,
        textStyle = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue,
            fontFamily = FontFamily.SansSerif,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    )
    TextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Contrasenya") },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        maxLines = 1,
        textStyle = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue,
            fontFamily = FontFamily.SansSerif,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    )
}

@Composable
fun SpacerDividerExample() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Text 1
        Text(
            text = "Primer Text",
            color = Color.Red,
            modifier = Modifier
                .fillMaxWidth()
        )
        // Divider 1
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp),
            color = Color.Gray,
            thickness = 1.dp
        )
        // Spacer
        Spacer(modifier = Modifier.height(30.dp))
        // Text 2
        Text(
            text = "Segon Text",
            color = Color.Blue,
            modifier = Modifier
                .fillMaxWidth()
        )
        // Divider 2
        Divider(
            modifier = Modifier
                .fillMaxWidth(),
            color = Color.Green,
            thickness = 8.dp,
        )
        // Text 3
        Text(
            text = "Tercer Text",
            color = Color.Magenta,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ButtonExample() {
    // Estat per gestionar el color del text
    var textColor by remember { mutableStateOf(Color.Black) }

    // Funció per alternar el color del text entre negre i vermell
    fun onClickButton() {
        textColor = Color.Red.takeIf { textColor == Color.Black } ?: Color.Black
    }

    // Columna per centrar el contingut
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Text amb el color dinàmic
        Text(
            text = "Canvia el color amb els botons!",
            color = textColor,
            modifier = Modifier
                .fillMaxWidth()
        )

        // Compose FlowRow per organitzar els botons
        FlowRow(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            // Diversos tipus de botons per canviar el color del text
            Button(onClick = { onClickButton() }) {
                Text("Button (Filled)")
            }
            FilledTonalButton(onClick = { onClickButton() }) {
                Text("FilledTonalButton")
            }
            OutlinedButton(onClick = { onClickButton() }) {
                Text("OutlinedButton")
            }
            ElevatedButton(onClick = { onClickButton() }) {
                Text("ElevatedButton")
            }
            TextButton(onClick = { onClickButton() }) {
                Text("TextButton")
            }
            FloatingActionButton(onClick = { onClickButton() }) {
                Text("FloatingActionButton")
            }
            SmallFloatingActionButton(onClick = { onClickButton() }) {
                Text("SmallFloatingActionButton")
            }
            LargeFloatingActionButton(onClick = { onClickButton() }) {
                Text("LargeFloatingActionButton")
            }
            ExtendedFloatingActionButton(onClick = { onClickButton() }) {
                Text("ExtendedFloatingActionButton")
            }
        }
    }
}

@Composable
fun MoreButtonExample() {
    // Estat per gestionar l'habilitació/deshabilitació dels botons
    var isEnabled by remember { mutableStateOf(true) }

    // Funció per canviar l'estat d'habilitació/deshabilitació dels botons
    fun toggleEnabled() {
        isEnabled = !isEnabled
    }


    // Columna per centrar el contingut
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Botó amb forma i colors per defecte
        Button(
            onClick = { /* Acció quan es fa clic al botó */ },
            enabled = isEnabled
        ) {
            Text("Botó per defecte")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botó amb forma rectangular, borde i marge interior personalitzats
        Button(
            shape = RectangleShape,
            onClick = { /* Acció quan es fa clic al botó */ },
            enabled = isEnabled
        ) {
            Text("Botó Rectangular")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botó amb forma circular, mostra interacció de l'usuari
        Button(
            shape = CircleShape,
            onClick = { /* Acció quan es fa clic al botó */ },
            modifier = Modifier
                .defaultMinSize(minHeight = 150.dp, minWidth = 150.dp),
            enabled = isEnabled
        ) {
            Text("Botó Circular")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botó deshabilitat amb forma de tall
        Button(
            shape = CutCornerShape(8.dp),
            onClick = { /* Acció quan es fa clic al botó */ },
            enabled = false
        ) {
            Text("Botó Deshabilitat")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botó amb forma de tall i colors personalitzats
        Button(
            shape = CutCornerShape(20, 30, 50, 10),
            border = BorderStroke(2.dp, Color.Black),
            onClick = { /* Acció quan es fa clic al botó */ },
            modifier = Modifier
                .padding(8.dp)
                .clickable(enabled = isEnabled) { /* Acció quan es fa clic al botó */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Green,
                contentColor = Color.DarkGray,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.White
            ),
            enabled = isEnabled
        ) {
            Text("Botó Personalitzat")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botó amb elevació i ombra
        Button(
            onClick = { /* Acció quan es fa clic al botó */ },
            modifier = Modifier
                .clickable(enabled = isEnabled) { /* Acció quan es fa clic al botó */ },
            elevation = ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 8.dp,
                pressedElevation = 16.dp
            ),
            enabled = isEnabled
        ) {
            Text("Botó Amb Elevació")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botó per habilitar/deshabilitar altres botons
        Button(
            onClick = { toggleEnabled() },
            modifier = Modifier
                .padding(8.dp)
                .clickable(enabled = true) { toggleEnabled() },
            enabled = true
        ) {
            //mostra text segons isEnabled
            if (isEnabled) Text("Deshabilita els altres botons") else
                Text("Habilita els altres botons")
        }
    }
}

