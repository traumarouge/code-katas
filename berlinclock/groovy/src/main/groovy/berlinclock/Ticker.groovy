package berlinclock


class Ticker {

    private int count = 0
    private LightBar next = null


    LightBar rightShift(LightBar lightBar) {
        next = lightBar
        lightBar
    }


    void tick() {
        count++

        if (count == 60) {
            count = 0
            next?.increment()
        }
    }
}