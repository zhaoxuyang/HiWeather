package com.vito.work.weather.service.spider

/**
 * Created by lingzhiyuan.
 * Date : 2016/11/16.
 * Time : 17:38.
 * Description:
 *
 */
abstract class AbstractSpiderTask {

    var lock: Boolean = false

    val task: (() -> Unit) -> Unit = {
        body ->
        try {
            if (! lock) {
                lock = true
                body()
                lock = false
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
}