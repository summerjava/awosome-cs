
# PTA-程序设计实验辅助教学平台

[PTA | 程序设计类实验辅助教学平台](https://pintia.cn/problem-sets?tab=0)

上面有非常多的习题，非常适合练习。

# webbench-网站压测工具

一款知名的linux下的网站性能压测工具，由Lionbridge公司开发，代码不多，不到1000行。它使用fork()模拟多个客户端同时访问我们设定的url，测试网站在压力下的性能，可以同时模拟3W个并发连接去测试网站的负载能力。webBech的标准测试可以向我们展示服务器的两项 内容：每秒钟相应请求数和每秒钟传输数据量。webbench不但能具有便准静态页面的测试能力，还能对动态页面（ASP,PHP,JAVA,CGI）进行测试的能力。还有就是他支持对含有SSL的安全网站例如电子商务网站进行静态或动态的性能测试，

下载地址：

[Web Bench Homepage](http://home.tiscali.cz/~cz210552/webbench.html)

使用起来非常简单：

wget https://www.ha97.com/code/webbench-1.5.tar.gz

tar zxvf webbench-1.5.tar.gz

cd webbench-1.5

make

make install

**命令行选项**

![](https://cdn.nlark.com/yuque/0/2022/png/640636/1641196345634-07bf7a06-eb5f-4e4c-aace-d75bd12d0ac8.png)

其核心原理：

- 父进程fork多个子进程，每个子进程在用户要求时间或默认时间对目标网站发起访问请求，父子进程通过管道进行通信。子进程通过管道写记录到的信息，父进程通过管道读子进程的信息，子进程在时间到后结束。父进程在子进程退出后统计并展示信息。

# CJson-JSON解码器

CJson是一款JSON解码器，代码不到1000行。github star 6.7K。

github：[GitHub - DaveGamble/cJSON: Ultralightweight JSON parser in ANSI C](https://github.com/DaveGamble/cJSON)

其核心数据结构：

/* The cJSON structure: */
typedef struct cJSON
{
    struct cJSON *next;
    struct cJSON *prev;
    struct cJSON *child;
    int type;
    char *valuestring;
    /* writing to valueint is DEPRECATED, use cJSON_SetNumberValue instead */
    int valueint;
    double valuedouble;
    char *string;
} cJSON;

支持的类型：

/* cJSON Types: */
#define cJSON_False 0
#define cJSON_True 1
#define cJSON_NULL 2
#define cJSON_Number 3
#define cJSON_String 4
#define cJSON_Array 5
#define cJSON_Object 6

其API用起来也非常简单：

char *out;cJSON *json;

json=cJSON_Parse(text);
if (!json) {
    printf("Error before: [%s]\n",cJSON_GetErrorPtr());
} else {
    out=cJSON_Print(json);
    cJSON_Delete(json);
    printf("%s\n",out);
    free(out);
}

# EasyLogger-高性能、轻量级C/C++日志库

是一款超轻量级、高性能的C/C++日志库。非常适合资源敏感的场景。其功能简单，上手迅速，以插件形式动态扩展支持更多实用功能。

代码下载链接：

https://gitee.com/Armink/EasyLogger

主要特性：

支持用户自定义输出方式（例如：终端、文件、数据库、串口、485、Flash...）；

日志内容可包含级别、时间戳、线程信息、进程信息等；

日志输出被设计为线程安全的方式，并支持 异步输出 及 缓冲输出 模式；

支持多种操作系统（RT-Thread、UCOS、Linux、Windows...），也支持裸机平台；

日志支持 RAW格式 ，支持 hexdump ；

支持按 标签 、 级别 、 关键词 进行动态过滤；

各级别日志支持不同颜色显示；

扩展性强，支持以插件形式扩展新功能。

# cWebsocket-轻量级websocket服务库

[GitHub - m8rge/cwebsocket: cWebsocket is lightweight websocket server library](https://github.com/m8rge/cwebsocket)

特点：跨平台、轻量级。

# cmockery-轻量级单元测试框架

一款轻量级C语言单测框架，google发布的，非常小巧和轻量级，代码不到3K行。对其他开源包没有依赖，对被测试代码侵入性非常小。

是由google在2008年发布的，这是google open source blog上的博文：

https://opensource.googleblog.com/2008/09/cmockery-easier-unit-tests-for-c.html

github链接：

[GitHub - google/cmockery: A lightweight library to simplify and generalize the process of writing unit tests for C applications.](https://github.com/google/cmockery)

# C语言实现数独

youtube上有完整的详细的系列教学视频，强烈推荐：

[Coding A Sudoku Solver in C - YouTube](https://www.youtube.com/playlist?list=PLkTXsX7igf8edTYU92nU-f5Ntzuf-RKvW)

不过视频是英文的，需要一定的英文听力能力。

![](https://cdn.nlark.com/yuque/0/2022/png/640636/1641200383852-7e8a5edf-b266-45ca-b4a7-2d564b6fcafe.png)

# Tinyhttpd-轻量级http server

一款超轻量级http server，使用C语言开发，代码总共才500行左右。通过这个小工程可以理解一个httpserver的本质。

github star 7.8K：

[GitHub - EZLippi/Tinyhttpd: Tinyhttpd 是J. David Blackstone在1999年写的一个不到 500 行的超轻量型 Http Server，用来学习非常不错，可以帮助我们真正理解服务器程序的本质。官网 //tinyhttpd.sourceforge.net](https://github.com/EZLippi/Tinyhttpd)

基础工作原理：

![](https://cdn.nlark.com/yuque/0/2022/png/640636/1641199555905-37f79a2c-303a-4bfc-9ff9-7cf9a1d59038.png)

# libev-开源事件驱动框架

难度指数：中。

一款C语言编写的高性能事件驱动框架，基于reactor模式实现。

官网：[libev](http://software.schmorp.de/pkg/libev.html)

github（star 1.2K）：

[GitHub - enki/libev: Full-featured high-performance event loop loosely modelled after libevent](https://github.com/enki/libev)

文档介绍：

https://metacpan.org/dist/EV/view/libev/ev.pod

注：

**学习此框架需要了解Linux操作系统部分基础知识。**

IO多路复用技术：

![](https://cdn.nlark.com/yuque/0/2022/png/640636/1641197614477-c87e497f-1fca-4d71-9450-d942bc772a28.png)

reactor模式：

![](https://cdn.nlark.com/yuque/0/2022/png/640636/1641197895353-690f05fd-231a-4bf4-bba1-609dc99dd8a3.png)

模块间的交互：

![](https://cdn.nlark.com/yuque/0/2022/png/640636/1641197838707-5d36e0ed-1a06-4204-88f7-3ed9018f4cbc.png)

# Memcached  
Memcached 是一个高性能的分布式内存对象缓存系统，用于动态Web应用以减轻数据库负载。它通过在内存中缓存数据和对象来减少读取数据库的次数，从而提供动态数据库驱动网站的速度。Memcached 基于一个存储键/值对的 hashmap。Memcached-1.4.7的代码量还是可以接受的，只有10K行左右。  
[memcached - a distributed memory object caching system](http://memcached.org/)

# buildyourownlisp-小型Lisp解释器

难度：高。

一本开源书籍，教你用C语言实现自己的lisp语言：一个1000行左右的简单lisp。

链接：

[https://www.buildyourownlisp.com/](https://www.buildyourownlisp.com/)

网上有2个中文翻译版：

（1）[第零零章 • 关于 · 学C语言写Lisp](https://www.abnerchou.me/BuildYourOwnLispCn/)

（2）并未翻译完成：

[&#x7B2C;&#x96F6;&#x96F6;&#x7AE0; &#x2022; &#x5173;&#x4E8E; &#xB7; Build Your Own Lisp &#x4E2D;&#x6587;&#x7248;](https://ksco.gitbooks.io/build-your-own-lisp/content/)

![](https://cdn.nlark.com/yuque/0/2022/png/640636/1641198652661-11c78c8f-def5-4cc6-9719-6514bbd9e1b9.png)

网友的实现：  
[GitHub - NessOffice/Lisp_on_C: An implementation of BuildYourOwnLisp](https://github.com/NessOffice/Lisp_on_C)

# CJson-json解码器
C文件只有500行。  
[https://sourceforge.net/projects/cjson/](https://sourceforge.net/projects/cjson/)

# kilo-文件编辑器

用不足1000行代码实现一个文件编辑器，酷不酷？

github star已有5.3K。

[GitHub - antirez/kilo: A text editor in less than 1000 LOC with syntax highlight and search.](https://github.com/antirez/kilo)

博客介绍：

http://antirez.com/news/108

官网：

[Build Your Own Text Editor](https://viewsourcecode.org/snaptoken/kilo/)

![](https://cdn.nlark.com/yuque/0/2022/png/640636/1641200814656-e116c8fe-f787-48f4-8c02-15aac4a46291.png)

# db_tutorial-从0到1写数据库  
[github-db-tutorial](https://github.com/cstack/db_tutorial)

# smartdns-一个本地DNS服务器  
[github-smartdns](https://github.com/pymumu/smartdns)

# ffmpeg-视频播放

不足1000行代码实现视频处理功能：

[ffmpeg tutorial](http://dranger.com/ffmpeg/ffmpeg.html)
