# ubaike-spider
ubaike 红盾网 爬虫 企业 工商数据 java   
spider模块为爬虫主要模块，主要是获取代理->获取html->解析html->存储到redis队列中  
store模块为存储模块，主要是从redis中获取数据->调用接口获取注册资本->保存进数据库中
