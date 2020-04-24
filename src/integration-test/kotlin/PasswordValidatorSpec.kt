import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class PasswordValidatorSpec : WordSpec() {

    init {
        "validatePasswords" should {
            val outContent = ByteArrayOutputStream()
            val errContent = ByteArrayOutputStream()
            val originalOut = System.out
            val originalErr = System.err

            run {
                System.setOut(PrintStream(outContent))
                System.setErr(PrintStream(errContent))
            }

            "validatePasswords: should" {
                validatePasswords("src/integration-test/resources/passwords.txt")
                outContent.toString().dropLast(1).shouldBe(
                    """
                        <a> is  acceptable
                        <tv> is not acceptable
                        <ptoui> is not acceptable
                        <bontres> is not acceptable
                        <zoggax> is not acceptable
                        <wiinq> is not acceptable
                        <eep> is  acceptable
                        <houctuh> is  acceptable
                    """.trimIndent()
                )
            }

            run {
                System.setOut(originalOut)
                System.setErr(originalErr)
            }
        }
    }
}