本项目参考地址 [史上最简单的 SpringCloud 教程 | 终章](https://blog.csdn.net/forezp/article/details/70148833)

1. 服务提供 service-hi
2. 服务消费者: ribbon + RestTemplate/feign(客户端)
问： 为什么要有服务消费者？
为了解决集群（相同服务，不同的主机）问题，对外来说，我们只需知道访问服务消费者的对外接口，而对于服务器之间的相互平衡和
路由控制我们并不需要担心，可以再服务消费者之间定义负载均衡策略。
ps:分布式（大模块业务分为很多子模块，把不同的子模块放在不同的服务器，好的服务器分配业务多的服务器）

理论上来说，单个的服务是可以独立的作为一个服务来访问的。当然你可以通过消费者开放的接口来访问服务，这里的优势是可以定义
熔断机制或者负载均衡等路由机制。

负载均衡又区分了两种类型：
1. 客户端负载均衡(Ribbon)
    1. 服务实例的清单在客户端，客户端进行负载均衡算法分配。
    2. (从上面的知识我们已经知道了：客户端可以从Eureka Server中得到一份服务清单，在发送请求时通过负载均衡算法，
    在多个服务器之间选择一个进行访问)
2. 服务端负载均衡(Nginx)
    1. 服务实例的清单在服务端，服务器进行负载均衡算法分配

3. 路由/转发/控制 zuul