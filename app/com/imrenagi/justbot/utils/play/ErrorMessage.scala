package com.imrenagi.justbot.utils.play

import java.util.UUID

/**
 * Created by imrenagi on 4/21/16.
 */
case class ErrorMessage(id: UUID = UUID.randomUUID(), status: Int, message: String, error_code: Int)
