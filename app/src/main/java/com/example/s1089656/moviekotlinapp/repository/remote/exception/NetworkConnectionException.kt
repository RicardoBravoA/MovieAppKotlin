package com.example.s1089656.moviekotlinapp.repository.remote.exception

import java.io.IOException

/**
 * Created by Ricardo Bravo on 24/07/18.
 */

class NetworkConnectionException : IOException {

    constructor() : super() {}

    constructor(message: String) : super(message) {}

    constructor(message: String, cause: Throwable) : super(message, cause) {}

    constructor(cause: Throwable) : super(cause) {}
}