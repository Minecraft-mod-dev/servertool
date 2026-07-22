package org.lin114514.plugin.serverTool;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.bukkit.scheduler.BukkitRunnable;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

import static org.bukkit.Bukkit.getLogger;

public class Feedback {
    private static final String baseUrl = "https://api.feedback.lin114514.top";
    private static final String source = "paperMinecraftServer";

    private static final OkHttpClient HTTP_CLIENT;

    static {
        HTTP_CLIENT = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build();
    }

    /**
     * 提交反馈（异步，安全调用，不卡服务器主线程）
     * @param type bug / feedback
     * @param message 反馈文本
     */
    public static void submit(String type, String message) {
        new BukkitRunnable(){
            @Override
            public void run(){
                try {
                    String eSource = URLEncoder.encode(source, StandardCharsets.UTF_8);
                    String eType = URLEncoder.encode(type, StandardCharsets.UTF_8);
                    String eMessage = URLEncoder.encode(message, StandardCharsets.UTF_8);

                    String URL = String.format(
                            "%s/send?source=%s&type=%s&msg=%s",
                            baseUrl,eSource,eType,eMessage
                    );

                    Request request = new Request.Builder()
                            .url(URL)
                            .get()
                            .build();
                    try (Response response = HTTP_CLIENT.newCall(request).execute()) {
                        if (response.body() != null) {
                            String resBody = response.body().string();
                        }
                    }
                }catch (Exception e) {
                    getLogger().warning("提交反馈失败: " + e.getMessage());
                }
            }
        }.runTaskAsynchronously(ServerTool.getInstance());
    }
}
