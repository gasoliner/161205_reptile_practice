package cn.wan.reptile_acm;

import org.apache.http.util.EntityUtils;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by 万洪基 on 2016/12/6.
 */
       /*
        * 思路
        * 1.发送请求并获得响应，
        * 2.把响应的内容解析，解析后有三种情况：
        *    |--获得view code界面的url，执行1,获得#include......，over
        *    |--获得下一页的url，执行1
        *    |--获得null，说明到最后一页也没发现view code界面的url，over
        * 3.如果获得了code，则用IO流导出成文件
        * */
public class Main_acm {
    public static void main(String[] args) throws IOException {
        String code;
        String url="http://acm.sdut.edu.cn/onlinejudge2/index.php/Home/Contest/conteststatus/cid/1817/pid/2668/result/1";
        GetCode getCode=new GetCode();
        getCode.setCookie("PHPSESSID=apu48s2hh1147o9i3hgejihk11; Hm_lvt_ffc0a3cbaca7823cf2e81a8611a92d93=1481453788,1481460206,1481517419,1481537730; Hm_lpvt_ffc0a3cbaca7823cf2e81a8611a92d93=1481542628; _ga=GA1.3.368584434.1481453788; refer=http%3A%2F%2Facm.sdut.edu.cn%2Fonlinejudge2%2Findex.php%2FHome%2FContest%2Fproblemlist%2Fcid%2F1821");
        getCode.setHost("acm.sdut.edu.cn");
        getCode.setReferer("http://acm.sdut.edu.cn/onlinejudge2/index.php/Home/Contest/problemlist/cid/1821");
        getCode.setUser_agent("Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 10.0; WOW64; Trident/7.0; .NET4.0C; .NET4.0E)");
        while (true){
            String result=EntityUtils.toString(getCode.sendRequest(url).getEntity(),"utf-8");
            url=getCode.match(result);

//            test
            System.out.println("result:"+result);
            System.out.println("url:"+url);

            if (getCode.isURLCodeFind){

////                test
//                System.out.println("---------------------------------------------------------------");
//                String temp=
//                System.out.println(temp);

                code=getCode.match(EntityUtils.toString(getCode.sendRequest(url).getEntity(),"utf-8"),"#include[\\s\\S]*\\*/");

//                test
                System.out.println("code:"+code);

                break;
            }else if (url==null){
                code=null;
                break;
            }
        }
        //io code
        if (code!=null){
            FileOutputStream fileOutputStream=new FileOutputStream("F:\\DownLoadCode\\1.txt");
            fileOutputStream.write(code.getBytes());
            fileOutputStream.close();
            getCode.stopAllResource();
        }else {
            System.out.println("该用户没有Accept该题目！");
        }


    }
}
