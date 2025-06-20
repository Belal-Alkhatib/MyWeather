package com.thechance.myweather.data.utils

import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

fun String.toLocalTime(): LocalTime {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
    return LocalTime.parse(this, formatter)
}

fun String.toLocalDate(): LocalDate =
    LocalDate.parse(this, DateTimeFormatter.ISO_DATE)

fun LocalTime.toHourString(): String {
    val formatter = DateTimeFormatter.ofPattern("HH:mm")
    return this.format(formatter)
}