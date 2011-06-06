package org.webtest09

import org.specs._
import org.webtest09._

import java.net.URLEncoder
import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.client.methods.HttpPut
import org.apache.http.entity.StringEntity
import org.apache.http.params.HttpProtocolParams


object RestSpec extends Specification with unfiltered.spec.jetty.Served {

  import dispatch._

  //def setup = { _.filter(new org.webtest09.RestApp) }
  def setup = RestApp applyPlans _
  val http = new Http

  "The rest app" should {
    "return no content if it doesn't exist" in {
      val status = http x (host as_str) {
        case (code, _, _, _) => code
      }
      status must_== 404
    }

    "have no data at root initially" in {
      val status = try {
        http x (host / "root" / "id1" as_str) { case (code, _, _, _) => code }
      } catch { case StatusCode(code, _) => code }
      status must_== 404
    }

    "add data at root" in {
      val input1 = Map("id[file]" -> "root input 101")
      val status = try {
        http x ( putForm(host / "root" / "id1", input1) as_str) { case (code, _, _, _) => code }
      } catch { case StatusCode(code, _) => code }
      status must_== 100
    }

  }
}