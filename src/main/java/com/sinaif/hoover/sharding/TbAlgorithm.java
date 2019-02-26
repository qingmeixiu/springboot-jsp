package com.sinaif.hoover.sharding;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.SingleKeyTableShardingAlgorithm;

import java.util.Collection;

public class TbAlgorithm implements SingleKeyTableShardingAlgorithm<Integer> {


    @Override
    public String doEqualSharding(Collection<String> availableTargetNames, ShardingValue<Integer> shardingValue) {
        int id = shardingValue.getValue();

        int index = id % 2;

        for (String each : availableTargetNames) {
            System.out.println("-------------"+each);
            if (each.endsWith(index + "")) {
                return each;
            }
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<String> doInSharding(Collection<String> availableTargetNames, ShardingValue<Integer> shardingValue) {
        return null;
    }

    @Override
    public Collection<String> doBetweenSharding(Collection<String> availableTargetNames, ShardingValue<Integer> shardingValue) {
        return null;
    }
}