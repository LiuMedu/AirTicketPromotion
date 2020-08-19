# 机票监控程序

#### 使用

1. 环境准备：
   * `JDK1.8`
   * `Win/Linux`(可以Run`Java`程序的主机或服务器)

2. 使用`git clone https://github.com/ThornClub/AirTicketPromotion.git`命令,下载程序

3. 将程序打包成jar包(**不打包configuration.xml**)

4. 修改`configuration.xml`，并与jar包放置同级目录

5. 运行jar包启动程序

#### 配置文件修改

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<information>
    <ticket>
        <!--当前位置城市代码：大写-->
        <fromcitycode>TGO</fromcitycode>
        <!--目标位置城市代码：大写-->
        <tocitycode>HET</tocitycode>
        <!--出行日期：格式yyyy-mm-dd，eg：2020-08-18-->
        <date>2020-09-04</date>
        <!--当前位置城市名：简体中文-->
        <fromadd>通辽</fromadd>
        <!--目标位置城市名：简体中文-->
        <toadd>呼和浩特</toadd>
        <!--Server酱的Key-->
        <key>SCU69038Tc47163fcf7b82a59188c79053967a00f5df71d8d1996b</key>
    </ticket>
</information>
```

**仅修改带注释的选项**
* 城市代码可到同程机票预定输入城市名即可展示
![img](https://cdn.jsdelivr.net/gh/ThornClub/Images/images/2020/08/19/e4088d.png
)
* 出行日期：格式必须标准
    * 多日期查询：多个日期以逗号(英文字符)分隔 例：2020-09-02,2020-09-03,2020-09-04
* 城市名：简体中文全称
* Server酱-Key：微信通知，可到[网站](http://sc.ftqq.com/3.version)上获取并填入其中

#### 启动脚本
由于`configuration.xml`资源文件的路径问题请参考以下方式
```shell
#!/bin/bash
cd /root/Test
java -jar AirTicketPromotion.jar
```

#### 定时运行

* Linux：`corntab`定时任务
* Windows：微软自带的定时任务

#### 日志
如果程序运行出现问题可以查看`info.log`来快速解决问题

#### 免责声明
本程序通过爬取同程网-机票预定的数据来实现的，如果本程序造成您的权益受到侵害或违反了中华人民共和国的法律，还请您在第一时间联系我
<a href="mailto:41445233@qq.com">41445233@qq.com</a>
<a href="mailto:libra@sgee.cc">libra@sgee.cc</a>

[博客](https://www.sgee.cc)


