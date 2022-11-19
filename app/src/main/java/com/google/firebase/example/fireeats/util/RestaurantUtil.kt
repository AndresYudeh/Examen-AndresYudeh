package com.google.firebase.example.fireeats.util

import android.content.Context
import com.google.firebase.example.fireeats.R
import com.google.firebase.example.fireeats.model.Restaurant

import java.util.Arrays
import java.util.Random

/**
 * Utilities for Restaurants.
 */
object RestaurantUtil {

    private const val APP_URL_FMT = "https://s1.eestatic.com/2015/02/09/elandroidelibre/el_androide_libre_9759562_179415365_1024x576.jpg"

    private val NAME_FIRST_WORDS = arrayOf(
        "Word", "Brave", "VirtualBox", "Postman", "Excel", "Discord")
    private val NAME_SECOND_WORDS = arrayOf(
           "")


    private val Empresa = arrayOf(
        "BraveSA", "Microsoft", "Soluction SA", "Tesla", "Valley", "Yahoo")

    /**
     * Create a random Restaurant POJO.
     */
    fun getRandom(context: Context): Restaurant {
        val restaurant = Restaurant()
        val random = Random()

        // Cities (first elemnt is 'Any')
        var cities = context.resources.getStringArray(R.array.cities)
        cities = Arrays.copyOfRange(cities, 1, cities.size)


        val prices = intArrayOf(1, 2, 3)

        restaurant.name = getRandomName(random)
        restaurant.city = getRandomEmpresa(random)
        restaurant.photo = APP_URL_FMT
        restaurant.price = getRandomInt(prices, random)
        restaurant.numRatings = random.nextInt(20)

        // Note: average rating intentionally not set

        return restaurant
    }



    /**
     * Get price represented as dollar signs.
     */
    fun getPriceString(restaurant: Restaurant): String {
        return getPriceString(restaurant.price)
    }
    private fun getRandomEmpresa(random: Random): String {
        return (getRandomString(Empresa, random) )
    }

    /**
     * Get price represented as dollar signs.
     */
    fun getPriceString(priceInt: Int): String {
        when (priceInt) {
            1 -> return "MB"
            2 -> return "GB"
            3 -> return "TB"
            else -> return "GB"
        }
    }

    private fun getRandomName(random: Random): String {
        return (getRandomString(NAME_FIRST_WORDS, random) + " " +
                getRandomString(NAME_SECOND_WORDS, random))
    }

    private fun getRandomString(array: Array<String>, random: Random): String {
        val ind = random.nextInt(array.size)
        return array[ind]
    }

    private fun getRandomInt(array: IntArray, random: Random): Int {
        val ind = random.nextInt(array.size)
        return array[ind]
    }
}
