package com.sopt.oliveyoung.util.extensions

import timber.log.Timber

class OliveYoungDebugTree : Timber.DebugTree() {
    override fun createStackElementTag(element: StackTraceElement) =
        "${element.fileName}:${element.lineNumber}#${element.methodName}"
}