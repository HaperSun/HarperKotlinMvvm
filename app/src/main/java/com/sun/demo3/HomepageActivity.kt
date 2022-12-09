package com.sun.demo3

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
/**
 * @author: Harper
 * @date: 2022/11/28
 * @note: 30
 */
class HomepageActivity : AppCompatActivity() {
    val aa = "gege"
    var bb = 99
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val 命名的变量是只读的
        val a = "哈哈"
        //var 命名的变量是可读可写的
        var b = 0.01
        b = PI1
        test1(this, this)
        range()
    }

    //函数默认都是public
    fun test1(context: Context, activity: Activity): Int {
        val aa = 1
        println(bb)
        return aa
    }

    //Unit 代表无参数返回的忽略类型，默认不写
    private fun range(): Unit {
        //todo range 表达式
        val number = 200
        if (number in 0..100) {
            println("查到了")
        } else {
            println("没找到")
        }
    }

    private fun whenA() {
        //todo when 表达式
        val week = 1
        val w: Any = when (week) {
            1 -> "今年卡"
            2 -> 22
            else -> {
                println("卡路里")
            }
        }
        println(w)
    }

    private fun string() {
        //todo String 模板
        val garden = "爬山"
        val time = 2
        println("今天去${garden},玩了$time 小时")
        //todo kt 中if是表达式，java中if是语句
        val aa = true
        println("钓到鱼没有啊？${if (aa) "钓到鱼了" else "没有"}")

        //todo 函数的默认值
        action1("张三", 100)
        action2("23")
        action3()
    }

    private fun action1(name: String, age: Int) {
        println("姓名:$name,年龄:$age")
    }

    private fun action2(name: String, age: Int = 33) {
        println("姓名:$name,年龄:$age")
    }

    private fun action3(name: String = "张三", age: Int = 99) {
        println("姓名:$name,年龄:$age")

        //todo 具名函数
        action4(age = 33, name = "赵六")
    }

    private fun action4(name: String, age: Int) {
        println("姓名:$name,年龄:$age")
    }

    private fun show(number: Int) {
        //todo Nothing类型的特点
        when (number) {
            -1 -> TODO("抛出异常")
            in 0..100 -> println("正常")
        }

        `测试反引号用法`(99)
        //todo in、is 在kt中是关键字
        TestJava1.`in`()
        TestJava1.`is`()
    }

    private fun `测试反引号用法`(age: Int) {
        println("年龄$age")

        //todo 匿名函数：该函数表示implemented中有几个e
        val length = "implemented".count {
            it == 'e'
        }
        println(length)
    }

    private fun action5() {
        /*private fun method1(age: Int): String {
            return "aa"
        }
        该函数可以简写成如下：*/
        //todo 函数的隐式返回：默认返回最后一行
        val method1: (String, Int) -> String = { name, age ->
            "姓名$name,年龄$age"
        }
//        method1("张三",70) 和 method1.invoke("张三",70) 是等价的
        println(method1("张三", 60))

        //todo it 在匿名函数中的使用
        val method2: (String) -> String = {
            "姓名是：$it"
        }
        println(method2("30"))

        //todo 匿名函数的类型推断
        //方法名 ： 必须指定 参数类型 和返回类型
        //方法名 = 可以根据类型来自动推断返回的数据类型
        val method3 = { name: String, age: Int ->
            "姓名：$name 年龄$age"
        }
        println(method3("张三",20))
    }


    interface AA {
        fun aa();
    }

    class Bb : AA {
        override fun aa() {
            //此处不处理会抛出异常
            TODO("Not yet implemented")
        }
    }
}