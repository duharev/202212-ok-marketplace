package ru.otus.otuskotlin.marketplace.sql.dsl

import java.util.*

class QueryContext {
    var select: String? = null
    var from: String = ""
}

class WhereContext {
    var where: String? = null
}

class OrContext {
    var or: String? = null
}

infix fun String.eq(s: Any?): String {
    return " where " + when(s) {
        null -> "$this is null"
        is Number -> "$this = ${s}"
        else -> "$this = '${s}'"
    }
}

infix fun String.nonEq(s: Any?): String {
    return " where " + when(s) {
        null -> "$this !is null"
        is Number -> "$this != ${s}"
        else -> "$this != '${s}'"
    }
}


class SqlSelectBuilder {
    private var id = UUID.randomUUID().toString()

    var select: String? = null
    var from: String? = null
    var where: String? = null
    var or: String? = null

    fun from(from: String) {
        this.from = from
    }

    fun select(vararg select: String) {
        this.select = select.joinToString()
    }

    fun where(block: WhereContext.() -> String) {
        this.where = WhereContext().let(block)
    }

    //todo implement OR
//    fun or( ): String {

//    }

    fun build(): String {
        return "select ${select?:"*"} " +
                "from ${from?: throw java.lang.RuntimeException("from is null")}" +
                (where?: "")
    }

}



fun query(block: SqlSelectBuilder.() -> Unit) = SqlSelectBuilder().apply(block)
