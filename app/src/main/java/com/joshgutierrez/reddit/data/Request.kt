import android.util.Log
import com.google.gson.Gson
import com.joshgutierrez.reddit.data.threadResult
import java.net.URL

class Request {

  companion object {

    private const val URL = "https://www.reddit.com/r/androiddev.json"
    private const val SEARCH = ""
    private const val COMPLETE_URL = "$URL"
  }
  //2
  fun run(): threadResult {

    val repoListJsonStr = URL(COMPLETE_URL).readText()
    Log.d(javaClass.simpleName, repoListJsonStr)

    return Gson().fromJson(repoListJsonStr, threadResult::class.java)
  }
}