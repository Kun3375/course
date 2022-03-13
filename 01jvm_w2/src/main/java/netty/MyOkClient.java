package netty;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author kun
 * @date 2022/3/13
 */
public class MyOkClient {

    public static void main(String[] args) {
        // use default dispatcher and config
        OkHttpClient client = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().url("http://localhost:8801").build();
        Call call = client.newCall(request);
        try (
                Response response = call.execute();
                ) {
            System.out.println(response.code());
            System.out.println(response.body().string());
        } catch (IOException e) {
            System.out.println("error: " + e);
        }

    }
}
