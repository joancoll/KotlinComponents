package cat.dam.andy.kotlincomponents

import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Air
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.material.icons.outlined.PhoneAndroid
import androidx.compose.material.icons.rounded.Image
import androidx.compose.material.icons.sharp.Image
import androidx.compose.material.icons.twotone.Image
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.material3.TimePicker
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.TimePickerLayoutType
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.state.ToggleableState
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
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.zIndex
import cat.dam.andy.kotlincomponents.ui.theme.KotlinComponentsTheme
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZoneOffset
import java.util.Calendar
import kotlin.math.roundToInt

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
                    //SimpleIcons()
                    //CustomIcons()
                    //IconButtonExample()
                    //ShowBadgeExample()
                    //ShowProgressBars()
                    //ImageExample()
                    //ImageAsyncExample()
                    //ShowToastAndSnackBar()
                    //CheckboxExample()
                    //TriStateCheckBoxExample()
                    //SwitchExample()
                    //RadioButtonExample()
                    //ShowChips()
                    //ShowSliderExample()
                    //ShowDialogExample()
                    //ShowTimePickerWithDialog()
                    ShowDatePickerWithDialog()
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
            modifier = Modifier.fillMaxWidth(),
            text = "Start", textAlign = TextAlign.Start,
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Center", textAlign = TextAlign.Center,
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
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
            text = "Text amb ombra", style = TextStyle(
                fontSize = 24.sp, shadow = Shadow(
                    color = Color.Green, offset = offset, blurRadius = 3f
                )
            )
        )
    }

    @Composable
    fun MultipleStylesInText() {
        Text(buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Magenta)) {
                append("Múlt")
            }
            append("iples ")

            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)) {
                append("Es")
            }
            append("tils")
        })
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
        var count by rememberSaveable { mutableStateOf(0) }
        // Text que es clicable i incrementa el comptador al clicar
        Text(text = "Nombre de vegades que has clicat aquest text: $count",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.clickable {
                count++
            })
    }

    @Composable
    fun SimpleClickableText() {
        ClickableText(text = AnnotatedString("Clica a qualsevol part del text per veure la seva posició al Logcat."),
            onClick = { offset ->
                Log.d("ClickableText", "Has clicat al caràcter número: $offset.")
            })
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SimpleTextField() {
        var name by rememberSaveable { mutableStateOf("") }
        var password by rememberSaveable { mutableStateOf("") }
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
                keyboardType = KeyboardType.Password, imeAction = ImeAction.Done
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
                text = "Primer Text", color = Color.Red, modifier = Modifier.fillMaxWidth()
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
                text = "Segon Text", color = Color.Blue, modifier = Modifier.fillMaxWidth()
            )
            // Divider 2
            Divider(
                modifier = Modifier.fillMaxWidth(),
                color = Color.Green,
                thickness = 8.dp,
            )
            // Text 3
            Text(
                text = "Tercer Text", color = Color.Magenta, modifier = Modifier.fillMaxWidth()
            )
        }
    }

    @OptIn(ExperimentalLayoutApi::class)
    @Composable
    fun ButtonExample() {
        // Estat per gestionar el color del text
        var textColor by rememberSaveable { mutableStateOf(Color.Black) }

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
                modifier = Modifier.fillMaxWidth()
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
        var isEnabled by rememberSaveable { mutableStateOf(true) }

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
                onClick = { /* Acció quan es fa clic al botó */ }, enabled = isEnabled
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
                modifier = Modifier.defaultMinSize(minHeight = 150.dp, minWidth = 150.dp),
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
                modifier = Modifier.clickable(enabled = isEnabled) { /* Acció quan es fa clic al botó */ },
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 8.dp, pressedElevation = 16.dp
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
                if (isEnabled) Text("Deshabilita els altres botons") else Text("Habilita els altres botons")
            }
        }
    }

    @Composable
    fun SimpleIcons() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(imageVector = Icons.Default.Image, contentDescription = null)
            Text(text = "Default")
            Icon(imageVector = Icons.Filled.Image, contentDescription = null)
            Text(text = "Filled (Default)")
            Icon(imageVector = Icons.Outlined.Image, contentDescription = null)
            Text(text = "Outlined")
            Icon(imageVector = Icons.Rounded.Image, contentDescription = null)
            Text(text = "Rounded")
            Icon(imageVector = Icons.TwoTone.Image, contentDescription = null)
            Text(text = "TwoTone")
            Icon(imageVector = Icons.Sharp.Image, contentDescription = null)
            Text(text = "Sharp")
        }
    }

    @Composable
    fun CustomIcons() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Icona amb forma circular
            Icon(
                imageVector = Icons.Default.Image,
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Green, CircleShape)
            )
            Text(text = "CircleShape")
            // Icona amb forma rectangular
            Icon(
                imageVector = Icons.Default.Image,
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.LightGray, RectangleShape)
            )
            Text(text = "RectangleShape")
            // Icona amb forma de tall
            Icon(
                imageVector = Icons.Default.Image,
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Red, CutCornerShape(8.dp))
            )
            Text(text = "CutCornerShape(8.dp)")
            // Icona amb forma arrodonida
            Icon(
                imageVector = Icons.Default.Image,
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Cyan, RoundedCornerShape(8.dp))
            )
            Text(text = "RoundedCornerShape(8.dp)")
            // Icona amb forma personalitzada
            Icon(
                imageVector = Icons.Default.Image,
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Yellow, object : Shape {
                        override fun createOutline(
                            size: androidx.compose.ui.geometry.Size,
                            layoutDirection: LayoutDirection,
                            density: Density
                        ): Outline {
                            return Outline.Rectangle(
                                Rect(
                                    0f, 0f, size.width * 2, size.height
                                )
                            )
                        }
                    })
            )
            Text(text = "Shape personalitzada")
            // Icona amb forma personalitzada
            Icon(
                imageVector = Icons.Default.Image,
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Magenta, object : Shape {
                        override fun createOutline(
                            size: androidx.compose.ui.geometry.Size,
                            layoutDirection: LayoutDirection,
                            density: Density
                        ): Outline {
                            return Outline.Generic(path = Path().apply {
                                moveTo(0f, 0f)
                                lineTo(size.width, 0f)
                                lineTo(size.width / 2, size.height)
                                close()
                            })
                        }
                    })
            )
            Text(text = "Shape personalitzada 2")
        }
    }

    @Composable
    fun IconButtonExample() {
        val context = LocalContext.current
        val interactionSource = remember {
            MutableInteractionSource()
        }
        val pressState = interactionSource.collectIsPressedAsState()
        val pressText = if (pressState.value) "clicant..." else "afegeix"
        Column(modifier = Modifier.padding(10.dp, 10.dp)) {
            IconButton(
                onClick = {
                    Toast.makeText(context, "Clicat!", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier
                    .size(150.dp, 80.dp)
                    .clip(RoundedCornerShape(20))
                    .border(3.dp, color = Color.Magenta, shape = RoundedCornerShape(20)),
                enabled = false,
                interactionSource = interactionSource,
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.White,
                    disabledContainerColor = Color.Gray,
                    disabledContentColor = Color.White,
                ),
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Filled.Add, contentDescription = "Add button"
                    )
                    Text(
                        text = pressText, fontSize = 18.sp
                    )
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ShowBadgeExample() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val badgeNumber = "7"
            // BadgedBox amb Badge amb número normal
            BadgedBox(
                badge = {
                    Badge()
                    {
                        Text(badgeNumber)
                    }
                }) {
                Icon(
                    Icons.Filled.Star,
                    contentDescription = "Favorite"
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            // BadgedBox amb Badge amb número gran i colors personalitzats
            BadgedBox(
                badge = {
                    Badge(
                        modifier = Modifier
                            .size(20.dp),
                        containerColor = Color.Green,
                        contentColor = Color.Black,
                    )
                    {
                        Text(
                            badgeNumber,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.semantics {
                                contentDescription = "$badgeNumber new notifications"
                            }
                        )
                    }
                }) {
                Icon(
                    Icons.Filled.Mail,
                    contentDescription = "Mail"
                )
            }
        }
    }

    @Composable
    fun ShowProgressBars() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(text = "LinearProgressIndicator")
            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp),
                progress = 0.7f,
                color = MaterialTheme.colorScheme.primary,
                trackColor = Color.LightGray,
            )
            Text(text = "CircularProgressIndicator")
            CircularProgressIndicator(
                modifier = Modifier
                    .size(100.dp),
                progress = 0.85f,
                color = Color.Magenta,
                strokeWidth = 10.dp,
            )
        }
    }

    @OptIn(ExperimentalLayoutApi::class)
    @Composable
    fun ImageExample() {
        val mypainterResource = painterResource(id = R.drawable.cats)
        val mypainterDescription = "Cats"
        val myCopyright = "©Andy"
        FlowRow(
            modifier = Modifier
                .fillMaxSize()
                .padding(6.dp)
                .background(Color.Yellow),
            horizontalArrangement = Arrangement.Center,
            verticalArrangement = Arrangement.Center
        ) {
            // Imatge des de recursos drawables
            Image(
                painter = mypainterResource,
                contentDescription = mypainterDescription,
            )
            // Imatge des de recursos drawables amb mida personalitzada
            Image(
                painter = mypainterResource,
                contentDescription = mypainterDescription,
                modifier = Modifier.size(120.dp)
            )
            // Imatge des de recursos drawables amb cantonades arrodonides
            Image(
                painter = mypainterResource,
                contentDescription = mypainterDescription,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(Color.Green, CircleShape)
            )
            // Imatge des de recursos drawables amb forma circular i mida personalitzada
            Image(
                painter = mypainterResource,
                contentDescription = mypainterDescription,
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.Cyan, RoundedCornerShape(16.dp))
                    .size(120.dp),
                contentScale = ContentScale.Crop //perquè no es vegi estirada
            )
            // Imatge recursos drawables amb forma circular, mida personalitzada i vora
            Image(
                painter = mypainterResource,
                contentDescription = mypainterDescription,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(120.dp)
                    //cal afegir clip a la vora perquè no sigui rectangular
                    .border(3.dp, color = Color.Red, shape = CircleShape),
                contentScale = ContentScale.Crop
            )
            // Imatge des de recursos drawables amb forma circular i ombra
            Image(
                painter = mypainterResource,
                contentDescription = mypainterDescription,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(120.dp)
                    //cal afegir clip perquè no sigui rectangular
                    .graphicsLayer(
                        shadowElevation = 10f, shape = CircleShape
                    ),
                contentScale = ContentScale.Crop
            )
            // Canviar color de fons imatge png per blau
            Image(
                painter = mypainterResource,
                contentDescription = mypainterDescription,
                modifier = Modifier
                    .size(120.dp)
                    .padding(8.dp)
                    .background(Color.Blue)
            )
            // Imatge des de recursos drawables amb color filter i BlendMode
            Image(
                painter = mypainterResource,
                contentDescription = mypainterDescription,
                modifier = Modifier
                    .size(180.dp)
                    .padding(8.dp),
                colorFilter = ColorFilter.tint(Color.Magenta, BlendMode.Darken),
            )

            // Afegir text o un altre component sobre una imatge
            Box(
                //mida ajustada al contingut i aquest alineat a bottom start
                modifier = Modifier
                    .wrapContentSize(align = Alignment.BottomStart)
                    .padding(8.dp)
            ) {
                Image(
                    painter = mypainterResource,
                    contentDescription = mypainterDescription,
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CutCornerShape(40, 40, 10, 10))
                        .background(Color.White, CutCornerShape(40, 40, 10, 10))
                        .zIndex(1f)
                )
                Box(
                    modifier = Modifier
                        .wrapContentSize(align = Alignment.Center)
                        // Ajustament per adaptar-se al contingut
                        .zIndex(2f)
                        .align(Alignment.BottomCenter)
                ) {
                    // copyright
                    Text(
                        text = myCopyright,
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Black,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }

    @Composable
    fun ImageAsyncExample() {
        // Columna per centrar el contingut
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Exemple càrrega d'imatges asíncrones des de la web
            // (utilitzant Coil)
            CoilImageComponent(
                "https://agora.xtec.cat/iespladelestany/wp-content/uploads/usu35/2015/11/P1420828.jpg",
                "Imatge asíncrona"
            )
        }
    }

    @Composable
    fun CoilImageComponent(imageUrl: String, desc: String) {
        SubcomposeAsyncImage(
            model = ImageRequest.Builder(LocalContext.current).data(imageUrl).crossfade(true)
                .build(),
            contentDescription = desc,
            contentScale = ContentScale.Crop,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
            colorFilter = ColorFilter.tint(Color.Blue)
        ) {
            when (painter.state) {
                is AsyncImagePainter.State.Error -> {
                    Text(text = "Error carregant la imatge")
                }

                is AsyncImagePainter.State.Loading -> CircularProgressIndicator()
                else -> Image(
                    painter = painter,
                    contentDescription = contentDescription,
                )
            }
        }
    }

    @Composable
    fun ShowToastAndSnackBar() {
        val context = LocalContext.current.applicationContext // Context per a Toast
        val snackbarHostState = remember { SnackbarHostState() }
        val coroutineScope = rememberCoroutineScope()
        val messageToShow = remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Botó per mostrar un Toast
            Button(
                onClick = {
                    Toast.makeText(context, "Això és un Toast!", Toast.LENGTH_SHORT).show()
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text("Mostrar Toast")
            }

            // Botó per mostrar la Snackbar original
            Button(
                onClick = {
                    coroutineScope.launch {
                        messageToShow.value = "Això és una Snackbar!"
                        snackbarHostState.showSnackbar(messageToShow.value)
                    }
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text("Mostrar Snackbar")
            }
            // Utilitzem Box per situar la Snackbar a la part inferior de la pantalla
            // (per defecte es mostra a la part superior)
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter //Change to your desired position
            ) {
                SnackbarHost(
                    hostState = snackbarHostState, modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Snackbar(modifier = Modifier
                        .padding(16.dp)
                        .border(2.dp, Color.Black, RoundedCornerShape(8.dp)),
                        shape = RoundedCornerShape(8.dp),
                        containerColor = Color.Blue,
                        contentColor = Color.White,
                        content = {
                            Text(
                                text = messageToShow.value, fontWeight = FontWeight.Bold
                            )
                        },
                        action = {
                            TextButton(onClick = {
                                snackbarHostState.currentSnackbarData?.dismiss()
                            }, content = {
                                Text("Tancar", color = Color.Yellow)
                            })
                        })
                }
            }
        }
    }

    @Composable
    fun CheckboxExample() {
        val contextForToast = LocalContext.current.applicationContext
        var checkedState by rememberSaveable { mutableStateOf(true) }
        Column(
            modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Checkbox senzill sense text
            Checkbox(
                checked = checkedState,
                onCheckedChange = {
                    checkedState = it;
                    Toast.makeText(contextForToast, "checked = $checkedState", Toast.LENGTH_SHORT)
                        .show()
                },
            )
            // Checkbox amb text
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = checkedState, onCheckedChange = {
                    checkedState = it;
                    Toast.makeText(contextForToast, "checked = $checkedState", Toast.LENGTH_SHORT)
                        .show()
                })
                Text(
                    modifier = Modifier.padding(start = 2.dp), text = "Checkbox amb text"
                )
            }
            // Personalització del Checkbox
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = checkedState,
                    onCheckedChange = {
                        checkedState = it
                        Toast.makeText(
                            contextForToast,
                            "checked = $checkedState",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    },
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.Cyan, CircleShape)
                        .scale(scale = 2.1f),
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Green,
                        uncheckedColor = Color.Red,
                        checkmarkColor = Color.White
                    ),
                )
                Text(
                    modifier = Modifier.padding(start = 2.dp), text = "Checkbox personalitzat"
                )
            }
            // Llista de Checkboxs amb text
            val fruitsList: List<String> = listOf("Poma", "Síndria", "Meló")
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(text = "Llista de Checkboxs amb text")
                fruitsList.forEach { fruitName ->
                    var checkedState by rememberSaveable {
                        mutableStateOf(true)
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(checked = checkedState, onCheckedChange = {
                            checkedState = it
                            Toast.makeText(
                                contextForToast, "$fruitName $checkedState", Toast.LENGTH_SHORT
                            ).show()
                        })
                        Text(
                            modifier = Modifier.padding(start = 2.dp), text = fruitName
                        )
                    }
                }
            }
        }
    }

    @Composable
    private fun TriStateCheckBoxExample() {
        // estats dels checkbox fills
        var checkBox1State by rememberSaveable { mutableStateOf(true) }
        var checkBox2State by rememberSaveable { mutableStateOf(true) }
        var checkBox3State by rememberSaveable { mutableStateOf(true) }
        // estat del checkbox pare (tri-state)
        // canvia quan un estat fill canvia
        val parentCheckBoxState = remember(checkBox1State, checkBox2State, checkBox3State) {
            if (checkBox1State && checkBox2State && checkBox3State) ToggleableState.On // si tots els fills són checked
            else if (!checkBox1State && !checkBox2State && !checkBox3State) ToggleableState.Off // si tots els fills són unchecked
            else ToggleableState.Indeterminate // alguns dels fills són checked, altres unchecked
        }
        Column(horizontalAlignment = Alignment.Start) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                // checkbox pare
                TriStateCheckbox(state = parentCheckBoxState, onClick = {
                    // event de clic al checkbox pare
                    // si el pare no és checked, fer els fills unchecked
                    // sino fer els fills checked
                    val state = !(parentCheckBoxState == ToggleableState.On)
                    checkBox1State = state
                    checkBox2State = state
                    checkBox3State = state
                })
                Text(
                    modifier = Modifier.padding(start = 2.dp), text = "Sistemes operatius"
                )
            }
            // checkboxs fills
            CheckBoxItem(checked = checkBox1State,
                osName = "Ubuntu",
                onCheckedChange = { checkBox1State = it })
            CheckBoxItem(checked = checkBox2State,
                osName = "Windows",
                onCheckedChange = { checkBox2State = it })
            CheckBoxItem(checked = checkBox3State,
                osName = "Mac",
                onCheckedChange = { checkBox3State = it })
        }
    }

    @Composable
    private fun CheckBoxItem(
        checked: Boolean,
        osName: String,
        contextForToast: Context = LocalContext.current.applicationContext,
        onCheckedChange: (Boolean) -> Unit,
    ) {
        Row(
            modifier = Modifier.padding(start = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(checked = checked, onCheckedChange = {
                Toast.makeText(contextForToast, "$osName $it", Toast.LENGTH_SHORT).show()
            })

            Text(
                modifier = Modifier.padding(start = 2.dp), text = osName
            )
        }
    }

    @Composable
    fun SwitchExample() {
        var switchState by rememberSaveable { mutableStateOf(true) }
        var contextForToast = LocalContext.current.applicationContext
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Switch senzill sense text
            Switch(
                checked = switchState,
                onCheckedChange = {
                    switchState = it
                    Toast.makeText(contextForToast, "checked = $switchState", Toast.LENGTH_SHORT)
                        .show()
                },
            )
            // Switch amb text
            Row(verticalAlignment = Alignment.CenterVertically) {
                Switch(
                    checked = switchState,
                    onCheckedChange = {
                        switchState = it
                        Toast.makeText(
                            contextForToast,
                            "checked = $switchState",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.Green,
                        uncheckedThumbColor = Color.Red,
                        checkedTrackColor = Color.Yellow,
                        uncheckedTrackColor = Color.White
                    ),
                )
                Text(
                    modifier = Modifier.padding(start = 2.dp),
                    text = "Switch amb text i colors personalitzats"
                )
            }
            // Personalització del Switch
            Row(verticalAlignment = Alignment.CenterVertically) {
                Switch(
                    checked = switchState,
                    onCheckedChange = {
                        switchState = it
                        Toast.makeText(
                            contextForToast,
                            "checked = $switchState",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    },
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.Cyan, CircleShape)
                        .scale(scale = 1.5f),
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.Green,
                        uncheckedThumbColor = Color.Red,
                        checkedTrackColor = Color.Green,
                        uncheckedTrackColor = Color.Red
                    ),
                    thumbContent = {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Favorite",
                            modifier = Modifier
                                .size(20.dp)
                                .padding(4.dp)
                        )
                    },
                )
                Text(
                    modifier = Modifier.padding(start = 2.dp),
                    text = "Switch personalitzat amb icona"
                )
            }
            Image(
                painter = if (switchState) painterResource(id = R.drawable.img_bulb_on)
                else painterResource(
                    id = R.drawable.img_bulb_off
                ), contentDescription = "Bulb Status"
            )
        }
    }

    @Composable
    fun RadioButtonExample() {
        var isSelected by rememberSaveable { mutableStateOf(false) }
        val radioOptions = listOf("Taronja", "Plàtan", "Poma", "Préssec")
        var selectedOption by rememberSaveable { mutableStateOf(radioOptions[0]) }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    enabled = true,
                    selected = isSelected,
                    onClick = { isSelected = !isSelected }
                )
                Text(
                    modifier = Modifier.padding(start = 2.dp), text = "RadioButton"
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = isSelected,
                    onClick = { isSelected = !isSelected },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.Green,
                        unselectedColor = Color.Magenta
                    )
                )
                Text(
                    modifier = Modifier.padding(start = 2.dp),
                    text = "RadioButton amb colors personalitzats"
                )
            }
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .padding(16.dp)
                    .border(
                        width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(8.dp)
                    ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Grup de RadioButtons - Fruita",
                    modifier = Modifier.padding(8.dp)
                )
                radioOptions.forEach { fruitName ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (fruitName == selectedOption),
                            onClick = { selectedOption = fruitName }
                        )
                        Text(
                            text = fruitName,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }
                Text(
                    "La fruita seleccionada és: $selectedOption",
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ShowChips() {
        val contextForToast = LocalContext.current.applicationContext

        // Estats i text per FilterChip i InputChip
        val filterChipStates = remember { mutableStateListOf(true, false, true) }
        val inputChipStates = remember { mutableStateListOf(true, true, true) }
        val inputChipVisibility = remember { mutableStateListOf(true, true, true) }
        val chipItems = initChipItems()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Assist Chip
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                itemsIndexed(chipItems) { index, chipItem ->
                    AssistChip(
                        modifier = Modifier.padding(horizontal = 2.dp), // gap between items
                        onClick = {
                            Toast.makeText(contextForToast, chipItem.label, Toast.LENGTH_SHORT)
                                .show()
                        },
                        label = { Text(chipItem.label) },
                        leadingIcon = {
                            Icon(
                                imageVector = chipItem.icon,
                                contentDescription = null,
                                modifier = Modifier.size(size = AssistChipDefaults.IconSize)
                            )
                        },
                        colors = AssistChipDefaults.assistChipColors(
                            containerColor = Color.Cyan.copy(alpha = 0.1f), // background color
                            labelColor = Color.Blue, // text color
                            leadingIconContentColor = Color.Blue // icon color
                        ),
                        border = AssistChipDefaults.assistChipBorder(
                            borderColor = Color.Black,
                            borderWidth = 2.dp
                        )
                    )
                }
            }

            // Filter Chip
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                itemsIndexed(chipItems) { index, chipItem ->
                    FilterChip(
                        modifier = Modifier.padding(horizontal = 2.dp), // gap between items
                        onClick = { filterChipStates[index] = !filterChipStates[index] },
                        label = { Text(chipItem.label) },
                        selected = filterChipStates.getOrNull(index) ?: false,
                        leadingIcon = if (filterChipStates.getOrNull(index) ?: false) {
                            {
                                Icon(
                                    imageVector = Icons.Filled.Done,
                                    contentDescription = "Done",
                                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                                )
                            }
                        } else {
                            null
                        },
                    )
                }
            }

            // Input Chip
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                itemsIndexed(chipItems) { index, chipItem ->
                    // Comprovar la visibilitat i mostrar o no l'InputChip
                    if (inputChipVisibility.getOrNull(index) == true) {
                        InputChip(
                            modifier = Modifier.padding(horizontal = 2.dp), // gap between items
                            onClick = {
                                inputChipStates[index] = !inputChipStates[index]
                                // Mostrar el missatge amb Toast
                                Toast.makeText(
                                    contextForToast,
                                    "Tancar ${chipItem.label}",
                                    Toast.LENGTH_SHORT
                                ).show()
                            },
                            label = { Text(chipItem.label) },
                            selected = inputChipStates.getOrNull(index) ?: false,
                            avatar = {
                                Icon(
                                    Icons.Filled.Person,
                                    contentDescription = "Icona de persona",
                                    modifier = Modifier.size(InputChipDefaults.AvatarSize)
                                )
                            },
                            trailingIcon = {
                                IconButton(
                                    onClick = {
                                        // Modificar la visibilitat a fals per fer que l'InputChip desaparegui
                                        inputChipVisibility[index] = false
                                    }
                                ) {
                                    Icon(
                                        Icons.Default.Close,
                                        contentDescription = "Tancar",
                                        modifier = Modifier.size(InputChipDefaults.AvatarSize)
                                    )
                                }
                            },
                        )
                    }
                }
            }

            // Suggestion Chip
            SuggestionChip(
                onClick = {
                    Toast.makeText(
                        contextForToast,
                        "SuggestionChip clicat",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                label = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            Icons.Default.Info,
                            contentDescription = "Icona d'informació",
                            modifier = Modifier.size(20.dp)
                        )
                        Text("Suggestion Chip")
                    }
                },
                colors = SuggestionChipDefaults.suggestionChipColors(
                    containerColor = Color.Green,
                    labelColor = Color.Black,
                ),
                border = SuggestionChipDefaults.suggestionChipBorder(
                    borderColor = Color.Blue,
                    borderWidth = 2.dp
                )
            )
        }
    }

    data class ChipItem(
        val label: String,
        val icon: ImageVector
    )

    private fun initChipItems(): List<ChipItem> {
        return listOf(
            ChipItem(
                label = "Lights",
                icon = Icons.Outlined.LightMode
            ),
            ChipItem(
                label = "Phone",
                icon = Icons.Outlined.PhoneAndroid
            ),
            ChipItem(
                label = "Air",
                icon = Icons.Outlined.Air
            )
        )
    }
}

@Composable
fun ShowSliderExample() {
    var sliderValue by rememberSaveable { mutableStateOf(0f) }
    var sliderValue2 by rememberSaveable { mutableStateOf(0f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Slider amb valor mínim i màxim
        Slider(
            value = sliderValue,
            onValueChange = { sliderValue = it },
            valueRange = 0f..100f,
            enabled = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        // Mostra el valor del slider passat a enter
        Text(text = "Valor: ${sliderValue.roundToInt()}")

        // Slider amb valor mínim i màxim i colors personalitzats
        Slider(
            value = sliderValue2,
            onValueChange = { sliderValue2 = it },
            valueRange = 0f..10f,
            steps = 9,   // Ajusta els passos per fer el canvi de valor
            colors = SliderDefaults.colors(
                thumbColor = Color.Blue,
                activeTrackColor = Color.Green,
                inactiveTrackColor = Color.Red
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Text(text = "Valor: ${sliderValue2.roundToInt()}")
    }
}

@Composable
fun ShowDialogExample() {
    Column {
        var contextForToast = LocalContext.current.applicationContext
        var showDialog by remember { mutableStateOf(false) }
        var showImageDialog by remember { mutableStateOf(false) }
        Button(onClick = { showDialog = true }) {
            Text("AlertDialog")
        }
        Button(onClick = { showImageDialog = true }) {
            Text("Dialog personalitzat")
        }
        if (showDialog) {
            AlDialog(
                onDismissRequest = {
                    showDialog = false
                    //programa l'acció a realitzar quan es cancel·la el diàleg
                    Toast.makeText(contextForToast, "AlertDialog Descartat", Toast.LENGTH_SHORT)
                        .show()
                },
                onConfirmation = {
                    showDialog = false
                    //programa l'acció a realitzar quan es confirma el diàleg
                    Toast.makeText(contextForToast, "AlertDialog Confirmat", Toast.LENGTH_SHORT)
                        .show()
                },
                dialogTitle = "Exemple AlertDialog",
                dialogText = "Aquest és un exemple d'un AlertDialog amb botons.",
                icon = Icons.Default.Info
            )
        }
        if (showImageDialog) {
            DialogWithImage(
                onDismissRequest = {
                    showImageDialog = false
                    //programa l'acció a realitzar quan es cancel·la el diàleg
                    Toast.makeText(
                        contextForToast,
                        "Dialog personalitzat Descartat",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                onConfirmation = {
                    showImageDialog = false
                    //programa l'acció a realitzar quan es confirma el diàleg
                    Toast.makeText(
                        contextForToast,
                        "Dialog personalitzat Confirmat",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                painter = painterResource(id = R.drawable.cats),
                imageDescription = "Cats"
            )
        }
    }
}

@Composable
fun AlDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    icon: ImageVector,
) {
    AlertDialog(icon = {
        Icon(icon, contentDescription = "Example Icon")
    }, title = {
        Text(text = dialogTitle)
    }, text = {
        Text(text = dialogText)
    }, onDismissRequest = {
        onDismissRequest()
    }, confirmButton = {
        TextButton(onClick = {
            onConfirmation()
        }) {
            Text("Confirma")
        }
    }, dismissButton = {
        TextButton(onClick = {
            onDismissRequest()
        }) {
            Text("Descarta")
        }
    })
}

@Composable
fun DialogWithImage(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    painter: Painter,
    imageDescription: String,
) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        // Mostra una Card arrodonida amb una imatge i dos botons
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(375.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painter,
                    contentDescription = imageDescription,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.height(160.dp)
                )
                Text(
                    text = "Aquest és un Dialog personalitzat amb botons i una imatge.",
                    modifier = Modifier.padding(16.dp),
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    TextButton(
                        onClick = { onDismissRequest() },
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Text("Descarta")
                    }
                    TextButton(
                        onClick = { onConfirmation() },
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Text("Confirma")
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowTimePickerWithDialog() {
    var showTimePickerDialog by remember { mutableStateOf(false) }
    var showTimeDialog by remember { mutableStateOf(false) }
    var selectedHour by remember { mutableStateOf(LocalTime.now().hour) }
    var selectedMinute by remember { mutableStateOf(LocalTime.now().minute) }
    val timeState = rememberTimePickerState(
        initialHour = selectedHour,
        initialMinute = selectedMinute,
        is24Hour = true
    )
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { showTimeDialog = true }) {
            Text(text = "Show Time Picker")
        }
        //Format time with leading zero
        Text(text = "Selected time: ${String.format("%02d:%02d", selectedHour, selectedMinute)}")
    }

    if (showTimeDialog) {
        AlertDialog(
            onDismissRequest = { showTimeDialog = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .background(color = Color.LightGray.copy(alpha = .3f))
                    .padding(top = 28.dp, start = 20.dp, end = 20.dp, bottom = 12.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TimePicker(
                    state = timeState,
                    layoutType = TimePickerLayoutType.Vertical,
                    colors = TimePickerDefaults.colors(
                        clockDialColor = Color.Cyan,
                        clockDialSelectedContentColor = Color.Red,
                        clockDialUnselectedContentColor = Color.Black,
                        selectorColor = Color.Green,
                        periodSelectorBorderColor = Color.Blue,
                        periodSelectorSelectedContainerColor = Color.Magenta,
                        periodSelectorSelectedContentColor = Color.Green,
                        periodSelectorUnselectedContainerColor = Color.Cyan,
                        periodSelectorUnselectedContentColor = Color.White,
                        timeSelectorSelectedContainerColor = Color.Yellow,
                        timeSelectorSelectedContentColor = Color.Magenta
                    )
                )
                Row(
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .fillMaxWidth(), horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = { showTimeDialog = false }) {
                        Text(
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .background(color = Color.Gray),
                            text = "Descarta"
                        )
                    }
                    TextButton(onClick = {
                        showTimeDialog = false
                        selectedHour = timeState.hour
                        selectedMinute = timeState.minute
                    }) {
                        Text(
                            text = "Confirma",
                            modifier = Modifier
                                .background(color = Color.Green)
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowDatePickerWithDialog() {
    var showDateDialog by remember { mutableStateOf(false) }
    var showDatePickerDialog by remember { mutableStateOf(false) }
    var selectedDay by remember { mutableStateOf(LocalDate.now().dayOfMonth) }
    var selectedMonth by remember { mutableStateOf(LocalDate.now().monthValue) }
    var selectedYear by remember { mutableStateOf(LocalDate.now().year) }
    val dateState = rememberDatePickerState(
        initialSelectedDateMillis = LocalDate.now().atStartOfDay()
            .toEpochSecond(ZoneOffset.UTC) * 1000,
        initialDisplayedMonthMillis = LocalDate.now().atStartOfDay()
            .toEpochSecond(ZoneOffset.UTC) * 1000,
        yearRange = 2000..2050,
        initialDisplayMode = DisplayMode.Picker,
    )
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { showDatePickerDialog = true }) {
            Text(text = "Show DatePicker Dialog")
        }
        Button(onClick = { showDateDialog = true }) {
            Text(text = "Show DateDialog")
        }
        //Format date with leading zero
        Text(
            text = "Selected date: ${
                String.format(
                    "%02d/%02d/%04d",
                    selectedDay,
                    selectedMonth,
                    selectedYear
                )
            }"
        )
    }
    if (showDatePickerDialog) {
        DatePickerDialog(
            onDismissRequest = { showDatePickerDialog = false },
            confirmButton = {
                TextButton(onClick = {
                    //mostra data seleccionada
                    var selectedDate = getDateFromMillis(dateState.selectedDateMillis!!)
                    selectedDay = selectedDate.day
                    selectedMonth = selectedDate.month
                    selectedYear = selectedDate.year
                    showDatePickerDialog = false
                }) {
                    Text("Confirma")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDatePickerDialog = false }) {
                    Text("Descarta")
                }
            }
        ) {
            DatePicker(state = dateState)
        }
    }
    if (showDateDialog) {
        AlertDialog(
            onDismissRequest = { showDateDialog = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .background(color = Color.LightGray.copy(alpha = .3f))
                    .padding(top = 28.dp, start = 20.dp, end = 20.dp, bottom = 12.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                DatePicker(
                    state = dateState,
                    title = { Text(text = "Seleccioni data") },
                    headline = { Text(text = "Aniversari") },
                    showModeToggle = true,
                    /*colors = DatePickerDefaults.colors(
                        containerColor = Color.Gray,
                        titleContentColor = Color.Cyan,
                        headlineContentColor = Color.DarkGray,
                        weekdayContentColor = Color.Black,
                        subheadContentColor = Color.Magenta,
                        yearContentColor = Color.Blue,
                        currentYearContentColor = Color.Green,
                        selectedYearContentColor = Color.Yellow,
                        selectedYearContainerColor = Color.LightGray,
                        dayContentColor = Color.Black,
                        disabledDayContentColor = Color.Gray,
                        selectedDayContentColor = Color.White,
                        disabledSelectedDayContentColor = Color.LightGray,
                        selectedDayContainerColor = Color.Blue,
                        disabledSelectedDayContainerColor = Color.Gray,
                        todayContentColor = Color.Red,
                        todayDateBorderColor = Color.Red,
                        dayInSelectionRangeContentColor = Color.Green,
                        dayInSelectionRangeContainerColor = Color.White
                    )*/
                )
                Row(
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .fillMaxWidth(), horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = { showDateDialog = false }) {
                        Text(
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .background(color = Color.Gray),
                            text = "Descarta"
                        )
                    }
                    TextButton(onClick = {
                        var selectedDate = getDateFromMillis(dateState.selectedDateMillis!!)
                        selectedDay = selectedDate.day
                        selectedMonth = selectedDate.month
                        selectedYear = selectedDate.year
                        showDateDialog = false
                    }) {
                        Text(
                            text = "Confirma",
                            modifier = Modifier
                                .background(color = Color.Green)
                        )
                    }
                }
            }
        }
    }
}

//funció que retorna un objecte data amb el nom del dia, mes i any a partir de la data en milisegons
data class DayMonthYear(val day: Int, val month: Int, val year: Int)

fun getDateFromMillis(millis: Long): DayMonthYear {
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = millis
    return DayMonthYear(
        calendar.get(Calendar.DAY_OF_MONTH),
        calendar.get(Calendar.MONTH) + 1,
        calendar.get(Calendar.YEAR)
    )
}
