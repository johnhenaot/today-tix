import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

class PasswordValidatorSpec : WordSpec() {
    init {
        "hasVowel" should {
            "hasVowel: return false when no vowels" {
                val testPassword = "cdfrgt"

                testPassword.hasVowel() shouldBe false

            }

            "hasVowel: return true with vowels" {
                val testPassword = "cdfagt"

                testPassword.hasVowel() shouldBe true
            }
        }

        "hasValidSequence" should {
            "hasValidSequence: should return false when three consecutive vowels" {
                val testPassword = "aeitru"

                testPassword.hasValidSequence() shouldBe false
            }

            "hasValidSequence: should return true when three consecutive vowels" {
                val testPassword = "aetru"

                testPassword.hasValidSequence() shouldBe true
            }
        }
    }
}