package com.example.hipolabschallange.designsystem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.example.hipolabschallange.designsystem.theme.MemberListContentPadding
import com.example.hipolabschallange.designsystem.theme.MemberListVerticalArrangementSpacedBy
import com.example.hipolabschallange.model.Member

@Composable
fun MemberList(
    modifier: Modifier = Modifier,
    items: List<Member>
) {
    LazyColumn(
        modifier = modifier
            .testTag("RecordCardList"),
        contentPadding = PaddingValues(
            horizontal = MemberListContentPadding
        ),
        verticalArrangement = Arrangement.spacedBy(
            MemberListVerticalArrangementSpacedBy
        ),
    ) {
        items(items) {
            RecordCard(
                modifier = Modifier.testTag("Record"),
                recordText = it.name
            )
        }
    }
}