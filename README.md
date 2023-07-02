## Rest-Server

### 功能介绍

1. 用 Java/SpringBoot/Hibernate 实现一个 RestServer，支持对整型类型的数值进行排序。
2. 通过 PostMan 等 RestClient 将待排序的多个数值发给 RestServer，RestServer 对这些数值进行排序。
3. 将排序前和排序后的数值存入数据库（可以是MySQL/H2等），并将排序结果返回给 RestClient。
4. 如果对 SpringBoot/Hibernate 不熟悉，可选用替代技术。

增强功能：在基础功能的基础上，支持对 String 、BigDecimal 类型的排序

### 技术实现

技术栈：Spring Boot + Mybatis + Mybatis Plus + SQLite

### 接口文档


https://console-docs.apipost.cn/preview/5892b4a859b92fa8/7966b34511c5c583

### 实现效果

接口调试结果：

![image-20230703010038997](https://cdn.staticaly.com/gh/RealBeBetter/image@master/img/202307030100827.png)

程序运行结果：

![image-20230703010937497](https://cdn.staticaly.com/gh/RealBeBetter/image@master/img/202307030109322.png)

数据入库结果：

![image-20230703011018644](https://cdn.staticaly.com/gh/RealBeBetter/image@master/img/202307030110341.png)

![image-20230703011034066](https://cdn.staticaly.com/gh/RealBeBetter/image@master/img/202307030110602.png)
