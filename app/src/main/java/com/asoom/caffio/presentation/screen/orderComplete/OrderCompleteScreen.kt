package com.asoom.caffio.presentation.screen.orderComplete

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asoom.caffio.R
import com.asoom.caffio.core.ui.components.ActionButton
import com.asoom.caffio.core.ui.components.CaffioButton
import com.asoom.caffio.ui.theme.brawn
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun OrderCompleteScreen(
    modifier: Modifier = Modifier,
    viewModel: OrderCompleteViewModel = koinViewModel()
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        ActionButton(
            modifier = Modifier.padding(start = 16.dp),
            onClick = {},
            actionIcon = R.drawable.ic_exit
        )
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_coffee),
                contentDescription = null,
                tint = brawn,
                modifier = Modifier
                    .size(32.dp)
                    .padding(end = 6.dp)
            )
            Text(
                text = "More Espresso, Less Depresso",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal
                ),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Icon(
                painter = painterResource(R.drawable.ic_coffee),
                contentDescription = null,
                tint = brawn,
                modifier = Modifier
                    .size(32.dp)
                    .padding(start = 6.dp)
            )
        }

        Image(
            painter = painterResource(R.drawable.cup_cake),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(310.dp)
                .padding(top = 16.dp)
        )
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 24.dp)
        ) {
            Text(
                text = "Bon appétit",
                color = Color(0xFF1F1F1F).copy(alpha = 0.8f),
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Image(
                painter = painterResource(R.drawable.ic_magic),
                contentDescription = null,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Spacer(modifier = Modifier.weight(1f))

        CaffioButton(
            text = stringResource(R.string.thank_youu),
            icon = R.drawable.icon_arrow_right,
            onClick = {
                viewModel.onClickButton()
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 50.dp)
        )
    }
}

@Preview
@Composable
private fun OrderCompleteScreenPreview() {
    OrderCompleteScreen()
}