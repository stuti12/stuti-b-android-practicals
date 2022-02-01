package com.example.myapplication

import com.example.myapplication.RecycleViewPractical.RecycleView.SpiritualTeacher

class DataFile {
   //RecycleView Data
     val teachers: Array<SpiritualTeacher>
        get() =
            arrayOf(
                SpiritualTeacher(
                    "C",
                    "Out beyond ideas of wrongdoing and rightdoing there is a field.I'll meet you there.",
                    R.drawable.c_image
                ),
                SpiritualTeacher(
                    "C++",
                    "Don't Carry Over Experiences from the past",
                    R.drawable.cpp_image
                ),
                SpiritualTeacher(
                    "Java",
                    "Walk as if you are kissing the Earth with your feet.",
                    R.drawable.java_image
                ),
                SpiritualTeacher(
                    ".net",
                    "Man suffers only because he takes seriously what the gods made for fun.",
                    R.drawable.net_image
                ),
                SpiritualTeacher(
                    "C++",
                    "Don't Carry Over Experiences from the past",
                    R.drawable.kotlin
                ),
                SpiritualTeacher(
                    "Java",
                    "Walk as if you are kissing the Earth with your feet.",
                    R.drawable.cpp_image
                ),
                SpiritualTeacher(
                    ".net",
                    "Man suffers only because he takes seriously what the gods made for fun.",
                    R.drawable.c_image
                ),
                SpiritualTeacher(
                    "C++",
                    "Don't Carry Over Experiences from the past",
                    R.drawable.net_image
                ),
                SpiritualTeacher(
                    "Java",
                    "Walk as if you are kissing the Earth with your feet.",
                    R.drawable.net_image
                ),
                SpiritualTeacher(
                    ".net",
                    "Man suffers only because he takes seriously what the gods made for fun.",
                    R.drawable.java_image
                ),
                SpiritualTeacher(
                    "Kotlin",
                    "Like vanishing dew,a passing apparition or the sudden flashnof lightning",
                    R.drawable.kotlin
                )
            )

    //listview Data
    val language = arrayOf<String>("C","C++","Java",".Net","Kotlin")
    val description = arrayOf<String>(
        "C programming is considered as the base for other programming languages",
        "C++ is an object-oriented programming language.",
        "Java is a programming language and a platform.",
        ".NET is a framework which is used to develop software applications.",
        "Kotlin is a open-source programming language, used to develop Android apps and much more.",
    )

    val imageId = arrayOf<Int>(
        R.drawable.c_image, R.drawable.cpp_image, R.drawable.java_image,
        R.drawable.net_image, R.drawable.kotlin
    )
}