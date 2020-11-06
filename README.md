# ubaike-spider

**ubaike-spider爬取红盾网的企业工商数据 **


项目采用java编写，redis和mysql作为数据库，代理采用的是[携趣ip代理](https://www.xiequ.cn/)

开了十个线程，跑了一晚上，获取了30多万条数据，没跑了，有点费ip代理
## 模块介绍

spider模块：爬虫核心模块，主要是获取代理->获取html->解析html->调用接口获取注册资本->存储到redis队列中，依赖redis
store模块：存储模块，主要是从redis中获取数据->保存进mysql数据库，依赖redis和mysql

## 如何使用
* 1.首先你的有自己的代理源，在spider模块中实现HttpProxy接口，在SpiderApplication中，将bean替换为自己所实现的类
* 2.配置好spider模块和store模块中的application.properties
* 3.在数据库中建好表company_info和error_log，建表语句在ubaike-spider.sql中
* 4.启动spider和store即可

## 其它
红盾网的企业信息是有自增id的，所以根据此可以爬取全部公司数据。  
红盾网的反爬虫系统比较强悍，如果同一个ip瞬间并发多了，会被永久性封禁ip（强制要求关注微信公众号，无论过多久都无法浏览对于企业页面），我的ip就是测试的时候被封掉了，每次测试还得用代理  
红盾网的页面有点乱，不同公司的html结构不太一样  
