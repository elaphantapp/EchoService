Elastos Echo Service
==============

## Summary
This repo provide a simple callback cache service.

## Configure
### Configure redis
```yaml
spring.redis.host=localhost
spring.redis.port=6379
spring.redis.password=
```

## Build with maven
In project directory, use maven command:
```Shell
$uname mvn clean compile package
```
If there is build success, Then the package echo.service.api-0.0.1.jar will be in target directory.

## Run

Copy echo.service.api-0.0.1.jar to your deploy directory.
then use jar command to run this spring boot application.

```shell
$uname java -jar echo.service.api-0.0.1.jar
```

## Usage
### Save callback data for 1hour 
```yaml
HTTP: POST
URL: /api/1/ela_echo/{app_id}/{traceid}
HEADERS:
    Content-Type: application/json
data: post data
return:
    成功: {
        "status":200,
    }
    失败: {"status":400, "result":"Err msg"}
```

### Get callback data
```yaml
HTTP: GET
URL: /api/1/ela_echo/{app_id}/{traceid}
HEADERS:
    Content-Type: application/json
data: post data
return:
    成功: {
        "data": post data
        "status":200,
    }
    失败: {"status":400, "result":"Err msg"}
```
