package com.enchanted;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: EnchantedHashMap
 * @Description: TODO: 手写HashMap
 * @PackageName:com.enchanted
 * @Author Enchanted
 * @Date 2023/11/9 19:56
 * @Version 1.0
 */

public class EnchantedHashMap<K,V> extends AbstractMap<K,V>
    implements Map<K,V>, Cloneable, Serializable {


    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    @Override
    public EnchantedHashMap<K, V> clone() {
        try {
            return (EnchantedHashMap) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

