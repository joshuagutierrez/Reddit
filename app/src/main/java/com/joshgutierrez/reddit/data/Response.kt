package com.joshgutierrez.reddit.data

data class threadResult(val data: hData)

data class hData(val children: List<Children>)

data class Children(
        val data: Data)

data class Data(
        val title: String?,
        val num_comments: Long?,
        val author_fullname: String?,
        val selftext: String?)