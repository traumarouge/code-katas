package berlinclock


class LightBar {

    private final int numberOfLights
    private final List register = []
    private LightBar next = null


    LightBar() { this(0) }


    LightBar(int numberOfLights) {
        this.numberOfLights = numberOfLights
        resetRegister()
    }


    LightBar rightShift(LightBar lightBar) {
        next = lightBar
        lightBar
    }


    List lights() { register.asImmutable() }


    void increment() {
        if (register.grep().size() < numberOfLights) {
            def index = register.findIndexOf { !it }
            register[index] = true
        } else {
            resetRegister()
            next?.increment()
        }
    }


    private void resetRegister() {
        register.clear()
        numberOfLights.times { register << false }
    }
}