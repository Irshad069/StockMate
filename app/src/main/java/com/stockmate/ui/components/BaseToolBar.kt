package com.stockmate.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stockmate.R
import com.stockmate.ui.utils.ssp

@Composable
fun BaseToolBar(
    title: String,
    onBackClick: () -> Unit = {},
    showBackButton: Boolean = true
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Transparent),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (showBackButton) {
            IconButton(
                onClick = onBackClick,
                modifier = Modifier.size(40.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "Back Button"
                )
            }
        } else {
            Spacer(modifier = Modifier.size(40.dp))
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = title,
                textAlign = TextAlign.Center,
                fontSize = 22.ssp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.size(40.dp))
    }
}

@Preview
@Composable
private fun BaseToolBarPreview() {
    BaseToolBar(
        title = "Hello",
        onBackClick = {}
    )
}
