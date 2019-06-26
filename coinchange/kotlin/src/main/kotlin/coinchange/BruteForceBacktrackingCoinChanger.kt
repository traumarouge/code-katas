package coinchange

import java.lang.IllegalArgumentException

class BruteForceBacktrackingCoinChanger(coins: Set<Int>) : CoinChanger {

    private val coins = coins.toList().sorted()

    override fun change(amount: Int): List<Int> =
            change(0, amount)?.sorted() ?: throw IllegalArgumentException()


    private fun change(index: Int, amount: Int): List<Int>? {

        when {
            amount == 0 -> return emptyList()
            amount <= 0 || index >= coins.size -> return null
        }

        val coin = coins[index]
        var list: MutableList<Int>? = null

        for (n in 0..amount / coin) {
            val res = change(index + 1, amount - n * coin)
            if (res != null && (list == null || list.size > res.size + n)) {
                list = res.toMutableList()
                repeat(n) { list.add(coin) }
            }
        }

        return list
    }
}