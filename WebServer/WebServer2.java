import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

/**
 * 这个示例是一个简单的Web服务器，用于演示基本的HTTP请求处理和静态文件服务。
 * 
 * 通过读取请求行来解析HTTP请求。
 * 对于GET请求，根据请求的路径查找相应的静态文件，
 * - 如果存在，则将文件内容作为响应的主体发送给客户端。
 * - 如果文件不存在，则返回404 Not Found响应。
 * 对于其他请求方法（如POST、PUT等），返回501 Not Implemented响应，表示不支持该方法。
 * 
 * Server is running on http://localhost:8080
 * 
 * 访问：http://localhost:8080/read.txt
 * 可以得到 WebServer/web/read.txt中的内容
 * 
 * 此示例中使用的是阻塞式I/O模型，每次处理请求都会阻塞当前线程，导致只能处理一个请求。在实际的Web服务器中，需要使用多线程或异步I/O来处理并发请求，以提高性能和吞吐量。
 * 
 * 对于生产环境的Web服务器，需要考虑错误处理、日志记录、并发控制、安全性等方面。例如，可以添加适当的异常处理机制，记录日志以进行故障排查，并实施适当的安全措施，如防止恶意请求、验证用户身份等。
 * 
 * 在处理文件读取时，应该使用适当的缓冲技术，以提高性能。可以使用BufferedReader或BufferedInputStream来读取文件。
 * 
 * 如果需要支持更多的HTTP功能，如请求头处理、请求参数解析、Cookie处理、会话管理等，可能需要借助现有的Java Web框架来简化开发过程。
 */
public class WebServer2 {
    public static void main(String[] args) {
        int port = 8080; // 设置服务器端口

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleRequest(Socket clientSocket) {
        try {
            // 获取输入流和输出流
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            OutputStream output = clientSocket.getOutputStream();

            // 读取请求行
            String requestLine = reader.readLine();
            String[] requestTokens = requestLine.split(" ");
            String requestMethod = requestTokens[0];
            String requestPath = requestTokens[1];

            // 处理GET请求
            if (requestMethod.equals("GET")) {
                // 构建请求资源的绝对路径
                String rootDirectory = "WebServer/web"; // 设置根目录
                String absolutePath = rootDirectory + requestPath;

                // 检查请求的资源是否存在
                File file = new File(absolutePath);
                if (file.exists() && file.isFile()) {
                    // 读取文件内容并构建HTTP响应
                    byte[] fileContent = Files.readAllBytes(file.toPath());
                    String response = buildResponse(200, fileContent);

                    // 发送HTTP响应给客户端
                    output.write(response.getBytes());
                } else {
                    // 请求的资源不存在，返回404 Not Found
                    String response = buildResponse(404, "404 Not Found".getBytes());

                    // 发送HTTP响应给客户端
                    output.write(response.getBytes());
                }
            } else {
                // 不支持的请求方法，返回501 Not Implemented
                String response = buildResponse(501, "501 Not Implemented".getBytes());

                // 发送HTTP响应给客户端
                output.write(response.getBytes());
            }

            // 关闭连接
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String buildResponse(int statusCode, byte[] content) {
        StringBuilder responseBuilder = new StringBuilder();

        // 构建响应行
        String statusLine = "HTTP/1.1 " + statusCode + " " + getStatusCodeMessage(statusCode) + "\r\n";
        responseBuilder.append(statusLine);

        // 构建响应头
        responseBuilder.append("Date: " + new Date() + "\r\n");
        responseBuilder.append("Server: SimpleWebServer\r\n");
        responseBuilder.append("Content-Type: text/html\r\n");
        responseBuilder.append("Content-Length: " + content.length + "\r\n");
        responseBuilder.append("\r\n");

        // 构建响应体
        responseBuilder.append(new String(content));

        return responseBuilder.toString();
    }

    private static String getStatusCodeMessage(int statusCode) {
        switch (statusCode) {
            case 200:
                return "OK";
            case 404:
                return "Not Found";
            case 501:
                return "Not Implemented";
            default:
                return "";
        }
    }
}
