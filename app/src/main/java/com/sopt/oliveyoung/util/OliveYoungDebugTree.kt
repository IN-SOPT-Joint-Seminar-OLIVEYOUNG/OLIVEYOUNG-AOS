package com.sopt.oliveyoung.util

import timber.log.Timber

class OliveYoungDebugTree : Timber.DebugTree() {
    override fun createStackElementTag(element: StackTraceElement) =
        "${element.fileName}:${element.lineNumber}#${element.methodName}"
}