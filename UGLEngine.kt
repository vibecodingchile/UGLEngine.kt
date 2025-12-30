package com.ugl.app

object UGLEngine {

    fun toUGL(text: String): Map<String, String> {
        val t = text.lowercase()

        return when {
            t.contains("ayuda") || t.contains("help") ->
                mapOf("intent" to "NEED", "object" to "HELP")

            t.contains("trabajo") || t.contains("work") ->
                mapOf("context" to "WORK")

            else ->
                mapOf("intent" to "UNKNOWN")
        }
    }

    fun fromUGL(ugl: Map<String, String>, lang: String): String {
        return when (ugl["object"]) {
            "HELP" ->
                if (lang == "es") "Necesito ayuda"
                else "I need help"

            else -> "Can you repeat?"
        }
    }
}