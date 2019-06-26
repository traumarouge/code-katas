package coinchange

interface CoinChanger {

    fun change(amount: Int): List<Int>
}