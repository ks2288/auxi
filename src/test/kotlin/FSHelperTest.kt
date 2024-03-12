import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.File

class FSHelperTest {
    private lateinit var testDirectory: File
    @Before
    fun setup() {
        testDirectory = File(TEST_PATH)
    }

    @After
    fun teardown() {
        testDirectory.deleteRecursively()
    }

    @Test
    fun testCreatePathWrapper() {
        val success = FSHelper.createPathDirectories(TEST_PATH)
        assert(success)
        // second assertion ensures the File instance carries the updated path
        assert(testDirectory.exists())
    }

    companion object {
        private const val TEST_DIR = "/.test"
        private val RUNTIME_DIR: String = System.getProperty("user.home")
        val TEST_PATH = "$RUNTIME_DIR$TEST_DIR"
    }
}