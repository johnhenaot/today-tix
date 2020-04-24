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

        "hasValidThreeLessPattern" should {
            "hasValidThreeLessPattern: should return false when three consecutive vowels" {
                val testPassword = "aeitru"

                testPassword.hasValidThreeLessPattern() shouldBe false
            }

            "hasValidThreeLessPattern: should return true when pattern is valid" {
                val testPassword = "aetru"

                testPassword.hasValidThreeLessPattern() shouldBe true
            }

            "hasValidThreeLessPattern: should return false when three consecutive consonats" {
                val testPassword = "armtru"

                testPassword.hasValidThreeLessPattern(false) shouldBe false
            }
        }

        "hasNoRepetitions" should {
            "hasNoRepetitions: should return false when no allowed repetitions" {
                val testPassword = "ooooooqqoooohgdjnghr"

                testPassword.hasValidRepetitionPattern() shouldBe false
            }

            "hasNoRepetitions: should return true when allowed repetitions" {
                listOf("look", "see", "food", "understood", "google", "feet", "meet", "steel")
                    .map {
                        it.hasValidRepetitionPattern() shouldBe true
                    }
            }
        }
    }
}