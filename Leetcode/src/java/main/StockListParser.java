import java.io.*;
import java.net.URL;

/**
 * Created by look on 14-9-25.
 */
public class StockListParser {

    public static void main(String[] args) throws Exception{
        URL url = new URL("http://quote.tool.hexun.com/hqzx/quote.aspx?type=2&market=0&sorttype=3&updown=up&count=2000");
        InputStream is = url.openStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "GBK"));
        String line = null;
        StringBuffer sb = new StringBuffer();
        while ((line = br.readLine()) != null){
            sb.append(line);
        }
        String content = sb.toString();
        content = content.replaceAll("'", "");
        content = content.substring(content.indexOf("[[")+2, content.indexOf(";")-2);
        String[] rows = content.split("\\],\\[");

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/zhoukai18610410728/Desktop/result.csv")));
        bw.append("代码,名称,最新价,涨跌幅,昨收,今开,最高,最低,成交量,成交额,换手,振幅,量比\n");
        for (String row : rows){
            bw.append(row).append("\n");
            System.out.println(row);
        }
        bw.close();
    }

}
