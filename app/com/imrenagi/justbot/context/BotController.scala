package com.imrenagi.justbot.context

import com.google.inject.Inject
import play.api.libs.ws.WSClient
import play.api.mvc.Controller

/**
 * Created by imrenagi on 4/21/16.
 */
@Singleton
class BotController @Inject() (ws: WSClient) extends Controller {

}

