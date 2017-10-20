/*
        Copyright  DR.YangLong

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.
*/
package site.yanglong.promotion.config.shiro.dynamic

import java.util.LinkedHashMap

/**
 * functional describe:动态权限配置Service
 *
 * @author DR.YangLong [410357434@163.com]
 * @version 1.0 2015/1/17 10:33
 */
interface DynamicPermissionService {

    /**
     * 初始化时获取当前已定义的filterchains
     */
    fun init()

    /**
     * 更新框架资源权限配置，需要线程同步,此方法会动态添加definitions
     * 如果有重复的url，新的map将覆盖以前的map
     * 也就是说，以前链接的权限配置会被新的权限配置覆盖
     */
    fun updatePermission(newDefinitions: LinkedHashMap<String, String>)

    /**
     * 需要线程同步,此方法会加载静态配置，DynamicPermissionDao查询出来的配置
     *
     */
    fun reloadPermission()

    companion object {
        /**
         * 资源权限的配置字符串模板
         */
        val PREMISSION_STRING = "perms[{0}]"
        /**
         * 角色权限的配置字符串模板
         */
        val ROLE_STRING = "roles[{0}]"
    }
}