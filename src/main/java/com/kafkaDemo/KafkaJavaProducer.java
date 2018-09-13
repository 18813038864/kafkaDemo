package com.kafkaDemo;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaJavaProducer {

    public static void main(String[]args){
        Properties props = new Properties();
        props.put("bootstrap.servers", "10.202.80.72:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String,String> producer = new KafkaProducer<String,String>(props);

        for(int i=0;i<100;i++){
            ProducerRecord<String,String> r = new ProducerRecord<String,String>("kafka_test",Integer.toString(i),Integer.toString(i));
            producer.send(r);
        }
        producer.close();
    }
}
