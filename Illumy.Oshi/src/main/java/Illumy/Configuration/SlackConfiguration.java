package Illumy.Configuration;

import java.io.BufferedReader;

import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SlackConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(SlackConfiguration.class);
    private final String url = "https://hooks.slack.com/services/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";

    public void enviarMensagem(JSONObject message) throws Exception {

        URL obj = new URL(this.url);

        //Essa função faz a conexão entre o link HTTP do slack ao JAVA
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //Método de envio das informações 
        con.setRequestMethod("POST");
        con.setDoOutput(true);

        //Enviando as informações via bytes e colocando no na variável url para que o sistema entenda
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(message.toString());

        //limpa as informações que foram inseridas 
        wr.flush();
        //fecha as informações  
        wr.close();

        int responseCode = con.getResponseCode();

        //Enviando solicitação para o slack atráves da URL
        logger.debug("Sending 'POST' request to URL: " + this.url);
        logger.debug("POST parameters: " + message.toString());
        logger.debug("Response Code: " + responseCode);

        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String inputLine;

        StringBuffer response = new StringBuffer();

        while ((inputLine = reader.readLine()) != null) {

            response.append(inputLine);

        }

        reader.close();

        System.out.println("Success: " + response);
    }
}
