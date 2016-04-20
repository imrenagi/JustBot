package com.imrenagi.justbot.utils.play

/**
 * Created by imrenagi on 4/21/16.
 */
import java.sql.Timestamp
import play.api.libs.json._
import scala.util.Try

trait DefaultJsonFormatter {
  implicit val bigIntFormat = new Format[BigInt] {
    override def reads(json: JsValue): JsResult[BigInt] = json.validate[String].flatMap { s =>
      Try(BigInt(s)).map(v => JsSuccess(v)).getOrElse(JsError(s"$s is not a number"))
    }

    override def writes(o: BigInt): JsValue = JsString(o.toString())
  }

  implicit val timestampFormat = new Format[Timestamp] {
    override def reads(json: JsValue): JsResult[Timestamp] = json.validate[Long].map { l =>
      new Timestamp(l)
    }

    override def writes(t: Timestamp): JsValue = JsNumber(t.getTime)
  }

  implicit val errorFormatter = Json.format[ErrorMessage]
}
