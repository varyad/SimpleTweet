package com.codepath.apps.restclienttemplate.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import org.json.JSONArray
import org.json.JSONObject

@Parcelize
class Tweet(var body: String= "", var createdAt: String = "", var user: User?=null) :
    Parcelable {

    companion object {
            fun fromJson(jsonObject: JSONObject): Tweet {
                val tweet = Tweet()
                tweet.body = jsonObject.getString("text")
                tweet.createdAt = jsonObject.getString("created_at")
                tweet.user = User.fromJson(jsonObject.getJSONObject("user"))
                return tweet
            }


            // take a whole jsonObject and convert it into Tweet Array
            fun fromJsonArray(jsonArray: JSONArray): List<Tweet> {
                val tweets = ArrayList<Tweet>()
                for (i in 0 until jsonArray.length()) {
                    tweets.add(fromJson(jsonArray.getJSONObject(i)))
                }
                return tweets
            }
    }
}