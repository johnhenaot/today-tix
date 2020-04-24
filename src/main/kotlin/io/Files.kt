package io

import java.io.File

fun File.getListOfPasswords(): List<String> =
    readLines()
        .dropLast(1)