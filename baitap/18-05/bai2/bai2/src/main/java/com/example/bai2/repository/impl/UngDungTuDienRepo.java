package com.example.bai2.repository.impl;

import com.example.bai2.repository.IUngDungTuDienRepo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Repository
public class UngDungTuDienRepo implements IUngDungTuDienRepo {
    static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("hello", "xin chào");
        hashMap.put("hii", "xin chào");
        hashMap.put("bye", "tạm biệt");
        hashMap.put("good", "tốt");
        hashMap.put("why", "tại sao");
        hashMap.put("where", "ở đâu");
        hashMap.put("sad", "buồn");
        hashMap.put("boy", "nam");
        hashMap.put("hour", "giờ");
        hashMap.put("girl", "nữ");
        hashMap.put("hot", "nóng");
        hashMap.put("student", "Học sinh");
    }

    @Override
    public String traCuu(String english) {
        Set<String> set = hashMap.keySet();
        String str = "";
        for (String s : set) {
            if (english.equals(s)) {
                str = hashMap.get(s);
                break;
            }
        }
        if (str == "") {
            str = "không tìm thấy";
        }
        return str;
    }
}
