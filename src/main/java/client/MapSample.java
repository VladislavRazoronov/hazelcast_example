package client;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map;

public class MapSample {
    public static void main(String[] args) {
        // Start the Hazelcast Client and connect to an already running Hazelcast Cluster on 127.0.0.1
        HazelcastInstance hz = HazelcastClient.newHazelcastClient();
        // Get the Distributed Map from Cluster.
        Map<String, String> map = hz.getMap("my-distributed-map");
        //Standard Put and Get.
        for(int i=0; i <1000;i++){
            map.put(Integer.toString(i),Integer.toString(2*i+i/2));
        }
        map.get("20");
        // Shutdown this Hazelcast client
        hz.shutdown();
    }
}
