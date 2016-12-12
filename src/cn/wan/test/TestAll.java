package cn.wan.test;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 万洪基 on 2016/12/12.
 */
public class TestAll {
    @Test
    public void match(){
        String txt1="#include &lt;string&gt;\n" +
                "using namespace std;\n" +
                "\n" +
                "class Pet\n" +
                "{\n" +
                "public:\n";


        String txt="<li><a href=\"/onlinejudge2/index.php/Home/User/info/uid/19168.html\">rchg150616万洪基</a></li>\n" +
                "\t\t\t\t\t    <li><a href=\"/onlinejudge2/index.php/Home/Login/logout\">Logout</a></li>\n" +
                "\t\t\t\t\t</ul>\n" +
                "\t\t\t\t\t\t        </div> <!-- /.navbar-collapse -->\n" +
                "\t\t</div><!-- /.container-fluid -->\n" +
                "\t</nav>\n" +
                "\n" +
                "\t<div class=\"main\">\n" +
                "\t\n" +
                "<div class=\"container\">\n" +
                "       <div class=\"block block-info\"></div>\n" +
                "       <div style=\"padding-top: 20px;\"></div>\n" +
                "       <div class=\"row\">\n" +
                "       <div class=\"prob-content\">\n" +
                "                <pre class=\"brush:cpp;\">#include &lt;iostream&gt;\n" +
                "#include &lt;string&gt;\n" +
                "using namespace std;\n" +
                "\n" +
                "class Pet\n" +
                "{\n" +
                "public:\n" +
                "    virtual void speak(){};\n" +
                "};\n" +
                "\n" +
                "class Cat:public Pet\n" +
                "{\n" +
                "public:\n" +
                "    virtual void speak();\n" +
                "};\n" +
                "\n" +
                "void Cat::speak()\n" +
                "{\n" +
                "    cout&lt;&lt;&quot;miao!miao!&quot;&lt;&lt;endl;\n" +
                "}\n" +
                "\n" +
                "class Dog:public Pet\n" +
                "{\n" +
                "public:\n" +
                "    virtual void speak();\n" +
                "};\n" +
                "\n" +
                "void Dog::speak()\n" +
                "{\n" +
                "    cout&lt;&lt;&quot;wang!wang!&quot;&lt;&lt;endl;\n" +
                "}\n" +
                "\n" +
                "int main()\n" +
                "{\n" +
                "    cout &lt;&lt; &quot;How does a pet speak ?&quot; &lt;&lt; endl;\n" +
                "    Cat cat;\n" +
                "    Dog dog;\n" +
                "    cat.speak();\n" +
                "    dog.speak();\n" +
                "    return 0;\n" +
                "}\n" +
                "\n" +
                "\n" +
                "/***************************************************\n" +
                "User name: rchg150616万洪基\n" +
                "Result: Accepted\n" +
                "Take time: 0ms\n" +
                "Take Memory: 156KB\n" +
                "Submit time: 2016-12-11 20:49:18\n" +
                "****************************************************/jdskfsdklfsdmlkfjudge2/Public/Home/syntax/scripts/shCore.js\"></script>\n" +
                "<script type=\"text/javascript\" src=\"/onlinejudge2/Public/Home/syntax/scripts/shBrushCpp.js\"></script>\n" +
                "<script type=\"text/javascript\" src=\"/onlinejudge2/Public/Home/syntax/scripts/shBrushJava.js\"></script>\n" +
                "<script type=\"text/javascript\" src=\"/onlinejudge2/Public/Home/syntax/scripts/shBrushPython.js\"></script>\n" +
                "<script type=\"text/javascript\" src=\"/onlinejudge2/Public/Home/syntax/scripts/shBrushRuby.js\"></script>\n" +
                "<link type=\"text/css\" rel=\"stylesheet\" href=\"/onlinejudge2/Public/Home/syntax/styles/shCore.css\"/>\n" +
                "<link type=\"text/css\" rel=\"stylesheet\" href=\"/onlinejudge2/Public/Home/syntax/styles/shThemeDefault.css\"/>";




        Pattern pattern=Pattern.compile("#include[\\s\\S]*\\*/");
        Matcher matcher=pattern.matcher(txt);
        if (matcher.find()){
            System.out.print(matcher.group());
        }

//        String s="da jia hao,ming tian bu fang jia !";
//        String reg="\\b[a-z]{3}\\b";
//        Pattern p = Pattern.compile(reg);
//        Matcher m = p.matcher(s);
//        while(m.find()){
//            System.out.println(m.group());
//        }
    }

    @Test
    public void aboutHttpClient() throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpGet HttpGetSubmit = new HttpGet("http://210.44.176.116/cjcx/zcjcx_list.php");
        HttpGet HttpGetSubmit = new HttpGet("http://acm.sdut.edu.cn/");

//
//        HttpGetSubmit.setHeader("Host","210.44.176.116");
//        HttpGetSubmit.setHeader("Referer", "http://210.44.176.116/cjcx/left.html");
//        HttpGetSubmit.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 10.0; WOW64; Trident/7.0; .NET4.0C; .NET4.0E)");
        CloseableHttpResponse response=httpClient.execute(HttpGetSubmit);

        HttpEntity httpEntity=response.getEntity();
        String result= EntityUtils.toString(httpEntity,"utf-8");
        System.out.println(result);
        httpClient.close();
        response.close();
    }
}
