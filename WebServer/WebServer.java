import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 这个示例使用Java的ServerSocket和Socket类来实现基本的Web服务器功能。它监听指定的端口，并在客户端连接时接受请求并发送响应。
 * 这个简单的示例，用于展示Web服务器的基本原理。
 * 
 * Server is running on http://localhost:8080
 * 
 * 访问http://localhost:8080后的样例输出：
 * Client connected from /0:0:0:0:0:0:0:1:52742
 * requestMethod = GET
 * requestPath = /
 * Client connected from /0:0:0:0:0:0:0:1:52743
 * requestMethod = GET
 * requestPath = /favicon.ico
 */
public class WebServer {
    public static void main(String[] args) {
        int port = 8080;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is running on http://localhost:" + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println(
                        "Client connected from " + clientSocket.getInetAddress() + ":" + clientSocket.getPort());

                // 处理客户端请求
                handleRequest(clientSocket);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleRequest(Socket clientSocket) {
        try {
            // 获取输入输出流
            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();

            // 读取请求数据
            byte[] buffer = new byte[1024];
            int byteRead = input.read(buffer);

            // 解析HTTP请求
            String request = new String(buffer, 0, byteRead);
            String[] requestLines = request.split("\\r?\\n");
            String[] requestTokens = requestLines[0].split(" ");
            String requestMethod = requestTokens[0];
            String requestPath = requestTokens[1];
            System.out.println("requestMethod = " + requestMethod);
            System.out.println("requestPath = " + requestPath);

            // 构建HTTP响应
            String responseBody = "Hello World!";
            String response = "HTTP/1.1 200 OK\r\nContent-Length: " + responseBody.length() + "\r\n\r\n" + responseBody;

            // 发送HTTP响应给客户端
            output.write(response.getBytes());

            // 关闭连接
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
