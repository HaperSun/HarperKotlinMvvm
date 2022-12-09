package com.sun.demo3

/**
 * @author Harper
 * @date 2022/11/28
 * note:
 */
class TestKt1 {

    private fun doLogin() {
        loginApi("张三", "1234") { msg: String, code:Int ->
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
        return name =="张三" && psw == "1234"
    }
}

