package com.example.activity4

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
///import com.example.activity4.ui.theme.Activity4Theme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.ViewModel
import com.example.activity4.data.DataForm
import com.example.activity4.ui.theme.CobaViewData


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Activity4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                        TampilLayout()
                }
            }
        }
    }
}

fun TampilLayout(
    modifier:Modifier = Modifier
){
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ){
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment= Alignment.CenterHorizontally,
            modifier = Modifier.padding(20.dp),
        ){
            TampilForm()
        }
    }
}

fun OutlinedTextField(value: Any, onValueChange: Boolean, keyboardOptions: KeyboardOptions, shape: CornerBasedShape, modifier: Modifier, label: () -> Unit, onValueChange1: () -> Unit) {

}

@Composable
fun TampilForm(cobaViewModel: ViewModel = ViewModel()){

    var textNama by remember (mutableStateOf(""))
    var textTlp by remember (mutableStateOf(""))

    val context = LocalContext.current
    val dataForm: DataForm
    val uiState by CobaViewData.uiState.collectAsState()
    dataForm = uiState

    OutlinedTextField(
        value = textNama
        , onValueChange = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.fillMaxWidth(),
            label = {Text(text = "Nama Lengkap")},
            onValueChange = {
                textNama = ///it
            })
    OutlinedTextField(
        value = textTlp,
        onValueChange = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number),
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.fillMaxWidth(),
            label = { Text (text ="Telepon")},
            onValueChange ={
                textTlp = ///it
            }
        )
    SelectJK(
        options = jenis.map{id ->context.resource.getString(id)},
        onSelectionChanged = {cobaViewModel.///setJenisK(it)})
    Button(
        modifier = Modifier.fillMaxWidth(),
        ///onClick= {
            cobaViewModel.///InsertData(textNama, textTlp, dataForm.sex)
        }
    )///{
        ///Text(text = stringResource(R.string.submit))
       ///fontsize = 16.sp
    ///}
    Spacer(modifier = Modifier.height(100.dp))
    TextHasil(
        namanya = CobaViewData.namaUsr,
        telponnya = CobaViewData.noTlp ,
        jenisnya = CobaViewData.jenisKL ,
        emailnya = CobaViewData.Email)
            }

    )
}
@Composable
fun TampilEmail(emailnya:String){
        Box {
            Text(text = "email : "+ emailnya )
            var modifier = Modifier
                .fillMaxWidth()
        }
}
@Composable
fun TextHasil(namanya: String, telponnya: String, jenisnya: String, emailnya: Any){
    ElevatedCard {
        var elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
        var modifier = Modifier
            .fillMaxWidth()
    }
        Text(
            text = "Nama : " + namanya,
            modifier = Modifier
                .padding(horizontal =  10.dp, vertical = 4.dp)
        )
        Text(
        text = "Telepon : " + telponnya,
        modifier = Modifier
            .padding(horizontal =  10.dp, vertical = 5.dp)
        )
    Text(
        text = "Jenis Kelamin : " + jenisnya,
        modifier = Modifier
            .padding(horizontal =  10.dp, vertical = 4.dp)
    )
}

@Composable
fun SelectJK(
    options:List<String>
    onSelectionChanged:(String)
){
    var SelectedValue by rememberSaveable { mutableStateOf("") }
    Column(modifier = Modifier.padding(16.dp)){
        options.forEach{ item ->
            Row(
                modifier = Modifier.selectable(
                    selected = selectedValue == item,
                    onClick = {
                        selectedValue = item
                        onSelectionChanged(item)
                    }
                )
            )
            RadioButton(selected = SelectedValue == item,
                onClick = { ///selectedValue = item
                    ///onSelectionChanged(item)
                }
            )
            Text(item)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
        TampilLayout()
}