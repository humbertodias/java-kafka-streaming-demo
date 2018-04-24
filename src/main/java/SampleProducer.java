import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Date;
import java.util.Properties;

public class SampleProducer {

    private static final String KAFKA_SERVER = "localhost:9092";
    private final KafkaProducer producer;

    public SampleProducer() {
        final Properties settings = new Properties();
        settings.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_SERVER);
        settings.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        settings.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        producer = new KafkaProducer<String,String>(settings);

    }

    public void send(String topic, String message) {
        ProducerRecord<Object, String> record = new ProducerRecord<>(topic, message);
        producer.send(record);
    }

    public void send(String topic, XPojo message) {
        ProducerRecord<Object, XPojo> record = new ProducerRecord<>(topic, message);
        producer.send(record);
    }


    public void close() {
        producer.close();
    }

    public static void main(String ... args) {
        SampleProducer myKafkaProducer = new SampleProducer();
        for (int i = 0; i < 10; i++) {
            XPojo xPojo = new XPojo();
            xPojo.setA(i);
            xPojo.setB("Demo" + i );
            xPojo.setC( new Date() );

//            myKafkaProducer.send("demo", xPojo);
            System.out.println("out_" + i);
            myKafkaProducer.send("demo", "Message "  + i );

        }
        //myKafkaProducer.close();

    }
}