package com.huntech.pvs.common.redis;

import com.huntech.pvs.common.util.LoggerUtils;
import com.huntech.pvs.common.util.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.util.SafeEncoder;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**

 * 
 * 开发公司：SOJSON在线工具 <p>
 * 版权所有：© www.sojson.com<p>
 * 博客地址：http://www.sojson.com/blog/  <p>
 * <p>
 * 
 * Redis Manager Utils
 * 
 * <p>
 * 
 * 区分　责任人　日期　　　　说明<br/>
 * 创建　周柏成　2016年6月2日 　<br/>
 *
 * @author zhou-baicheng
 * @email  so@sojson.com
 * @version 1.0,2016年6月2日 <br/>
 * 
 */
public class JedisManager {

    private JedisPool jedisPool;

    public Jedis getJedis() {
        Jedis jedis = null;
        try {
            jedis = getJedisPool().getResource();
        } catch (JedisConnectionException e) {
        	String message = StringUtils.trim(e.getMessage());
        	if("Could not get a resource from the pool".equalsIgnoreCase(message)){
        		System.out.println("++++++++++请检查你的redis服务++++++++");
        		System.out.println("|①.请检查是否安装redis服务，如果没安装，Windos 请参考Blog：http://www.sojson.com/blog/110.html|");
        		System.out.println("|②.请检查redis 服务是否启动。启动口诀[安装目录中的redis-server.exe，双击即可，如果有错误，请用CMD方式启动，怎么启动百度，或者加QQ群。]|");
        		System.out.println("|③.请检查redis启动是否带配置文件启动，也就是是否有密码，是否端口有变化（默认6379）。解决方案，参考第二点。如果需要配置密码和改变端口，请修改spring-cache.xml配置。|");
        		System.out.println("|④.QQ群：259217951，目前需要付费，免费的方案请参考链接：http://www.sojson.com/shiro");
        		
        		System.out.println("|PS.如果对Redis表示排斥，请使用Ehcache版本：http://www.sojson.com/jc_shiro_ssm_ehcache.html");
        		System.out.println("项目退出中....生产环境中，请删除这些东西。我来自。JedisManage.java line:53");
//        		System.exit(0);//停止项目
        	}
        	throw new JedisConnectionException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return jedis;
    }

    public void returnResource(Jedis jedis, boolean isBroken) {
        if (jedis == null)
            return;
        /**
         * @deprecated starting from Jedis 3.0 this method will not be exposed.
         * Resource cleanup should be done using @see {@link redis.clients.jedis.Jedis#close()}
        if (isBroken){
            getJedisPool().returnBrokenResource(jedis);
        }else{
            getJedisPool().returnResource(jedis);
        }
        */
        jedis.close();
    }

    /**
     * 把key存入redis中
     *
     * @param key     k
     * @param value   v
     * @param seconds 过期时间（秒）
     * @return boolean
     */
    public boolean set(int dbIndex, byte[] key, byte[] value, int seconds) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.select(dbIndex);
            String result = jedis.set(key, value);
            if (seconds > 0) {
                Long r = jedis.expire(key, seconds);//设置过期时间
            }
        } catch (Exception e) {
            return false;
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
        return true;
    }

    public  byte[] get(int dbIndex,byte[] key) {
        byte[] value = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.select(dbIndex);
            value = jedis.get(key);
        } catch (Exception e) {
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
        return value;
    }


    /**
     * 向缓存中设置对象
     *
     * @param key key
     * @param obj value
     * @return boolean
     */
    public  boolean set(int dbIndex,String key, Object obj, Integer seconds) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.select(dbIndex);
            ObjectMapper mapper = new ObjectMapper();
            String value = mapper.writeValueAsString(obj);
            jedis.set(SafeEncoder.encode(key), SafeEncoder.encode(value));
            if (seconds != null) {
                jedis.expire(key, seconds);
            }
            return true;
        } catch (Exception e) {
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
        return false;
    }


    /**
     * 向缓存中设置对象
     *
     * @param key   key
     * @param value value
     * @return boolean
     */
    public  boolean set(int dbIndex, String key, String value, Integer seconds) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.select(dbIndex);
            jedis.set(SafeEncoder.encode(key), SafeEncoder.encode(value));
            if (seconds != null) {
                jedis.expire(key, seconds);
            }
            return true;
        } catch (Exception e) {
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
        return false;
    }

    /**
     * 移除缓存中设置对象
     *
     * @param keys 被删除的KEYS
     * @return Long 被删除个数
     */
    public  Long del(int dbIndex,String... keys) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.select(dbIndex);
            return jedis.del(keys);
        } catch (Exception e) {
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
        return null;
    }

    /**
     * 根据key 获取对象
     *
     * @param key key
     * @return T
     */
    public  <T> T get(int dbIndex,String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.select(dbIndex);
            String v = jedis.get(key);
            if (StringUtils.isNotEmpty(v)) {
                ObjectMapper mapper = new ObjectMapper();
                return mapper.readValue(v, clazz);
            }
        } catch (Exception e) {
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
        return null;
    }

    /**
     * 根据key值得到String类型的返回值
     *
     * @param key key
     * @return String
     */
    public  String get(int dbIndex,String key) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.select(dbIndex);
            String v = jedis.get(key);
            if (StringUtils.isNotEmpty(v)) {
                return v;
            }
        } catch (Exception e) {
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
        return null;
    }

    public  Boolean exists(int dbIndex,String key) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.select(dbIndex);
            return jedis.exists(key);
        } catch (Exception e) {
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
        return null;
    }

    /**
     * redis的list操作：
     * 把元素插入到列表的尾部
     *
     * @param key     KEY
     * @param strings 要插入的值，变参
     * @return 返回插入后list的大小
     */
    public  Long rpush(int dbIndex,String key, String... strings) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.select(dbIndex);
            return jedis.rpush(key, strings);
        } catch (Exception e) {
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
        return null;
    }

    /**
     * redis的list操作：
     * 根据开始与结束下标取list中的值
     *
     * @param key   KEY
     * @param start 开始下标
     * @param end   结束下标
     * @return List<String>
     */
    public  List<String> lrange(int dbIndex,String key, int start, int end) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.select(dbIndex);
            return jedis.lrange(key, start, end);
        } catch (Exception e) {
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
        return null;
    }

    /**
     * redis的list操作：
     * 取列表的长度
     *
     * @param key key
     * @return Long
     */
    public  Long llen(int dbIndex,String key) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.select(dbIndex);
            return jedis.llen(key);
        } catch (Exception e) {
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
        return null;
    }

    /**
     * redis的list操作：
     * 根据值移除list中的元素
     *
     * @param key   KEY
     * @param count ：
     *              count > 0 : 从表头开始向表尾搜索，移除与 value 相等的元素，数量为 count 。
     *              count < 0 : 从表尾开始向表头搜索，移除与 value 相等的元素，数量为 count 的绝对值。
     *              count = 0 : 移除表中所有与 value 相等的值。
     * @param value 要删除的值
     * @return 返回被移除的个数
     */
    public  Long lrem(int dbIndex,String key, long count, String value) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.select(dbIndex);
            return jedis.lrem(key, count, value);
        } catch (Exception e) {
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
        return null;
    }

    public  boolean setLong(int dbIndex,String key, Long value) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.select(dbIndex);
            return "OK".equals(jedis.set(key, String.valueOf(value)));
        } catch (Exception e) {
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
        return false;
    }

    public  Long getLong(int dbIndex,String key) {
        String result = get(dbIndex,key);
        return result == null ? null : Long.valueOf(result);
    }


    public  Long incrBy(int dbIndex,String key, Long increment) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.select(dbIndex);
            return jedis.incrBy(key, increment);
        } catch (Exception e) {
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
        return null;
    }

    public  Long hashSet(int dbIndex,String key, String field, String value) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.select(dbIndex);
            return jedis.hset(key, field, value);
        } catch (Exception e) {
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
        return -1L;
    }

    public  Long hashSetLong(int dbIndex,String key, String field, Long value) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.select(dbIndex);
            return jedis.hset(key, field, String.valueOf(value));
        } catch (Exception e) {
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
        return -1L;
    }

    public  Long hashIncrBy(int dbIndex,String key, String field, Long increment) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.select(dbIndex);
            return jedis.hincrBy(key, field, increment);
        } catch (Exception e) {
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
        return -1L;
    }

    public  Map<String, String> hashGetAll(int dbIndex,String key) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.select(dbIndex);
            return jedis.hgetAll(key);
        } catch (Exception e) {
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
        return null;
    }


    public  Set<String> hashKeys(int dbIndex,String key) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.select(dbIndex);
            return jedis.hkeys(key);
        } catch (Exception e) {
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
        return null;
    }

    public  Long hashDelAll(int dbIndex,String key, String... fields) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.select(dbIndex);
            return jedis.hdel(key, fields);
        } catch (Exception e) {
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
        return null;
    }





    public byte[] getValueByKey(int dbIndex, byte[] key) throws Exception {
        Jedis jedis = null;
        byte[] result = null;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            jedis.select(dbIndex);
            result = jedis.get(key);
        } catch (Exception e) {
            isBroken = true;
            throw e;
        } finally {
            returnResource(jedis, isBroken);
        }
        return result;
    }

    public void deleteByKey(int dbIndex, byte[] key) throws Exception {
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            jedis.select(dbIndex);
            Long result = jedis.del(key);
            LoggerUtils.fmtDebug(getClass(), "删除Session结果：%s" , result);
        } catch (Exception e) {
            isBroken = true;
            throw e;
        } finally {
            returnResource(jedis, isBroken);
        }
    }

    public void saveValueByKey(int dbIndex, byte[] key, byte[] value, int expireTime)
            throws Exception {
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            jedis.select(dbIndex);
            jedis.set(key, value);
            if (expireTime > 0)
                jedis.expire(key, expireTime);
        } catch (Exception e) {
            isBroken = true;
            throw e;
        } finally {
            returnResource(jedis, isBroken);
        }
    }

    public void saveValueByKey(int dbIndex, String key, String value)
            throws Exception {
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            jedis.select(dbIndex);
            jedis.set(key, value);

        } catch (Exception e) {
            isBroken = true;
            throw e;
        } finally {
            returnResource(jedis, isBroken);
        }
    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

}
