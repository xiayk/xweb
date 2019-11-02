## 短链 页面暂未完成
#### URL: [http://t.xiayk.com](http://t.xiayk.com)
#### API: 
##### 转短链 http://t.xiayk.com/toShortUrl
- request Params 
`{
	url: "http://baidu.com"
`}
- response Params
`
http://t.xiayk.com/3M73qu
`

##### 转长链 http://t.xiayk.com/toLongUrl
- request Params
`{
	url: "http://t.xiayk.com/3M73qu"
}`
- response Params
`
http://baidu.com/
`

##### http://t.xiayk.com/{code}

### 已知问题
- http://t.xiayk.com/{any} 会出错
