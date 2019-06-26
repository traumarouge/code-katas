package coinchange

import java.lang.IllegalArgumentException

class DynamicBacktrackingCoinChanger(coins: Set<Int>) : CoinChanger {

    private val coins = coins.toList().sorted()

    override fun change(amount: Int): List<Int> =
            change(amount, arrayOfNulls(amount))?.sorted() ?: throw IllegalArgumentException()


    private fun change(amount: Int, arr: Array<List<Int>?>): List<Int>? {

        when {
            amount < 0 -> return null
            amount == 0 -> return emptyList()
            arr[amount - 1] != null -> return arr[amount - 1]
        }

        var list: List<Int>? = null

        for (coin in coins) {
            val res = change(amount - coin, arr)
            if (res != null && (list == null || list.size > res.size + 1)) list = res + coin
        }

        arr[amount - 1] = list

        return list
    }
}