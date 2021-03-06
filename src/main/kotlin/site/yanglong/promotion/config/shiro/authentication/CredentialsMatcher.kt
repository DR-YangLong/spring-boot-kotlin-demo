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
package site.yanglong.promotion.config.shiro.authentication

import org.apache.commons.codec.digest.DigestUtils
import org.apache.shiro.authc.AuthenticationInfo
import org.apache.shiro.authc.AuthenticationToken
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher

/**
 * functional describe:凭证对比处理器,密码使用MD5
 * {@see org.apache.commons.codec.digest.DigestUtils.md5Hex(String data)}
 * 加密存入数据库
 *
 * @author DR.YangLong [410357434@163.com]
 * @version 1.0 2015/5/14 13:11
 */
class CredentialsMatcher : SimpleCredentialsMatcher() {

    override fun doCredentialsMatch(token: AuthenticationToken, info: AuthenticationInfo): Boolean {
        if (token.credentials != null || info.credentials != null) {
            val submitPWD = String(token.credentials as CharArray)
            val storePWD = info.credentials as String
            val md5PWD = DigestUtils.md5Hex(submitPWD)
            if (md5PWD == storePWD) {
                return true
            }
        }
        return false
    }
}
