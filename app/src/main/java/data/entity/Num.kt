package data.entity

class Num(val text: String, val number: Int, val found: Boolean, val type: String) {
    override fun toString(): String {
        return "Num(text='$text', number=$number, found=$found, type='$type')"
    }
}