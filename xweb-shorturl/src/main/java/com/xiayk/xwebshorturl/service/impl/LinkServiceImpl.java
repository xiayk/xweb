package com.xiayk.xwebshorturl.service.impl;

import com.xiayk.xwebshorturl.model.po.Link;
import com.xiayk.xwebshorturl.utils.DateUtil;
import com.xiayk.xwebshorturl.utils.MD5Util;
import com.xiayk.xwebshorturl.service.LinkService;
import com.xiayk.xwebshorturl.dao.LinkMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @ClassName LinkServiceImpl
 * @Author XiaYk
 * @Date 2019-11-02 02:46
 * @Version 1.0
 */
@Service
public class LinkServiceImpl implements LinkService {

    @Resource
    private LinkMapper linkMapper;

    private final String HOST = "http://t.xiayk.com/";

    @Override
    public String longToShort(String longUrl) {
        String shortUrl = linkMapper.findShortUrlByLongUrl(longUrl);
        //数据库中不存在
        if (shortUrl == null){
            shortUrl = this.gererateShortUrl(longUrl);
            shortUrl = HOST + shortUrl;

            //存入数据库
            Link link = new Link();
            link.setCreateDate(DateUtil.formatDate(new Date()));
            link.setLongUrl(longUrl);
            link.setShortUrl(shortUrl);
            linkMapper.insert(link);
        }
        return shortUrl;
    }

    /**
     * 将长链接转换为短链接
     * @param url
     * @return
     */
    public String gererateShortUrl(String url) {
        // 可以自定义生成 MD5 加密字符传前的混合 KEY
        String key = "xiayk" ;
        // 要使用生成 URL 的字符
        String[] chars = new String[] { "a" , "b" , "c" , "d" , "e" , "f" , "g" , "h" ,
                "i" , "j" , "k" , "l" , "m" , "n" , "o" , "p" , "q" , "r" , "s" , "t" ,
                "u" , "v" , "w" , "x" , "y" , "z" , "0" , "1" , "2" , "3" , "4" , "5" ,
                "6" , "7" , "8" , "9" , "A" , "B" , "C" , "D" , "E" , "F" , "G" , "H" ,
                "I" , "J" , "K" , "L" , "M" , "N" , "O" , "P" , "Q" , "R" , "S" , "T" ,
                "U" , "V" , "W" , "X" , "Y" , "Z"

        };
        // 对传入网址进行 MD5 加密
        String sMD5EncryptResult = MD5Util.MD5(key+url);
        String hex = sMD5EncryptResult;

//        String[] resUrl = new String[4];
//        for ( int i = 0; i < 4; i++) {

        // 把加密字符按照 8 位一组 16 进制与 0x3FFFFFFF 进行位与运算
        String sTempSubString = hex.substring(2 * 8, 2 * 8 + 8);    //固定取第三组

        // 这里需要使用 long 型来转换，因为 Inteper .parseInt() 只能处理 31 位 , 首位为符号位 , 如果不用 long ，则会越界
        long lHexLong = 0x3FFFFFFF & Long.parseLong (sTempSubString, 16);
        String outChars = "" ;
        for ( int j = 0; j < 6; j++) {
            // 把得到的值与 0x0000003D 进行位与运算，取得字符数组 chars 索引
            long index = 0x0000003D & lHexLong;
            // 把取得的字符相加
            outChars += chars[( int ) index];
            // 每次循环按位右移 5 位
            lHexLong = lHexLong >> 5;
        }
        // 把字符串存入对应索引的输出数组
//            resUrl[i] = outChars;
//        }
        return outChars;
    }

//    public static void main(String[] args) {
//        System.out.println(new LinkServiceImpl().gererateShortUrl("http://Service:8080"));
//    }

    @Override
    public String shortToLong(String code) {
        String shortUrl = HOST + code;
        return linkMapper.findLongUrlByShortUrl(shortUrl);
    }
}
