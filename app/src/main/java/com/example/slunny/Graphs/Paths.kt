package com.example.slunny.Graphs


sealed class Paths(path: String) {
    object home: Paths("/home")
    object town: Paths("/town")
}