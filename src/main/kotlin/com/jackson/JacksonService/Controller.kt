package com.jackson.JacksonService

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.beans.factory.annotation.Autowired


@RestController
@RequestMapping(value = "/json")
class Controller  {
    @PostMapping(value = "/put")
    fun sendMessageToKafkaTopic(@RequestParam("message") message: String) {

        val json = "{ \"color\": \"green\", \"kana\": \"みどり\", \"code\": { \"rgba\": [0,255,0,1], \"hex\": \"#0F0\" } }"

        // mapperオブジェクトを作成
        val mapper = jacksonObjectMapper()

        // jsonをdeserialize
        // 下の場合はjsonがColor型のオブジェクトにマッピングされる
        val color = mapper.readValue<Color>(json)

        println(color)
        println("色(かな)：${color.kana}")
        println("RGBAコードのG値：${color.code.rgba[1]}")



    }
}