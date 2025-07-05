package com.asoom.caffio.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asoom.caffio.R
import androidx.compose.ui.tooling.preview.Preview
import com.asoom.caffio.core.designSystem.theme.CaffioTheme
import com.asoom.caffio.core.designSystem.theme.ThemePreviews
import com.asoom.caffio.core.ui.ActionButton

@Composable
fun HomeScreen(
    onCoffeeClick: (String) -> Unit,
    onSnackClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(24.dp)
    ) {
        // Top Row: Avatar and Add button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.account),
                contentDescription = "Avatar",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
            ActionButton(
                onClick = { /* TODO: Add action */ },
                actionIcon = R.drawable.icon_add,
                backgroundColor = MaterialTheme.colorScheme.primary,
                iconColor = Color.White
            )
        }

        // Main Content
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Good Morning",
                style = MaterialTheme.typography.titleLarge.copy(
                    color = Color(0xFFBDBDBD),
                    fontWeight = FontWeight.Normal,
                    fontSize = 28.sp
                )
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Hamsa",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 32.sp,
                        color = Color.Black
                    )
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    painter = painterResource(id = R.drawable.icon_star),
                    contentDescription = "Star",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(28.dp)
                )
            }
            Text(
                text = "What would you like to drink today?",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color(0xFF757575),
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                ),
                modifier = Modifier.padding(top = 4.dp, bottom = 24.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.coffio),
                contentDescription = "Coffee Cup",
                modifier = Modifier
                    .size(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Black",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp,
                    color = Color.Black
                )
            )
        }

        // Continue Button
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
        ) {
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .background(Color.Black)
                    .clickable { onCoffeeClick("Black") }
                    .padding(horizontal = 32.dp, vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Continue",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    painter = painterResource(id = R.drawable.icon_arrow_right),
                    contentDescription = "Arrow Right",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@ThemePreviews
@Composable
fun PreviewHomeScreen() {
    CaffioTheme {
        HomeScreen(
            onCoffeeClick = {},
            onSnackClick = {}
        )
    }
}