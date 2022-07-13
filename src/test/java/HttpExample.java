import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.Closeable;
import java.io.IOException;

public class HttpExample {
    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://yandex.by/");
        try {
            HttpResponse response = httpClient.execute(httpGet);
            if(response.getStatusLine().getStatusCode()!=200) {
                throw new RuntimeException("An error code.   Server returned" + response.getStatusLine().getStatusCode() +
                        " " + response.getStatusLine().getReasonPhrase());
            }
            String responseText = EntityUtils.toString(response.getEntity());
            System.out.println(responseText);
            httpClient.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
