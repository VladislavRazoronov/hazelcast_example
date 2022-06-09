import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void instantiate_values(HazelcastInstance instance){
        Map<String,String> numbers = instance.getMap("map");
        for(int i = 0; i<1000; i++){
            numbers.put(Integer.toString(i),Integer.toString(i));
        }
    }

    public static void main(String[] args) {
        HazelcastInstance Instance1 = Hazelcast.newHazelcastInstance();
        HazelcastInstance Instance2 = Hazelcast.newHazelcastInstance();
        HazelcastInstance Instance3 = Hazelcast.newHazelcastInstance();

        instantiate_values(Instance2);
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        Instance2.shutdown();
        Instance3.shutdown();
    }
}
