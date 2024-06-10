package com.example.myapplication

import java.io.Serializable

data class WeatherInfo(val day: String, val min: String, val max: String, val condition: String) : Serializable

