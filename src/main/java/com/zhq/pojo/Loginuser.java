package com.zhq.pojo;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Data;

@Data
public class Loginuser {
    int id;
    String username;
    String password;
    String perm;

}
