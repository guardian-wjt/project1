package cn.justweb;

import java.io.*;

public class AutoMD {
    public static void main(String[] args) throws  Exception{

        //路径：
        String path = "C:\\javaweb\\day21_JQuery高级\\代码\\day21_JQuery高级";
        File file = new File(path);
        File[] files = file.listFiles();
        String all = "";
        for (int i = 0; i < files.length; i++) {

            File file1 = files[i];
            String name = file1.getName();
            all += "## " + name + "\r\n";
            File[] files1 = file1.listFiles();
            for (int j = 0; j < files1.length; j++) {
                String name1 = files1[j].getName();
                if(!name1.endsWith("html")){
                    continue;
                }

                String fileContext = readToBuffer(files1[j]).toString();

                all += "### "+name1+"\r\n"+"~~~html\r\n"+fileContext+"\r\n~~~\r\n";

            }


        }

        FileOutputStream os = new FileOutputStream(path+"\\a1.md");

        os.write(all.getBytes());
        os.close();
    }

    public static StringBuilder readToBuffer(File file) throws Exception {
        StringBuilder builder = new StringBuilder();
        InputStream is = new FileInputStream(file);
        String line; // 用来保存每行读取的内容
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        line = reader.readLine(); // 读取第一行
        while (line != null) { // 如果 line 为空说明读完了
            builder.append(line); // 将读到的内容添加到 buffer 中
            builder.append("\n"); // 添加换行符
            line = reader.readLine(); // 读取下一行
        }
        reader.close();
        is.close();

        return builder;
    }
}
