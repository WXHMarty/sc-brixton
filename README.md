###关于spring cloud的一些学习demo

####模块说明：  
>>eureka: 注册服务  
>>servera: 模拟提供服务端  
>>serverb: 模拟客户服务端(使用robbin)  
>>serverc: 模拟客户服务端(使用feign)  
>>serverd: 模拟客户服务端断路器(robbin + hystrix)  
>>servere: 模拟客户服务端断路器(feign feign中以集成hystrix)  
>>serverf: 模拟注册服务

####模块启动先后顺序：  
>>1. 先启动serverf  
>>2. 再启动eureka  
>>3. 最后启动servera serverb serverc serverd servere
