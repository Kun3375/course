### component
- RequestFilter 过滤器；CheckTokenFilter 判断 Header 存在 token 
- RequestRouter 路由选择；RoundRobinRouter 轮询路由的实现
- DiscoveryAndRouter 发现和路由；FixedDiscoveryAndRouter 固定写死发现的服务、通过 uri 前缀进行路由

### 流程
1. 启动 test1 servers：启动 BackServer、-Dserver.port=8901 启动 BackServer
2. 启动 test2 servers：-Dserver.port=8800 启动 BackServer、-Dserver.port=8801 启动 BackServer
3. 启动 gateway MyNettyServer
4. 请求：`curl --header token:fake localhost:8080/test1` or `curl --header token:fake localhost:8080/test2` 测试