package fiap.com.br.proguard

import com.google.gson.annotations.SerializedName

enum class SWPeoples(val id: Int) {
    LukeSkywalker(1),
    DartVader(4)
}

data class SWPeople(
    @SerializedName("name") val name: String
)

