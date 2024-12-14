package com.example.foodbasket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodbasket.ui.theme.FoodBasketTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.foodbasket.ui.theme.AnaRenk
import com.example.foodbasket.ui.theme.AnaRenkDark
import com.example.foodbasket.ui.theme.ArkaPlan
import com.example.foodbasket.ui.theme.PembeTon
import com.example.foodbasket.ui.theme.YaziRenk1
import com.example.foodbasket.ui.theme.YaziRenk2


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodBasketTheme {

                Anasayfa()
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Anasayfa(darkTheme: Boolean= isSystemInDarkTheme()){
    var searchQuery by remember { mutableStateOf("") }
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()

    )
    {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .size(600.dp, 300.dp)
                .background(if(darkTheme) AnaRenk else AnaRenkDark)
        ) {
            Spacer(modifier = Modifier.size(30.dp))
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { newValue -> searchQuery = newValue },
                placeholder = { Text(text = stringResource(id = R.string.pleceholder1), color = YaziRenk2)},
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .size(350.dp, 58.dp)
                    .padding(3.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = YaziRenk1
                ),
                leadingIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.baseline_search_24),
                        contentDescription = "Search Icon",
                        tint = Color.Gray 
                    )
                }

            )
            // Spacer(modifier = Modifier.size(30.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Sol taraf: Yazılar
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp)
                ) {
                    // Üst Yazı
                    Text(
                        text = stringResource(id = R.string.baslik1),
                        fontSize = 14.sp,
                        color = YaziRenk1,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = stringResource(id = R.string.baslik2),
                        fontSize = 14.sp,
                        color = YaziRenk1,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = stringResource(id = R.string.baslik3),
                        fontSize = 14.sp,
                        color = YaziRenk1,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = stringResource(id = R.string.baslik4),
                        fontSize = 12.sp,
                        color = YaziRenk1,
                        fontWeight = FontWeight.Medium
                    )
                }


                Box( contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(200.dp)
                        .background(color = ArkaPlan, shape = CircleShape)
                ){
                    Image(
                        painter = painterResource(id = R.drawable.gift1),
                        contentDescription = "hediyefoto",
                        modifier = Modifier
                            .size(200.dp)
                            .padding(end = 16.dp)
                    )
                }

            }


        }
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconItem(imageRes = R.drawable.discount, text = stringResource(id = R.string.fırsatlar))
            IconItem(imageRes = R.drawable.sepet3, text = stringResource(id = R.string.ymarket))
            IconItem(imageRes = R.drawable.kupon, text = stringResource(id = R.string.kuponlarım))
            IconItem(imageRes = R.drawable.poset, text = stringResource(id = R.string.gerial))
        }
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            MyButton(icerik = stringResource(id = R.string.sıralama))
            MyButton(icerik = stringResource(id = R.string.mutfak))
            MyButton(icerik = stringResource(id = R.string.sepetTutari))
        }


        Text(
            text = "Mutfaklar",
            fontSize = 20.sp,
        )
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            MutfakItem(imageRes = R.drawable.tatli, text = stringResource(id = R.string.tatli))
            MutfakItem(imageRes = R.drawable.burger, text = stringResource(id = R.string.burger))
            MutfakItem(imageRes = R.drawable.pizza, text = stringResource(id = R.string.pizza))
            MutfakItem(imageRes = R.drawable.tavuk, text = stringResource(id = R.string.tavuk))

        }

    }


}

@Composable
fun IconItem(imageRes:Int,text:String){
    Column(
        modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box( contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(50.dp)
                .background(color = PembeTon, shape = CircleShape)
        ){
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = text,
                modifier = Modifier.size(40.dp)
            )
        }

        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = text,
             // Yazı stili
            textAlign = TextAlign.Center
        )
    }

}
@Composable
fun MutfakItem(imageRes:Int,text:String){
    Column( modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = text,
            modifier = Modifier.size(80.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = text,
            textAlign = TextAlign.Center
        )
    }
}
@Composable
fun MyButton(icerik:String){
    Button(onClick = { /*TODO*/ }, 
        colors=ButtonDefaults.buttonColors(
            containerColor = YaziRenk1,
            contentColor= YaziRenk2
        )
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = icerik)
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = ""
            )
        }
    }
}

@Preview(showBackground = true, locale = "tr")
@Composable
fun GreetingPreview() {
    FoodBasketTheme {
       //reeting("Android")
    }
}