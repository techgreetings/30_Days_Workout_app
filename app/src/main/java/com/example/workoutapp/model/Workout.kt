package com.example.workoutapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.workoutapp.R


data class Workout(
    @StringRes val title: Int,
    @StringRes val heading: Int,
    @DrawableRes val imageRes: Int,
    @StringRes val description: Int
)

val workoutes = listOf(
    Workout(R.string.title1,R.string.heading1,R.drawable.workout1,R.string.description1),
    Workout(R.string.title2,R.string.heading2,R.drawable.workout2,R.string.description2),
    Workout(R.string.title3,R.string.heading3,R.drawable.workout3,R.string.description3),
    Workout(R.string.title4,R.string.heading4,R.drawable.workout4,R.string.description4),
    Workout(R.string.title5,R.string.heading5,R.drawable.workout5,R.string.description5),
    Workout(R.string.title6,R.string.heading6,R.drawable.workout6,R.string.description6),
    Workout(R.string.title7,R.string.heading7,R.drawable.workout7,R.string.description7),
    Workout(R.string.title8,R.string.heading8,R.drawable.workout8,R.string.description8),
    Workout(R.string.title9,R.string.heading9,R.drawable.workout9,R.string.description9),
    Workout(R.string.title10,R.string.heading10,R.drawable.workout10,R.string.description10),
    Workout(R.string.title11,R.string.heading11,R.drawable.workout11,R.string.description11),
    Workout(R.string.title12,R.string.heading12,R.drawable.workout12,R.string.description12),
    Workout(R.string.title13,R.string.heading13,R.drawable.workout13,R.string.description13),
    Workout(R.string.title14,R.string.heading14,R.drawable.workout14,R.string.description14),
    Workout(R.string.title15,R.string.heading15,R.drawable.workout15,R.string.description15),
    Workout(R.string.title16,R.string.heading16,R.drawable.workout16,R.string.description16),
    Workout(R.string.title17,R.string.heading17,R.drawable.workout17,R.string.description17),
    Workout(R.string.title18,R.string.heading18,R.drawable.workout18,R.string.description18),
    Workout(R.string.title19,R.string.heading19,R.drawable.workout19,R.string.description19),
    Workout(R.string.title20,R.string.heading20,R.drawable.workout20,R.string.description20),
    Workout(R.string.title21,R.string.heading21,R.drawable.workout21,R.string.description21),
    Workout(R.string.title22,R.string.heading22,R.drawable.workout22,R.string.description22),
    Workout(R.string.title23,R.string.heading23,R.drawable.workout23,R.string.description23),
    Workout(R.string.title24,R.string.heading24,R.drawable.workout24,R.string.description24),
    Workout(R.string.title25,R.string.heading25,R.drawable.workout25,R.string.description25),
    Workout(R.string.title26,R.string.heading26,R.drawable.workout26,R.string.description26),
    Workout(R.string.title27,R.string.heading27,R.drawable.workout27,R.string.description27),
    Workout(R.string.title28,R.string.heading28,R.drawable.workout28,R.string.description28),
    Workout(R.string.title29,R.string.heading29,R.drawable.workout29,R.string.description29),
    Workout(R.string.title30,R.string.heading30,R.drawable.workout30,R.string.description30),
)