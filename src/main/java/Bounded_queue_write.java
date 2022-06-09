import com.hazelcast.collection.IQueue;
import com.hazelcast.config.QueueConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class Bounded_queue_write {
    public static void main(String[] args) throws InterruptedException {
        HazelcastInstance instance = Hazelcast.newHazelcastInstance();
        QueueConfig qCfg = new QueueConfig("queue");
        qCfg.setMaxSize(10);
        instance.getConfig().addQueueConfig(qCfg);
        IQueue<Integer> queue = instance.getQueue( "queue" );
        for ( int k = 1; k < 100; k++ ) {
            queue.put( k );
            System.out.println( "Producing: " + k );
            Thread.sleep(1000);
        }
        queue.put( -1 );
        System.out.println( "Producer Finished!" );
    }
}
