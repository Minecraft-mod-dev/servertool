# ServerTool v1.2.1-Release
## 简介
ServerTool 是一个**Paper端**的**Minecraft插件**，提供了**3个**主要内容
### 反馈系统
#### 亮点
🌏**外链API**，支持发送反馈和查看反馈列表(需要自己搭建服务，否则无法使用)  
💻**异步处理**，减少服务器卡顿，不占用主线程
#### 用法
##### 重要的事情说三遍
##### 需要自己搭建服务，否则无法使用！
##### 需要自己搭建服务，否则无法使用！
##### 需要自己搭建服务，否则无法使用！  
可以参考:  
[创建域名及绑定Cloudflare](https://blog.lin114514.top/cloudflare/cf-bp-1)  
[如何创建DNS记录<可参考>](https://tenfy.cn/posts/cloudflare-dns-tutorial/)  
[Workers实现反馈系统核心](https://blog.lin114514.top/cloudflare/cf-workers-feedback)  
注：该指令**所有玩家**均可使用
```
/feedback <type> <message>
```
**type:** 反馈类型 **<bug|feedback>**  
**message:** 反馈内容
### 服务器公告板
#### 亮点
✅**现代化公告板API**，规避传统公告板的问题  
💠**功能齐全**，覆盖服务器关闭提示，加入服务器群组公告等功能
#### 用法
注：该功能指令**仅OP**可使用
```
/offlinehint <minutes> <why>
```
**minutes:** 服务器关闭前的倒计时（单位：分钟）
**why:** 服务器关闭的原因
```
/joingrouphint <groupURL>
```
**groupURL:** 服务器群组的链接
### 服务器新手礼包
#### 亮点
👍**物品齐全**，可以基本满足玩家新手时期的生存
#### 用法
该功能没有指令
## 支持版本
主要支持版本是**1.21/1.21.1**。
## 题外话
欢迎加入我们的Minecraft服务器！
