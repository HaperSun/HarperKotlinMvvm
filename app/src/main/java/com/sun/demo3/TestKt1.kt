package com.sun.demo3

import java.lang.Exception
import kotlin.math.roundToInt

/**
 * @author Harper
 * @date 2022/11/28
 * note:
 */
class TestKt1 {

    private fun doLogin() {
        loginApi("张三", "1234") { msg: String, code: Int ->
            println("状态：$msg 返回码：$code")
        }
    }

    //todo kt中参数是函数的函数
    fun loginApi(name: String, psw: String, response: (String, Int) -> Unit) {
        if (name == null || psw == null) {
            TODO("输入错误")
        }
        if (serviceLogin(name, psw)) {
            response("success", 200)
        } else {
            response("fail", 400)
        }
    }

    fun serviceLogin(name: String, psw: String): Boolean {
        return name == "张三" && psw == "1234"
    }

    fun let() {
        //name是可空类型 可能是null，想要使用name，必须给出补救措施
        var name: String? = null
//        name = "Dy"

        //空合并操作符
        println(name ?: "我是null")

        //let函数
        val r = name?.let {
            if (it.isBlank()) {
                "empty"
            } else {
                it
            }
        }

        println(name?.let { "[$it]" } ?: "我是null")

        //断言
        val b = name!!.capitalize()
    }

    //异常处理和自定义异常
    fun exception() {
        try {
            var i: String? = null
            checkException(i)
            println(i!!.length)
        } catch (e: Exception) {
            println("哈哈：$e")
        }
    }

    private fun checkException(i: String?) {
        i ?: throw IException()

    }

    //自带的先决条件函数，可直接抛出异常
    fun hanShu() {
        var a1: String? = null
//        checkNotNull(a1)
//        requireNotNull(a1)
        var a2: Boolean = false
//        require(a2)
    }

    //字符串截取
    fun subString() {
        val indexOf = INFO.indexOf('5')
        println(INFO.substring(0, indexOf))
        println(INFO.substring(0 until indexOf))
    }

    //split 函数
    fun split() {
        val s = "da,ge,hao"
        val list = s.split(",")
        println(list)
        val (v1, v2, v3) = list
        println("v1:$v1, v2:$v2, v3:$v3")
    }

    //replace函数
    fun replace() {
        val pwd = "AHKLGKEDLLOOQNNNG"
        val n = pwd.replace(Regex("[AN]")) {
            when (it.value) {
                "A" -> "9"
                "L" -> "7"
                else -> it.value
            }
        }
        println("加密：$n")
    }

    //== 值比较不区分大小写，=== 引用类型的比较
    fun dengYu() {
        val a1 = "Da"
        val a2 = "Da"
        val a3 = "Yd"
        println(a1 == a2)
        println(a1 === a3)
    }

    fun zFbL() {
        val s = "AKJLGE"
        s.forEach { c ->
            //这里可以用c覆盖默认的it，相当于修改参数名
            print("$c ")
        }
    }

    //数字类型的字符串安全转换函数 toIntOrNull()
    fun sZzH() {
        val n: Int = "66".toInt()
        //输出66
        println(n)
        val n1: Int? = "66.6".toIntOrNull()
        //输出null
        println(n1)
    }

    //double 转 int
    fun dZi(){
        //输出65，四舍五入
        println(65.45.toInt())
        //输出65，四舍五入
        println(65.45.roundToInt())
        //输出65.823
        val a = "%.3f".format(65.8231)
    }

    fun apply(){
        val s = "Da Ge Hao"
        //apply函数默认有this，指向字符串本身，this.length相当于length
        val a =  s.apply {
            println(length)
        }.apply { "最后一个字符：${this[length -1]}" }
    }
}

class IException : IllegalArgumentException("我是null")

