import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class GitHubServer {
    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(9090), 0);

        server.createContext("/", exchange -> {

            String response = "<html>"
                    + "<head>"
                    + "<style>"
                    + "body {"
                    + "  text-align: center;"
                    + "  margin-top: 100px;"
                    + "  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;"
                    + "  background: linear-gradient(to right, #667eea, #764ba2);"
                    + "  color: white;"
                    + "}"
                    + "h1 {"
                    + "  font-size: 42px;"
                    + "  margin-bottom: 20px;"
                    + "}"
                    + "a {"
                    + "  display: inline-block;"
                    + "  margin-top: 20px;"
                    + "  font-size: 26px;"
                    + "  padding: 12px 25px;"
                    + "  color: white;"
                    + "  background-color: #ff7eb3;"
                    + "  text-decoration: none;"
                    + "  border-radius: 10px;"
                    + "  transition: 0.3s;"
                    + "}"
                    + "a:hover {"
                    + "  background-color: #ff4f91;"
                    + "  transform: scale(1.05);"
                    + "}"
                    + "</style>"
                    + "</head>"
                    + "<body>"
                    + "<h1>🚀 Welcome to My first DevOps Project Using Jenkins</h1>"
                    + "<p>✨ Built using Java + Maven ✨</p>"
                    + "<a href='https://github.com/navyasrigondela45' target='_blank'>👉 Open My GitHub</a>"
				    
                    + "</body>"
                    + "</html>";

            exchange.getResponseHeaders().add("Content-Type", "text/html; charset=UTF-8");
            exchange.sendResponseHeaders(200, response.getBytes().length);

            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        server.start();
        System.out.println("🚀 Server started on port 9090");

	Thread.currentThread().join();
    }
}
