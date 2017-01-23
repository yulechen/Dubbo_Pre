/*
 * Copyright 1999-2011 Alibaba Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dubbo.proxy.factory;

import dubbo.common.model.Constants;
import dubbo.common.model.URL;
import dubbo.extension.annotation.Adaptive;
import dubbo.extension.annotation.SPI;
import dubbo.proxy.invoke.Invoker;
import dubbo.proxy.invoke.RpcException;

/**
 * ProxyFactory. (API/SPI, Singleton, ThreadSafe)
 * 
 * @author william.liangf
 */
@SPI("javassist")
public interface ProxyFactory {

    /**
     * create proxy.
     * 
     * @param invoker
     * @return proxy
     */
    @Adaptive({Constants.PROXY_KEY})
    <T> T getProxy(Invoker<T> invoker) throws RpcException;

    /**
     * create invoker.
     * 
     * @param <T>
     * @param proxy
     * @param type
     * @param url
     * @return invoker
     */
    @Adaptive({Constants.PROXY_KEY})
    <T> Invoker<T> getInvoker(T proxy, Class<T> type, URL url) throws RpcException;

}